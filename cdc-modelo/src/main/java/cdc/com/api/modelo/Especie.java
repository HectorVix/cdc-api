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
@Table(name = "especie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especie.findAll", query = "SELECT e FROM Especie e")
    , @NamedQuery(name = "Especie.findByEspecieId", query = "SELECT e FROM Especie e WHERE e.especieId = :especieId")
    , @NamedQuery(name = "Especie.findByNombre", query = "SELECT e FROM Especie e WHERE e.nombre = :nombre")})
public class Especie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "especie_id")
    private Integer especieId;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "eSPECIEespecieid")
    private List<Infraspecificepithet> infraspecificepithetList;
    @JoinColumn(name = "GENERO_genero_id", referencedColumnName = "genero_id")
    @ManyToOne
    private Genero gENEROgeneroid;

    public Especie() {
    }

    public Especie(Integer especieId) {
        this.especieId = especieId;
    }

    public Integer getEspecieId() {
        return especieId;
    }

    public void setEspecieId(Integer especieId) {
        this.especieId = especieId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Infraspecificepithet> getInfraspecificepithetList() {
        return infraspecificepithetList;
    }

    public void setInfraspecificepithetList(List<Infraspecificepithet> infraspecificepithetList) {
        this.infraspecificepithetList = infraspecificepithetList;
    }

    public Genero getGENEROgeneroid() {
        return gENEROgeneroid;
    }

    public void setGENEROgeneroid(Genero gENEROgeneroid) {
        this.gENEROgeneroid = gENEROgeneroid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especieId != null ? especieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especie)) {
            return false;
        }
        Especie other = (Especie) object;
        if ((this.especieId == null && other.especieId != null) || (this.especieId != null && !this.especieId.equals(other.especieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Especie[ especieId=" + especieId + " ]";
    }
    
}
