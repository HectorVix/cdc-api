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
@Table(name = "ecomonitoreo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecomonitoreo.findAll", query = "SELECT e FROM Ecomonitoreo e")
    , @NamedQuery(name = "Ecomonitoreo.findByEcomonitoreoId", query = "SELECT e FROM Ecomonitoreo e WHERE e.ecomonitoreoId = :ecomonitoreoId")})
public class Ecomonitoreo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ecomonitoreo_id")
    private Integer ecomonitoreoId;
    @JoinTable(name = "ecomonitoreo_has_sitio", joinColumns = {
        @JoinColumn(name = "ECOMONITOREO_ecomonitoreo_id", referencedColumnName = "ecomonitoreo_id")}, inverseJoinColumns = {
        @JoinColumn(name = "SITIO_sitio_id", referencedColumnName = "sitio_id")})
    @ManyToMany
    private List<Sitio> sitioList;
    @JoinColumn(name = "LOCALIZACION_localizacion_id", referencedColumnName = "localizacion_id")
    @ManyToOne
    private Localizacion lOCALIZACIONlocalizacionid;
    @OneToMany(mappedBy = "eCOMONITOREOecomonitoreoid")
    private List<Ecovisita> ecovisitaList;

    public Ecomonitoreo() {
    }

    public Ecomonitoreo(Integer ecomonitoreoId) {
        this.ecomonitoreoId = ecomonitoreoId;
    }

    public Integer getEcomonitoreoId() {
        return ecomonitoreoId;
    }

    public void setEcomonitoreoId(Integer ecomonitoreoId) {
        this.ecomonitoreoId = ecomonitoreoId;
    }

    @XmlTransient
    public List<Sitio> getSitioList() {
        return sitioList;
    }

    public void setSitioList(List<Sitio> sitioList) {
        this.sitioList = sitioList;
    }

    public Localizacion getLOCALIZACIONlocalizacionid() {
        return lOCALIZACIONlocalizacionid;
    }

    public void setLOCALIZACIONlocalizacionid(Localizacion lOCALIZACIONlocalizacionid) {
        this.lOCALIZACIONlocalizacionid = lOCALIZACIONlocalizacionid;
    }

    @XmlTransient
    public List<Ecovisita> getEcovisitaList() {
        return ecovisitaList;
    }

    public void setEcovisitaList(List<Ecovisita> ecovisitaList) {
        this.ecovisitaList = ecovisitaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ecomonitoreoId != null ? ecomonitoreoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecomonitoreo)) {
            return false;
        }
        Ecomonitoreo other = (Ecomonitoreo) object;
        if ((this.ecomonitoreoId == null && other.ecomonitoreoId != null) || (this.ecomonitoreoId != null && !this.ecomonitoreoId.equals(other.ecomonitoreoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Ecomonitoreo[ ecomonitoreoId=" + ecomonitoreoId + " ]";
    }
    
}
