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
    , @NamedQuery(name = "Fuente.findByPublicacioncdc", query = "SELECT f FROM Fuente f WHERE f.publicacioncdc = :publicacioncdc")
    , @NamedQuery(name = "Fuente.findByValor", query = "SELECT f FROM Fuente f WHERE f.valor = :valor")
    , @NamedQuery(name = "Fuente.findByClave", query = "SELECT f FROM Fuente f WHERE f.clave = :clave")
    , @NamedQuery(name = "Fuente.findByComentario", query = "SELECT f FROM Fuente f WHERE f.comentario = :comentario")
    , @NamedQuery(name = "Fuente.findByNotadigest", query = "SELECT f FROM Fuente f WHERE f.notadigest = :notadigest")
    , @NamedQuery(name = "Fuente.findByActualizar", query = "SELECT f FROM Fuente f WHERE f.actualizar = :actualizar")
    , @NamedQuery(name = "Fuente.findByControl", query = "SELECT f FROM Fuente f WHERE f.control = :control")
    , @NamedQuery(name = "Fuente.findByBcd", query = "SELECT f FROM Fuente f WHERE f.bcd = :bcd")
    , @NamedQuery(name = "Fuente.findByComunnat", query = "SELECT f FROM Fuente f WHERE f.comunnat = :comunnat")
    , @NamedQuery(name = "Fuente.findByComunterr", query = "SELECT f FROM Fuente f WHERE f.comunterr = :comunterr")
    , @NamedQuery(name = "Fuente.findByBosque", query = "SELECT f FROM Fuente f WHERE f.bosque = :bosque")
    , @NamedQuery(name = "Fuente.findBySabana", query = "SELECT f FROM Fuente f WHERE f.sabana = :sabana")
    , @NamedQuery(name = "Fuente.findByPrado", query = "SELECT f FROM Fuente f WHERE f.prado = :prado")
    , @NamedQuery(name = "Fuente.findByChaparral", query = "SELECT f FROM Fuente f WHERE f.chaparral = :chaparral")
    , @NamedQuery(name = "Fuente.findByDesierto", query = "SELECT f FROM Fuente f WHERE f.desierto = :desierto")
    , @NamedQuery(name = "Fuente.findByAlpino", query = "SELECT f FROM Fuente f WHERE f.alpino = :alpino")
    , @NamedQuery(name = "Fuente.findByOtroterr", query = "SELECT f FROM Fuente f WHERE f.otroterr = :otroterr")
    , @NamedQuery(name = "Fuente.findByComunac", query = "SELECT f FROM Fuente f WHERE f.comunac = :comunac")
    , @NamedQuery(name = "Fuente.findByPalustre", query = "SELECT f FROM Fuente f WHERE f.palustre = :palustre")
    , @NamedQuery(name = "Fuente.findByLacustre", query = "SELECT f FROM Fuente f WHERE f.lacustre = :lacustre")
    , @NamedQuery(name = "Fuente.findByFluvial", query = "SELECT f FROM Fuente f WHERE f.fluvial = :fluvial")
    , @NamedQuery(name = "Fuente.findByEstuarino", query = "SELECT f FROM Fuente f WHERE f.estuarino = :estuarino")
    , @NamedQuery(name = "Fuente.findByMaritimo", query = "SELECT f FROM Fuente f WHERE f.maritimo = :maritimo")
    , @NamedQuery(name = "Fuente.findBySubterr", query = "SELECT f FROM Fuente f WHERE f.subterr = :subterr")
    , @NamedQuery(name = "Fuente.findByFlora", query = "SELECT f FROM Fuente f WHERE f.flora = :flora")
    , @NamedQuery(name = "Fuente.findByFloraac", query = "SELECT f FROM Fuente f WHERE f.floraac = :floraac")
    , @NamedQuery(name = "Fuente.findByFloraterr", query = "SELECT f FROM Fuente f WHERE f.floraterr = :floraterr")
    , @NamedQuery(name = "Fuente.findByPlnovasc", query = "SELECT f FROM Fuente f WHERE f.plnovasc = :plnovasc")
    , @NamedQuery(name = "Fuente.findByPlvasc", query = "SELECT f FROM Fuente f WHERE f.plvasc = :plvasc")
    , @NamedQuery(name = "Fuente.findByMicroorg", query = "SELECT f FROM Fuente f WHERE f.microorg = :microorg")
    , @NamedQuery(name = "Fuente.findByInfositio", query = "SELECT f FROM Fuente f WHERE f.infositio = :infositio")
    , @NamedQuery(name = "Fuente.findByFauna", query = "SELECT f FROM Fuente f WHERE f.fauna = :fauna")
    , @NamedQuery(name = "Fuente.findByFaunaac", query = "SELECT f FROM Fuente f WHERE f.faunaac = :faunaac")
    , @NamedQuery(name = "Fuente.findByFaunaterr", query = "SELECT f FROM Fuente f WHERE f.faunaterr = :faunaterr")
    , @NamedQuery(name = "Fuente.findByMoluscos", query = "SELECT f FROM Fuente f WHERE f.moluscos = :moluscos")
    , @NamedQuery(name = "Fuente.findByInsectos", query = "SELECT f FROM Fuente f WHERE f.insectos = :insectos")
    , @NamedQuery(name = "Fuente.findByCrustaceos", query = "SELECT f FROM Fuente f WHERE f.crustaceos = :crustaceos")
    , @NamedQuery(name = "Fuente.findByOtroartrop", query = "SELECT f FROM Fuente f WHERE f.otroartrop = :otroartrop")
    , @NamedQuery(name = "Fuente.findByOtroinvert", query = "SELECT f FROM Fuente f WHERE f.otroinvert = :otroinvert")
    , @NamedQuery(name = "Fuente.findByPeces", query = "SELECT f FROM Fuente f WHERE f.peces = :peces")
    , @NamedQuery(name = "Fuente.findByAnfibios", query = "SELECT f FROM Fuente f WHERE f.anfibios = :anfibios")
    , @NamedQuery(name = "Fuente.findByReptiles", query = "SELECT f FROM Fuente f WHERE f.reptiles = :reptiles")
    , @NamedQuery(name = "Fuente.findByAves", query = "SELECT f FROM Fuente f WHERE f.aves = :aves")
    , @NamedQuery(name = "Fuente.findByMamiferos", query = "SELECT f FROM Fuente f WHERE f.mamiferos = :mamiferos")
    , @NamedQuery(name = "Fuente.findByCienfisic", query = "SELECT f FROM Fuente f WHERE f.cienfisic = :cienfisic")
    , @NamedQuery(name = "Fuente.findByFisiotopo", query = "SELECT f FROM Fuente f WHERE f.fisiotopo = :fisiotopo")
    , @NamedQuery(name = "Fuente.findByHidrol", query = "SELECT f FROM Fuente f WHERE f.hidrol = :hidrol")
    , @NamedQuery(name = "Fuente.findByGeologia", query = "SELECT f FROM Fuente f WHERE f.geologia = :geologia")
    , @NamedQuery(name = "Fuente.findBySuelos", query = "SELECT f FROM Fuente f WHERE f.suelos = :suelos")
    , @NamedQuery(name = "Fuente.findByClima", query = "SELECT f FROM Fuente f WHERE f.clima = :clima")
    , @NamedQuery(name = "Fuente.findByBiologia", query = "SELECT f FROM Fuente f WHERE f.biologia = :biologia")
    , @NamedQuery(name = "Fuente.findByEcologia", query = "SELECT f FROM Fuente f WHERE f.ecologia = :ecologia")
    , @NamedQuery(name = "Fuente.findByFunecol", query = "SELECT f FROM Fuente f WHERE f.funecol = :funecol")
    , @NamedQuery(name = "Fuente.findByDiversnat", query = "SELECT f FROM Fuente f WHERE f.diversnat = :diversnat")
    , @NamedQuery(name = "Fuente.findByInventario", query = "SELECT f FROM Fuente f WHERE f.inventario = :inventario")
    , @NamedQuery(name = "Fuente.findByTecinvest", query = "SELECT f FROM Fuente f WHERE f.tecinvest = :tecinvest")
    , @NamedQuery(name = "Fuente.findByAm", query = "SELECT f FROM Fuente f WHERE f.am = :am")
    , @NamedQuery(name = "Fuente.findByPlanmanejo", query = "SELECT f FROM Fuente f WHERE f.planmanejo = :planmanejo")
    , @NamedQuery(name = "Fuente.findByTecmanejo", query = "SELECT f FROM Fuente f WHERE f.tecmanejo = :tecmanejo")
    , @NamedQuery(name = "Fuente.findByEstimpamb", query = "SELECT f FROM Fuente f WHERE f.estimpamb = :estimpamb")
    , @NamedQuery(name = "Fuente.findByOrganprott", query = "SELECT f FROM Fuente f WHERE f.organprott = :organprott")
    , @NamedQuery(name = "Fuente.findByHerrprot", query = "SELECT f FROM Fuente f WHERE f.herrprot = :herrprot")})
public class Fuente implements Serializable {

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
    @Column(name = "comunnat")
    private Boolean comunnat;
    @Column(name = "comunterr")
    private Boolean comunterr;
    @Column(name = "bosque")
    private Boolean bosque;
    @Column(name = "sabana")
    private Boolean sabana;
    @Column(name = "prado")
    private Boolean prado;
    @Column(name = "chaparral")
    private Boolean chaparral;
    @Column(name = "desierto")
    private Boolean desierto;
    @Column(name = "alpino")
    private Boolean alpino;
    @Column(name = "otroterr")
    private Boolean otroterr;
    @Column(name = "comunac")
    private Boolean comunac;
    @Column(name = "palustre")
    private Boolean palustre;
    @Column(name = "lacustre")
    private Boolean lacustre;
    @Column(name = "fluvial")
    private Boolean fluvial;
    @Column(name = "estuarino")
    private Boolean estuarino;
    @Column(name = "maritimo")
    private Boolean maritimo;
    @Column(name = "subterr")
    private Boolean subterr;
    @Column(name = "flora")
    private Boolean flora;
    @Column(name = "floraac")
    private Boolean floraac;
    @Column(name = "floraterr")
    private Boolean floraterr;
    @Column(name = "plnovasc")
    private Boolean plnovasc;
    @Column(name = "plvasc")
    private Boolean plvasc;
    @Column(name = "microorg")
    private Boolean microorg;
    @Column(name = "infositio")
    private Boolean infositio;
    @Column(name = "fauna")
    private Boolean fauna;
    @Column(name = "faunaac")
    private Boolean faunaac;
    @Column(name = "faunaterr")
    private Boolean faunaterr;
    @Column(name = "moluscos")
    private Boolean moluscos;
    @Column(name = "insectos")
    private Boolean insectos;
    @Column(name = "crustaceos")
    private Boolean crustaceos;
    @Column(name = "otroartrop")
    private Boolean otroartrop;
    @Column(name = "otroinvert")
    private Boolean otroinvert;
    @Column(name = "peces")
    private Boolean peces;
    @Column(name = "anfibios")
    private Boolean anfibios;
    @Column(name = "reptiles")
    private Boolean reptiles;
    @Column(name = "aves")
    private Boolean aves;
    @Column(name = "mamiferos")
    private Boolean mamiferos;
    @Column(name = "cienfisic")
    private Boolean cienfisic;
    @Column(name = "fisiotopo")
    private Boolean fisiotopo;
    @Column(name = "hidrol")
    private Boolean hidrol;
    @Column(name = "geologia")
    private Boolean geologia;
    @Column(name = "suelos")
    private Boolean suelos;
    @Column(name = "clima")
    private Boolean clima;
    @Column(name = "biologia")
    private Boolean biologia;
    @Column(name = "ecologia")
    private Boolean ecologia;
    @Column(name = "funecol")
    private Boolean funecol;
    @Column(name = "diversnat")
    private Boolean diversnat;
    @Column(name = "inventario")
    private Boolean inventario;
    @Column(name = "tecinvest")
    private Boolean tecinvest;
    @Column(name = "am")
    private Boolean am;
    @Column(name = "planmanejo")
    private Boolean planmanejo;
    @Column(name = "tecmanejo")
    private Boolean tecmanejo;
    @Column(name = "estimpamb")
    private Boolean estimpamb;
    @Column(name = "organprott")
    private Boolean organprott;
    @Column(name = "herrprot")
    private Boolean herrprot;
    @JoinColumn(name = "RASTREO_rastreo_id", referencedColumnName = "rastreo_id")
    @ManyToOne
    private Rastreo rASTREOrastreoid;
    @JoinColumn(name = "USUARIO_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario uSUARIOusuarioid;
    @OneToMany(mappedBy = "fUENTEfuenteid")
    private List<Archivo> archivoList;

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

    public Boolean getComunnat() {
        return comunnat;
    }

    public void setComunnat(Boolean comunnat) {
        this.comunnat = comunnat;
    }

    public Boolean getComunterr() {
        return comunterr;
    }

    public void setComunterr(Boolean comunterr) {
        this.comunterr = comunterr;
    }

    public Boolean getBosque() {
        return bosque;
    }

    public void setBosque(Boolean bosque) {
        this.bosque = bosque;
    }

    public Boolean getSabana() {
        return sabana;
    }

    public void setSabana(Boolean sabana) {
        this.sabana = sabana;
    }

    public Boolean getPrado() {
        return prado;
    }

    public void setPrado(Boolean prado) {
        this.prado = prado;
    }

    public Boolean getChaparral() {
        return chaparral;
    }

    public void setChaparral(Boolean chaparral) {
        this.chaparral = chaparral;
    }

    public Boolean getDesierto() {
        return desierto;
    }

    public void setDesierto(Boolean desierto) {
        this.desierto = desierto;
    }

    public Boolean getAlpino() {
        return alpino;
    }

    public void setAlpino(Boolean alpino) {
        this.alpino = alpino;
    }

    public Boolean getOtroterr() {
        return otroterr;
    }

    public void setOtroterr(Boolean otroterr) {
        this.otroterr = otroterr;
    }

    public Boolean getComunac() {
        return comunac;
    }

    public void setComunac(Boolean comunac) {
        this.comunac = comunac;
    }

    public Boolean getPalustre() {
        return palustre;
    }

    public void setPalustre(Boolean palustre) {
        this.palustre = palustre;
    }

    public Boolean getLacustre() {
        return lacustre;
    }

    public void setLacustre(Boolean lacustre) {
        this.lacustre = lacustre;
    }

    public Boolean getFluvial() {
        return fluvial;
    }

    public void setFluvial(Boolean fluvial) {
        this.fluvial = fluvial;
    }

    public Boolean getEstuarino() {
        return estuarino;
    }

    public void setEstuarino(Boolean estuarino) {
        this.estuarino = estuarino;
    }

    public Boolean getMaritimo() {
        return maritimo;
    }

    public void setMaritimo(Boolean maritimo) {
        this.maritimo = maritimo;
    }

    public Boolean getSubterr() {
        return subterr;
    }

    public void setSubterr(Boolean subterr) {
        this.subterr = subterr;
    }

    public Boolean getFlora() {
        return flora;
    }

    public void setFlora(Boolean flora) {
        this.flora = flora;
    }

    public Boolean getFloraac() {
        return floraac;
    }

    public void setFloraac(Boolean floraac) {
        this.floraac = floraac;
    }

    public Boolean getFloraterr() {
        return floraterr;
    }

    public void setFloraterr(Boolean floraterr) {
        this.floraterr = floraterr;
    }

    public Boolean getPlnovasc() {
        return plnovasc;
    }

    public void setPlnovasc(Boolean plnovasc) {
        this.plnovasc = plnovasc;
    }

    public Boolean getPlvasc() {
        return plvasc;
    }

    public void setPlvasc(Boolean plvasc) {
        this.plvasc = plvasc;
    }

    public Boolean getMicroorg() {
        return microorg;
    }

    public void setMicroorg(Boolean microorg) {
        this.microorg = microorg;
    }

    public Boolean getInfositio() {
        return infositio;
    }

    public void setInfositio(Boolean infositio) {
        this.infositio = infositio;
    }

    public Boolean getFauna() {
        return fauna;
    }

    public void setFauna(Boolean fauna) {
        this.fauna = fauna;
    }

    public Boolean getFaunaac() {
        return faunaac;
    }

    public void setFaunaac(Boolean faunaac) {
        this.faunaac = faunaac;
    }

    public Boolean getFaunaterr() {
        return faunaterr;
    }

    public void setFaunaterr(Boolean faunaterr) {
        this.faunaterr = faunaterr;
    }

    public Boolean getMoluscos() {
        return moluscos;
    }

    public void setMoluscos(Boolean moluscos) {
        this.moluscos = moluscos;
    }

    public Boolean getInsectos() {
        return insectos;
    }

    public void setInsectos(Boolean insectos) {
        this.insectos = insectos;
    }

    public Boolean getCrustaceos() {
        return crustaceos;
    }

    public void setCrustaceos(Boolean crustaceos) {
        this.crustaceos = crustaceos;
    }

    public Boolean getOtroartrop() {
        return otroartrop;
    }

    public void setOtroartrop(Boolean otroartrop) {
        this.otroartrop = otroartrop;
    }

    public Boolean getOtroinvert() {
        return otroinvert;
    }

    public void setOtroinvert(Boolean otroinvert) {
        this.otroinvert = otroinvert;
    }

    public Boolean getPeces() {
        return peces;
    }

    public void setPeces(Boolean peces) {
        this.peces = peces;
    }

    public Boolean getAnfibios() {
        return anfibios;
    }

    public void setAnfibios(Boolean anfibios) {
        this.anfibios = anfibios;
    }

    public Boolean getReptiles() {
        return reptiles;
    }

    public void setReptiles(Boolean reptiles) {
        this.reptiles = reptiles;
    }

    public Boolean getAves() {
        return aves;
    }

    public void setAves(Boolean aves) {
        this.aves = aves;
    }

    public Boolean getMamiferos() {
        return mamiferos;
    }

    public void setMamiferos(Boolean mamiferos) {
        this.mamiferos = mamiferos;
    }

    public Boolean getCienfisic() {
        return cienfisic;
    }

    public void setCienfisic(Boolean cienfisic) {
        this.cienfisic = cienfisic;
    }

    public Boolean getFisiotopo() {
        return fisiotopo;
    }

    public void setFisiotopo(Boolean fisiotopo) {
        this.fisiotopo = fisiotopo;
    }

    public Boolean getHidrol() {
        return hidrol;
    }

    public void setHidrol(Boolean hidrol) {
        this.hidrol = hidrol;
    }

    public Boolean getGeologia() {
        return geologia;
    }

    public void setGeologia(Boolean geologia) {
        this.geologia = geologia;
    }

    public Boolean getSuelos() {
        return suelos;
    }

    public void setSuelos(Boolean suelos) {
        this.suelos = suelos;
    }

    public Boolean getClima() {
        return clima;
    }

    public void setClima(Boolean clima) {
        this.clima = clima;
    }

    public Boolean getBiologia() {
        return biologia;
    }

    public void setBiologia(Boolean biologia) {
        this.biologia = biologia;
    }

    public Boolean getEcologia() {
        return ecologia;
    }

    public void setEcologia(Boolean ecologia) {
        this.ecologia = ecologia;
    }

    public Boolean getFunecol() {
        return funecol;
    }

    public void setFunecol(Boolean funecol) {
        this.funecol = funecol;
    }

    public Boolean getDiversnat() {
        return diversnat;
    }

    public void setDiversnat(Boolean diversnat) {
        this.diversnat = diversnat;
    }

    public Boolean getInventario() {
        return inventario;
    }

    public void setInventario(Boolean inventario) {
        this.inventario = inventario;
    }

    public Boolean getTecinvest() {
        return tecinvest;
    }

    public void setTecinvest(Boolean tecinvest) {
        this.tecinvest = tecinvest;
    }

    public Boolean getAm() {
        return am;
    }

    public void setAm(Boolean am) {
        this.am = am;
    }

    public Boolean getPlanmanejo() {
        return planmanejo;
    }

    public void setPlanmanejo(Boolean planmanejo) {
        this.planmanejo = planmanejo;
    }

    public Boolean getTecmanejo() {
        return tecmanejo;
    }

    public void setTecmanejo(Boolean tecmanejo) {
        this.tecmanejo = tecmanejo;
    }

    public Boolean getEstimpamb() {
        return estimpamb;
    }

    public void setEstimpamb(Boolean estimpamb) {
        this.estimpamb = estimpamb;
    }

    public Boolean getOrganprott() {
        return organprott;
    }

    public void setOrganprott(Boolean organprott) {
        this.organprott = organprott;
    }

    public Boolean getHerrprot() {
        return herrprot;
    }

    public void setHerrprot(Boolean herrprot) {
        this.herrprot = herrprot;
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
    
}
