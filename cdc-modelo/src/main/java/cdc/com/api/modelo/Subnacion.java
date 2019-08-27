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
import javax.persistence.JoinColumns;
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
    , @NamedQuery(name = "Subnacion.findBySubnacionId", query = "SELECT s FROM Subnacion s WHERE s.subnacionPK.subnacionId = :subnacionId")
    , @NamedQuery(name = "Subnacion.findByCodigo", query = "SELECT s FROM Subnacion s WHERE s.subnacionPK.codigo = :codigo")
    , @NamedQuery(name = "Subnacion.findByNombre", query = "SELECT s FROM Subnacion s WHERE s.nombre = :nombre")})
public class Subnacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubnacionPK subnacionPK;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "subnacion")
    private List<Municipio> municipioList;
    @JoinColumns({
        @JoinColumn(name = "NACION_nacion_id", referencedColumnName = "nacion_id")
        , @JoinColumn(name = "NACION_codigo", referencedColumnName = "codigo")})
    @ManyToOne
    private Nacion nacion;

    public Subnacion() {
    }

    public Subnacion(SubnacionPK subnacionPK) {
        this.subnacionPK = subnacionPK;
    }

    public Subnacion(int subnacionId, int codigo) {
        this.subnacionPK = new SubnacionPK(subnacionId, codigo);
    }

    public SubnacionPK getSubnacionPK() {
        return subnacionPK;
    }

    public void setSubnacionPK(SubnacionPK subnacionPK) {
        this.subnacionPK = subnacionPK;
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

    public Nacion getNacion() {
        return nacion;
    }

    public void setNacion(Nacion nacion) {
        this.nacion = nacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subnacionPK != null ? subnacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subnacion)) {
            return false;
        }
        Subnacion other = (Subnacion) object;
        if ((this.subnacionPK == null && other.subnacionPK != null) || (this.subnacionPK != null && !this.subnacionPK.equals(other.subnacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Subnacion[ subnacionPK=" + subnacionPK + " ]";
    }
    
}
