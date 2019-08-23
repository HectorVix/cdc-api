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
@Table(name = "elemento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elemento.findAll", query = "SELECT e FROM Elemento e")
    , @NamedQuery(name = "Elemento.findByElementoId", query = "SELECT e FROM Elemento e WHERE e.elementoId = :elementoId")
    , @NamedQuery(name = "Elemento.findByCodigo", query = "SELECT e FROM Elemento e WHERE e.codigo = :codigo")
    , @NamedQuery(name = "Elemento.findByNombrecomun", query = "SELECT e FROM Elemento e WHERE e.nombrecomun = :nombrecomun")
    , @NamedQuery(name = "Elemento.findByNombrecientifico", query = "SELECT e FROM Elemento e WHERE e.nombrecientifico = :nombrecientifico")
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
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "nombrecomun")
    private String nombrecomun;
    @Column(name = "nombrecientifico")
    private String nombrecientifico;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "clase")
    private String clase;
    @Column(name = "comunidad")
    private String comunidad;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombrecomun() {
        return nombrecomun;
    }

    public void setNombrecomun(String nombrecomun) {
        this.nombrecomun = nombrecomun;
    }

    public String getNombrecientifico() {
        return nombrecientifico;
    }

    public void setNombrecientifico(String nombrecientifico) {
        this.nombrecientifico = nombrecientifico;
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
