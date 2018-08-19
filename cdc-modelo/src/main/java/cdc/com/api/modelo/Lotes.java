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
@Table(name = "lotes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lotes.findAll", query = "SELECT l FROM Lotes l")
    , @NamedQuery(name = "Lotes.findByLotesId", query = "SELECT l FROM Lotes l WHERE l.lotesId = :lotesId")})
public class Lotes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lotes_id")
    private Integer lotesId;
    @ManyToMany(mappedBy = "lotesList")
    private List<Area> areaList;
    @JoinTable(name = "lotes_has_transaccion", joinColumns = {
        @JoinColumn(name = "LOTES_lotes_id", referencedColumnName = "lotes_id")}, inverseJoinColumns = {
        @JoinColumn(name = "TRANSACCION_transaccion_id", referencedColumnName = "transaccion_id")})
    @ManyToMany
    private List<Transaccion> transaccionList;
    @JoinTable(name = "sitio_has_lotes", joinColumns = {
        @JoinColumn(name = "LOTES_lotes_id", referencedColumnName = "lotes_id")}, inverseJoinColumns = {
        @JoinColumn(name = "SITIO_sitio_id", referencedColumnName = "sitio_id")})
    @ManyToMany
    private List<Sitio> sitioList;
    @JoinTable(name = "proyecto_has_lotes", joinColumns = {
        @JoinColumn(name = "LOTES_lotes_id", referencedColumnName = "lotes_id")}, inverseJoinColumns = {
        @JoinColumn(name = "PROYECTO_proyecto_id", referencedColumnName = "proyecto_id")})
    @ManyToMany
    private List<Proyecto> proyectoList;

    public Lotes() {
    }

    public Lotes(Integer lotesId) {
        this.lotesId = lotesId;
    }

    public Integer getLotesId() {
        return lotesId;
    }

    public void setLotesId(Integer lotesId) {
        this.lotesId = lotesId;
    }

    @XmlTransient
    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    @XmlTransient
    public List<Transaccion> getTransaccionList() {
        return transaccionList;
    }

    public void setTransaccionList(List<Transaccion> transaccionList) {
        this.transaccionList = transaccionList;
    }

    @XmlTransient
    public List<Sitio> getSitioList() {
        return sitioList;
    }

    public void setSitioList(List<Sitio> sitioList) {
        this.sitioList = sitioList;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lotesId != null ? lotesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lotes)) {
            return false;
        }
        Lotes other = (Lotes) object;
        if ((this.lotesId == null && other.lotesId != null) || (this.lotesId != null && !this.lotesId.equals(other.lotesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Lotes[ lotesId=" + lotesId + " ]";
    }
    
}
