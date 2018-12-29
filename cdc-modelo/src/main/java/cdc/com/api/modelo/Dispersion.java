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
    , @NamedQuery(name = "Dispersion.findByDispersionId", query = "SELECT d FROM Dispersion d WHERE d.dispersionId = :dispersionId")
    , @NamedQuery(name = "Dispersion.findByLe", query = "SELECT d FROM Dispersion d WHERE d.le = :le")
    , @NamedQuery(name = "Dispersion.findByNommapanummarg", query = "SELECT d FROM Dispersion d WHERE d.nommapanummarg = :nommapanummarg")
    , @NamedQuery(name = "Dispersion.findByProv", query = "SELECT d FROM Dispersion d WHERE d.prov = :prov")
    , @NamedQuery(name = "Dispersion.findByDireccion", query = "SELECT d FROM Dispersion d WHERE d.direccion = :direccion")
    , @NamedQuery(name = "Dispersion.findByUltobs", query = "SELECT d FROM Dispersion d WHERE d.ultobs = :ultobs")})
public class Dispersion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dispersion_id")
    private Integer dispersionId;
    @Column(name = "le")
    private String le;
    @Column(name = "nommapanummarg")
    private String nommapanummarg;
    @Column(name = "prov")
    private String prov;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "ultobs")
    private String ultobs;
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

    public String getLe() {
        return le;
    }

    public void setLe(String le) {
        this.le = le;
    }

    public String getNommapanummarg() {
        return nommapanummarg;
    }

    public void setNommapanummarg(String nommapanummarg) {
        this.nommapanummarg = nommapanummarg;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUltobs() {
        return ultobs;
    }

    public void setUltobs(String ultobs) {
        this.ultobs = ultobs;
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
