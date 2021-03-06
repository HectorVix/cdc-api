/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Héctor Vix
 */
@Entity
@Table(name = "elemento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elemento.findAll", query = "SELECT e FROM Elemento e")
    , @NamedQuery(name = "Elemento.findByElementoId", query = "SELECT e FROM Elemento e WHERE e.elementoId = :elementoId")
    , @NamedQuery(name = "Elemento.findByCodigoe", query = "SELECT e FROM Elemento e WHERE e.codigoe = :codigoe")
    , @NamedQuery(name = "Elemento.findByNombrecomunn", query = "SELECT e FROM Elemento e WHERE e.nombrecomunn = :nombrecomunn")
    , @NamedQuery(name = "Elemento.findByNombren", query = "SELECT e FROM Elemento e WHERE e.nombren = :nombren")
    , @NamedQuery(name = "Elemento.findByComentario", query = "SELECT e FROM Elemento e WHERE e.comentario = :comentario")
    , @NamedQuery(name = "Elemento.findByFecha", query = "SELECT e FROM Elemento e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "Elemento.findByClase", query = "SELECT e FROM Elemento e WHERE e.clase = :clase")
    , @NamedQuery(name = "Elemento.findByComunidad", query = "SELECT e FROM Elemento e WHERE e.comunidad = :comunidad")})
public class Elemento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "elemento_id")
    private Integer elementoId;
    @Column(name = "codigoe")
    private String codigoe;
    @Column(name = "nombrecomunn")
    private String nombrecomunn;
    @Column(name = "nombren")
    private String nombren;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "clase")
    private String clase;
    @Column(name = "comunidad")
    private String comunidad;
    @OneToMany(mappedBy = "eLEMENTOelementoid")
    private List<Subnacional> subnacionalList;
    @OneToMany(mappedBy = "eLEMENTOelementoid")
    private List<Protocolo> protocoloList;
    @OneToMany(mappedBy = "eLEMENTOelementoid")
    private List<Foto> fotoList;
    @OneToMany(mappedBy = "eLEMENTOelementoid")
    private List<Global> globalList;
    @OneToMany(mappedBy = "eLEMENTOelementoid")
    private List<Nacional> nacionalList;
    @OneToMany(mappedBy = "eLEMENTOelementoid")
    private List<Rastreo> rastreoList;
    @OneToMany(mappedBy = "eLEMENTOelementoid")
    private List<Caracterizacion> caracterizacionList;
    @JoinColumn(name = "USUARIO_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario uSUARIOusuarioid;

    public Elemento() {
    }

    public Elemento(Integer elementoId) {
        this.elementoId = elementoId;
    }

    public Integer getElementoId() {
        return elementoId;
    }

    public void setElementoId(Integer elementoId) {
        this.elementoId = elementoId;
    }

    public String getCodigoe() {
        return codigoe;
    }

    public void setCodigoe(String codigoe) {
        this.codigoe = codigoe;
    }

    public String getNombrecomunn() {
        return nombrecomunn;
    }

    public void setNombrecomunn(String nombrecomunn) {
        this.nombrecomunn = nombrecomunn;
    }

    public String getNombren() {
        return nombren;
    }

    public void setNombren(String nombren) {
        this.nombren = nombren;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    @XmlTransient
    public List<Subnacional> getSubnacionalList() {
        return subnacionalList;
    }

    public void setSubnacionalList(List<Subnacional> subnacionalList) {
        this.subnacionalList = subnacionalList;
    }

    @XmlTransient
    public List<Protocolo> getProtocoloList() {
        return protocoloList;
    }

    public void setProtocoloList(List<Protocolo> protocoloList) {
        this.protocoloList = protocoloList;
    }

    @XmlTransient
    public List<Foto> getFotoList() {
        return fotoList;
    }

    public void setFotoList(List<Foto> fotoList) {
        this.fotoList = fotoList;
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
    public List<Rastreo> getRastreoList() {
        return rastreoList;
    }

    public void setRastreoList(List<Rastreo> rastreoList) {
        this.rastreoList = rastreoList;
    }

    @XmlTransient
    public List<Caracterizacion> getCaracterizacionList() {
        return caracterizacionList;
    }

    public void setCaracterizacionList(List<Caracterizacion> caracterizacionList) {
        this.caracterizacionList = caracterizacionList;
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
        hash += (elementoId != null ? elementoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elemento)) {
            return false;
        }
        Elemento other = (Elemento) object;
        if ((this.elementoId == null && other.elementoId != null) || (this.elementoId != null && !this.elementoId.equals(other.elementoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Elemento[ elementoId=" + elementoId + " ]";
    }
    
}
