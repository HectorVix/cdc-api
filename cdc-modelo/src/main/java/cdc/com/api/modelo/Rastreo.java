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
@Table(name = "rastreo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rastreo.findAll", query = "SELECT r FROM Rastreo r")
    , @NamedQuery(name = "Rastreo.findByRastreoId", query = "SELECT r FROM Rastreo r WHERE r.rastreoId = :rastreoId")
    , @NamedQuery(name = "Rastreo.findByCodigoe", query = "SELECT r FROM Rastreo r WHERE r.codigoe = :codigoe")
    , @NamedQuery(name = "Rastreo.findByTropicos", query = "SELECT r FROM Rastreo r WHERE r.tropicos = :tropicos")
    , @NamedQuery(name = "Rastreo.findByNacion", query = "SELECT r FROM Rastreo r WHERE r.nacion = :nacion")
    , @NamedQuery(name = "Rastreo.findBySubnacion", query = "SELECT r FROM Rastreo r WHERE r.subnacion = :subnacion")
    , @NamedQuery(name = "Rastreo.findByClasetax", query = "SELECT r FROM Rastreo r WHERE r.clasetax = :clasetax")
    , @NamedQuery(name = "Rastreo.findByOrden", query = "SELECT r FROM Rastreo r WHERE r.orden = :orden")
    , @NamedQuery(name = "Rastreo.findByFamilia", query = "SELECT r FROM Rastreo r WHERE r.familia = :familia")
    , @NamedQuery(name = "Rastreo.findByGenero", query = "SELECT r FROM Rastreo r WHERE r.genero = :genero")
    , @NamedQuery(name = "Rastreo.findByAutor", query = "SELECT r FROM Rastreo r WHERE r.autor = :autor")
    , @NamedQuery(name = "Rastreo.findByFuentenom", query = "SELECT r FROM Rastreo r WHERE r.fuentenom = :fuentenom")
    , @NamedQuery(name = "Rastreo.findByRefnombreg", query = "SELECT r FROM Rastreo r WHERE r.refnombreg = :refnombreg")
    , @NamedQuery(name = "Rastreo.findByDisttax", query = "SELECT r FROM Rastreo r WHERE r.disttax = :disttax")
    , @NamedQuery(name = "Rastreo.findByDudatax", query = "SELECT r FROM Rastreo r WHERE r.dudatax = :dudatax")
    , @NamedQuery(name = "Rastreo.findByNomcomung", query = "SELECT r FROM Rastreo r WHERE r.nomcomung = :nomcomung")
    , @NamedQuery(name = "Rastreo.findByComtaxg", query = "SELECT r FROM Rastreo r WHERE r.comtaxg = :comtaxg")
    , @NamedQuery(name = "Rastreo.findByNombren", query = "SELECT r FROM Rastreo r WHERE r.nombren = :nombren")
    , @NamedQuery(name = "Rastreo.findByNumsinn", query = "SELECT r FROM Rastreo r WHERE r.numsinn = :numsinn")
    , @NamedQuery(name = "Rastreo.findByNomcomunn", query = "SELECT r FROM Rastreo r WHERE r.nomcomunn = :nomcomunn")
    , @NamedQuery(name = "Rastreo.findByComtaxn", query = "SELECT r FROM Rastreo r WHERE r.comtaxn = :comtaxn")
    , @NamedQuery(name = "Rastreo.findByRangog", query = "SELECT r FROM Rastreo r WHERE r.rangog = :rangog")
    , @NamedQuery(name = "Rastreo.findByFecharevrg", query = "SELECT r FROM Rastreo r WHERE r.fecharevrg = :fecharevrg")
    , @NamedQuery(name = "Rastreo.findByFormularg", query = "SELECT r FROM Rastreo r WHERE r.formularg = :formularg")
    , @NamedQuery(name = "Rastreo.findByResprg", query = "SELECT r FROM Rastreo r WHERE r.resprg = :resprg")
    , @NamedQuery(name = "Rastreo.findByAepeu", query = "SELECT r FROM Rastreo r WHERE r.aepeu = :aepeu")
    , @NamedQuery(name = "Rastreo.findByFechaaepeu", query = "SELECT r FROM Rastreo r WHERE r.fechaaepeu = :fechaaepeu")
    , @NamedQuery(name = "Rastreo.findByCites", query = "SELECT r FROM Rastreo r WHERE r.cites = :cites")
    , @NamedQuery(name = "Rastreo.findByIucn", query = "SELECT r FROM Rastreo r WHERE r.iucn = :iucn")
    , @NamedQuery(name = "Rastreo.findByPlanscons", query = "SELECT r FROM Rastreo r WHERE r.planscons = :planscons")
    , @NamedQuery(name = "Rastreo.findByResplan", query = "SELECT r FROM Rastreo r WHERE r.resplan = :resplan")
    , @NamedQuery(name = "Rastreo.findByResumenman", query = "SELECT r FROM Rastreo r WHERE r.resumenman = :resumenman")
    , @NamedQuery(name = "Rastreo.findByResresumen", query = "SELECT r FROM Rastreo r WHERE r.resresumen = :resresumen")
    , @NamedQuery(name = "Rastreo.findByExsitu", query = "SELECT r FROM Rastreo r WHERE r.exsitu = :exsitu")
    , @NamedQuery(name = "Rastreo.findByInstexsitu", query = "SELECT r FROM Rastreo r WHERE r.instexsitu = :instexsitu")
    , @NamedQuery(name = "Rastreo.findByEndemismo", query = "SELECT r FROM Rastreo r WHERE r.endemismo = :endemismo")
    , @NamedQuery(name = "Rastreo.findByRangon", query = "SELECT r FROM Rastreo r WHERE r.rangon = :rangon")
    , @NamedQuery(name = "Rastreo.findByFecharevrn", query = "SELECT r FROM Rastreo r WHERE r.fecharevrn = :fecharevrn")
    , @NamedQuery(name = "Rastreo.findByFormularn", query = "SELECT r FROM Rastreo r WHERE r.formularn = :formularn")
    , @NamedQuery(name = "Rastreo.findByRastreolen", query = "SELECT r FROM Rastreo r WHERE r.rastreolen = :rastreolen")
    , @NamedQuery(name = "Rastreo.findByLestimn", query = "SELECT r FROM Rastreo r WHERE r.lestimn = :lestimn")
    , @NamedQuery(name = "Rastreo.findByLeprotn", query = "SELECT r FROM Rastreo r WHERE r.leprotn = :leprotn")
    , @NamedQuery(name = "Rastreo.findByAbundn", query = "SELECT r FROM Rastreo r WHERE r.abundn = :abundn")
    , @NamedQuery(name = "Rastreo.findByProtnacion", query = "SELECT r FROM Rastreo r WHERE r.protnacion = :protnacion")
    , @NamedQuery(name = "Rastreo.findByRefnombren", query = "SELECT r FROM Rastreo r WHERE r.refnombren = :refnombren")
    , @NamedQuery(name = "Rastreo.findByTransparencian", query = "SELECT r FROM Rastreo r WHERE r.transparencian = :transparencian")
    , @NamedQuery(name = "Rastreo.findByRangos", query = "SELECT r FROM Rastreo r WHERE r.rangos = :rangos")
    , @NamedQuery(name = "Rastreo.findByFecharevrs", query = "SELECT r FROM Rastreo r WHERE r.fecharevrs = :fecharevrs")
    , @NamedQuery(name = "Rastreo.findByFormulars", query = "SELECT r FROM Rastreo r WHERE r.formulars = :formulars")
    , @NamedQuery(name = "Rastreo.findByRastreoles", query = "SELECT r FROM Rastreo r WHERE r.rastreoles = :rastreoles")
    , @NamedQuery(name = "Rastreo.findByLestims", query = "SELECT r FROM Rastreo r WHERE r.lestims = :lestims")
    , @NamedQuery(name = "Rastreo.findByLeprots", query = "SELECT r FROM Rastreo r WHERE r.leprots = :leprots")
    , @NamedQuery(name = "Rastreo.findByAbunds", query = "SELECT r FROM Rastreo r WHERE r.abunds = :abunds")
    , @NamedQuery(name = "Rastreo.findByProtsubnac", query = "SELECT r FROM Rastreo r WHERE r.protsubnac = :protsubnac")
    , @NamedQuery(name = "Rastreo.findByRefnombres", query = "SELECT r FROM Rastreo r WHERE r.refnombres = :refnombres")
    , @NamedQuery(name = "Rastreo.findByTransparencias", query = "SELECT r FROM Rastreo r WHERE r.transparencias = :transparencias")
    , @NamedQuery(name = "Rastreo.findByReopc1", query = "SELECT r FROM Rastreo r WHERE r.reopc1 = :reopc1")
    , @NamedQuery(name = "Rastreo.findByReopc2", query = "SELECT r FROM Rastreo r WHERE r.reopc2 = :reopc2")
    , @NamedQuery(name = "Rastreo.findByReopc3", query = "SELECT r FROM Rastreo r WHERE r.reopc3 = :reopc3")
    , @NamedQuery(name = "Rastreo.findByReopc4", query = "SELECT r FROM Rastreo r WHERE r.reopc4 = :reopc4")
    , @NamedQuery(name = "Rastreo.findByReopc5", query = "SELECT r FROM Rastreo r WHERE r.reopc5 = :reopc5")
    , @NamedQuery(name = "Rastreo.findByCodfuenten", query = "SELECT r FROM Rastreo r WHERE r.codfuenten = :codfuenten")
    , @NamedQuery(name = "Rastreo.findByCodfuentes", query = "SELECT r FROM Rastreo r WHERE r.codfuentes = :codfuentes")
    , @NamedQuery(name = "Rastreo.findByActualizag", query = "SELECT r FROM Rastreo r WHERE r.actualizag = :actualizag")
    , @NamedQuery(name = "Rastreo.findByActualizan", query = "SELECT r FROM Rastreo r WHERE r.actualizan = :actualizan")
    , @NamedQuery(name = "Rastreo.findByActualizas", query = "SELECT r FROM Rastreo r WHERE r.actualizas = :actualizas")})
public class Rastreo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rastreo_id")
    private Integer rastreoId;
    @Column(name = "codigoe")
    private String codigoe;
    @Column(name = "tropicos")
    private String tropicos;
    @Column(name = "nacion")
    private String nacion;
    @Column(name = "subnacion")
    private String subnacion;
    @Column(name = "clasetax")
    private String clasetax;
    @Column(name = "orden")
    private String orden;
    @Column(name = "familia")
    private String familia;
    @Column(name = "genero")
    private String genero;
    @Column(name = "autor")
    private String autor;
    @Column(name = "fuentenom")
    private Integer fuentenom;
    @Column(name = "refnombreg")
    private String refnombreg;
    @Column(name = "disttax")
    private String disttax;
    @Column(name = "dudatax")
    private String dudatax;
    @Column(name = "nomcomung")
    private String nomcomung;
    @Column(name = "comtaxg")
    private String comtaxg;
    @Column(name = "nombren")
    private String nombren;
    @Column(name = "numsinn")
    private Integer numsinn;
    @Column(name = "nomcomunn")
    private String nomcomunn;
    @Column(name = "comtaxn")
    private String comtaxn;
    @Column(name = "rangog")
    private String rangog;
    @Column(name = "fecharevrg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharevrg;
    @Column(name = "formularg")
    private String formularg;
    @Column(name = "resprg")
    private String resprg;
    @Column(name = "aepeu")
    private String aepeu;
    @Column(name = "fechaaepeu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaaepeu;
    @Column(name = "cites")
    private String cites;
    @Column(name = "iucn")
    private String iucn;
    @Column(name = "planscons")
    private String planscons;
    @Column(name = "resplan")
    private String resplan;
    @Column(name = "resumenman")
    private String resumenman;
    @Column(name = "resresumen")
    private String resresumen;
    @Column(name = "exsitu")
    private Boolean exsitu;
    @Column(name = "instexsitu")
    private String instexsitu;
    @Column(name = "endemismo")
    private String endemismo;
    @Column(name = "rangon")
    private String rangon;
    @Column(name = "fecharevrn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharevrn;
    @Column(name = "formularn")
    private String formularn;
    @Column(name = "rastreolen")
    private String rastreolen;
    @Column(name = "lestimn")
    private String lestimn;
    @Column(name = "leprotn")
    private String leprotn;
    @Column(name = "abundn")
    private String abundn;
    @Column(name = "protnacion")
    private String protnacion;
    @Column(name = "refnombren")
    private String refnombren;
    @Column(name = "transparencian")
    private Boolean transparencian;
    @Column(name = "rangos")
    private String rangos;
    @Column(name = "fecharevrs")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharevrs;
    @Column(name = "formulars")
    private String formulars;
    @Column(name = "rastreoles")
    private String rastreoles;
    @Column(name = "lestims")
    private String lestims;
    @Column(name = "leprots")
    private String leprots;
    @Column(name = "abunds")
    private String abunds;
    @Column(name = "protsubnac")
    private String protsubnac;
    @Column(name = "refnombres")
    private String refnombres;
    @Column(name = "transparencias")
    private Boolean transparencias;
    @Column(name = "reopc1")
    private String reopc1;
    @Column(name = "reopc2")
    private String reopc2;
    @Column(name = "reopc3")
    private String reopc3;
    @Column(name = "reopc4")
    private String reopc4;
    @Column(name = "reopc5")
    private String reopc5;
    @Column(name = "codfuenten")
    private String codfuenten;
    @Column(name = "codfuentes")
    private String codfuentes;
    @Column(name = "actualizag")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizag;
    @Column(name = "actualizan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizan;
    @Column(name = "actualizas")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizas;
    @OneToMany(mappedBy = "rASTREOrastreoid")
    private List<Fuente> fuenteList;
    @OneToMany(mappedBy = "rASTREOrastreoid")
    private List<Observaciones> observacionesList;
    @OneToMany(mappedBy = "rASTREOrastreoid")
    private List<Localizacion> localizacionList;
    @JoinColumn(name = "ELEMENTO_elemento_id", referencedColumnName = "elemento_id")
    @ManyToOne
    private Elemento eLEMENTOelementoid;

    public Rastreo() {
    }

    public Rastreo(Integer rastreoId) {
        this.rastreoId = rastreoId;
    }

    public Integer getRastreoId() {
        return rastreoId;
    }

    public void setRastreoId(Integer rastreoId) {
        this.rastreoId = rastreoId;
    }

    public String getCodigoe() {
        return codigoe;
    }

    public void setCodigoe(String codigoe) {
        this.codigoe = codigoe;
    }

    public String getTropicos() {
        return tropicos;
    }

    public void setTropicos(String tropicos) {
        this.tropicos = tropicos;
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

    public String getClasetax() {
        return clasetax;
    }

    public void setClasetax(String clasetax) {
        this.clasetax = clasetax;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getFuentenom() {
        return fuentenom;
    }

    public void setFuentenom(Integer fuentenom) {
        this.fuentenom = fuentenom;
    }

    public String getRefnombreg() {
        return refnombreg;
    }

    public void setRefnombreg(String refnombreg) {
        this.refnombreg = refnombreg;
    }

    public String getDisttax() {
        return disttax;
    }

    public void setDisttax(String disttax) {
        this.disttax = disttax;
    }

    public String getDudatax() {
        return dudatax;
    }

    public void setDudatax(String dudatax) {
        this.dudatax = dudatax;
    }

    public String getNomcomung() {
        return nomcomung;
    }

    public void setNomcomung(String nomcomung) {
        this.nomcomung = nomcomung;
    }

    public String getComtaxg() {
        return comtaxg;
    }

    public void setComtaxg(String comtaxg) {
        this.comtaxg = comtaxg;
    }

    public String getNombren() {
        return nombren;
    }

    public void setNombren(String nombren) {
        this.nombren = nombren;
    }

    public Integer getNumsinn() {
        return numsinn;
    }

    public void setNumsinn(Integer numsinn) {
        this.numsinn = numsinn;
    }

    public String getNomcomunn() {
        return nomcomunn;
    }

    public void setNomcomunn(String nomcomunn) {
        this.nomcomunn = nomcomunn;
    }

    public String getComtaxn() {
        return comtaxn;
    }

    public void setComtaxn(String comtaxn) {
        this.comtaxn = comtaxn;
    }

    public String getRangog() {
        return rangog;
    }

    public void setRangog(String rangog) {
        this.rangog = rangog;
    }

    public Date getFecharevrg() {
        return fecharevrg;
    }

    public void setFecharevrg(Date fecharevrg) {
        this.fecharevrg = fecharevrg;
    }

    public String getFormularg() {
        return formularg;
    }

    public void setFormularg(String formularg) {
        this.formularg = formularg;
    }

    public String getResprg() {
        return resprg;
    }

    public void setResprg(String resprg) {
        this.resprg = resprg;
    }

    public String getAepeu() {
        return aepeu;
    }

    public void setAepeu(String aepeu) {
        this.aepeu = aepeu;
    }

    public Date getFechaaepeu() {
        return fechaaepeu;
    }

    public void setFechaaepeu(Date fechaaepeu) {
        this.fechaaepeu = fechaaepeu;
    }

    public String getCites() {
        return cites;
    }

    public void setCites(String cites) {
        this.cites = cites;
    }

    public String getIucn() {
        return iucn;
    }

    public void setIucn(String iucn) {
        this.iucn = iucn;
    }

    public String getPlanscons() {
        return planscons;
    }

    public void setPlanscons(String planscons) {
        this.planscons = planscons;
    }

    public String getResplan() {
        return resplan;
    }

    public void setResplan(String resplan) {
        this.resplan = resplan;
    }

    public String getResumenman() {
        return resumenman;
    }

    public void setResumenman(String resumenman) {
        this.resumenman = resumenman;
    }

    public String getResresumen() {
        return resresumen;
    }

    public void setResresumen(String resresumen) {
        this.resresumen = resresumen;
    }

    public Boolean getExsitu() {
        return exsitu;
    }

    public void setExsitu(Boolean exsitu) {
        this.exsitu = exsitu;
    }

    public String getInstexsitu() {
        return instexsitu;
    }

    public void setInstexsitu(String instexsitu) {
        this.instexsitu = instexsitu;
    }

    public String getEndemismo() {
        return endemismo;
    }

    public void setEndemismo(String endemismo) {
        this.endemismo = endemismo;
    }

    public String getRangon() {
        return rangon;
    }

    public void setRangon(String rangon) {
        this.rangon = rangon;
    }

    public Date getFecharevrn() {
        return fecharevrn;
    }

    public void setFecharevrn(Date fecharevrn) {
        this.fecharevrn = fecharevrn;
    }

    public String getFormularn() {
        return formularn;
    }

    public void setFormularn(String formularn) {
        this.formularn = formularn;
    }

    public String getRastreolen() {
        return rastreolen;
    }

    public void setRastreolen(String rastreolen) {
        this.rastreolen = rastreolen;
    }

    public String getLestimn() {
        return lestimn;
    }

    public void setLestimn(String lestimn) {
        this.lestimn = lestimn;
    }

    public String getLeprotn() {
        return leprotn;
    }

    public void setLeprotn(String leprotn) {
        this.leprotn = leprotn;
    }

    public String getAbundn() {
        return abundn;
    }

    public void setAbundn(String abundn) {
        this.abundn = abundn;
    }

    public String getProtnacion() {
        return protnacion;
    }

    public void setProtnacion(String protnacion) {
        this.protnacion = protnacion;
    }

    public String getRefnombren() {
        return refnombren;
    }

    public void setRefnombren(String refnombren) {
        this.refnombren = refnombren;
    }

    public Boolean getTransparencian() {
        return transparencian;
    }

    public void setTransparencian(Boolean transparencian) {
        this.transparencian = transparencian;
    }

    public String getRangos() {
        return rangos;
    }

    public void setRangos(String rangos) {
        this.rangos = rangos;
    }

    public Date getFecharevrs() {
        return fecharevrs;
    }

    public void setFecharevrs(Date fecharevrs) {
        this.fecharevrs = fecharevrs;
    }

    public String getFormulars() {
        return formulars;
    }

    public void setFormulars(String formulars) {
        this.formulars = formulars;
    }

    public String getRastreoles() {
        return rastreoles;
    }

    public void setRastreoles(String rastreoles) {
        this.rastreoles = rastreoles;
    }

    public String getLestims() {
        return lestims;
    }

    public void setLestims(String lestims) {
        this.lestims = lestims;
    }

    public String getLeprots() {
        return leprots;
    }

    public void setLeprots(String leprots) {
        this.leprots = leprots;
    }

    public String getAbunds() {
        return abunds;
    }

    public void setAbunds(String abunds) {
        this.abunds = abunds;
    }

    public String getProtsubnac() {
        return protsubnac;
    }

    public void setProtsubnac(String protsubnac) {
        this.protsubnac = protsubnac;
    }

    public String getRefnombres() {
        return refnombres;
    }

    public void setRefnombres(String refnombres) {
        this.refnombres = refnombres;
    }

    public Boolean getTransparencias() {
        return transparencias;
    }

    public void setTransparencias(Boolean transparencias) {
        this.transparencias = transparencias;
    }

    public String getReopc1() {
        return reopc1;
    }

    public void setReopc1(String reopc1) {
        this.reopc1 = reopc1;
    }

    public String getReopc2() {
        return reopc2;
    }

    public void setReopc2(String reopc2) {
        this.reopc2 = reopc2;
    }

    public String getReopc3() {
        return reopc3;
    }

    public void setReopc3(String reopc3) {
        this.reopc3 = reopc3;
    }

    public String getReopc4() {
        return reopc4;
    }

    public void setReopc4(String reopc4) {
        this.reopc4 = reopc4;
    }

    public String getReopc5() {
        return reopc5;
    }

    public void setReopc5(String reopc5) {
        this.reopc5 = reopc5;
    }

    public String getCodfuenten() {
        return codfuenten;
    }

    public void setCodfuenten(String codfuenten) {
        this.codfuenten = codfuenten;
    }

    public String getCodfuentes() {
        return codfuentes;
    }

    public void setCodfuentes(String codfuentes) {
        this.codfuentes = codfuentes;
    }

    public Date getActualizag() {
        return actualizag;
    }

    public void setActualizag(Date actualizag) {
        this.actualizag = actualizag;
    }

    public Date getActualizan() {
        return actualizan;
    }

    public void setActualizan(Date actualizan) {
        this.actualizan = actualizan;
    }

    public Date getActualizas() {
        return actualizas;
    }

    public void setActualizas(Date actualizas) {
        this.actualizas = actualizas;
    }

    @XmlTransient
    public List<Fuente> getFuenteList() {
        return fuenteList;
    }

    public void setFuenteList(List<Fuente> fuenteList) {
        this.fuenteList = fuenteList;
    }

    @XmlTransient
    public List<Observaciones> getObservacionesList() {
        return observacionesList;
    }

    public void setObservacionesList(List<Observaciones> observacionesList) {
        this.observacionesList = observacionesList;
    }

    @XmlTransient
    public List<Localizacion> getLocalizacionList() {
        return localizacionList;
    }

    public void setLocalizacionList(List<Localizacion> localizacionList) {
        this.localizacionList = localizacionList;
    }

    public Elemento getELEMENTOelementoid() {
        return eLEMENTOelementoid;
    }

    public void setELEMENTOelementoid(Elemento eLEMENTOelementoid) {
        this.eLEMENTOelementoid = eLEMENTOelementoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rastreoId != null ? rastreoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rastreo)) {
            return false;
        }
        Rastreo other = (Rastreo) object;
        if ((this.rastreoId == null && other.rastreoId != null) || (this.rastreoId != null && !this.rastreoId.equals(other.rastreoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Rastreo[ rastreoId=" + rastreoId + " ]";
    }
    
}
