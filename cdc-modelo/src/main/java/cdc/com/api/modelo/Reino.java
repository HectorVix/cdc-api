/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.modelo;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Héctor Vix
 */
@Entity
@Table(name = "reino")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reino.findAll", query = "SELECT r FROM Reino r")
    , @NamedQuery(name = "Reino.findByReinoId", query = "SELECT r FROM Reino r WHERE r.reinoId = :reinoId")
    , @NamedQuery(name = "Reino.findByNombre", query = "SELECT r FROM Reino r WHERE r.nombre = :nombre")})
public class Reino implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reino_id")
    private Integer reinoId;
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "USUARIO_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario uSUARIOusuarioid;
    @OneToMany(mappedBy = "rEINOreinoid")
    private List<Phylum> phylumList;

    public Reino() {
    }

    public Reino(Integer reinoId) {
        this.reinoId = reinoId;
    }

    public Integer getReinoId() {
        return reinoId;
    }

    public void setReinoId(Integer reinoId) {
        this.reinoId = reinoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUSUARIOusuarioid() {
        return uSUARIOusuarioid;
    }

    public void setUSUARIOusuarioid(Usuario uSUARIOusuarioid) {
        this.uSUARIOusuarioid = uSUARIOusuarioid;
    }

    @XmlTransient
    public List<Phylum> getPhylumList() {
        return phylumList;
    }

    public void setPhylumList(List<Phylum> phylumList) {
        this.phylumList = phylumList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reinoId != null ? reinoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reino)) {
            return false;
        }
        Reino other = (Reino) object;
        if ((this.reinoId == null && other.reinoId != null) || (this.reinoId != null && !this.reinoId.equals(other.reinoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Reino[ reinoId=" + reinoId + " ]";
    }
    
}
