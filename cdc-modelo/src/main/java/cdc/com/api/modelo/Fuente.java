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
@Table(name = "fuente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fuente.findAll", query = "SELECT f FROM Fuente f")
    , @NamedQuery(name = "Fuente.findByFuenteId", query = "SELECT f FROM Fuente f WHERE f.fuenteId = :fuenteId")
    , @NamedQuery(name = "Fuente.findByNaturalezadocumento", query = "SELECT f FROM Fuente f WHERE f.naturalezadocumento = :naturalezadocumento")
    , @NamedQuery(name = "Fuente.findByCodfuente", query = "SELECT f FROM Fuente f WHERE f.codfuente = :codfuente")
    , @NamedQuery(name = "Fuente.findByCita", query = "SELECT f FROM Fuente f WHERE f.cita = :cita")
    , @NamedQuery(name = "Fuente.findByArchivado", query = "SELECT f FROM Fuente f WHERE f.archivado = :archivado")
    , @NamedQuery(name = "Fuente.findByCobgeo", query = "SELECT f FROM Fuente f WHERE f.cobgeo = :cobgeo")
    , @NamedQuery(name = "Fuente.findByCoords", query = "SELECT f FROM Fuente f WHERE f.coords = :coords")
    , @NamedQuery(name = "Fuente.findByCoordn", query = "SELECT f FROM Fuente f WHERE f.coordn = :coordn")
    , @NamedQuery(name = "Fuente.findByCoorde", query = "SELECT f FROM Fuente f WHERE f.coorde = :coorde")
    , @NamedQuery(name = "Fuente.findByCoordo", query = "SELECT f FROM Fuente f WHERE f.coordo = :coordo")
    , @NamedQuery(name = "Fuente.findByResumen", query = "SELECT f FROM Fuente f WHERE f.resumen = :resumen")
    , @NamedQuery(name = "Fuente.findByVarios", query = "SELECT f FROM Fuente f WHERE f.varios = :varios")
    , @NamedQuery(name = "Fuente.findByPublicacioncdc", query = "SELECT f FROM Fuente f WHERE f.publicacioncdc = :publicacioncdc")
    , @NamedQuery(name = "Fuente.findByValor", query = "SELECT f FROM Fuente f WHERE f.valor = :valor")
    , @NamedQuery(name = "Fuente.findByClave", query = "SELECT f FROM Fuente f WHERE f.clave = :clave")
    , @NamedQuery(name = "Fuente.findByComentario", query = "SELECT f FROM Fuente f WHERE f.comentario = :comentario")
    , @NamedQuery(name = "Fuente.findByNotadigest", query = "SELECT f FROM Fuente f WHERE f.notadigest = :notadigest")
    , @NamedQuery(name = "Fuente.findByActualizar", query = "SELECT f FROM Fuente f WHERE f.actualizar = :actualizar")
    , @NamedQuery(name = "Fuente.findByControl", query = "SELECT f FROM Fuente f WHERE f.control = :control")
    , @NamedQuery(name = "Fuente.findByBcd", query = "SELECT f FROM Fuente f WHERE f.bcd = :bcd")})
public class Fuente implements Serializable {

    @Column(name = "flora")
    private Boolean flora;
    @Column(name = "fauna")
    private Boolean fauna;
    @Column(name = "otros")
    private Boolean otros;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fuente_id")
    private Integer fuenteId;
    @Column(name = "naturalezadocumento")
    private String naturalezadocumento;
    @Column(name = "codfuente")
    private String codfuente;
    @Column(name = "cita")
    private String cita;
    @Column(name = "archivado")
    private String archivado;
    @Column(name = "cobgeo")
    private String cobgeo;
    @Column(name = "coords")
    private String coords;
    @Column(name = "coordn")
    private String coordn;
    @Column(name = "coorde")
    private String coorde;
    @Column(name = "coordo")
    private String coordo;
    @Column(name = "resumen")
    private String resumen;
    @Column(name = "varios")
    private Boolean varios;
    @Column(name = "publicacioncdc")
    private Boolean publicacioncdc;
    @Column(name = "valor")
    private String valor;
    @Column(name = "clave")
    private String clave;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "notadigest")
    private String notadigest;
    @Column(name = "actualizar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizar;
    @Column(name = "control")
    @Temporal(TemporalType.TIMESTAMP)
    private Date control;
    @Column(name = "bcd")
    private String bcd;
    @JoinColumn(name = "RASTREO_rastreo_id", referencedColumnName = "rastreo_id")
    @ManyToOne
    private Rastreo rASTREOrastreoid;
    @JoinColumn(name = "USUARIO_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario uSUARIOusuarioid;
    @OneToMany(mappedBy = "fUENTEfuenteid")
    private List<Archivo> archivoList;
    @OneToMany(mappedBy = "fUENTEfuenteid")
    private List<Tema> temaList;

    public Fuente() {
    }

    public Fuente(Integer fuenteId) {
        this.fuenteId = fuenteId;
    }

    public Integer getFuenteId() {
        return fuenteId;
    }

    public void setFuenteId(Integer fuenteId) {
        this.fuenteId = fuenteId;
    }

    public String getNaturalezadocumento() {
        return naturalezadocumento;
    }

    public void setNaturalezadocumento(String naturalezadocumento) {
        this.naturalezadocumento = naturalezadocumento;
    }

    public String getCodfuente() {
        return codfuente;
    }

    public void setCodfuente(String codfuente) {
        this.codfuente = codfuente;
    }

    public String getCita() {
        return cita;
    }

    public void setCita(String cita) {
        this.cita = cita;
    }

    public String getArchivado() {
        return archivado;
    }

    public void setArchivado(String archivado) {
        this.archivado = archivado;
    }

    public String getCobgeo() {
        return cobgeo;
    }

    public void setCobgeo(String cobgeo) {
        this.cobgeo = cobgeo;
    }

    public String getCoords() {
        return coords;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }

    public String getCoordn() {
        return coordn;
    }

    public void setCoordn(String coordn) {
        this.coordn = coordn;
    }

    public String getCoorde() {
        return coorde;
    }

    public void setCoorde(String coorde) {
        this.coorde = coorde;
    }

    public String getCoordo() {
        return coordo;
    }

    public void setCoordo(String coordo) {
        this.coordo = coordo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Boolean getVarios() {
        return varios;
    }

    public void setVarios(Boolean varios) {
        this.varios = varios;
    }

    public Boolean getPublicacioncdc() {
        return publicacioncdc;
    }

    public void setPublicacioncdc(Boolean publicacioncdc) {
        this.publicacioncdc = publicacioncdc;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNotadigest() {
        return notadigest;
    }

    public void setNotadigest(String notadigest) {
        this.notadigest = notadigest;
    }

    public Date getActualizar() {
        return actualizar;
    }

    public void setActualizar(Date actualizar) {
        this.actualizar = actualizar;
    }

    public Date getControl() {
        return control;
    }

    public void setControl(Date control) {
        this.control = control;
    }

    public String getBcd() {
        return bcd;
    }

    public void setBcd(String bcd) {
        this.bcd = bcd;
    }

    public Rastreo getRASTREOrastreoid() {
        return rASTREOrastreoid;
    }

    public void setRASTREOrastreoid(Rastreo rASTREOrastreoid) {
        this.rASTREOrastreoid = rASTREOrastreoid;
    }

    public Usuario getUSUARIOusuarioid() {
        return uSUARIOusuarioid;
    }

    public void setUSUARIOusuarioid(Usuario uSUARIOusuarioid) {
        this.uSUARIOusuarioid = uSUARIOusuarioid;
    }

    @XmlTransient
    public List<Archivo> getArchivoList() {
        return archivoList;
    }

    public void setArchivoList(List<Archivo> archivoList) {
        this.archivoList = archivoList;
    }

    @XmlTransient
    public List<Tema> getTemaList() {
        return temaList;
    }

    public void setTemaList(List<Tema> temaList) {
        this.temaList = temaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fuenteId != null ? fuenteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fuente)) {
            return false;
        }
        Fuente other = (Fuente) object;
        if ((this.fuenteId == null && other.fuenteId != null) || (this.fuenteId != null && !this.fuenteId.equals(other.fuenteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Fuente[ fuenteId=" + fuenteId + " ]";
    }

    public Boolean getFlora() {
        return flora;
    }

    public void setFlora(Boolean flora) {
        this.flora = flora;
    }

    public Boolean getFauna() {
        return fauna;
    }

    public void setFauna(Boolean fauna) {
        this.fauna = fauna;
    }

    public Boolean getOtros() {
        return otros;
    }

    public void setOtros(Boolean otros) {
        this.otros = otros;
    }
    
}
