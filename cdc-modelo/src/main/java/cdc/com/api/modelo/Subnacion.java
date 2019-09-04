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
@Table(name = "subnacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subnacion.findAll", query = "SELECT s FROM Subnacion s")
    , @NamedQuery(name = "Subnacion.findBySubnacionId", query = "SELECT s FROM Subnacion s WHERE s.subnacionId = :subnacionId")
    , @NamedQuery(name = "Subnacion.findByCodigo", query = "SELECT s FROM Subnacion s WHERE s.codigo = :codigo")
    , @NamedQuery(name = "Subnacion.findByNombre", query = "SELECT s FROM Subnacion s WHERE s.nombre = :nombre")})
public class Subnacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subnacion_id")
    private Integer subnacionId;
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "sUBNACIONsubnacionid")
    private List<Municipio> municipioList;
    @JoinColumn(name = "NACION_nacion_id", referencedColumnName = "nacion_id")
    @ManyToOne
    private Nacion nACIONnacionid;

    public Subnacion() {
    }

    public Subnacion(Integer subnacionId) {
        this.subnacionId = subnacionId;
    }

    public Integer getSubnacionId() {
        return subnacionId;
    }

    public void setSubnacionId(Integer subnacionId) {
        this.subnacionId = subnacionId;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Municipio> getMunicipioList() {
        return municipioList;
    }

    public void setMunicipioList(List<Municipio> municipioList) {
        this.municipioList = municipioList;
    }

    public Nacion getNACIONnacionid() {
        return nACIONnacionid;
    }

    public void setNACIONnacionid(Nacion nACIONnacionid) {
        this.nACIONnacionid = nACIONnacionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subnacionId != null ? subnacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subnacion)) {
            return false;
        }
        Subnacion other = (Subnacion) object;
        if ((this.subnacionId == null && other.subnacionId != null) || (this.subnacionId != null && !this.subnacionId.equals(other.subnacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Subnacion[ subnacionId=" + subnacionId + " ]";
    }
    
}
