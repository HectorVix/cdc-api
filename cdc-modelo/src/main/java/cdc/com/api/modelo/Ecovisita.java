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
@Table(name = "ecovisita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecovisita.findAll", query = "SELECT e FROM Ecovisita e")
    , @NamedQuery(name = "Ecovisita.findByEcovisitaId", query = "SELECT e FROM Ecovisita e WHERE e.ecovisitaId = :ecovisitaId")})
public class Ecovisita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ecovisita_id")
    private Integer ecovisitaId;
    @JoinColumn(name = "ECOMONITOREO_ecomonitoreo_id", referencedColumnName = "ecomonitoreo_id")
    @ManyToOne
    private Ecomonitoreo eCOMONITOREOecomonitoreoid;

    public Ecovisita() {
    }

    public Ecovisita(Integer ecovisitaId) {
        this.ecovisitaId = ecovisitaId;
    }

    public Integer getEcovisitaId() {
        return ecovisitaId;
    }

    public void setEcovisitaId(Integer ecovisitaId) {
        this.ecovisitaId = ecovisitaId;
    }

    public Ecomonitoreo getECOMONITOREOecomonitoreoid() {
        return eCOMONITOREOecomonitoreoid;
    }

    public void setECOMONITOREOecomonitoreoid(Ecomonitoreo eCOMONITOREOecomonitoreoid) {
        this.eCOMONITOREOecomonitoreoid = eCOMONITOREOecomonitoreoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ecovisitaId != null ? ecovisitaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecovisita)) {
            return false;
        }
        Ecovisita other = (Ecovisita) object;
        if ((this.ecovisitaId == null && other.ecovisitaId != null) || (this.ecovisitaId != null && !this.ecovisitaId.equals(other.ecovisitaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Ecovisita[ ecovisitaId=" + ecovisitaId + " ]";
    }
    
}
