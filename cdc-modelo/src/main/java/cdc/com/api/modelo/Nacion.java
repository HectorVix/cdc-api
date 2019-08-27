/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    , @NamedQuery(name = "Nacion.findByNacionId", query = "SELECT n FROM Nacion n WHERE n.nacionPK.nacionId = :nacionId")
    , @NamedQuery(name = "Nacion.findByCodigo", query = "SELECT n FROM Nacion n WHERE n.nacionPK.codigo = :codigo")
    , @NamedQuery(name = "Nacion.findByNombre", query = "SELECT n FROM Nacion n WHERE n.nombre = :nombre")})
public class Nacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NacionPK nacionPK;
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "USUARIO_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario uSUARIOusuarioid;
    @OneToMany(mappedBy = "nacion")
    private List<Subnacion> subnacionList;

    public Nacion() {
    }

    public Nacion(NacionPK nacionPK) {
        this.nacionPK = nacionPK;
    }

    public Nacion(int nacionId, String codigo) {
        this.nacionPK = new NacionPK(nacionId, codigo);
    }

    public NacionPK getNacionPK() {
        return nacionPK;
    }

    public void setNacionPK(NacionPK nacionPK) {
        this.nacionPK = nacionPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUSUARIOusuarioid() {
        return uSUARIOusuarioid;
    }

    public void setUSUARIOusuarioid(Usuario uSUARIOusuarioid) {
        this.uSUARIOusuarioid = uSUARIOusuarioid;
    }

    @XmlTransient
    public List<Subnacion> getSubnacionList() {
        return subnacionList;
    }

    public void setSubnacionList(List<Subnacion> subnacionList) {
        this.subnacionList = subnacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nacionPK != null ? nacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nacion)) {
            return false;
        }
        Nacion other = (Nacion) object;
        if ((this.nacionPK == null && other.nacionPK != null) || (this.nacionPK != null && !this.nacionPK.equals(other.nacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Nacion[ nacionPK=" + nacionPK + " ]";
    }
    
}
