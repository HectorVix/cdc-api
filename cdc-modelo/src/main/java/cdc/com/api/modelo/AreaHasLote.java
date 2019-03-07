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
@Table(name = "area_has_lote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaHasLote.findAll", query = "SELECT a FROM AreaHasLote a")
    , @NamedQuery(name = "AreaHasLote.findByAreaLoteId", query = "SELECT a FROM AreaHasLote a WHERE a.areaLoteId = :areaLoteId")})
public class AreaHasLote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "area_lote_id")
    private Integer areaLoteId;
    @JoinColumn(name = "AREA_area_id", referencedColumnName = "area_id")
    @ManyToOne
    private Area aREAareaid;
    @JoinColumn(name = "LOTE_lote_id", referencedColumnName = "lote_id")
    @ManyToOne
    private Lote lOTEloteid;

    public AreaHasLote() {
    }

    public AreaHasLote(Integer areaLoteId) {
        this.areaLoteId = areaLoteId;
    }

    public Integer getAreaLoteId() {
        return areaLoteId;
    }

    public void setAreaLoteId(Integer areaLoteId) {
        this.areaLoteId = areaLoteId;
    }

    public Area getAREAareaid() {
        return aREAareaid;
    }

    public void setAREAareaid(Area aREAareaid) {
        this.aREAareaid = aREAareaid;
    }

    public Lote getLOTEloteid() {
        return lOTEloteid;
    }

    public void setLOTEloteid(Lote lOTEloteid) {
        this.lOTEloteid = lOTEloteid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaLoteId != null ? areaLoteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaHasLote)) {
            return false;
        }
        AreaHasLote other = (AreaHasLote) object;
        if ((this.areaLoteId == null && other.areaLoteId != null) || (this.areaLoteId != null && !this.areaLoteId.equals(other.areaLoteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.AreaHasLote[ areaLoteId=" + areaLoteId + " ]";
    }
    
}
