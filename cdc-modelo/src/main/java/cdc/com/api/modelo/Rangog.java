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
@Table(name = "rangog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rangog.findAll", query = "SELECT r FROM Rangog r")
    , @NamedQuery(name = "Rangog.findByRangogId", query = "SELECT r FROM Rangog r WHERE r.rangogId = :rangogId")
    , @NamedQuery(name = "Rangog.findByRangog", query = "SELECT r FROM Rangog r WHERE r.rangog = :rangog")})
public class Rangog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rangog_id")
    private Integer rangogId;
    @Column(name = "rangog")
    private String rangog;
    @JoinColumn(name = "USUARIO_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario uSUARIOusuarioid;

    public Rangog() {
    }

    public Rangog(Integer rangogId) {
        this.rangogId = rangogId;
    }

    public Integer getRangogId() {
        return rangogId;
    }

    public void setRangogId(Integer rangogId) {
        this.rangogId = rangogId;
    }

    public String getRangog() {
        return rangog;
    }

    public void setRangog(String rangog) {
        this.rangog = rangog;
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
        hash += (rangogId != null ? rangogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rangog)) {
            return false;
        }
        Rangog other = (Rangog) object;
        if ((this.rangogId == null && other.rangogId != null) || (this.rangogId != null && !this.rangogId.equals(other.rangogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Rangog[ rangogId=" + rangogId + " ]";
    }
    
}
