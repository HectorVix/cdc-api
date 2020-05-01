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
@Table(name = "familia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familia.findAll", query = "SELECT f FROM Familia f")
    , @NamedQuery(name = "Familia.findByFamiliaId", query = "SELECT f FROM Familia f WHERE f.familiaId = :familiaId")
    , @NamedQuery(name = "Familia.findByNombre", query = "SELECT f FROM Familia f WHERE f.nombre = :nombre")})
public class Familia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "familia_id")
    private Integer familiaId;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "fAMILIAfamiliaid")
    private List<Genero> generoList;
    @JoinColumn(name = "ORDEN_orden_id", referencedColumnName = "orden_id")
    @ManyToOne
    private Orden oRDENordenid;

    public Familia() {
    }

    public Familia(Integer familiaId) {
        this.familiaId = familiaId;
    }

    public Integer getFamiliaId() {
        return familiaId;
    }

    public void setFamiliaId(Integer familiaId) {
        this.familiaId = familiaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Genero> getGeneroList() {
        return generoList;
    }

    public void setGeneroList(List<Genero> generoList) {
        this.generoList = generoList;
    }

    public Orden getORDENordenid() {
        return oRDENordenid;
    }

    public void setORDENordenid(Orden oRDENordenid) {
        this.oRDENordenid = oRDENordenid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (familiaId != null ? familiaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familia)) {
            return false;
        }
        Familia other = (Familia) object;
        if ((this.familiaId == null && other.familiaId != null) || (this.familiaId != null && !this.familiaId.equals(other.familiaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Familia[ familiaId=" + familiaId + " ]";
    }
    
}
