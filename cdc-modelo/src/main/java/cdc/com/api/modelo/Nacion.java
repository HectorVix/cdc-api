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
@Table(name = "nacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nacion.findAll", query = "SELECT n FROM Nacion n")
    , @NamedQuery(name = "Nacion.findByNacionId", query = "SELECT n FROM Nacion n WHERE n.nacionId = :nacionId")
    , @NamedQuery(name = "Nacion.findByCodigo", query = "SELECT n FROM Nacion n WHERE n.codigo = :codigo")
    , @NamedQuery(name = "Nacion.findByNombre", query = "SELECT n FROM Nacion n WHERE n.nombre = :nombre")})
public class Nacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nacion_id")
    private Integer nacionId;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "nACIONnacionid")
    private List<Subnacion> subnacionList;
    @JoinColumn(name = "USUARIO_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario uSUARIOusuarioid;

    public Nacion() {
    }

    public Nacion(Integer nacionId) {
        this.nacionId = nacionId;
    }

    public Integer getNacionId() {
        return nacionId;
    }

    public void setNacionId(Integer nacionId) {
        this.nacionId = nacionId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Subnacion> getSubnacionList() {
        return subnacionList;
    }

    public void setSubnacionList(List<Subnacion> subnacionList) {
        this.subnacionList = subnacionList;
    }

    public Usuario getUSUARIOusuarioid() {
        return uSUARIOusuarioid;
    }

    public void setUSUARIOusuarioid(Usuario uSUARIOusuarioid) {
        this.uSUARIOusuarioid = uSUARIOusuarioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nacionId != null ? nacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nacion)) {
            return false;
        }
        Nacion other = (Nacion) object;
        if ((this.nacionId == null && other.nacionId != null) || (this.nacionId != null && !this.nacionId.equals(other.nacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Nacion[ nacionId=" + nacionId + " ]";
    }
    
}
