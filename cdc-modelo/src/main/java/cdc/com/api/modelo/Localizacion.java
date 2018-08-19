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
@Table(name = "localizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localizacion.findAll", query = "SELECT l FROM Localizacion l")
    , @NamedQuery(name = "Localizacion.findByLocalizacionId", query = "SELECT l FROM Localizacion l WHERE l.localizacionId = :localizacionId")})
public class Localizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "localizacion_id")
    private Integer localizacionId;
    @JoinTable(name = "localizacion_has_sitio", joinColumns = {
        @JoinColumn(name = "LOCALIZACION_localizacion_id", referencedColumnName = "localizacion_id")}, inverseJoinColumns = {
        @JoinColumn(name = "SITIO_sitio_id", referencedColumnName = "sitio_id")})
    @ManyToMany
    private List<Sitio> sitioList;
    @OneToMany(mappedBy = "lOCALIZACIONlocalizacionid")
    private List<Proteccion> proteccionList;
    @OneToMany(mappedBy = "lOCALIZACIONlocalizacionid")
    private List<Ecomonitoreo> ecomonitoreoList;
    @OneToMany(mappedBy = "lOCALIZACIONlocalizacionid")
    private List<Protocolo> protocoloList;
    @JoinColumn(name = "RASTREO_rastreo_id", referencedColumnName = "rastreo_id")
    @ManyToOne
    private Rastreo rASTREOrastreoid;

    public Localizacion() {
    }

    public Localizacion(Integer localizacionId) {
        this.localizacionId = localizacionId;
    }

    public Integer getLocalizacionId() {
        return localizacionId;
    }

    public void setLocalizacionId(Integer localizacionId) {
        this.localizacionId = localizacionId;
    }

    @XmlTransient
    public List<Sitio> getSitioList() {
        return sitioList;
    }

    public void setSitioList(List<Sitio> sitioList) {
        this.sitioList = sitioList;
    }

    @XmlTransient
    public List<Proteccion> getProteccionList() {
        return proteccionList;
    }

    public void setProteccionList(List<Proteccion> proteccionList) {
        this.proteccionList = proteccionList;
    }

    @XmlTransient
    public List<Ecomonitoreo> getEcomonitoreoList() {
        return ecomonitoreoList;
    }

    public void setEcomonitoreoList(List<Ecomonitoreo> ecomonitoreoList) {
        this.ecomonitoreoList = ecomonitoreoList;
    }

    @XmlTransient
    public List<Protocolo> getProtocoloList() {
        return protocoloList;
    }

    public void setProtocoloList(List<Protocolo> protocoloList) {
        this.protocoloList = protocoloList;
    }

    public Rastreo getRASTREOrastreoid() {
        return rASTREOrastreoid;
    }

    public void setRASTREOrastreoid(Rastreo rASTREOrastreoid) {
        this.rASTREOrastreoid = rASTREOrastreoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localizacionId != null ? localizacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localizacion)) {
            return false;
        }
        Localizacion other = (Localizacion) object;
        if ((this.localizacionId == null && other.localizacionId != null) || (this.localizacionId != null && !this.localizacionId.equals(other.localizacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Localizacion[ localizacionId=" + localizacionId + " ]";
    }
    
}
