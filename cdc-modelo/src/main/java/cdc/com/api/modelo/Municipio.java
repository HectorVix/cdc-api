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
@Table(name = "municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m")
    , @NamedQuery(name = "Municipio.findByMunicipioId", query = "SELECT m FROM Municipio m WHERE m.municipioId = :municipioId")
    , @NamedQuery(name = "Municipio.findByCodigo", query = "SELECT m FROM Municipio m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Municipio.findByNombre", query = "SELECT m FROM Municipio m WHERE m.nombre = :nombre")})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "municipio_id")
    private Integer municipioId;
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "SUBNACION_subnacion_id", referencedColumnName = "subnacion_id")
    @ManyToOne
    private Subnacion sUBNACIONsubnacionid;

    public Municipio() {
    }

    public Municipio(Integer municipioId) {
        this.municipioId = municipioId;
    }

    public Integer getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Integer municipioId) {
        this.municipioId = municipioId;
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

    public Subnacion getSUBNACIONsubnacionid() {
        return sUBNACIONsubnacionid;
    }

    public void setSUBNACIONsubnacionid(Subnacion sUBNACIONsubnacionid) {
        this.sUBNACIONsubnacionid = sUBNACIONsubnacionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipioId != null ? municipioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.municipioId == null && other.municipioId != null) || (this.municipioId != null && !this.municipioId.equals(other.municipioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Municipio[ municipioId=" + municipioId + " ]";
    }
    
}
