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
@Table(name = "sitio_has_lote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SitioHasLote.findAll", query = "SELECT s FROM SitioHasLote s")
    , @NamedQuery(name = "SitioHasLote.findBySitioLoteId", query = "SELECT s FROM SitioHasLote s WHERE s.sitioLoteId = :sitioLoteId")})
public class SitioHasLote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sitio_lote_id")
    private Integer sitioLoteId;
    @JoinColumn(name = "LOTE_lote_id", referencedColumnName = "lote_id")
    @ManyToOne
    private Lote lOTEloteid;
    @JoinColumn(name = "SITIO_sitio_id", referencedColumnName = "sitio_id")
    @ManyToOne
    private Sitio sITIOsitioid;

    public SitioHasLote() {
    }

    public SitioHasLote(Integer sitioLoteId) {
        this.sitioLoteId = sitioLoteId;
    }

    public Integer getSitioLoteId() {
        return sitioLoteId;
    }

    public void setSitioLoteId(Integer sitioLoteId) {
        this.sitioLoteId = sitioLoteId;
    }

    public Lote getLOTEloteid() {
        return lOTEloteid;
    }

    public void setLOTEloteid(Lote lOTEloteid) {
        this.lOTEloteid = lOTEloteid;
    }

    public Sitio getSITIOsitioid() {
        return sITIOsitioid;
    }

    public void setSITIOsitioid(Sitio sITIOsitioid) {
        this.sITIOsitioid = sITIOsitioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sitioLoteId != null ? sitioLoteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SitioHasLote)) {
            return false;
        }
        SitioHasLote other = (SitioHasLote) object;
        if ((this.sitioLoteId == null && other.sitioLoteId != null) || (this.sitioLoteId != null && !this.sitioLoteId.equals(other.sitioLoteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.SitioHasLote[ sitioLoteId=" + sitioLoteId + " ]";
    }
    
}
