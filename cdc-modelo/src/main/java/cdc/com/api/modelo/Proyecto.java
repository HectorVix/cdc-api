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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Héctor Vix
 */
@Entity
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByProyectoId", query = "SELECT p FROM Proyecto p WHERE p.proyectoId = :proyectoId")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proyecto_id")
    private Integer proyectoId;
    @JoinTable(name = "proyecto_has_transaccion", joinColumns = {
        @JoinColumn(name = "PROYECTO_proyecto_id", referencedColumnName = "proyecto_id")}, inverseJoinColumns = {
        @JoinColumn(name = "TRANSACCION_transaccion_id", referencedColumnName = "transaccion_id")})
    @ManyToMany
    private List<Transaccion> transaccionList;
    @ManyToMany(mappedBy = "proyectoList")
    private List<Lotes> lotesList;
    @JoinTable(name = "sitio_has_proyecto", joinColumns = {
        @JoinColumn(name = "PROYECTO_proyecto_id", referencedColumnName = "proyecto_id")}, inverseJoinColumns = {
        @JoinColumn(name = "SITIO_sitio_id", referencedColumnName = "sitio_id")})
    @ManyToMany
    private List<Sitio> sitioList;

    public Proyecto() {
    }

    public Proyecto(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }

    public Integer getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }

    @XmlTransient
    public List<Transaccion> getTransaccionList() {
        return transaccionList;
    }

    public void setTransaccionList(List<Transaccion> transaccionList) {
        this.transaccionList = transaccionList;
    }

    @XmlTransient
    public List<Lotes> getLotesList() {
        return lotesList;
    }

    public void setLotesList(List<Lotes> lotesList) {
        this.lotesList = lotesList;
    }

    @XmlTransient
    public List<Sitio> getSitioList() {
        return sitioList;
    }

    public void setSitioList(List<Sitio> sitioList) {
        this.sitioList = sitioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectoId != null ? proyectoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.proyectoId == null && other.proyectoId != null) || (this.proyectoId != null && !this.proyectoId.equals(other.proyectoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Proyecto[ proyectoId=" + proyectoId + " ]";
    }
    
}
