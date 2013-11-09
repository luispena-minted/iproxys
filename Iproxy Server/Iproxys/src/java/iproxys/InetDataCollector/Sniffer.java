/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iproxys.InetDataCollector;

import iproxy.externalDependencies.ConfiguracionGeneral;
import iproxy.externalDependencies.EjecutarIPtable;
import iproxy.externalDependencies.SquidController;
import iproxys.PersistenceData.*;
import iproxys.dataFacade.HttpBlockDbFacade;
import iproxys.dataFacade.UnBlockableIPFacade;
import iproxys.dns.DnsLookupper;
import iproxys.jess.JessSuggestions;
import iproxys.jess.ServiceCore;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import javax.ejb.EJB;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;

/**
 *
 * @author root
 */
public class Sniffer extends Thread {

    private static NetworkInterface[] InetInterfaces = jpcap.JpcapCaptor.getDeviceList();
    private static jpcap.JpcapCaptor capture;
    public static String InterfaceIP = "";
    public static Date TimeTempRef = new Date();
    public static Date TimepRef = new Date();
    private static Thread loop = null;
    public static String interfaceMask = "";
    public static List<SummaryIPPort_BandWidth> IPPortPDUs = new ArrayList<>();
    public static List<SummaryIPPort_BandWidth> TempIPPortPDUs = new ArrayList<>();
    public static List<SummaryPort_BandWidth> PortPDUs = new ArrayList<>();
    public static List<SummaryPort_BandWidth> TempPortPDUs = new ArrayList<>();
    public static List<SummaryIP_BandWidth> IPPDUs = new ArrayList<>();
    public static List<SummaryIP_BandWidth> TempIPPDUs = new ArrayList<>();
    private final int TimeTemp = 60000;
    private static Sniffer sniffer = null;
    private static ConfiguracionGeneral confgral;
    public static double networkMonitor = 0;
    public static double networkMonitorLastSeg = 0;
    private static Timer networkMonTimer = null;
    private EjecutarIPtable ipTableIns = EjecutarIPtable.getInstance();
    private DnsLookupper dnsLookIns = DnsLookupper.getInstance();
    private SquidController squidControllerInst = SquidController.getInstance();
    private HttpBlockDbFacade httpBlockIns = HttpBlockDbFacade.getInstance();
    private boolean control = true;
    private String domain;
    @EJB
    UnBlockableIPFacade unblockables = UnBlockableIPFacade.getInstance();
    private static TimerTask netMonTask = new TimerTask() {
        @Override
        public void run() {
            networkMonitorLastSeg = networkMonitor / 1024;
            Sniffer.networkMonitor = 0;
        }
    };

    public static NetworkInterface[] getAllInterfaces() {
        return InetInterfaces;
    }

    private void startSniff() {

        try {
            capture = jpcap.JpcapCaptor.openDevice(InetInterfaces[1], 1024 * 1024, false, 10000);
            setFilter();
            loop = new Thread(this);
            loop.start();
            networkMonTimer = new Timer();
            networkMonTimer.scheduleAtFixedRate(netMonTask, 1000, 1000);
        } catch (Exception ex) {
            System.err.println(ex);

        }

    }

    private void startSniff(int SelectInter) {
        try {
            capture = jpcap.JpcapCaptor.openDevice(InetInterfaces[SelectInter], 1024 * 1024, false, 10000);
            setFilter();
            loop = new Thread(this);
            loop.start();
            networkMonTimer = new Timer();
            networkMonTimer.scheduleAtFixedRate(netMonTask, 1000, 1000);

        } catch (Exception ex) {
            System.err.println(ex);
        }

    }

    private String getNetwork(String ip_re, String mask) {

        InetAddress ip;
        InetAddress mascara;
        try {
            ip = InetAddress.getByName(ip_re);
            mascara = InetAddress.getByName(mask);
        } catch (UnknownHostException ex) {
            return "192.168.0.0";
        }

        byte[] byteip = ip.getAddress();
        byte[] bytemask = mascara.getAddress();
        byte[] network = new byte[byteip.length];
        for (int i = 0; i < byteip.length; i++) {
            network[i] = (byte) (byteip[i] & bytemask[i]);
        }
        InetAddress realnetwork;
        try {
            realnetwork = InetAddress.getByAddress(network);
        } catch (UnknownHostException ex) {
            return "192.168.0.0";
        }
        return (realnetwork.getHostAddress());
    }

    @Override
    public void run() {

        confgral = ConfiguracionGeneral.getInstance();
        confgral.setAnchoBanda(ConfiguracionGeneral.Megabit * 3.2);

        while (true) {
            //Capturar paquetes hasta que pasen TimeTemp Milisegundos    
            capture.processPacket(-1, new RecievePackets());


            if ((new Date().getTime() - TimeTempRef.getTime()) >= TimeTemp) {
                Sniffer.TimeTempRef = new Date();
                iproxys.jess.ServiceCore jess = ServiceCore.getInstance();
                doCalculateDB_Temp();
                jess.addList(TempIPPDUs.toArray());
                jess.addList(TempIPPortPDUs.toArray());
                jess.addList(TempPortPDUs.toArray());
                for (JessSuggestions sug : jess.GetAllSuggestions()) {
                    TemporaryBlockedEntity temporaryBlockedEntity = new TemporaryBlockedEntity();
                    System.out.println(sug.getAction() + "  tipo:" + sug.getTipo() + "  ipdst:" + sug.getIp_Dst() + "  ipsrc:" + sug.getIp_Src());
                    
                    switch (sug.getTipo()) {
                        
                        case TemporaryBlockedEntity.BLOCK_IP:
                            temporaryBlockedEntity.setBlockedIP(sug.getIp_Dst());
                            
                            
                            
                            break;
                        case TemporaryBlockedEntity.BLOCK_IP_AND_PORT:
                            temporaryBlockedEntity.setBlockedIP(sug.getIp_Dst());
                            temporaryBlockedEntity.setBlockedPort(sug.getPort());
                            temporaryBlockedEntity.setProtocol(sug.getProtocol());
                            
                            
                            break;
                        case TemporaryBlockedEntity.BLOCK_PORT:
                            temporaryBlockedEntity.setBlockedPort(sug.getPort());
                            temporaryBlockedEntity.setProtocol(sug.getProtocol());
                            
                            
                            break;
                        case TemporaryBlockedEntity.BLOCK_HTTP_DOMAIN_TO_IP:
                            temporaryBlockedEntity.setBlockedIP(sug.getIp_Dst());
                            // ARREGLAR DOMINIO
                            temporaryBlockedEntity.setBlockedDomain(sug.getIp_Src());
                            
                            
                            break;
                    }
                    temporaryBlockedEntity.setIdentifier(sug.getTipo());
                    temporaryBlockedEntity.setBlockedOnTimeDate(new Date());
                    temporaryBlockedEntity.save();
                }
                jess.eraseData();
                Sniffer.TempPortPDUs.clear();
                Sniffer.TempIPPDUs.clear();
                Sniffer.TempIPPortPDUs.clear();

            }
        }
    }

    private void setFilter() throws IOException {

        NetworkInterfaceAddress[] IPaddr = InetInterfaces[1].addresses;
        Sniffer.InterfaceIP = IPaddr[0].address.getHostAddress();
        Sniffer.interfaceMask = IPaddr[0].subnet.getHostAddress();

        capture.setFilter("dst net " + getNetwork(InterfaceIP, interfaceMask) + " mask " + IPaddr[0].subnet.getHostAddress() + "", true);

        System.err.println("dst net " + getNetwork(InterfaceIP, interfaceMask) + " mask " + IPaddr[0].subnet.getHostAddress() + "");

    }

    public void select() {

        startSniff(1);
        System.err.println("ESCUCHANDO POR AL INTERFAZ " + InetInterfaces[0].name);
    }

    private Sniffer() {
    }

    public static Sniffer getInstance() {
        if (sniffer == null) {
            sniffer = new Sniffer();
        }
        return sniffer;
    }

    private void doCalculateDB() {

        BDCalculator_IP(IPPDUs);
        BDCalculator_IPPort(IPPortPDUs);
        BDCalculator_Port(PortPDUs);

    }

    private void doCalculateDB_Temp() {

        BDCalculator_IP(TempIPPDUs);
        BDCalculator_IPPort(TempIPPortPDUs);
        BDCalculator_Port(TempPortPDUs);

    }

    private void BDCalculator_IP(List<SummaryIP_BandWidth> relativo) {

        for (SummaryIP_BandWidth sug : relativo) {
            // Convirtiendo de Bytes a KiloBytes
            sug.setBdusage(sug.getBdusage() / ConfiguracionGeneral.Kilobit);
            // Dividiendo entre la cantidad de segundos que duro el muestreo
            sug.setBdusage(sug.getBdusage() / (TimeTemp / 1000));
            // Obteniendo el porcentaje de utilizacion de ancho 
            sug.setBdusage((sug.getBdusage() / confgral.getAnchoBanda()) * 100);

        }

    }

    private void BDCalculator_Port(List<SummaryPort_BandWidth> relativo) {

        for (SummaryPort_BandWidth sug : relativo) {
            // Convirtiendo de Bytes a KiloBytes
            sug.setBdusage(sug.getBdusage() / ConfiguracionGeneral.Kilobit);
            // Dividiendo entre la cantidad de segundos que duro el muestreo
            sug.setBdusage(sug.getBdusage() / (TimeTemp / 1000));
            // Obteniendo el porcentaje de utilizacion de ancho 
            sug.setBdusage((sug.getBdusage() / confgral.getAnchoBanda()) * 100);
        }

    }

    private void BDCalculator_IPPort(List<SummaryIPPort_BandWidth> relativo) {


        for (SummaryIPPort_BandWidth sug : relativo) {
            // Convirtiendo de Bytes a KiloBytes
            sug.setBdusage(sug.getBdusage() / ConfiguracionGeneral.Kilobit);
            // Dividiendo entre la cantidad de segundos que duro el muestreo
            sug.setBdusage(sug.getBdusage() / (TimeTemp / 1000));
            // Obteniendo el porcentaje de utilizacion de ancho 
            sug.setBdusage((sug.getBdusage() / confgral.getAnchoBanda()) * 100);
        }

    }
}
