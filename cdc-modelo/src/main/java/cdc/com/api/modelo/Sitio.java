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
@Table(name = "sitio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sitio.findAll", query = "SELECT s FROM Sitio s")
    , @NamedQuery(name = "Sitio.findBySitioId", query = "SELECT s FROM Sitio s WHERE s.sitioId = :sitioId")
    , @NamedQuery(name = "Sitio.findByCodsitio", query = "SELECT s FROM Sitio s WHERE s.codsitio = :codsitio")
    , @NamedQuery(name = "Sitio.findByNomsitio", query = "SELECT s FROM Sitio s WHERE s.nomsitio = :nomsitio")
    , @NamedQuery(name = "Sitio.findBySinsitio", query = "SELECT s FROM Sitio s WHERE s.sinsitio = :sinsitio")
    , @NamedQuery(name = "Sitio.findByNacion", query = "SELECT s FROM Sitio s WHERE s.nacion = :nacion")
    , @NamedQuery(name = "Sitio.findBySubnacion", query = "SELECT s FROM Sitio s WHERE s.subnacion = :subnacion")
    , @NamedQuery(name = "Sitio.findBySiteresp", query = "SELECT s FROM Sitio s WHERE s.siteresp = :siteresp")
    , @NamedQuery(name = "Sitio.findByLat", query = "SELECT s FROM Sitio s WHERE s.lat = :lat")
    , @NamedQuery(name = "Sitio.findByLong1", query = "SELECT s FROM Sitio s WHERE s.long1 = :long1")
    , @NamedQuery(name = "Sitio.findByCoords", query = "SELECT s FROM Sitio s WHERE s.coords = :coords")
    , @NamedQuery(name = "Sitio.findByCoordn", query = "SELECT s FROM Sitio s WHERE s.coordn = :coordn")
    , @NamedQuery(name = "Sitio.findByCoorde", query = "SELECT s FROM Sitio s WHERE s.coorde = :coorde")
    , @NamedQuery(name = "Sitio.findByCoordo", query = "SELECT s FROM Sitio s WHERE s.coordo = :coordo")
    , @NamedQuery(name = "Sitio.findByDireccion", query = "SELECT s FROM Sitio s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "Sitio.findByDescrito", query = "SELECT s FROM Sitio s WHERE s.descrito = :descrito")
    , @NamedQuery(name = "Sitio.findByMapasitio", query = "SELECT s FROM Sitio s WHERE s.mapasitio = :mapasitio")
    , @NamedQuery(name = "Sitio.findByFechamapa", query = "SELECT s FROM Sitio s WHERE s.fechamapa = :fechamapa")
    , @NamedQuery(name = "Sitio.findByDibujante", query = "SELECT s FROM Sitio s WHERE s.dibujante = :dibujante")
    , @NamedQuery(name = "Sitio.findByJustlimite", query = "SELECT s FROM Sitio s WHERE s.justlimite = :justlimite")
    , @NamedQuery(name = "Sitio.findByAreaprisec1", query = "SELECT s FROM Sitio s WHERE s.areaprisec1 = :areaprisec1")
    , @NamedQuery(name = "Sitio.findByAreaprisec2", query = "SELECT s FROM Sitio s WHERE s.areaprisec2 = :areaprisec2")
    , @NamedQuery(name = "Sitio.findByAreapri1", query = "SELECT s FROM Sitio s WHERE s.areapri1 = :areapri1")
    , @NamedQuery(name = "Sitio.findByAreapri2", query = "SELECT s FROM Sitio s WHERE s.areapri2 = :areapri2")
    , @NamedQuery(name = "Sitio.findByAreatotal1", query = "SELECT s FROM Sitio s WHERE s.areatotal1 = :areatotal1")
    , @NamedQuery(name = "Sitio.findByAreatotal2", query = "SELECT s FROM Sitio s WHERE s.areatotal2 = :areatotal2")
    , @NamedQuery(name = "Sitio.findByComsitio", query = "SELECT s FROM Sitio s WHERE s.comsitio = :comsitio")
    , @NamedQuery(name = "Sitio.findByRangoant", query = "SELECT s FROM Sitio s WHERE s.rangoant = :rangoant")
    , @NamedQuery(name = "Sitio.findByComrango", query = "SELECT s FROM Sitio s WHERE s.comrango = :comrango")
    , @NamedQuery(name = "Sitio.findByImpdivbiol", query = "SELECT s FROM Sitio s WHERE s.impdivbiol = :impdivbiol")
    , @NamedQuery(name = "Sitio.findByComdivbiol", query = "SELECT s FROM Sitio s WHERE s.comdivbiol = :comdivbiol")
    , @NamedQuery(name = "Sitio.findByImpnodivbiol", query = "SELECT s FROM Sitio s WHERE s.impnodivbiol = :impnodivbiol")
    , @NamedQuery(name = "Sitio.findByComnodivbiol", query = "SELECT s FROM Sitio s WHERE s.comnodivbiol = :comnodivbiol")
    , @NamedQuery(name = "Sitio.findByUrgencia", query = "SELECT s FROM Sitio s WHERE s.urgencia = :urgencia")
    , @NamedQuery(name = "Sitio.findByComurgencia", query = "SELECT s FROM Sitio s WHERE s.comurgencia = :comurgencia")
    , @NamedQuery(name = "Sitio.findByIntenccons", query = "SELECT s FROM Sitio s WHERE s.intenccons = :intenccons")
    , @NamedQuery(name = "Sitio.findByNumlotes", query = "SELECT s FROM Sitio s WHERE s.numlotes = :numlotes")
    , @NamedQuery(name = "Sitio.findByCostestprot1", query = "SELECT s FROM Sitio s WHERE s.costestprot1 = :costestprot1")
    , @NamedQuery(name = "Sitio.findByCostestprot2", query = "SELECT s FROM Sitio s WHERE s.costestprot2 = :costestprot2")
    , @NamedQuery(name = "Sitio.findByCoddesig", query = "SELECT s FROM Sitio s WHERE s.coddesig = :coddesig")
    , @NamedQuery(name = "Sitio.findByDesignacion", query = "SELECT s FROM Sitio s WHERE s.designacion = :designacion")
    , @NamedQuery(name = "Sitio.findByComprot", query = "SELECT s FROM Sitio s WHERE s.comprot = :comprot")
    , @NamedQuery(name = "Sitio.findByComusotierra", query = "SELECT s FROM Sitio s WHERE s.comusotierra = :comusotierra")
    , @NamedQuery(name = "Sitio.findByCompeligrnat", query = "SELECT s FROM Sitio s WHERE s.compeligrnat = :compeligrnat")
    , @NamedQuery(name = "Sitio.findByComexoticas", query = "SELECT s FROM Sitio s WHERE s.comexoticas = :comexoticas")
    , @NamedQuery(name = "Sitio.findByUsotierraf", query = "SELECT s FROM Sitio s WHERE s.usotierraf = :usotierraf")
    , @NamedQuery(name = "Sitio.findByNecinform", query = "SELECT s FROM Sitio s WHERE s.necinform = :necinform")
    , @NamedQuery(name = "Sitio.findByNecmanejo", query = "SELECT s FROM Sitio s WHERE s.necmanejo = :necmanejo")
    , @NamedQuery(name = "Sitio.findByComam", query = "SELECT s FROM Sitio s WHERE s.comam = :comam")
    , @NamedQuery(name = "Sitio.findByRbsopc1", query = "SELECT s FROM Sitio s WHERE s.rbsopc1 = :rbsopc1")
    , @NamedQuery(name = "Sitio.findByRbsopc2", query = "SELECT s FROM Sitio s WHERE s.rbsopc2 = :rbsopc2")
    , @NamedQuery(name = "Sitio.findByRbsopc3", query = "SELECT s FROM Sitio s WHERE s.rbsopc3 = :rbsopc3")
    , @NamedQuery(name = "Sitio.findByRbsopc4", query = "SELECT s FROM Sitio s WHERE s.rbsopc4 = :rbsopc4")
    , @NamedQuery(name = "Sitio.findByRbsopc5", query = "SELECT s FROM Sitio s WHERE s.rbsopc5 = :rbsopc5")
    , @NamedQuery(name = "Sitio.findByRespdatos", query = "SELECT s FROM Sitio s WHERE s.respdatos = :respdatos")
    , @NamedQuery(name = "Sitio.findByActualizar", query = "SELECT s FROM Sitio s WHERE s.actualizar = :actualizar")})
public class Sitio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sitio_id")
    private Integer sitioId;
    @Column(name = "codsitio")
    private String codsitio;
    @Column(name = "nomsitio")
    private String nomsitio;
    @Column(name = "sinsitio")
    private String sinsitio;
    @Column(name = "nacion")
    private String nacion;
    @Column(name = "subnacion")
    private String subnacion;
    @Column(name = "siteresp")
    private String siteresp;
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
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "descrito")
    private String descrito;
    @Column(name = "mapasitio")
    private String mapasitio;
    @Column(name = "fechamapa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamapa;
    @Column(name = "dibujante")
    private String dibujante;
    @Column(name = "justlimite")
    private String justlimite;
    @Column(name = "areaprisec1")
    private Integer areaprisec1;
    @Column(name = "areaprisec2")
    private Integer areaprisec2;
    @Column(name = "areapri1")
    private Integer areapri1;
    @Column(name = "areapri2")
    private Integer areapri2;
    @Column(name = "areatotal1")
    private Integer areatotal1;
    @Column(name = "areatotal2")
    private Integer areatotal2;
    @Column(name = "comsitio")
    private String comsitio;
    @Column(name = "rangoant")
    private String rangoant;
    @Column(name = "comrango")
    private String comrango;
    @Column(name = "impdivbiol")
    private String impdivbiol;
    @Column(name = "comdivbiol")
    private String comdivbiol;
    @Column(name = "impnodivbiol")
    private String impnodivbiol;
    @Column(name = "comnodivbiol")
    private String comnodivbiol;
    @Column(name = "urgencia")
    private String urgencia;
    @Column(name = "comurgencia")
    private String comurgencia;
    @Column(name = "intenccons")
    private String intenccons;
    @Column(name = "numlotes")
    private Integer numlotes;
    @Column(name = "costestprot1")
    private Integer costestprot1;
    @Column(name = "costestprot2")
    private Integer costestprot2;
    @Column(name = "coddesig")
    private String coddesig;
    @Column(name = "designacion")
    private String designacion;
    @Column(name = "comprot")
    private String comprot;
    @Column(name = "comusotierra")
    private String comusotierra;
    @Column(name = "compeligrnat")
    private String compeligrnat;
    @Column(name = "comexoticas")
    private String comexoticas;
    @Column(name = "usotierraf")
    private String usotierraf;
    @Column(name = "necinform")
    private String necinform;
    @Column(name = "necmanejo")
    private String necmanejo;
    @Column(name = "comam")
    private String comam;
    @Column(name = "rbsopc1")
    private String rbsopc1;
    @Column(name = "rbsopc2")
    private String rbsopc2;
    @Column(name = "rbsopc3")
    private String rbsopc3;
    @Column(name = "rbsopc4")
    private String rbsopc4;
    @Column(name = "rbsopc5")
    private String rbsopc5;
    @Column(name = "respdatos")
    private String respdatos;
    @Column(name = "actualizar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizar;
    @ManyToMany(mappedBy = "sitioList")
    private List<Localizacion> localizacionList;
    @ManyToMany(mappedBy = "sitioList")
    private List<Area> areaList;
    @JoinColumn(name = "USUARIO_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario uSUARIOusuarioid;
    @OneToMany(mappedBy = "sITIOsitioid")
    private List<Macsitio> macsitioList;
    @OneToMany(mappedBy = "sITIOsitioid")
    private List<Subdivision> subdivisionList;
    @OneToMany(mappedBy = "sITIOsitioid")
    private List<ContactoHasSitio> contactoHasSitioList;
    @OneToMany(mappedBy = "sITIOsitioid")
    private List<SitioHasLote> sitioHasLoteList;
    @OneToMany(mappedBy = "sITIOsitioid")
    private List<Foto> fotoList;
    @OneToMany(mappedBy = "sITIOsitioid")
    private List<Observaciones> observacionesList;

    public Sitio() {
    }

    public Sitio(Integer sitioId) {
        this.sitioId = sitioId;
    }

    public Integer getSitioId() {
        return sitioId;
    }

    public void setSitioId(Integer sitioId) {
        this.sitioId = sitioId;
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

    public String getSinsitio() {
        return sinsitio;
    }

    public void setSinsitio(String sinsitio) {
        this.sinsitio = sinsitio;
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

    public String getSiteresp() {
        return siteresp;
    }

    public void setSiteresp(String siteresp) {
        this.siteresp = siteresp;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescrito() {
        return descrito;
    }

    public void setDescrito(String descrito) {
        this.descrito = descrito;
    }

    public String getMapasitio() {
        return mapasitio;
    }

    public void setMapasitio(String mapasitio) {
        this.mapasitio = mapasitio;
    }

    public Date getFechamapa() {
        return fechamapa;
    }

    public void setFechamapa(Date fechamapa) {
        this.fechamapa = fechamapa;
    }

    public String getDibujante() {
        return dibujante;
    }

    public void setDibujante(String dibujante) {
        this.dibujante = dibujante;
    }

    public String getJustlimite() {
        return justlimite;
    }

    public void setJustlimite(String justlimite) {
        this.justlimite = justlimite;
    }

    public Integer getAreaprisec1() {
        return areaprisec1;
    }

    public void setAreaprisec1(Integer areaprisec1) {
        this.areaprisec1 = areaprisec1;
    }

    public Integer getAreaprisec2() {
        return areaprisec2;
    }

    public void setAreaprisec2(Integer areaprisec2) {
        this.areaprisec2 = areaprisec2;
    }

    public Integer getAreapri1() {
        return areapri1;
    }

    public void setAreapri1(Integer areapri1) {
        this.areapri1 = areapri1;
    }

    public Integer getAreapri2() {
        return areapri2;
    }

    public void setAreapri2(Integer areapri2) {
        this.areapri2 = areapri2;
    }

    public Integer getAreatotal1() {
        return areatotal1;
    }

    public void setAreatotal1(Integer areatotal1) {
        this.areatotal1 = areatotal1;
    }

    public Integer getAreatotal2() {
        return areatotal2;
    }

    public void setAreatotal2(Integer areatotal2) {
        this.areatotal2 = areatotal2;
    }

    public String getComsitio() {
        return comsitio;
    }

    public void setComsitio(String comsitio) {
        this.comsitio = comsitio;
    }

    public String getRangoant() {
        return rangoant;
    }

    public void setRangoant(String rangoant) {
        this.rangoant = rangoant;
    }

    public String getComrango() {
        return comrango;
    }

    public void setComrango(String comrango) {
        this.comrango = comrango;
    }

    public String getImpdivbiol() {
        return impdivbiol;
    }

    public void setImpdivbiol(String impdivbiol) {
        this.impdivbiol = impdivbiol;
    }

    public String getComdivbiol() {
        return comdivbiol;
    }

    public void setComdivbiol(String comdivbiol) {
        this.comdivbiol = comdivbiol;
    }

    public String getImpnodivbiol() {
        return impnodivbiol;
    }

    public void setImpnodivbiol(String impnodivbiol) {
        this.impnodivbiol = impnodivbiol;
    }

    public String getComnodivbiol() {
        return comnodivbiol;
    }

    public void setComnodivbiol(String comnodivbiol) {
        this.comnodivbiol = comnodivbiol;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getComurgencia() {
        return comurgencia;
    }

    public void setComurgencia(String comurgencia) {
        this.comurgencia = comurgencia;
    }

    public String getIntenccons() {
        return intenccons;
    }

    public void setIntenccons(String intenccons) {
        this.intenccons = intenccons;
    }

    public Integer getNumlotes() {
        return numlotes;
    }

    public void setNumlotes(Integer numlotes) {
        this.numlotes = numlotes;
    }

    public Integer getCostestprot1() {
        return costestprot1;
    }

    public void setCostestprot1(Integer costestprot1) {
        this.costestprot1 = costestprot1;
    }

    public Integer getCostestprot2() {
        return costestprot2;
    }

    public void setCostestprot2(Integer costestprot2) {
        this.costestprot2 = costestprot2;
    }

    public String getCoddesig() {
        return coddesig;
    }

    public void setCoddesig(String coddesig) {
        this.coddesig = coddesig;
    }

    public String getDesignacion() {
        return designacion;
    }

    public void setDesignacion(String designacion) {
        this.designacion = designacion;
    }

    public String getComprot() {
        return comprot;
    }

    public void setComprot(String comprot) {
        this.comprot = comprot;
    }

    public String getComusotierra() {
        return comusotierra;
    }

    public void setComusotierra(String comusotierra) {
        this.comusotierra = comusotierra;
    }

    public String getCompeligrnat() {
        return compeligrnat;
    }

    public void setCompeligrnat(String compeligrnat) {
        this.compeligrnat = compeligrnat;
    }

    public String getComexoticas() {
        return comexoticas;
    }

    public void setComexoticas(String comexoticas) {
        this.comexoticas = comexoticas;
    }

    public String getUsotierraf() {
        return usotierraf;
    }

    public void setUsotierraf(String usotierraf) {
        this.usotierraf = usotierraf;
    }

    public String getNecinform() {
        return necinform;
    }

    public void setNecinform(String necinform) {
        this.necinform = necinform;
    }

    public String getNecmanejo() {
        return necmanejo;
    }

    public void setNecmanejo(String necmanejo) {
        this.necmanejo = necmanejo;
    }

    public String getComam() {
        return comam;
    }

    public void setComam(String comam) {
        this.comam = comam;
    }

    public String getRbsopc1() {
        return rbsopc1;
    }

    public void setRbsopc1(String rbsopc1) {
        this.rbsopc1 = rbsopc1;
    }

    public String getRbsopc2() {
        return rbsopc2;
    }

    public void setRbsopc2(String rbsopc2) {
        this.rbsopc2 = rbsopc2;
    }

    public String getRbsopc3() {
        return rbsopc3;
    }

    public void setRbsopc3(String rbsopc3) {
        this.rbsopc3 = rbsopc3;
    }

    public String getRbsopc4() {
        return rbsopc4;
    }

    public void setRbsopc4(String rbsopc4) {
        this.rbsopc4 = rbsopc4;
    }

    public String getRbsopc5() {
        return rbsopc5;
    }

    public void setRbsopc5(String rbsopc5) {
        this.rbsopc5 = rbsopc5;
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
    public List<Localizacion> getLocalizacionList() {
        return localizacionList;
    }

    public void setLocalizacionList(List<Localizacion> localizacionList) {
        this.localizacionList = localizacionList;
    }

    @XmlTransient
    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    public Usuario getUSUARIOusuarioid() {
        return uSUARIOusuarioid;
    }

    public void setUSUARIOusuarioid(Usuario uSUARIOusuarioid) {
        this.uSUARIOusuarioid = uSUARIOusuarioid;
    }

    @XmlTransient
    public List<Macsitio> getMacsitioList() {
        return macsitioList;
    }

    public void setMacsitioList(List<Macsitio> macsitioList) {
        this.macsitioList = macsitioList;
    }

    @XmlTransient
    public List<Subdivision> getSubdivisionList() {
        return subdivisionList;
    }

    public void setSubdivisionList(List<Subdivision> subdivisionList) {
        this.subdivisionList = subdivisionList;
    }

    @XmlTransient
    public List<ContactoHasSitio> getContactoHasSitioList() {
        return contactoHasSitioList;
    }

    public void setContactoHasSitioList(List<ContactoHasSitio> contactoHasSitioList) {
        this.contactoHasSitioList = contactoHasSitioList;
    }

    @XmlTransient
    public List<SitioHasLote> getSitioHasLoteList() {
        return sitioHasLoteList;
    }

    public void setSitioHasLoteList(List<SitioHasLote> sitioHasLoteList) {
        this.sitioHasLoteList = sitioHasLoteList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sitioId != null ? sitioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sitio)) {
            return false;
        }
        Sitio other = (Sitio) object;
        if ((this.sitioId == null && other.sitioId != null) || (this.sitioId != null && !this.sitioId.equals(other.sitioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Sitio[ sitioId=" + sitioId + " ]";
    }
    
}
