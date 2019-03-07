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
@Table(name = "contacto_has_lote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactoHasLote.findAll", query = "SELECT c FROM ContactoHasLote c")
    , @NamedQuery(name = "ContactoHasLote.findByContactoLoteId", query = "SELECT c FROM ContactoHasLote c WHERE c.contactoLoteId = :contactoLoteId")})
public class ContactoHasLote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contacto_lote_id")
    private Integer contactoLoteId;
    @JoinColumn(name = "CONTACTO_contacto_id", referencedColumnName = "contacto_id")
    @ManyToOne
    private Contacto cONTACTOcontactoid;
    @JoinColumn(name = "LOTE_lote_id", referencedColumnName = "lote_id")
    @ManyToOne
    private Lote lOTEloteid;

    public ContactoHasLote() {
    }

    public ContactoHasLote(Integer contactoLoteId) {
        this.contactoLoteId = contactoLoteId;
    }

    public Integer getContactoLoteId() {
        return contactoLoteId;
    }

    public void setContactoLoteId(Integer contactoLoteId) {
        this.contactoLoteId = contactoLoteId;
    }

    public Contacto getCONTACTOcontactoid() {
        return cONTACTOcontactoid;
    }

    public void setCONTACTOcontactoid(Contacto cONTACTOcontactoid) {
        this.cONTACTOcontactoid = cONTACTOcontactoid;
    }

    public Lote getLOTEloteid() {
        return lOTEloteid;
    }

    public void setLOTEloteid(Lote lOTEloteid) {
        this.lOTEloteid = lOTEloteid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactoLoteId != null ? contactoLoteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactoHasLote)) {
            return false;
        }
        ContactoHasLote other = (ContactoHasLote) object;
        if ((this.contactoLoteId == null && other.contactoLoteId != null) || (this.contactoLoteId != null && !this.contactoLoteId.equals(other.contactoLoteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.ContactoHasLote[ contactoLoteId=" + contactoLoteId + " ]";
    }
    
}
