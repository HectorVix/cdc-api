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
@Table(name = "clase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c")
    , @NamedQuery(name = "Clase.findByClaseId", query = "SELECT c FROM Clase c WHERE c.claseId = :claseId")
    , @NamedQuery(name = "Clase.findByNombre", query = "SELECT c FROM Clase c WHERE c.nombre = :nombre")})
public class Clase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clase_id")
    private Integer claseId;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "cLASEclaseid")
    private List<Orden> ordenList;
    @JoinColumn(name = "PHYLUM_phylum_id", referencedColumnName = "phylum_id")
    @ManyToOne
    private Phylum pHYLUMphylumid;

    public Clase() {
    }

    public Clase(Integer claseId) {
        this.claseId = claseId;
    }

    public Integer getClaseId() {
        return claseId;
    }

    public void setClaseId(Integer claseId) {
        this.claseId = claseId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Orden> getOrdenList() {
        return ordenList;
    }

    public void setOrdenList(List<Orden> ordenList) {
        this.ordenList = ordenList;
    }

    public Phylum getPHYLUMphylumid() {
        return pHYLUMphylumid;
    }

    public void setPHYLUMphylumid(Phylum pHYLUMphylumid) {
        this.pHYLUMphylumid = pHYLUMphylumid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claseId != null ? claseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.claseId == null && other.claseId != null) || (this.claseId != null && !this.claseId.equals(other.claseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Clase[ claseId=" + claseId + " ]";
    }
    
}
