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
@Table(name = "dispersion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dispersion.findAll", query = "SELECT d FROM Dispersion d")
    , @NamedQuery(name = "Dispersion.findByDispersionId", query = "SELECT d FROM Dispersion d WHERE d.dispersionId = :dispersionId")})
public class Dispersion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dispersion_id")
    private Integer dispersionId;
    @JoinColumn(name = "PROTOCOLO_protocolo_id", referencedColumnName = "protocolo_id")
    @ManyToOne
    private Protocolo pROTOCOLOprotocoloid;

    public Dispersion() {
    }

    public Dispersion(Integer dispersionId) {
        this.dispersionId = dispersionId;
    }

    public Integer getDispersionId() {
        return dispersionId;
    }

    public void setDispersionId(Integer dispersionId) {
        this.dispersionId = dispersionId;
    }

    public Protocolo getPROTOCOLOprotocoloid() {
        return pROTOCOLOprotocoloid;
    }

    public void setPROTOCOLOprotocoloid(Protocolo pROTOCOLOprotocoloid) {
        this.pROTOCOLOprotocoloid = pROTOCOLOprotocoloid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dispersionId != null ? dispersionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dispersion)) {
            return false;
        }
        Dispersion other = (Dispersion) object;
        if ((this.dispersionId == null && other.dispersionId != null) || (this.dispersionId != null && !this.dispersionId.equals(other.dispersionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Dispersion[ dispersionId=" + dispersionId + " ]";
    }
    
}
