/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iproxys.PersistenceData;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
@Table(name = "SummaryPort_BandWidth")

public class SummaryPort_BandWidth implements Serializable
{
//    public static final String findAll = "findAll";
    @Id @Column (name = "id") @GeneratedValue
    private long id;
    
    @Column (name = "Port")
    private int port;
    
    @Column (name = "Protocol")
    private int protocol;
    
    @Column (name = "bdusage")
    private double bdusage;
    
    @Column (name = "timeref")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date timeref;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @return the protocol
     */
    public int getProtocol() {
        return protocol;
    }

    /**
     * @param protocol the protocol to set
     */
    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }

    /**
     * @return the bdusage
     */
    public double getBdusage() {
        return bdusage;
    }

    /**
     * @param bdusage the bdusage to set
     */
    public void setBdusage(double bdusage) {
        this.bdusage = bdusage;
    }

    /**
     * @return the timeref
     */
    public Date getTimeref() {
        return timeref;
    }

    /**
     * @param timeref the timeref to set
     */
    public void setTimeref(Date timeref) {
        this.timeref = timeref;
    }


    
}
