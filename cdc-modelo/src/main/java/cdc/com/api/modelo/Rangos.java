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
@Table(name = "rangos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rangos.findAll", query = "SELECT r FROM Rangos r")
    , @NamedQuery(name = "Rangos.findByRangosId", query = "SELECT r FROM Rangos r WHERE r.rangosId = :rangosId")
    , @NamedQuery(name = "Rangos.findByRangos", query = "SELECT r FROM Rangos r WHERE r.rangos = :rangos")})
public class Rangos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rangos_id")
    private Integer rangosId;
    @Column(name = "rangos")
    private String rangos;
    @JoinColumn(name = "USUARIO_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario uSUARIOusuarioid;

    public Rangos() {
    }

    public Rangos(Integer rangosId) {
        this.rangosId = rangosId;
    }

    public Integer getRangosId() {
        return rangosId;
    }

    public void setRangosId(Integer rangosId) {
        this.rangosId = rangosId;
    }

    public String getRangos() {
        return rangos;
    }

    public void setRangos(String rangos) {
        this.rangos = rangos;
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
        hash += (rangosId != null ? rangosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rangos)) {
            return false;
        }
        Rangos other = (Rangos) object;
        if ((this.rangosId == null && other.rangosId != null) || (this.rangosId != null && !this.rangosId.equals(other.rangosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Rangos[ rangosId=" + rangosId + " ]";
    }
    
}
