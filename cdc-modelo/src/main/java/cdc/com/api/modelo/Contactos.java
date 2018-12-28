/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Héctor Vix
 */
@Entity
@Table(name = "contactos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contactos.findAll", query = "SELECT c FROM Contactos c")
    , @NamedQuery(name = "Contactos.findByContactosId", query = "SELECT c FROM Contactos c WHERE c.contactosId = :contactosId")
    , @NamedQuery(name = "Contactos.findByNumident", query = "SELECT c FROM Contactos c WHERE c.numident = :numident")})
public class Contactos implements Serializable {

    @Column(name = "dir2")
    private String dir2;

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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contactos_id")
    private Integer contactosId;
    @Column(name = "numident")
    private String numident;
    @JoinColumn(name = "USUARIO_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario uSUARIOusuarioid;

    public Contactos() {
    }

    public Contactos(Integer contactosId) {
        this.contactosId = contactosId;
    }

    public Integer getContactosId() {
        return contactosId;
    }

    public void setContactosId(Integer contactosId) {
        this.contactosId = contactosId;
    }

    public String getNumident() {
        return numident;
    }

    public void setNumident(String numident) {
        this.numident = numident;
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
        hash += (contactosId != null ? contactosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactos)) {
            return false;
        }
        Contactos other = (Contactos) object;
        if ((this.contactosId == null && other.contactosId != null) || (this.contactosId != null && !this.contactosId.equals(other.contactosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Contactos[ contactosId=" + contactosId + " ]";
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

    public String getDir2() {
        return dir2;
    }

    public void setDir2(String dir2) {
        this.dir2 = dir2;
    }

}
