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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a")
    , @NamedQuery(name = "Area.findByAreaId", query = "SELECT a FROM Area a WHERE a.areaId = :areaId")
    , @NamedQuery(name = "Area.findByCodigoam", query = "SELECT a FROM Area a WHERE a.codigoam = :codigoam")
    , @NamedQuery(name = "Area.findByNombream", query = "SELECT a FROM Area a WHERE a.nombream = :nombream")
    , @NamedQuery(name = "Area.findBySinam", query = "SELECT a FROM Area a WHERE a.sinam = :sinam")
    , @NamedQuery(name = "Area.findByAmmayor", query = "SELECT a FROM Area a WHERE a.ammayor = :ammayor")
    , @NamedQuery(name = "Area.findByCoddueno", query = "SELECT a FROM Area a WHERE a.coddueno = :coddueno")
    , @NamedQuery(name = "Area.findByAreatot1", query = "SELECT a FROM Area a WHERE a.areatot1 = :areatot1")
    , @NamedQuery(name = "Area.findByCodsitio", query = "SELECT a FROM Area a WHERE a.codsitio = :codsitio")
    , @NamedQuery(name = "Area.findByNomsitio", query = "SELECT a FROM Area a WHERE a.nomsitio = :nomsitio")
    , @NamedQuery(name = "Area.findByNacion", query = "SELECT a FROM Area a WHERE a.nacion = :nacion")
    , @NamedQuery(name = "Area.findBySubnacion", query = "SELECT a FROM Area a WHERE a.subnacion = :subnacion")
    , @NamedQuery(name = "Area.findBySubdivision", query = "SELECT a FROM Area a WHERE a.subdivision = :subdivision")
    , @NamedQuery(name = "Area.findByNommapa", query = "SELECT a FROM Area a WHERE a.nommapa = :nommapa")
    , @NamedQuery(name = "Area.findByCodmapa", query = "SELECT a FROM Area a WHERE a.codmapa = :codmapa")
    , @NamedQuery(name = "Area.findByNummarg", query = "SELECT a FROM Area a WHERE a.nummarg = :nummarg")
    , @NamedQuery(name = "Area.findByLat", query = "SELECT a FROM Area a WHERE a.lat = :lat")
    , @NamedQuery(name = "Area.findByLong1", query = "SELECT a FROM Area a WHERE a.long1 = :long1")
    , @NamedQuery(name = "Area.findByCoords", query = "SELECT a FROM Area a WHERE a.coords = :coords")
    , @NamedQuery(name = "Area.findByCoordn", query = "SELECT a FROM Area a WHERE a.coordn = :coordn")
    , @NamedQuery(name = "Area.findByCoorde", query = "SELECT a FROM Area a WHERE a.coorde = :coorde")
    , @NamedQuery(name = "Area.findByCoordo", query = "SELECT a FROM Area a WHERE a.coordo = :coordo")
    , @NamedQuery(name = "Area.findByDescripcion", query = "SELECT a FROM Area a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Area.findByAreatot2", query = "SELECT a FROM Area a WHERE a.areatot2 = :areatot2")
    , @NamedQuery(name = "Area.findByAreasubnac1", query = "SELECT a FROM Area a WHERE a.areasubnac1 = :areasubnac1")
    , @NamedQuery(name = "Area.findByAreasubnac2", query = "SELECT a FROM Area a WHERE a.areasubnac2 = :areasubnac2")
    , @NamedQuery(name = "Area.findByMultisubnac", query = "SELECT a FROM Area a WHERE a.multisubnac = :multisubnac")
    , @NamedQuery(name = "Area.findByLimites", query = "SELECT a FROM Area a WHERE a.limites = :limites")
    , @NamedQuery(name = "Area.findByContinua", query = "SELECT a FROM Area a WHERE a.continua = :continua")
    , @NamedQuery(name = "Area.findByInvoltnc", query = "SELECT a FROM Area a WHERE a.involtnc = :involtnc")
    , @NamedQuery(name = "Area.findByComentario", query = "SELECT a FROM Area a WHERE a.comentario = :comentario")
    , @NamedQuery(name = "Area.findByFechaesta", query = "SELECT a FROM Area a WHERE a.fechaesta = :fechaesta")
    , @NamedQuery(name = "Area.findByProtasign", query = "SELECT a FROM Area a WHERE a.protasign = :protasign")
    , @NamedQuery(name = "Area.findByAdministrador", query = "SELECT a FROM Area a WHERE a.administrador = :administrador")
    , @NamedQuery(name = "Area.findByInstadmin", query = "SELECT a FROM Area a WHERE a.instadmin = :instadmin")
    , @NamedQuery(name = "Area.findByDiradmin1", query = "SELECT a FROM Area a WHERE a.diradmin1 = :diradmin1")
    , @NamedQuery(name = "Area.findByDiradmin2", query = "SELECT a FROM Area a WHERE a.diradmin2 = :diradmin2")
    , @NamedQuery(name = "Area.findByCiudadadmin", query = "SELECT a FROM Area a WHERE a.ciudadadmin = :ciudadadmin")
    , @NamedQuery(name = "Area.findBySubnacadmin", query = "SELECT a FROM Area a WHERE a.subnacadmin = :subnacadmin")
    , @NamedQuery(name = "Area.findByCodpostaladmin", query = "SELECT a FROM Area a WHERE a.codpostaladmin = :codpostaladmin")
    , @NamedQuery(name = "Area.findByTelefadminist", query = "SELECT a FROM Area a WHERE a.telefadminist = :telefadminist")
    , @NamedQuery(name = "Area.findByAccesopub", query = "SELECT a FROM Area a WHERE a.accesopub = :accesopub")
    , @NamedQuery(name = "Area.findByInstcoop", query = "SELECT a FROM Area a WHERE a.instcoop = :instcoop")
    , @NamedQuery(name = "Area.findByCommanejo", query = "SELECT a FROM Area a WHERE a.commanejo = :commanejo")
    , @NamedQuery(name = "Area.findByAmopc1", query = "SELECT a FROM Area a WHERE a.amopc1 = :amopc1")
    , @NamedQuery(name = "Area.findByAmopc2", query = "SELECT a FROM Area a WHERE a.amopc2 = :amopc2")
    , @NamedQuery(name = "Area.findByAmopc3", query = "SELECT a FROM Area a WHERE a.amopc3 = :amopc3")
    , @NamedQuery(name = "Area.findByAmopc4", query = "SELECT a FROM Area a WHERE a.amopc4 = :amopc4")
    , @NamedQuery(name = "Area.findByAmopc5", query = "SELECT a FROM Area a WHERE a.amopc5 = :amopc5")
    , @NamedQuery(name = "Area.findByRespdatos", query = "SELECT a FROM Area a WHERE a.respdatos = :respdatos")
    , @NamedQuery(name = "Area.findByActualizar", query = "SELECT a FROM Area a WHERE a.actualizar = :actualizar")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "area_id")
    private Integer areaId;
    @Column(name = "codigoam")
    private String codigoam;
    @Column(name = "nombream")
    private String nombream;
    @Column(name = "sinam")
    private String sinam;
    @Column(name = "ammayor")
    private String ammayor;
    @Column(name = "coddueno")
    private String coddueno;
    @Column(name = "areatot1")
    private Integer areatot1;
    @Column(name = "codsitio")
    private String codsitio;
    @Column(name = "nomsitio")
    private String nomsitio;
    @Column(name = "nacion")
    private String nacion;
    @Column(name = "subnacion")
    private String subnacion;
    @Column(name = "subdivision")
    private String subdivision;
    @Column(name = "nommapa")
    private String nommapa;
    @Column(name = "codmapa")
    private String codmapa;
    @Column(name = "nummarg")
    private String nummarg;
    @Column(name = "lat")
    private String lat;
    @Column(name = "long1")
    private String long1;
    @Column(name = "coords")
    private String coords;
    @Column(name = "coordn")
    private String coordn;
    @Column(name = "coorde")
    private String coorde;
    @Column(name = "coordo")
    private String coordo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "areatot2")
    private Integer areatot2;
    @Column(name = "areasubnac1")
    private Integer areasubnac1;
    @Column(name = "areasubnac2")
    private Integer areasubnac2;
    @Column(name = "multisubnac")
    private Boolean multisubnac;
    @Column(name = "limites")
    private Boolean limites;
    @Column(name = "continua")
    private Boolean continua;
    @Column(name = "involtnc")
    private Boolean involtnc;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "fechaesta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaesta;
    @Column(name = "protasign")
    private String protasign;
    @Column(name = "administrador")
    private String administrador;
    @Column(name = "instadmin")
    private String instadmin;
    @Column(name = "diradmin1")
    private String diradmin1;
    @Column(name = "diradmin2")
    private String diradmin2;
    @Column(name = "ciudadadmin")
    private String ciudadadmin;
    @Column(name = "subnacadmin")
    private String subnacadmin;
    @Column(name = "codpostaladmin")
    private String codpostaladmin;
    @Column(name = "telefadminist")
    private String telefadminist;
    @Column(name = "accesopub")
    private String accesopub;
    @Column(name = "instcoop")
    private String instcoop;
    @Column(name = "commanejo")
    private String commanejo;
    @Column(name = "amopc1")
    private String amopc1;
    @Column(name = "amopc2")
    private String amopc2;
    @Column(name = "amopc3")
    private String amopc3;
    @Column(name = "amopc4")
    private String amopc4;
    @Column(name = "amopc5")
    private String amopc5;
    @Column(name = "respdatos")
    private String respdatos;
    @Column(name = "actualizar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizar;
    @JoinTable(name = "sitio_has_area", joinColumns = {
        @JoinColumn(name = "AREA_area_id", referencedColumnName = "area_id")}, inverseJoinColumns = {
        @JoinColumn(name = "SITIO_sitio_id", referencedColumnName = "sitio_id")})
    @ManyToMany
    private List<Sitio> sitioList;
    @OneToMany(mappedBy = "aREAareaid")
    private List<ContactoHasArea> contactoHasAreaList;
    @OneToMany(mappedBy = "aREAareaid")
    private List<ListaElemento> listaElementoList;
    @JoinColumn(name = "USUARIO_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario uSUARIOusuarioid;
    @OneToMany(mappedBy = "aREAareaid")
    private List<Foto> fotoList;
    @OneToMany(mappedBy = "aREAareaid")
    private List<Observaciones> observacionesList;
    @OneToMany(mappedBy = "aREAareaid")
    private List<AreaHasLote> areaHasLoteList;

    public Area() {
    }

    public Area(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getCodigoam() {
        return codigoam;
    }

    public void setCodigoam(String codigoam) {
        this.codigoam = codigoam;
    }

    public String getNombream() {
        return nombream;
    }

    public void setNombream(String nombream) {
        this.nombream = nombream;
    }

    public String getSinam() {
        return sinam;
    }

    public void setSinam(String sinam) {
        this.sinam = sinam;
    }

    public String getAmmayor() {
        return ammayor;
    }

    public void setAmmayor(String ammayor) {
        this.ammayor = ammayor;
    }

    public String getCoddueno() {
        return coddueno;
    }

    public void setCoddueno(String coddueno) {
        this.coddueno = coddueno;
    }

    public Integer getAreatot1() {
        return areatot1;
    }

    public void setAreatot1(Integer areatot1) {
        this.areatot1 = areatot1;
    }

    public String getCodsitio() {
        return codsitio;
    }

    public void setCodsitio(String codsitio) {
        this.codsitio = codsitio;
    }

    public String getNomsitio() {
        return nomsitio;
    }

    public void setNomsitio(String nomsitio) {
        this.nomsitio = nomsitio;
    }

    public String getNacion() {
        return nacion;
    }

    public void setNacion(String nacion) {
        this.nacion = nacion;
    }

    public String getSubnacion() {
        return subnacion;
    }

    public void setSubnacion(String subnacion) {
        this.subnacion = subnacion;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getNommapa() {
        return nommapa;
    }

    public void setNommapa(String nommapa) {
        this.nommapa = nommapa;
    }

    public String getCodmapa() {
        return codmapa;
    }

    public void setCodmapa(String codmapa) {
        this.codmapa = codmapa;
    }

    public String getNummarg() {
        return nummarg;
    }

    public void setNummarg(String nummarg) {
        this.nummarg = nummarg;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong1() {
        return long1;
    }

    public void setLong1(String long1) {
        this.long1 = long1;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getAreatot2() {
        return areatot2;
    }

    public void setAreatot2(Integer areatot2) {
        this.areatot2 = areatot2;
    }

    public Integer getAreasubnac1() {
        return areasubnac1;
    }

    public void setAreasubnac1(Integer areasubnac1) {
        this.areasubnac1 = areasubnac1;
    }

    public Integer getAreasubnac2() {
        return areasubnac2;
    }

    public void setAreasubnac2(Integer areasubnac2) {
        this.areasubnac2 = areasubnac2;
    }

    public Boolean getMultisubnac() {
        return multisubnac;
    }

    public void setMultisubnac(Boolean multisubnac) {
        this.multisubnac = multisubnac;
    }

    public Boolean getLimites() {
        return limites;
    }

    public void setLimites(Boolean limites) {
        this.limites = limites;
    }

    public Boolean getContinua() {
        return continua;
    }

    public void setContinua(Boolean continua) {
        this.continua = continua;
    }

    public Boolean getInvoltnc() {
        return involtnc;
    }

    public void setInvoltnc(Boolean involtnc) {
        this.involtnc = involtnc;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaesta() {
        return fechaesta;
    }

    public void setFechaesta(Date fechaesta) {
        this.fechaesta = fechaesta;
    }

    public String getProtasign() {
        return protasign;
    }

    public void setProtasign(String protasign) {
        this.protasign = protasign;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public String getInstadmin() {
        return instadmin;
    }

    public void setInstadmin(String instadmin) {
        this.instadmin = instadmin;
    }

    public String getDiradmin1() {
        return diradmin1;
    }

    public void setDiradmin1(String diradmin1) {
        this.diradmin1 = diradmin1;
    }

    public String getDiradmin2() {
        return diradmin2;
    }

    public void setDiradmin2(String diradmin2) {
        this.diradmin2 = diradmin2;
    }

    public String getCiudadadmin() {
        return ciudadadmin;
    }

    public void setCiudadadmin(String ciudadadmin) {
        this.ciudadadmin = ciudadadmin;
    }

    public String getSubnacadmin() {
        return subnacadmin;
    }

    public void setSubnacadmin(String subnacadmin) {
        this.subnacadmin = subnacadmin;
    }

    public String getCodpostaladmin() {
        return codpostaladmin;
    }

    public void setCodpostaladmin(String codpostaladmin) {
        this.codpostaladmin = codpostaladmin;
    }

    public String getTelefadminist() {
        return telefadminist;
    }

    public void setTelefadminist(String telefadminist) {
        this.telefadminist = telefadminist;
    }

    public String getAccesopub() {
        return accesopub;
    }

    public void setAccesopub(String accesopub) {
        this.accesopub = accesopub;
    }

    public String getInstcoop() {
        return instcoop;
    }

    public void setInstcoop(String instcoop) {
        this.instcoop = instcoop;
    }

    public String getCommanejo() {
        return commanejo;
    }

    public void setCommanejo(String commanejo) {
        this.commanejo = commanejo;
    }

    public String getAmopc1() {
        return amopc1;
    }

    public void setAmopc1(String amopc1) {
        this.amopc1 = amopc1;
    }

    public String getAmopc2() {
        return amopc2;
    }

    public void setAmopc2(String amopc2) {
        this.amopc2 = amopc2;
    }

    public String getAmopc3() {
        return amopc3;
    }

    public void setAmopc3(String amopc3) {
        this.amopc3 = amopc3;
    }

    public String getAmopc4() {
        return amopc4;
    }

    public void setAmopc4(String amopc4) {
        this.amopc4 = amopc4;
    }

    public String getAmopc5() {
        return amopc5;
    }

    public void setAmopc5(String amopc5) {
        this.amopc5 = amopc5;
    }

    public String getRespdatos() {
        return respdatos;
    }

    public void setRespdatos(String respdatos) {
        this.respdatos = respdatos;
    }

    public Date getActualizar() {
        return actualizar;
    }

    public void setActualizar(Date actualizar) {
        this.actualizar = actualizar;
    }

    @XmlTransient
    public List<Sitio> getSitioList() {
        return sitioList;
    }

    public void setSitioList(List<Sitio> sitioList) {
        this.sitioList = sitioList;
    }

    @XmlTransient
    public List<ContactoHasArea> getContactoHasAreaList() {
        return contactoHasAreaList;
    }

    public void setContactoHasAreaList(List<ContactoHasArea> contactoHasAreaList) {
        this.contactoHasAreaList = contactoHasAreaList;
    }

    @XmlTransient
    public List<ListaElemento> getListaElementoList() {
        return listaElementoList;
    }

    public void setListaElementoList(List<ListaElemento> listaElementoList) {
        this.listaElementoList = listaElementoList;
    }

    public Usuario getUSUARIOusuarioid() {
        return uSUARIOusuarioid;
    }

    public void setUSUARIOusuarioid(Usuario uSUARIOusuarioid) {
        this.uSUARIOusuarioid = uSUARIOusuarioid;
    }

    @XmlTransient
    public List<Foto> getFotoList() {
        return fotoList;
    }

    public void setFotoList(List<Foto> fotoList) {
        this.fotoList = fotoList;
    }

    @XmlTransient
    public List<Observaciones> getObservacionesList() {
        return observacionesList;
    }

    public void setObservacionesList(List<Observaciones> observacionesList) {
        this.observacionesList = observacionesList;
    }

    @XmlTransient
    public List<AreaHasLote> getAreaHasLoteList() {
        return areaHasLoteList;
    }

    public void setAreaHasLoteList(List<AreaHasLote> areaHasLoteList) {
        this.areaHasLoteList = areaHasLoteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaId != null ? areaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.areaId == null && other.areaId != null) || (this.areaId != null && !this.areaId.equals(other.areaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Area[ areaId=" + areaId + " ]";
    }
    
}
