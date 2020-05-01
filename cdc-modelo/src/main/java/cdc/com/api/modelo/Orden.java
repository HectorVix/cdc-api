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
@Table(name = "orden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o")
    , @NamedQuery(name = "Orden.findByOrdenId", query = "SELECT o FROM Orden o WHERE o.ordenId = :ordenId")
    , @NamedQuery(name = "Orden.findByNombre", query = "SELECT o FROM Orden o WHERE o.nombre = :nombre")})
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orden_id")
    private Integer ordenId;
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "CLASE_clase_id", referencedColumnName = "clase_id")
    @ManyToOne
    private Clase cLASEclaseid;
    @OneToMany(mappedBy = "oRDENordenid")
    private List<Familia> familiaList;

    public Orden() {
    }

    public Orden(Integer ordenId) {
        this.ordenId = ordenId;
    }

    public Integer getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(Integer ordenId) {
        this.ordenId = ordenId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Clase getCLASEclaseid() {
        return cLASEclaseid;
    }

    public void setCLASEclaseid(Clase cLASEclaseid) {
        this.cLASEclaseid = cLASEclaseid;
    }

    @XmlTransient
    public List<Familia> getFamiliaList() {
        return familiaList;
    }

    public void setFamiliaList(List<Familia> familiaList) {
        this.familiaList = familiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenId != null ? ordenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.ordenId == null && other.ordenId != null) || (this.ordenId != null && !this.ordenId.equals(other.ordenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Orden[ ordenId=" + ordenId + " ]";
    }
    
}
