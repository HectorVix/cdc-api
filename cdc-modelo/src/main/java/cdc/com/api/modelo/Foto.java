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
@Table(name = "foto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Foto.findAll", query = "SELECT f FROM Foto f")
    , @NamedQuery(name = "Foto.findByFotoId", query = "SELECT f FROM Foto f WHERE f.fotoId = :fotoId")
    , @NamedQuery(name = "Foto.findByVERTEBRADOvertebradoid", query = "SELECT f FROM Foto f WHERE f.vERTEBRADOvertebradoid = :vERTEBRADOvertebradoid")
    , @NamedQuery(name = "Foto.findByNombre", query = "SELECT f FROM Foto f WHERE f.nombre = :nombre")
    , @NamedQuery(name = "Foto.findByAutor", query = "SELECT f FROM Foto f WHERE f.autor = :autor")
    , @NamedQuery(name = "Foto.findByDescripcion", query = "SELECT f FROM Foto f WHERE f.descripcion = :descripcion")})
public class Foto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "foto_id")
    private Integer fotoId;
    @Basic(optional = false)
    @Column(name = "VERTEBRADO_vertebrado_id")
    private int vERTEBRADOvertebradoid;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "autor")
    private String autor;
    @Column(name = "descripcion")
    private String descripcion;
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @JoinColumn(name = "AREA_area_id", referencedColumnName = "area_id")
    @ManyToOne
    private Area aREAareaid;
    @JoinColumn(name = "ELEMENTO_elemento_id", referencedColumnName = "elemento_id")
    @ManyToOne
    private Elemento eLEMENTOelementoid;
    @JoinColumn(name = "PLANTA_planta_id", referencedColumnName = "planta_id")
    @ManyToOne
    private Planta pLANTAplantaid;
    @JoinColumn(name = "SITIO_sitio_id", referencedColumnName = "sitio_id")
    @ManyToOne
    private Sitio sITIOsitioid;
    @JoinColumn(name = "VERTEBRADO_vertebrado_id1", referencedColumnName = "vertebrado_id")
    @ManyToOne
    private Vertebrado vERTEBRADOvertebradoid1;

    public Foto() {
    }

    public Foto(Integer fotoId) {
        this.fotoId = fotoId;
    }

    public Foto(Integer fotoId, int vERTEBRADOvertebradoid) {
        this.fotoId = fotoId;
        this.vERTEBRADOvertebradoid = vERTEBRADOvertebradoid;
    }

    public Integer getFotoId() {
        return fotoId;
    }

    public void setFotoId(Integer fotoId) {
        this.fotoId = fotoId;
    }

    public int getVERTEBRADOvertebradoid() {
        return vERTEBRADOvertebradoid;
    }

    public void setVERTEBRADOvertebradoid(int vERTEBRADOvertebradoid) {
        this.vERTEBRADOvertebradoid = vERTEBRADOvertebradoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Area getAREAareaid() {
        return aREAareaid;
    }

    public void setAREAareaid(Area aREAareaid) {
        this.aREAareaid = aREAareaid;
    }

    public Elemento getELEMENTOelementoid() {
        return eLEMENTOelementoid;
    }

    public void setELEMENTOelementoid(Elemento eLEMENTOelementoid) {
        this.eLEMENTOelementoid = eLEMENTOelementoid;
    }

    public Planta getPLANTAplantaid() {
        return pLANTAplantaid;
    }

    public void setPLANTAplantaid(Planta pLANTAplantaid) {
        this.pLANTAplantaid = pLANTAplantaid;
    }

    public Sitio getSITIOsitioid() {
        return sITIOsitioid;
    }

    public void setSITIOsitioid(Sitio sITIOsitioid) {
        this.sITIOsitioid = sITIOsitioid;
    }

    public Vertebrado getVERTEBRADOvertebradoid1() {
        return vERTEBRADOvertebradoid1;
    }

    public void setVERTEBRADOvertebradoid1(Vertebrado vERTEBRADOvertebradoid1) {
        this.vERTEBRADOvertebradoid1 = vERTEBRADOvertebradoid1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fotoId != null ? fotoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foto)) {
            return false;
        }
        Foto other = (Foto) object;
        if ((this.fotoId == null && other.fotoId != null) || (this.fotoId != null && !this.fotoId.equals(other.fotoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Foto[ fotoId=" + fotoId + " ]";
    }
    
}
