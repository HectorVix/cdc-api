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
@Table(name = "contacto_has_fuente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactoHasFuente.findAll", query = "SELECT c FROM ContactoHasFuente c")
    , @NamedQuery(name = "ContactoHasFuente.findByContactoFuenteId", query = "SELECT c FROM ContactoHasFuente c WHERE c.contactoFuenteId = :contactoFuenteId")
    , @NamedQuery(name = "ContactoHasFuente.findByCodfuente", query = "SELECT c FROM ContactoHasFuente c WHERE c.codfuente = :codfuente")})
public class ContactoHasFuente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contacto_fuente_id")
    private Integer contactoFuenteId;
    @Column(name = "codfuente")
    private String codfuente;
    @JoinColumn(name = "CONTACTO_contacto_id", referencedColumnName = "contacto_id")
    @ManyToOne
    private Contacto cONTACTOcontactoid;
    @JoinColumn(name = "FUENTE_fuente_id", referencedColumnName = "fuente_id")
    @ManyToOne
    private Fuente fUENTEfuenteid;

    public ContactoHasFuente() {
    }

    public ContactoHasFuente(Integer contactoFuenteId) {
        this.contactoFuenteId = contactoFuenteId;
    }

    public Integer getContactoFuenteId() {
        return contactoFuenteId;
    }

    public void setContactoFuenteId(Integer contactoFuenteId) {
        this.contactoFuenteId = contactoFuenteId;
    }

    public String getCodfuente() {
        return codfuente;
    }

    public void setCodfuente(String codfuente) {
        this.codfuente = codfuente;
    }

    public Contacto getCONTACTOcontactoid() {
        return cONTACTOcontactoid;
    }

    public void setCONTACTOcontactoid(Contacto cONTACTOcontactoid) {
        this.cONTACTOcontactoid = cONTACTOcontactoid;
    }

    public Fuente getFUENTEfuenteid() {
        return fUENTEfuenteid;
    }

    public void setFUENTEfuenteid(Fuente fUENTEfuenteid) {
        this.fUENTEfuenteid = fUENTEfuenteid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactoFuenteId != null ? contactoFuenteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactoHasFuente)) {
            return false;
        }
        ContactoHasFuente other = (ContactoHasFuente) object;
        if ((this.contactoFuenteId == null && other.contactoFuenteId != null) || (this.contactoFuenteId != null && !this.contactoFuenteId.equals(other.contactoFuenteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.ContactoHasFuente[ contactoFuenteId=" + contactoFuenteId + " ]";
    }
    
}
