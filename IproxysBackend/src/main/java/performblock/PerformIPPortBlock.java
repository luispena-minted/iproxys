/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package performblock;

import PersistenceData.TemporaryBlockedEntity;
import externalDependencies.EjecutarComando;

/**
 *
 * @author root
 */
public class PerformIPPortBlock implements PerformBlock {

    private TemporaryBlockedEntity temporaryBlockedEntity;
    private EjecutarComando ejecutarComando;
    private String protocolName;
    public PerformIPPortBlock(TemporaryBlockedEntity temporaryBlockedEntity) {
        this.temporaryBlockedEntity = temporaryBlockedEntity;
        protocolName = (temporaryBlockedEntity.getProtocol() == 6 )?"tcp":"udp";
        ejecutarComando = EjecutarComando.getInstance();
    }

    @Override
    public void block() {
        ejecutarComando.Ejecutar_Comando("iptables -A INPUT -s "+temporaryBlockedEntity.getBlockedIP()+" -p "+protocolName+" --dport "+temporaryBlockedEntity.getBlockedPort()+" -j DROP");
    }

    @Override
    public void unBlock() {
        ejecutarComando.Ejecutar_Comando("iptables -D INPUT -s "+temporaryBlockedEntity.getBlockedIP()+" -p "+protocolName+" --dport "+temporaryBlockedEntity.getBlockedPort()+" -j DROP");
    }

    public void blockSquid() {
        String results = "";
        do {
            results = ejecutarComando.Ejecutar_Comando("conntrack -D -p tcp --dport " + temporaryBlockedEntity.getBlockedPort() + " --src " + temporaryBlockedEntity.getBlockedIP() +" --dst  "+ temporaryBlockedEntity.getBlockedIPDest());
            results = results == null ? "" : results;
            System.out.println(results);
        }while (!results.isEmpty());
    }

}
