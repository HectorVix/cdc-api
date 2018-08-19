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
    , @NamedQuery(name = "Sitio.findBySitioId", query = "SELECT s FROM Sitio s WHERE s.sitioId = :sitioId")})
public class Sitio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sitio_id")
    private Integer sitioId;
    @ManyToMany(mappedBy = "sitioList")
    private List<Localizacion> localizacionList;
    @ManyToMany(mappedBy = "sitioList")
    private List<Ecomonitoreo> ecomonitoreoList;
    @ManyToMany(mappedBy = "sitioList")
    private List<Lotes> lotesList;
    @ManyToMany(mappedBy = "sitioList")
    private List<Area> areaList;
    @ManyToMany(mappedBy = "sitioList")
    private List<Proyecto> proyectoList;
    @OneToMany(mappedBy = "sITIOsitioid")
    private List<Localizador> localizadorList;
    @OneToMany(mappedBy = "sITIOsitioid")
    private List<Foto> fotoList;
    @OneToMany(mappedBy = "sITIOsitioid")
    private List<Identificador> identificadorList;

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

    @XmlTransient
    public List<Localizacion> getLocalizacionList() {
        return localizacionList;
    }

    public void setLocalizacionList(List<Localizacion> localizacionList) {
        this.localizacionList = localizacionList;
    }

    @XmlTransient
    public List<Ecomonitoreo> getEcomonitoreoList() {
        return ecomonitoreoList;
    }

    public void setEcomonitoreoList(List<Ecomonitoreo> ecomonitoreoList) {
        this.ecomonitoreoList = ecomonitoreoList;
    }

    @XmlTransient
    public List<Lotes> getLotesList() {
        return lotesList;
    }

    public void setLotesList(List<Lotes> lotesList) {
        this.lotesList = lotesList;
    }

    @XmlTransient
    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @XmlTransient
    public List<Localizador> getLocalizadorList() {
        return localizadorList;
    }

    public void setLocalizadorList(List<Localizador> localizadorList) {
        this.localizadorList = localizadorList;
    }

    @XmlTransient
    public List<Foto> getFotoList() {
        return fotoList;
    }

    public void setFotoList(List<Foto> fotoList) {
        this.fotoList = fotoList;
    }

    @XmlTransient
    public List<Identificador> getIdentificadorList() {
        return identificadorList;
    }

    public void setIdentificadorList(List<Identificador> identificadorList) {
        this.identificadorList = identificadorList;
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
