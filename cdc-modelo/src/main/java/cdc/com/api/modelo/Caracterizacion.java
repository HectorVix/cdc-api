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
@Table(name = "caracterizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caracterizacion.findAll", query = "SELECT c FROM Caracterizacion c")
    , @NamedQuery(name = "Caracterizacion.findByCaracterizacionId", query = "SELECT c FROM Caracterizacion c WHERE c.caracterizacionId = :caracterizacionId")
    , @NamedQuery(name = "Caracterizacion.findByCodigoe", query = "SELECT c FROM Caracterizacion c WHERE c.codigoe = :codigoe")})
public class Caracterizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "caracterizacion_id")
    private Integer caracterizacionId;
    @Column(name = "codigoe")
    private String codigoe;
    @JoinColumn(name = "ELEMENTO_elemento_id", referencedColumnName = "elemento_id")
    @ManyToOne(optional = false)
    private Elemento eLEMENTOelementoid;
    @OneToMany(mappedBy = "cARACTERIZACIONcaracterizacionid")
    private List<Planta> plantaList;
    @OneToMany(mappedBy = "cARACTERIZACIONcaracterizacionid")
    private List<Vertebrado> vertebradoList;

    public Caracterizacion() {
    }

    public Caracterizacion(Integer caracterizacionId) {
        this.caracterizacionId = caracterizacionId;
    }

    public Integer getCaracterizacionId() {
        return caracterizacionId;
    }

    public void setCaracterizacionId(Integer caracterizacionId) {
        this.caracterizacionId = caracterizacionId;
    }

    public String getCodigoe() {
        return codigoe;
    }

    public void setCodigoe(String codigoe) {
        this.codigoe = codigoe;
    }

    public Elemento getELEMENTOelementoid() {
        return eLEMENTOelementoid;
    }

    public void setELEMENTOelementoid(Elemento eLEMENTOelementoid) {
        this.eLEMENTOelementoid = eLEMENTOelementoid;
    }

    @XmlTransient
    public List<Planta> getPlantaList() {
        return plantaList;
    }

    public void setPlantaList(List<Planta> plantaList) {
        this.plantaList = plantaList;
    }

    @XmlTransient
    public List<Vertebrado> getVertebradoList() {
        return vertebradoList;
    }

    public void setVertebradoList(List<Vertebrado> vertebradoList) {
        this.vertebradoList = vertebradoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caracterizacionId != null ? caracterizacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caracterizacion)) {
            return false;
        }
        Caracterizacion other = (Caracterizacion) object;
        if ((this.caracterizacionId == null && other.caracterizacionId != null) || (this.caracterizacionId != null && !this.caracterizacionId.equals(other.caracterizacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Caracterizacion[ caracterizacionId=" + caracterizacionId + " ]";
    }
    
}
