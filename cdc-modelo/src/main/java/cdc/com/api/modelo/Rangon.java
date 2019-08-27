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
@Table(name = "rangon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rangon.findAll", query = "SELECT r FROM Rangon r")
    , @NamedQuery(name = "Rangon.findByRangonId", query = "SELECT r FROM Rangon r WHERE r.rangonId = :rangonId")
    , @NamedQuery(name = "Rangon.findByRangon", query = "SELECT r FROM Rangon r WHERE r.rangon = :rangon")})
public class Rangon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rangon_id")
    private Integer rangonId;
    @Column(name = "rangon")
    private String rangon;
    @JoinColumn(name = "USUARIO_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario uSUARIOusuarioid;

    public Rangon() {
    }

    public Rangon(Integer rangonId) {
        this.rangonId = rangonId;
    }

    public Integer getRangonId() {
        return rangonId;
    }

    public void setRangonId(Integer rangonId) {
        this.rangonId = rangonId;
    }

    public String getRangon() {
        return rangon;
    }

    public void setRangon(String rangon) {
        this.rangon = rangon;
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
        hash += (rangonId != null ? rangonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rangon)) {
            return false;
        }
        Rangon other = (Rangon) object;
        if ((this.rangonId == null && other.rangonId != null) || (this.rangonId != null && !this.rangonId.equals(other.rangonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Rangon[ rangonId=" + rangonId + " ]";
    }
    
}
