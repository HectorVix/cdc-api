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
@Table(name = "infraspecificepithet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Infraspecificepithet.findAll", query = "SELECT i FROM Infraspecificepithet i")
    , @NamedQuery(name = "Infraspecificepithet.findByInfraspecificepithetId", query = "SELECT i FROM Infraspecificepithet i WHERE i.infraspecificepithetId = :infraspecificepithetId")
    , @NamedQuery(name = "Infraspecificepithet.findByNombre", query = "SELECT i FROM Infraspecificepithet i WHERE i.nombre = :nombre")})
public class Infraspecificepithet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "infraspecificepithet_id")
    private Integer infraspecificepithetId;
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "ESPECIE_especie_id", referencedColumnName = "especie_id")
    @ManyToOne
    private Especie eSPECIEespecieid;

    public Infraspecificepithet() {
    }

    public Infraspecificepithet(Integer infraspecificepithetId) {
        this.infraspecificepithetId = infraspecificepithetId;
    }

    public Integer getInfraspecificepithetId() {
        return infraspecificepithetId;
    }

    public void setInfraspecificepithetId(Integer infraspecificepithetId) {
        this.infraspecificepithetId = infraspecificepithetId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especie getESPECIEespecieid() {
        return eSPECIEespecieid;
    }

    public void setESPECIEespecieid(Especie eSPECIEespecieid) {
        this.eSPECIEespecieid = eSPECIEespecieid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (infraspecificepithetId != null ? infraspecificepithetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Infraspecificepithet)) {
            return false;
        }
        Infraspecificepithet other = (Infraspecificepithet) object;
        if ((this.infraspecificepithetId == null && other.infraspecificepithetId != null) || (this.infraspecificepithetId != null && !this.infraspecificepithetId.equals(other.infraspecificepithetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Infraspecificepithet[ infraspecificepithetId=" + infraspecificepithetId + " ]";
    }
    
}
