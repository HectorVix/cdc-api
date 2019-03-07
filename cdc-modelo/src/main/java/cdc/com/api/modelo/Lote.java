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
@Table(name = "lote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lote.findAll", query = "SELECT l FROM Lote l")
    , @NamedQuery(name = "Lote.findByLoteId", query = "SELECT l FROM Lote l WHERE l.loteId = :loteId")})
public class Lote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lote_id")
    private Integer loteId;
    @OneToMany(mappedBy = "lOTEloteid")
    private List<SitioHasLote> sitioHasLoteList;
    @OneToMany(mappedBy = "lOTEloteid")
    private List<ContactoHasLote> contactoHasLoteList;
    @OneToMany(mappedBy = "lOTEloteid")
    private List<AreaHasLote> areaHasLoteList;

    public Lote() {
    }

    public Lote(Integer loteId) {
        this.loteId = loteId;
    }

    public Integer getLoteId() {
        return loteId;
    }

    public void setLoteId(Integer loteId) {
        this.loteId = loteId;
    }

    @XmlTransient
    public List<SitioHasLote> getSitioHasLoteList() {
        return sitioHasLoteList;
    }

    public void setSitioHasLoteList(List<SitioHasLote> sitioHasLoteList) {
        this.sitioHasLoteList = sitioHasLoteList;
    }

    @XmlTransient
    public List<ContactoHasLote> getContactoHasLoteList() {
        return contactoHasLoteList;
    }

    public void setContactoHasLoteList(List<ContactoHasLote> contactoHasLoteList) {
        this.contactoHasLoteList = contactoHasLoteList;
    }

    @XmlTransient
    public List<AreaHasLote> getAreaHasLoteList() {
        return areaHasLoteList;
    }

    public void setAreaHasLoteList(List<AreaHasLote> areaHasLoteList) {
        this.areaHasLoteList = areaHasLoteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loteId != null ? loteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lote)) {
            return false;
        }
        Lote other = (Lote) object;
        if ((this.loteId == null && other.loteId != null) || (this.loteId != null && !this.loteId.equals(other.loteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Lote[ loteId=" + loteId + " ]";
    }
    
}
