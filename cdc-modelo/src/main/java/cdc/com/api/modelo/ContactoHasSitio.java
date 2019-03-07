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
@Table(name = "contacto_has_sitio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactoHasSitio.findAll", query = "SELECT c FROM ContactoHasSitio c")
    , @NamedQuery(name = "ContactoHasSitio.findByContactoSitioId", query = "SELECT c FROM ContactoHasSitio c WHERE c.contactoSitioId = :contactoSitioId")})
public class ContactoHasSitio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contacto_sitio_id")
    private Integer contactoSitioId;
    @JoinColumn(name = "CONTACTO_contacto_id", referencedColumnName = "contacto_id")
    @ManyToOne
    private Contacto cONTACTOcontactoid;
    @JoinColumn(name = "SITIO_sitio_id", referencedColumnName = "sitio_id")
    @ManyToOne
    private Sitio sITIOsitioid;

    public ContactoHasSitio() {
    }

    public ContactoHasSitio(Integer contactoSitioId) {
        this.contactoSitioId = contactoSitioId;
    }

    public Integer getContactoSitioId() {
        return contactoSitioId;
    }

    public void setContactoSitioId(Integer contactoSitioId) {
        this.contactoSitioId = contactoSitioId;
    }

    public Contacto getCONTACTOcontactoid() {
        return cONTACTOcontactoid;
    }

    public void setCONTACTOcontactoid(Contacto cONTACTOcontactoid) {
        this.cONTACTOcontactoid = cONTACTOcontactoid;
    }

    public Sitio getSITIOsitioid() {
        return sITIOsitioid;
    }

    public void setSITIOsitioid(Sitio sITIOsitioid) {
        this.sITIOsitioid = sITIOsitioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactoSitioId != null ? contactoSitioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactoHasSitio)) {
            return false;
        }
        ContactoHasSitio other = (ContactoHasSitio) object;
        if ((this.contactoSitioId == null && other.contactoSitioId != null) || (this.contactoSitioId != null && !this.contactoSitioId.equals(other.contactoSitioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.ContactoHasSitio[ contactoSitioId=" + contactoSitioId + " ]";
    }
    
}
