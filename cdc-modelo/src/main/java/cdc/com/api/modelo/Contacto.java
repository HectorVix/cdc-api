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
@Table(name = "contacto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c")
    , @NamedQuery(name = "Contacto.findByContactoId", query = "SELECT c FROM Contacto c WHERE c.contactoId = :contactoId")
    , @NamedQuery(name = "Contacto.findByNumident", query = "SELECT c FROM Contacto c WHERE c.numident = :numident")
    , @NamedQuery(name = "Contacto.findByNombreident", query = "SELECT c FROM Contacto c WHERE c.nombreident = :nombreident")
    , @NamedQuery(name = "Contacto.findByTitulo", query = "SELECT c FROM Contacto c WHERE c.titulo = :titulo")
    , @NamedQuery(name = "Contacto.findByNombre", query = "SELECT c FROM Contacto c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Contacto.findByApellido1", query = "SELECT c FROM Contacto c WHERE c.apellido1 = :apellido1")
    , @NamedQuery(name = "Contacto.findByApellido2", query = "SELECT c FROM Contacto c WHERE c.apellido2 = :apellido2")
    , @NamedQuery(name = "Contacto.findBySufijo", query = "SELECT c FROM Contacto c WHERE c.sufijo = :sufijo")
    , @NamedQuery(name = "Contacto.findByPosicion", query = "SELECT c FROM Contacto c WHERE c.posicion = :posicion")
    , @NamedQuery(name = "Contacto.findByInstitucion", query = "SELECT c FROM Contacto c WHERE c.institucion = :institucion")
    , @NamedQuery(name = "Contacto.findByEmail", query = "SELECT c FROM Contacto c WHERE c.email = :email")
    , @NamedQuery(name = "Contacto.findByDir1", query = "SELECT c FROM Contacto c WHERE c.dir1 = :dir1")
    , @NamedQuery(name = "Contacto.findByDir2", query = "SELECT c FROM Contacto c WHERE c.dir2 = :dir2")
    , @NamedQuery(name = "Contacto.findByDir3", query = "SELECT c FROM Contacto c WHERE c.dir3 = :dir3")
    , @NamedQuery(name = "Contacto.findByPais", query = "SELECT c FROM Contacto c WHERE c.pais = :pais")
    , @NamedQuery(name = "Contacto.findByCiudad", query = "SELECT c FROM Contacto c WHERE c.ciudad = :ciudad")
    , @NamedQuery(name = "Contacto.findBySubnacion", query = "SELECT c FROM Contacto c WHERE c.subnacion = :subnacion")
    , @NamedQuery(name = "Contacto.findByCodpostal", query = "SELECT c FROM Contacto c WHERE c.codpostal = :codpostal")
    , @NamedQuery(name = "Contacto.findByMasident", query = "SELECT c FROM Contacto c WHERE c.masident = :masident")
    , @NamedQuery(name = "Contacto.findBySmsa", query = "SELECT c FROM Contacto c WHERE c.smsa = :smsa")
    , @NamedQuery(name = "Contacto.findByTeleftrabajo", query = "SELECT c FROM Contacto c WHERE c.teleftrabajo = :teleftrabajo")
    , @NamedQuery(name = "Contacto.findByTelefhogar", query = "SELECT c FROM Contacto c WHERE c.telefhogar = :telefhogar")
    , @NamedQuery(name = "Contacto.findByTipocont", query = "SELECT c FROM Contacto c WHERE c.tipocont = :tipocont")
    , @NamedQuery(name = "Contacto.findByActivcont", query = "SELECT c FROM Contacto c WHERE c.activcont = :activcont")
    , @NamedQuery(name = "Contacto.findByResumen", query = "SELECT c FROM Contacto c WHERE c.resumen = :resumen")
    , @NamedQuery(name = "Contacto.findByCoddirp", query = "SELECT c FROM Contacto c WHERE c.coddirp = :coddirp")
    , @NamedQuery(name = "Contacto.findByActualizar", query = "SELECT c FROM Contacto c WHERE c.actualizar = :actualizar")})
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contacto_id")
    private Integer contactoId;
    @Column(name = "numident")
    private String numident;
    @Column(name = "nombreident")
    private String nombreident;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2;
    @Column(name = "sufijo")
    private String sufijo;
    @Column(name = "posicion")
    private String posicion;
    @Column(name = "institucion")
    private String institucion;
    @Column(name = "email")
    private String email;
    @Column(name = "dir1")
    private String dir1;
    @Column(name = "dir2")
    private String dir2;
    @Column(name = "dir3")
    private String dir3;
    @Column(name = "pais")
    private String pais;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "subnacion")
    private String subnacion;
    @Column(name = "codpostal")
    private String codpostal;
    @Column(name = "masident")
    private String masident;
    @Column(name = "smsa")
    private String smsa;
    @Column(name = "teleftrabajo")
    private Integer teleftrabajo;
    @Column(name = "telefhogar")
    private Integer telefhogar;
    @Column(name = "tipocont")
    private String tipocont;
    @Column(name = "activcont")
    private String activcont;
    @Column(name = "resumen")
    private String resumen;
    @Column(name = "coddirp")
    private String coddirp;
    @Column(name = "actualizar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizar;
    @OneToMany(mappedBy = "cONTACTOcontactoid")
    private List<ContactoHasFuente> contactoHasFuenteList;
    @OneToMany(mappedBy = "cONTACTOcontactoid")
    private List<ContactoHasArea> contactoHasAreaList;
    @OneToMany(mappedBy = "cONTACTOcontactoid")
    private List<ContactoHasSitio> contactoHasSitioList;
    @JoinColumn(name = "USUARIO_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario uSUARIOusuarioid;
    @OneToMany(mappedBy = "cONTACTOcontactoid")
    private List<ContactoHasLote> contactoHasLoteList;

    public Contacto() {
    }

    public Contacto(Integer contactoId) {
        this.contactoId = contactoId;
    }

    public Integer getContactoId() {
        return contactoId;
    }

    public void setContactoId(Integer contactoId) {
        this.contactoId = contactoId;
    }

    public String getNumident() {
        return numident;
    }

    public void setNumident(String numident) {
        this.numident = numident;
    }

    public String getNombreident() {
        return nombreident;
    }

    public void setNombreident(String nombreident) {
        this.nombreident = nombreident;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getSufijo() {
        return sufijo;
    }

    public void setSufijo(String sufijo) {
        this.sufijo = sufijo;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDir1() {
        return dir1;
    }

    public void setDir1(String dir1) {
        this.dir1 = dir1;
    }

    public String getDir2() {
        return dir2;
    }

    public void setDir2(String dir2) {
        this.dir2 = dir2;
    }

    public String getDir3() {
        return dir3;
    }

    public void setDir3(String dir3) {
        this.dir3 = dir3;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getSubnacion() {
        return subnacion;
    }

    public void setSubnacion(String subnacion) {
        this.subnacion = subnacion;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getMasident() {
        return masident;
    }

    public void setMasident(String masident) {
        this.masident = masident;
    }

    public String getSmsa() {
        return smsa;
    }

    public void setSmsa(String smsa) {
        this.smsa = smsa;
    }

    public Integer getTeleftrabajo() {
        return teleftrabajo;
    }

    public void setTeleftrabajo(Integer teleftrabajo) {
        this.teleftrabajo = teleftrabajo;
    }

    public Integer getTelefhogar() {
        return telefhogar;
    }

    public void setTelefhogar(Integer telefhogar) {
        this.telefhogar = telefhogar;
    }

    public String getTipocont() {
        return tipocont;
    }

    public void setTipocont(String tipocont) {
        this.tipocont = tipocont;
    }

    public String getActivcont() {
        return activcont;
    }

    public void setActivcont(String activcont) {
        this.activcont = activcont;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getCoddirp() {
        return coddirp;
    }

    public void setCoddirp(String coddirp) {
        this.coddirp = coddirp;
    }

    public Date getActualizar() {
        return actualizar;
    }

    public void setActualizar(Date actualizar) {
        this.actualizar = actualizar;
    }

    @XmlTransient
    public List<ContactoHasFuente> getContactoHasFuenteList() {
        return contactoHasFuenteList;
    }

    public void setContactoHasFuenteList(List<ContactoHasFuente> contactoHasFuenteList) {
        this.contactoHasFuenteList = contactoHasFuenteList;
    }

    @XmlTransient
    public List<ContactoHasArea> getContactoHasAreaList() {
        return contactoHasAreaList;
    }

    public void setContactoHasAreaList(List<ContactoHasArea> contactoHasAreaList) {
        this.contactoHasAreaList = contactoHasAreaList;
    }

    @XmlTransient
    public List<ContactoHasSitio> getContactoHasSitioList() {
        return contactoHasSitioList;
    }

    public void setContactoHasSitioList(List<ContactoHasSitio> contactoHasSitioList) {
        this.contactoHasSitioList = contactoHasSitioList;
    }

    public Usuario getUSUARIOusuarioid() {
        return uSUARIOusuarioid;
    }

    public void setUSUARIOusuarioid(Usuario uSUARIOusuarioid) {
        this.uSUARIOusuarioid = uSUARIOusuarioid;
    }

    @XmlTransient
    public List<ContactoHasLote> getContactoHasLoteList() {
        return contactoHasLoteList;
    }

    public void setContactoHasLoteList(List<ContactoHasLote> contactoHasLoteList) {
        this.contactoHasLoteList = contactoHasLoteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactoId != null ? contactoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.contactoId == null && other.contactoId != null) || (this.contactoId != null && !this.contactoId.equals(other.contactoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Contacto[ contactoId=" + contactoId + " ]";
    }
    
}
