/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Héctor Vix
 */
@Entity
@Table(name = "contacto_has_area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactoHasArea.findAll", query = "SELECT c FROM ContactoHasArea c")
    , @NamedQuery(name = "ContactoHasArea.findByContactoAreaId", query = "SELECT c FROM ContactoHasArea c WHERE c.contactoAreaId = :contactoAreaId")})
public class ContactoHasArea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contacto_area_id")
    private Integer contactoAreaId;
    @JoinColumn(name = "AREA_area_id", referencedColumnName = "area_id")
    @ManyToOne
    private Area aREAareaid;
    @JoinColumn(name = "CONTACTO_contacto_id", referencedColumnName = "contacto_id")
    @ManyToOne
    private Contacto cONTACTOcontactoid;

    public ContactoHasArea() {
    }

    public ContactoHasArea(Integer contactoAreaId) {
        this.contactoAreaId = contactoAreaId;
    }

    public Integer getContactoAreaId() {
        return contactoAreaId;
    }

    public void setContactoAreaId(Integer contactoAreaId) {
        this.contactoAreaId = contactoAreaId;
    }

    public Area getAREAareaid() {
        return aREAareaid;
    }

    public void setAREAareaid(Area aREAareaid) {
        this.aREAareaid = aREAareaid;
    }

    public Contacto getCONTACTOcontactoid() {
        return cONTACTOcontactoid;
    }

    public void setCONTACTOcontactoid(Contacto cONTACTOcontactoid) {
        this.cONTACTOcontactoid = cONTACTOcontactoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactoAreaId != null ? contactoAreaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactoHasArea)) {
            return false;
        }
        ContactoHasArea other = (ContactoHasArea) object;
        if ((this.contactoAreaId == null && other.contactoAreaId != null) || (this.contactoAreaId != null && !this.contactoAreaId.equals(other.contactoAreaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.ContactoHasArea[ contactoAreaId=" + contactoAreaId + " ]";
    }
    
}
