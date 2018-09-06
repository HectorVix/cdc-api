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
import javax.persistence.ManyToMany;
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
@Table(name = "sitio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sitio.findAll", query = "SELECT s FROM Sitio s")
    , @NamedQuery(name = "Sitio.findBySitioId", query = "SELECT s FROM Sitio s WHERE s.sitioId = :sitioId")
    , @NamedQuery(name = "Sitio.findByCodsitio", query = "SELECT s FROM Sitio s WHERE s.codsitio = :codsitio")})
public class Sitio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sitio_id")
    private Integer sitioId;
    @Column(name = "codsitio")
    private String codsitio;
    @ManyToMany(mappedBy = "sitioList")
    private List<Localizacion> localizacionList;
    @ManyToMany(mappedBy = "sitioList")
    private List<Area> areaList;
    @OneToMany(mappedBy = "sITIOsitioid")
    private List<Foto> fotoList;
    @OneToMany(mappedBy = "sITIOsitioid")
    private List<Observaciones> observacionesList;

    public Sitio() {
    }

    public Sitio(Integer sitioId) {
        this.sitioId = sitioId;
    }

    public Integer getSitioId() {
        return sitioId;
    }

    public void setSitioId(Integer sitioId) {
        this.sitioId = sitioId;
    }

    public String getCodsitio() {
        return codsitio;
    }

    public void setCodsitio(String codsitio) {
        this.codsitio = codsitio;
    }

    @XmlTransient
    public List<Localizacion> getLocalizacionList() {
        return localizacionList;
    }

    public void setLocalizacionList(List<Localizacion> localizacionList) {
        this.localizacionList = localizacionList;
    }

    @XmlTransient
    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    @XmlTransient
    public List<Foto> getFotoList() {
        return fotoList;
    }

    public void setFotoList(List<Foto> fotoList) {
        this.fotoList = fotoList;
    }

    @XmlTransient
    public List<Observaciones> getObservacionesList() {
        return observacionesList;
    }

    public void setObservacionesList(List<Observaciones> observacionesList) {
        this.observacionesList = observacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sitioId != null ? sitioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sitio)) {
            return false;
        }
        Sitio other = (Sitio) object;
        if ((this.sitioId == null && other.sitioId != null) || (this.sitioId != null && !this.sitioId.equals(other.sitioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Sitio[ sitioId=" + sitioId + " ]";
    }
    
}
