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
@Table(name = "jerarquizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jerarquizacion.findAll", query = "SELECT j FROM Jerarquizacion j")
    , @NamedQuery(name = "Jerarquizacion.findByJerarquizacionId", query = "SELECT j FROM Jerarquizacion j WHERE j.jerarquizacionId = :jerarquizacionId")
    , @NamedQuery(name = "Jerarquizacion.findByCodigoe", query = "SELECT j FROM Jerarquizacion j WHERE j.codigoe = :codigoe")})
public class Jerarquizacion implements Serializable {

    @Column(name = "estado")
    private Integer estado;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "jerarquizacion_id")
    private Integer jerarquizacionId;
    @Column(name = "codigoe")
    private String codigoe;
    @JoinColumn(name = "ELEMENTO_elemento_id", referencedColumnName = "elemento_id")
    @ManyToOne
    private Elemento eLEMENTOelementoid;
    @OneToMany(mappedBy = "jERARQUIZACIONjerarquizacionid")
    private List<Global> globalList;
    @OneToMany(mappedBy = "jERARQUIZACIONjerarquizacionid")
    private List<Nacional> nacionalList;
    @OneToMany(mappedBy = "jERARQUIZACIONjerarquizacionid")
    private List<Subnacional> subnacionalList;
    @OneToMany(mappedBy = "jERARQUIZACIONjerarquizacionid")
    private List<Rastreo> rastreoList;

    public Jerarquizacion() {
    }

    public Jerarquizacion(Integer jerarquizacionId) {
        this.jerarquizacionId = jerarquizacionId;
    }

    public Integer getJerarquizacionId() {
        return jerarquizacionId;
    }

    public void setJerarquizacionId(Integer jerarquizacionId) {
        this.jerarquizacionId = jerarquizacionId;
    }

    public String getCodigoe() {
        return codigoe;
    }

    public void setCodigoe(String codigoe) {
        this.codigoe = codigoe;
    }

    public Elemento getELEMENTOelementoid() {
        return eLEMENTOelementoid;
    }

    public void setELEMENTOelementoid(Elemento eLEMENTOelementoid) {
        this.eLEMENTOelementoid = eLEMENTOelementoid;
    }

    @XmlTransient
    public List<Global> getGlobalList() {
        return globalList;
    }

    public void setGlobalList(List<Global> globalList) {
        this.globalList = globalList;
    }

    @XmlTransient
    public List<Nacional> getNacionalList() {
        return nacionalList;
    }

    public void setNacionalList(List<Nacional> nacionalList) {
        this.nacionalList = nacionalList;
    }

    @XmlTransient
    public List<Subnacional> getSubnacionalList() {
        return subnacionalList;
    }

    public void setSubnacionalList(List<Subnacional> subnacionalList) {
        this.subnacionalList = subnacionalList;
    }

    @XmlTransient
    public List<Rastreo> getRastreoList() {
        return rastreoList;
    }

    public void setRastreoList(List<Rastreo> rastreoList) {
        this.rastreoList = rastreoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jerarquizacionId != null ? jerarquizacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jerarquizacion)) {
            return false;
        }
        Jerarquizacion other = (Jerarquizacion) object;
        if ((this.jerarquizacionId == null && other.jerarquizacionId != null) || (this.jerarquizacionId != null && !this.jerarquizacionId.equals(other.jerarquizacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Jerarquizacion[ jerarquizacionId=" + jerarquizacionId + " ]";
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
}
