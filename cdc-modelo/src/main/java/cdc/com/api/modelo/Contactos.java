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
@Table(name = "contactos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contactos.findAll", query = "SELECT c FROM Contactos c")
    , @NamedQuery(name = "Contactos.findByContactosId", query = "SELECT c FROM Contactos c WHERE c.contactosId = :contactosId")
    , @NamedQuery(name = "Contactos.findByNumident", query = "SELECT c FROM Contactos c WHERE c.numident = :numident")})
public class Contactos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contactos_id")
    private Integer contactosId;
    @Column(name = "numident")
    private String numident;
    @JoinColumn(name = "USUARIO_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario uSUARIOusuarioid;

    public Contactos() {
    }

    public Contactos(Integer contactosId) {
        this.contactosId = contactosId;
    }

    public Integer getContactosId() {
        return contactosId;
    }

    public void setContactosId(Integer contactosId) {
        this.contactosId = contactosId;
    }

    public String getNumident() {
        return numident;
    }

    public void setNumident(String numident) {
        this.numident = numident;
    }

    public Usuario getUSUARIOusuarioid() {
        return uSUARIOusuarioid;
    }

    public void setUSUARIOusuarioid(Usuario uSUARIOusuarioid) {
        this.uSUARIOusuarioid = uSUARIOusuarioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactosId != null ? contactosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactos)) {
            return false;
        }
        Contactos other = (Contactos) object;
        if ((this.contactosId == null && other.contactosId != null) || (this.contactosId != null && !this.contactosId.equals(other.contactosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Contactos[ contactosId=" + contactosId + " ]";
    }
    
}
