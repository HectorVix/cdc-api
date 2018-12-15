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
import javax.persistence.Lob;
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
@Table(name = "archivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archivo.findAll", query = "SELECT a FROM Archivo a")
    , @NamedQuery(name = "Archivo.findByArchivoId", query = "SELECT a FROM Archivo a WHERE a.archivoId = :archivoId")
    , @NamedQuery(name = "Archivo.findByNombre", query = "SELECT a FROM Archivo a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Archivo.findByDescripcion", query = "SELECT a FROM Archivo a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Archivo.findByDepartamento", query = "SELECT a FROM Archivo a WHERE a.departamento = :departamento")
    , @NamedQuery(name = "Archivo.findByLocalizacion", query = "SELECT a FROM Archivo a WHERE a.localizacion = :localizacion")})
public class Archivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "archivo_id")
    private Integer archivoId;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "localizacion")
    private String localizacion;
    @Lob
    @Column(name = "archivocdc")
    private byte[] archivocdc;
    @JoinColumn(name = "FUENTE_fuente_id", referencedColumnName = "fuente_id")
    @ManyToOne
    private Fuente fUENTEfuenteid;

    public Archivo() {
    }

    public Archivo(Integer archivoId) {
        this.archivoId = archivoId;
    }

    public Integer getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(Integer archivoId) {
        this.archivoId = archivoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public byte[] getArchivocdc() {
        return archivocdc;
    }

    public void setArchivocdc(byte[] archivocdc) {
        this.archivocdc = archivocdc;
    }

    public Fuente getFUENTEfuenteid() {
        return fUENTEfuenteid;
    }

    public void setFUENTEfuenteid(Fuente fUENTEfuenteid) {
        this.fUENTEfuenteid = fUENTEfuenteid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (archivoId != null ? archivoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivo)) {
            return false;
        }
        Archivo other = (Archivo) object;
        if ((this.archivoId == null && other.archivoId != null) || (this.archivoId != null && !this.archivoId.equals(other.archivoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Archivo[ archivoId=" + archivoId + " ]";
    }
    
}
