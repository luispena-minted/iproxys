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
@Table(name="SummaryIP_BandWidth")
public class SummaryIP_BandWidth implements Serializable, Comparable<SummaryIP_BandWidth> {
   
    @Id @GeneratedValue @Column(name="id")
    private long id;
    
    @Column(name="ip")
    private String ip_Dst;
    
    @Column(name="bdusage")
    private double bdusage;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP) @Column(name="timeref")
    private Date timeref;

    /**
     * @return the id
     */
   
    @Override
    public int compareTo(SummaryIP_BandWidth t) {
        String[] split = getIp_Dst().split("\\.");
        String[] split1 = t.getIp_Dst().split("\\.");
        int ent1 = 0;
        int ent2 = 0;
        for(int i = 0; i < split.length ; i++){
            ent2 += Integer.parseInt(split1[i]);
            ent1 += Integer.parseInt(split[i]);
        }
        return (ent1 > ent2 )? -1 :(ent1 == ent2)?0 :-1 ;
    }

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
     * @return the ip_Dst
     */
    public String getIp_Dst() {
        return ip_Dst;
    }

    /**
     * @param ip_Dst the ip_Dst to set
     */
    public void setIp_Dst(String ip_Dst) {
        this.ip_Dst = ip_Dst;
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
