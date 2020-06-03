/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5testsequence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ashraf Habromman
 */
@Entity
@Table(name = "HOTMEL_GUEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HotmelGuest.findAll", query = "SELECT h FROM HotmelGuest h"),
    @NamedQuery(name = "HotmelGuest.findByGuestSsn", query = "SELECT h FROM HotmelGuest h WHERE h.guestSsn = :guestSsn"),
    @NamedQuery(name = "HotmelGuest.findByGuestName", query = "SELECT h FROM HotmelGuest h WHERE h.guestName = :guestName")})
public class HotmelGuest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="guestSsnGenerator")
    @SequenceGenerator(name="guestSsnGenerator",sequenceName="GUEST_SSN_SEQ", allocationSize=1)  
    @Basic(optional = false)
    @Column(name = "GUEST_SSN")
    private Integer guestSsn;
    @Basic(optional = false)
    @Column(name = "GUEST_NAME")
    private String guestName;

    public HotmelGuest() {
    }

    public HotmelGuest(Integer guestSsn) {
        this.guestSsn = guestSsn;
    }

    public HotmelGuest(Integer guestSsn, String guestName) {
        this.guestSsn = guestSsn;
        this.guestName = guestName;
    }

    public Integer getGuestSsn() {
        return guestSsn;
    }

    public void setGuestSsn(Integer guestSsn) {
        this.guestSsn = guestSsn;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guestSsn != null ? guestSsn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HotmelGuest)) {
            return false;
        }
        HotmelGuest other = (HotmelGuest) object;
        if ((this.guestSsn == null && other.guestSsn != null) || (this.guestSsn != null && !this.guestSsn.equals(other.guestSsn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hw5testsequence.HotmelGuest[ guestSsn=" + guestSsn + " ]";
    }
    
}
