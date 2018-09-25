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
@Table(name = "localizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localizacion.findAll", query = "SELECT l FROM Localizacion l")
    , @NamedQuery(name = "Localizacion.findByLocalizacionId", query = "SELECT l FROM Localizacion l WHERE l.localizacionId = :localizacionId")
    , @NamedQuery(name = "Localizacion.findByCodigole", query = "SELECT l FROM Localizacion l WHERE l.codigole = :codigole")
    })
public class Localizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "localizacion_id")
    private Integer localizacionId;
    @Column(name = "codigole")
    private String codigole;
    @Column(name = "ident")
    private Boolean ident;
    @Column(name = "subnacion")
    private String subnacion;
    @Column(name = "subdivision")
    private String subdivision;
    @Column(name = "codsitio")
    private String codsitio;
    @Column(name = "nomsitio")
    private String nomsitio;
    @Column(name = "sitioeva")
    private String sitioeva;
    @Column(name = "precisionl")
    private String precisionl;
    @Column(name = "nommapa")
    private String nommapa;
    @Column(name = "codmapa")
    private String codmapa;
    @Column(name = "nummarg")
    private String nummarg;
    @Column(name = "numpunto")
    private String numpunto;
    @Column(name = "diezdiez")
    private String diezdiez;
    @Column(name = "latitud")
    private String latitud;
    @Column(name = "longitud")
    private String longitud;
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
    @Column(name = "ecoregion")
    private String ecoregion;
    @Column(name = "cuenca")
    private String cuenca;
    @Column(name = "fechaeva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaeva;
    @Column(name = "ultobs")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultobs;
    @Column(name = "priobs")
    private String priobs;
    @Column(name = "rangole")
    private String rangole;
    @Column(name = "fecharangole")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharangole;
    @Column(name = "comrangole")
    private String comrangole;
    @Column(name = "datosle")
    private String datosle;
    @Column(name = "contacto")
    private String contacto;
    @Column(name = "numcontacto")
    private String numcontacto;
    @Column(name = "desgen")
    private String desgen;
    @Column(name = "elev")
    private Integer elev;
    @Column(name = "area")
    private Integer area;
    @Column(name = "masterreno")
    private Boolean masterreno;
    @Column(name = "masprotec")
    private Boolean masprotec;
    @Column(name = "masmanejo")
    private Boolean masmanejo;
    @Column(name = "involtnc")
    private Boolean involtnc;
    @Column(name = "commanejo")
    private String commanejo;
    @Column(name = "comprot")
    private String comprot;
    @Column(name = "prop")
    private String prop;
    @Column(name = "infprop")
    private Boolean infprop;
    @Column(name = "comprop")
    private String comprop;
    @Column(name = "leopc1")
    private String leopc1;
    @Column(name = "leopc2")
    private String leopc2;
    @Column(name = "leopc3")
    private String leopc3;
    @Column(name = "leopc4")
    private String leopc4;
    @Column(name = "leopc5")
    private String leopc5;
    @Column(name = "leopc6")
    private String leopc6;
    @Column(name = "leopc7")
    private String leopc7;
    @Column(name = "leopc8")
    private String leopc8;
    @Column(name = "leopc9")
    private String leopc9;
    @Column(name = "leopc10")
    private String leopc10;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "sensdatos")
    private Boolean sensdatos;
    @Column(name = "limites")
    private Boolean limites;
    @Column(name = "fotos")
    private Boolean fotos;
    @Column(name = "mejorfuente")
    private String mejorfuente;
    @Column(name = "codfuente")
    private String codfuente;
    @Column(name = "mdrev")
    private Boolean mdrev;
    @Column(name = "transcrito")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transcrito;
    @Column(name = "cc")
    private Boolean cc;
    @Column(name = "cartografo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cartografo;
    @Column(name = "respdatos")
    @Temporal(TemporalType.TIMESTAMP)
    private Date respdatos;
    @Column(name = "actualizar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizar;
    @JoinTable(name = "localizacion_has_sitio", joinColumns = {
        @JoinColumn(name = "LOCALIZACION_localizacion_id", referencedColumnName = "localizacion_id")}, inverseJoinColumns = {
        @JoinColumn(name = "SITIO_sitio_id", referencedColumnName = "sitio_id")})
    @ManyToMany
    private List<Sitio> sitioList;
    @OneToMany(mappedBy = "lOCALIZACIONlocalizacionid")
    private List<Proteccion> proteccionList;
    @OneToMany(mappedBy = "lOCALIZACIONlocalizacionid")
    private List<Protocolo> protocoloList;
    @JoinColumn(name = "RASTREO_rastreo_id", referencedColumnName = "rastreo_id")
    @ManyToOne
    private Rastreo rASTREOrastreoid;
    @OneToMany(mappedBy = "lOCALIZACIONlocalizacionid")
    private List<Observaciones> observacionesList;

    public Localizacion() {
    }

    public Localizacion(Integer localizacionId) {
        this.localizacionId = localizacionId;
    }

    public Integer getLocalizacionId() {
        return localizacionId;
    }

    public void setLocalizacionId(Integer localizacionId) {
        this.localizacionId = localizacionId;
    }

    public String getCodigole() {
        return codigole;
    }

    public void setCodigole(String codigole) {
        this.codigole = codigole;
    }

    public Boolean getIdent() {
        return ident;
    }

    public void setIdent(Boolean ident) {
        this.ident = ident;
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

    public String getSitioeva() {
        return sitioeva;
    }

    public void setSitioeva(String sitioeva) {
        this.sitioeva = sitioeva;
    }

    public String getPrecisionl() {
        return precisionl;
    }

    public void setPrecisionl(String precisionl) {
        this.precisionl = precisionl;
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

    public String getNumpunto() {
        return numpunto;
    }

    public void setNumpunto(String numpunto) {
        this.numpunto = numpunto;
    }

    public String getDiezdiez() {
        return diezdiez;
    }

    public void setDiezdiez(String diezdiez) {
        this.diezdiez = diezdiez;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
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

    public String getEcoregion() {
        return ecoregion;
    }

    public void setEcoregion(String ecoregion) {
        this.ecoregion = ecoregion;
    }

    public String getCuenca() {
        return cuenca;
    }

    public void setCuenca(String cuenca) {
        this.cuenca = cuenca;
    }

    public Date getFechaeva() {
        return fechaeva;
    }

    public void setFechaeva(Date fechaeva) {
        this.fechaeva = fechaeva;
    }

    public Date getUltobs() {
        return ultobs;
    }

    public void setUltobs(Date ultobs) {
        this.ultobs = ultobs;
    }

    public String getPriobs() {
        return priobs;
    }

    public void setPriobs(String priobs) {
        this.priobs = priobs;
    }

    public String getRangole() {
        return rangole;
    }

    public void setRangole(String rangole) {
        this.rangole = rangole;
    }

    public Date getFecharangole() {
        return fecharangole;
    }

    public void setFecharangole(Date fecharangole) {
        this.fecharangole = fecharangole;
    }

    public String getComrangole() {
        return comrangole;
    }

    public void setComrangole(String comrangole) {
        this.comrangole = comrangole;
    }

    public String getDatosle() {
        return datosle;
    }

    public void setDatosle(String datosle) {
        this.datosle = datosle;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getNumcontacto() {
        return numcontacto;
    }

    public void setNumcontacto(String numcontacto) {
        this.numcontacto = numcontacto;
    }

    public String getDesgen() {
        return desgen;
    }

    public void setDesgen(String desgen) {
        this.desgen = desgen;
    }

    public Integer getElev() {
        return elev;
    }

    public void setElev(Integer elev) {
        this.elev = elev;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Boolean getMasterreno() {
        return masterreno;
    }

    public void setMasterreno(Boolean masterreno) {
        this.masterreno = masterreno;
    }

    public Boolean getMasprotec() {
        return masprotec;
    }

    public void setMasprotec(Boolean masprotec) {
        this.masprotec = masprotec;
    }

    public Boolean getMasmanejo() {
        return masmanejo;
    }

    public void setMasmanejo(Boolean masmanejo) {
        this.masmanejo = masmanejo;
    }

    public Boolean getInvoltnc() {
        return involtnc;
    }

    public void setInvoltnc(Boolean involtnc) {
        this.involtnc = involtnc;
    }

    public String getCommanejo() {
        return commanejo;
    }

    public void setCommanejo(String commanejo) {
        this.commanejo = commanejo;
    }

    public String getComprot() {
        return comprot;
    }

    public void setComprot(String comprot) {
        this.comprot = comprot;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public Boolean getInfprop() {
        return infprop;
    }

    public void setInfprop(Boolean infprop) {
        this.infprop = infprop;
    }

    public String getComprop() {
        return comprop;
    }

    public void setComprop(String comprop) {
        this.comprop = comprop;
    }

    public String getLeopc1() {
        return leopc1;
    }

    public void setLeopc1(String leopc1) {
        this.leopc1 = leopc1;
    }

    public String getLeopc2() {
        return leopc2;
    }

    public void setLeopc2(String leopc2) {
        this.leopc2 = leopc2;
    }

    public String getLeopc3() {
        return leopc3;
    }

    public void setLeopc3(String leopc3) {
        this.leopc3 = leopc3;
    }

    public String getLeopc4() {
        return leopc4;
    }

    public void setLeopc4(String leopc4) {
        this.leopc4 = leopc4;
    }

    public String getLeopc5() {
        return leopc5;
    }

    public void setLeopc5(String leopc5) {
        this.leopc5 = leopc5;
    }

    public String getLeopc6() {
        return leopc6;
    }

    public void setLeopc6(String leopc6) {
        this.leopc6 = leopc6;
    }

    public String getLeopc7() {
        return leopc7;
    }

    public void setLeopc7(String leopc7) {
        this.leopc7 = leopc7;
    }

    public String getLeopc8() {
        return leopc8;
    }

    public void setLeopc8(String leopc8) {
        this.leopc8 = leopc8;
    }

    public String getLeopc9() {
        return leopc9;
    }

    public void setLeopc9(String leopc9) {
        this.leopc9 = leopc9;
    }

    public String getLeopc10() {
        return leopc10;
    }

    public void setLeopc10(String leopc10) {
        this.leopc10 = leopc10;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Boolean getSensdatos() {
        return sensdatos;
    }

    public void setSensdatos(Boolean sensdatos) {
        this.sensdatos = sensdatos;
    }

    public Boolean getLimites() {
        return limites;
    }

    public void setLimites(Boolean limites) {
        this.limites = limites;
    }

    public Boolean getFotos() {
        return fotos;
    }

    public void setFotos(Boolean fotos) {
        this.fotos = fotos;
    }

    public String getMejorfuente() {
        return mejorfuente;
    }

    public void setMejorfuente(String mejorfuente) {
        this.mejorfuente = mejorfuente;
    }

    public String getCodfuente() {
        return codfuente;
    }

    public void setCodfuente(String codfuente) {
        this.codfuente = codfuente;
    }

    public Boolean getMdrev() {
        return mdrev;
    }

    public void setMdrev(Boolean mdrev) {
        this.mdrev = mdrev;
    }

    public Date getTranscrito() {
        return transcrito;
    }

    public void setTranscrito(Date transcrito) {
        this.transcrito = transcrito;
    }

    public Boolean getCc() {
        return cc;
    }

    public void setCc(Boolean cc) {
        this.cc = cc;
    }

    public Date getCartografo() {
        return cartografo;
    }

    public void setCartografo(Date cartografo) {
        this.cartografo = cartografo;
    }

    public Date getRespdatos() {
        return respdatos;
    }

    public void setRespdatos(Date respdatos) {
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
    public List<Proteccion> getProteccionList() {
        return proteccionList;
    }

    public void setProteccionList(List<Proteccion> proteccionList) {
        this.proteccionList = proteccionList;
    }

    @XmlTransient
    public List<Protocolo> getProtocoloList() {
        return protocoloList;
    }

    public void setProtocoloList(List<Protocolo> protocoloList) {
        this.protocoloList = protocoloList;
    }

    public Rastreo getRASTREOrastreoid() {
        return rASTREOrastreoid;
    }

    public void setRASTREOrastreoid(Rastreo rASTREOrastreoid) {
        this.rASTREOrastreoid = rASTREOrastreoid;
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
        hash += (localizacionId != null ? localizacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localizacion)) {
            return false;
        }
        Localizacion other = (Localizacion) object;
        if ((this.localizacionId == null && other.localizacionId != null) || (this.localizacionId != null && !this.localizacionId.equals(other.localizacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Localizacion[ localizacionId=" + localizacionId + " ]";
    }
    
}
