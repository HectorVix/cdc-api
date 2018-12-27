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
@Table(name = "distribucion2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distribucion2.findAll", query = "SELECT d FROM Distribucion2 d")
    , @NamedQuery(name = "Distribucion2.findByDistribucion2Id", query = "SELECT d FROM Distribucion2 d WHERE d.distribucion2Id = :distribucion2Id")
    , @NamedQuery(name = "Distribucion2.findByCodecoregn", query = "SELECT d FROM Distribucion2 d WHERE d.codecoregn = :codecoregn")
    , @NamedQuery(name = "Distribucion2.findByStatecoregn", query = "SELECT d FROM Distribucion2 d WHERE d.statecoregn = :statecoregn")
    , @NamedQuery(name = "Distribucion2.findByCodcuencan", query = "SELECT d FROM Distribucion2 d WHERE d.codcuencan = :codcuencan")
    , @NamedQuery(name = "Distribucion2.findByStatcuencan", query = "SELECT d FROM Distribucion2 d WHERE d.statcuencan = :statcuencan")})
public class Distribucion2 implements Serializable {

    @JoinColumn(name = "VERTEBRADO_vertebrado_id", referencedColumnName = "vertebrado_id")
    @ManyToOne
    private Vertebrado vERTEBRADOvertebradoid;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "distribucion2_id")
    private Integer distribucion2Id;
    @Column(name = "codecoregn")
    private String codecoregn;
    @Column(name = "statecoregn")
    private String statecoregn;
    @Column(name = "codcuencan")
    private String codcuencan;
    @Column(name = "statcuencan")
    private String statcuencan;
    @JoinColumn(name = "PLANTA_planta_id", referencedColumnName = "planta_id")
    @ManyToOne
    private Planta pLANTAplantaid;

    public Distribucion2() {
    }

    public Distribucion2(Integer distribucion2Id) {
        this.distribucion2Id = distribucion2Id;
    }

    public Integer getDistribucion2Id() {
        return distribucion2Id;
    }

    public void setDistribucion2Id(Integer distribucion2Id) {
        this.distribucion2Id = distribucion2Id;
    }

    public String getCodecoregn() {
        return codecoregn;
    }

    public void setCodecoregn(String codecoregn) {
        this.codecoregn = codecoregn;
    }

    public String getStatecoregn() {
        return statecoregn;
    }

    public void setStatecoregn(String statecoregn) {
        this.statecoregn = statecoregn;
    }

    public String getCodcuencan() {
        return codcuencan;
    }

    public void setCodcuencan(String codcuencan) {
        this.codcuencan = codcuencan;
    }

    public String getStatcuencan() {
        return statcuencan;
    }

    public void setStatcuencan(String statcuencan) {
        this.statcuencan = statcuencan;
    }

    public Planta getPLANTAplantaid() {
        return pLANTAplantaid;
    }

    public void setPLANTAplantaid(Planta pLANTAplantaid) {
        this.pLANTAplantaid = pLANTAplantaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (distribucion2Id != null ? distribucion2Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distribucion2)) {
            return false;
        }
        Distribucion2 other = (Distribucion2) object;
        if ((this.distribucion2Id == null && other.distribucion2Id != null) || (this.distribucion2Id != null && !this.distribucion2Id.equals(other.distribucion2Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Distribucion2[ distribucion2Id=" + distribucion2Id + " ]";
    }

    public Vertebrado getVERTEBRADOvertebradoid() {
        return vERTEBRADOvertebradoid;
    }

    public void setVERTEBRADOvertebradoid(Vertebrado vERTEBRADOvertebradoid) {
        this.vERTEBRADOvertebradoid = vERTEBRADOvertebradoid;
    }
    
}
