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
@Table(name = "fuente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fuente.findAll", query = "SELECT f FROM Fuente f")
    , @NamedQuery(name = "Fuente.findByFuenteId", query = "SELECT f FROM Fuente f WHERE f.fuenteId = :fuenteId")})
public class Fuente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fuente_id")
    private Integer fuenteId;
    @JoinColumn(name = "USUARIO_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario uSUARIOusuarioid;

    public Fuente() {
    }

    public Fuente(Integer fuenteId) {
        this.fuenteId = fuenteId;
    }

    public Integer getFuenteId() {
        return fuenteId;
    }

    public void setFuenteId(Integer fuenteId) {
        this.fuenteId = fuenteId;
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
        hash += (fuenteId != null ? fuenteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fuente)) {
            return false;
        }
        Fuente other = (Fuente) object;
        if ((this.fuenteId == null && other.fuenteId != null) || (this.fuenteId != null && !this.fuenteId.equals(other.fuenteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Fuente[ fuenteId=" + fuenteId + " ]";
    }
    
}
