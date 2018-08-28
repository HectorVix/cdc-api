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
    , @NamedQuery(name = "Localizacion.findByLocalizacionId", query = "SELECT l FROM Localizacion l WHERE l.localizacionId = :localizacionId")})
public class Localizacion implements Serializable {

    @Column(name = "codigole")
    private String codigole;
    @Column(name = "ident")
    private String ident;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "nomcomuns")
    private String nomcomuns;
    @Column(name = "rangog")
    private String rangog;
    @Column(name = "rangon")
    private String rangon;
    @Column(name = "rangos")
    private String rangos;
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
    @Column(name = "precision")
    private String precision;
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
    @Column(name = "resprg")
    private String resprg;
    @Column(name = "contacto")
    private String contacto;
    @Column(name = "numcontacto")
    private String numcontacto;
    @Column(name = "elev")
    private Integer elev;
    @Column(name = "area")
    private Integer area;
    @Column(name = "masterreno")
    private String masterreno;
    @Column(name = "masprotec")
    private String masprotec;
    @Column(name = "masmanejo")
    private String masmanejo;
    @Column(name = "involtnc")
    private String involtnc;
    @Column(name = "commanejo")
    private String commanejo;
    @Column(name = "comprot")
    private String comprot;
    @Column(name = "prop")
    private String prop;
    @Column(name = "infprop")
    private String infprop;
    @Column(name = "comprop")
    private String comprop;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "sensdatos")
    private String sensdatos;
    @Column(name = "limites")
    private String limites;
    @Column(name = "fotos")
    private String fotos;
    @Column(name = "mejorfuente")
    private String mejorfuente;
    @Column(name = "codfuente")
    private String codfuente;
    @Column(name = "transcrito")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transcrito;
    @Column(name = "mdrev")
    private String mdrev;
    @Column(name = "cartografo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cartografo;
    @Column(name = "cc")
    private String cc;
    @Column(name = "respdatos")
    private String respdatos;
    @Column(name = "actualizar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizar;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "localizacion_id")
    private Integer localizacionId;
    @JoinTable(name = "localizacion_has_sitio", joinColumns = {
        @JoinColumn(name = "LOCALIZACION_localizacion_id", referencedColumnName = "localizacion_id")}, inverseJoinColumns = {
        @JoinColumn(name = "SITIO_sitio_id", referencedColumnName = "sitio_id")})
    @ManyToMany
    private List<Sitio> sitioList;
    @OneToMany(mappedBy = "lOCALIZACIONlocalizacionid")
    private List<Proteccion> proteccionList;
    @OneToMany(mappedBy = "lOCALIZACIONlocalizacionid")
    private List<Ecomonitoreo> ecomonitoreoList;
    @OneToMany(mappedBy = "lOCALIZACIONlocalizacionid")
    private List<Protocolo> protocoloList;
    @JoinColumn(name = "RASTREO_rastreo_id", referencedColumnName = "rastreo_id")
    @ManyToOne
    private Rastreo rASTREOrastreoid;

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
    public List<Ecomonitoreo> getEcomonitoreoList() {
        return ecomonitoreoList;
    }

    public void setEcomonitoreoList(List<Ecomonitoreo> ecomonitoreoList) {
        this.ecomonitoreoList = ecomonitoreoList;
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

    public String getCodigole() {
        return codigole;
    }

    public void setCodigole(String codigole) {
        this.codigole = codigole;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNomcomuns() {
        return nomcomuns;
    }

    public void setNomcomuns(String nomcomuns) {
        this.nomcomuns = nomcomuns;
    }

    public String getRangog() {
        return rangog;
    }

    public void setRangog(String rangog) {
        this.rangog = rangog;
    }

    public String getRangon() {
        return rangon;
    }

    public void setRangon(String rangon) {
        this.rangon = rangon;
    }

    public String getRangos() {
        return rangos;
    }

    public void setRangos(String rangos) {
        this.rangos = rangos;
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

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
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

    public String getResprg() {
        return resprg;
    }

    public void setResprg(String resprg) {
        this.resprg = resprg;
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

    public String getMasterreno() {
        return masterreno;
    }

    public void setMasterreno(String masterreno) {
        this.masterreno = masterreno;
    }

    public String getMasprotec() {
        return masprotec;
    }

    public void setMasprotec(String masprotec) {
        this.masprotec = masprotec;
    }

    public String getMasmanejo() {
        return masmanejo;
    }

    public void setMasmanejo(String masmanejo) {
        this.masmanejo = masmanejo;
    }

    public String getInvoltnc() {
        return involtnc;
    }

    public void setInvoltnc(String involtnc) {
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

    public String getInfprop() {
        return infprop;
    }

    public void setInfprop(String infprop) {
        this.infprop = infprop;
    }

    public String getComprop() {
        return comprop;
    }

    public void setComprop(String comprop) {
        this.comprop = comprop;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getSensdatos() {
        return sensdatos;
    }

    public void setSensdatos(String sensdatos) {
        this.sensdatos = sensdatos;
    }

    public String getLimites() {
        return limites;
    }

    public void setLimites(String limites) {
        this.limites = limites;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
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

    public Date getTranscrito() {
        return transcrito;
    }

    public void setTranscrito(Date transcrito) {
        this.transcrito = transcrito;
    }

    public String getMdrev() {
        return mdrev;
    }

    public void setMdrev(String mdrev) {
        this.mdrev = mdrev;
    }

    public Date getCartografo() {
        return cartografo;
    }

    public void setCartografo(Date cartografo) {
        this.cartografo = cartografo;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
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
    
}
