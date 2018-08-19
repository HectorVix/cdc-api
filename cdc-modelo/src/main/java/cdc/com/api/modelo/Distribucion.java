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
@Table(name = "distribucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distribucion.findAll", query = "SELECT d FROM Distribucion d")
    , @NamedQuery(name = "Distribucion.findByDistribucionId", query = "SELECT d FROM Distribucion d WHERE d.distribucionId = :distribucionId")})
public class Distribucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "distribucion_id")
    private Integer distribucionId;
    @JoinColumn(name = "PLANTA_planta_id", referencedColumnName = "planta_id")
    @ManyToOne
    private Planta pLANTAplantaid;
    @JoinColumn(name = "VERTEBRADO_vertebrado_id", referencedColumnName = "vertebrado_id")
    @ManyToOne
    private Vertebrado vERTEBRADOvertebradoid;

    public Distribucion() {
    }

    public Distribucion(Integer distribucionId) {
        this.distribucionId = distribucionId;
    }

    public Integer getDistribucionId() {
        return distribucionId;
    }

    public void setDistribucionId(Integer distribucionId) {
        this.distribucionId = distribucionId;
    }

    public Planta getPLANTAplantaid() {
        return pLANTAplantaid;
    }

    public void setPLANTAplantaid(Planta pLANTAplantaid) {
        this.pLANTAplantaid = pLANTAplantaid;
    }

    public Vertebrado getVERTEBRADOvertebradoid() {
        return vERTEBRADOvertebradoid;
    }

    public void setVERTEBRADOvertebradoid(Vertebrado vERTEBRADOvertebradoid) {
        this.vERTEBRADOvertebradoid = vERTEBRADOvertebradoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (distribucionId != null ? distribucionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distribucion)) {
            return false;
        }
        Distribucion other = (Distribucion) object;
        if ((this.distribucionId == null && other.distribucionId != null) || (this.distribucionId != null && !this.distribucionId.equals(other.distribucionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Distribucion[ distribucionId=" + distribucionId + " ]";
    }
    
}
