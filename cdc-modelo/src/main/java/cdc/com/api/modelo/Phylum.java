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
@Table(name = "phylum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phylum.findAll", query = "SELECT p FROM Phylum p")
    , @NamedQuery(name = "Phylum.findByPhylumId", query = "SELECT p FROM Phylum p WHERE p.phylumId = :phylumId")
    , @NamedQuery(name = "Phylum.findByNombre", query = "SELECT p FROM Phylum p WHERE p.nombre = :nombre")})
public class Phylum implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "phylum_id")
    private Integer phylumId;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "pHYLUMphylumid")
    private List<Clase> claseList;
    @JoinColumn(name = "REINO_reino_id", referencedColumnName = "reino_id")
    @ManyToOne
    private Reino rEINOreinoid;

    public Phylum() {
    }

    public Phylum(Integer phylumId) {
        this.phylumId = phylumId;
    }

    public Integer getPhylumId() {
        return phylumId;
    }

    public void setPhylumId(Integer phylumId) {
        this.phylumId = phylumId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Clase> getClaseList() {
        return claseList;
    }

    public void setClaseList(List<Clase> claseList) {
        this.claseList = claseList;
    }

    public Reino getREINOreinoid() {
        return rEINOreinoid;
    }

    public void setREINOreinoid(Reino rEINOreinoid) {
        this.rEINOreinoid = rEINOreinoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phylumId != null ? phylumId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phylum)) {
            return false;
        }
        Phylum other = (Phylum) object;
        if ((this.phylumId == null && other.phylumId != null) || (this.phylumId != null && !this.phylumId.equals(other.phylumId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Phylum[ phylumId=" + phylumId + " ]";
    }
    
}
