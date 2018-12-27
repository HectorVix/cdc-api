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
@Table(name = "vertebrado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vertebrado.findAll", query = "SELECT v FROM Vertebrado v")
    , @NamedQuery(name = "Vertebrado.findByVertebradoId", query = "SELECT v FROM Vertebrado v WHERE v.vertebradoId = :vertebradoId")
    , @NamedQuery(name = "Vertebrado.findByCodigoe", query = "SELECT v FROM Vertebrado v WHERE v.codigoe = :codigoe")})
public class Vertebrado implements Serializable {

    @OneToMany(mappedBy = "vERTEBRADOvertebradoid")
    private List<Distribucion2> distribucion2List;

    @Column(name = "nenea")
    private String nenea;
    @Column(name = "nabra")
    private String nabra;
    @Column(name = "njula")
    private String njula;
    @Column(name = "nocta")
    private String nocta;
    @Column(name = "neneb")
    private String neneb;
    @Column(name = "nabrb")
    private String nabrb;
    @Column(name = "njulb")
    private String njulb;
    @Column(name = "noctb")
    private String noctb;
    @Column(name = "nfeba")
    private String nfeba;
    @Column(name = "nmaya")
    private String nmaya;
    @Column(name = "nagoa")
    private String nagoa;
    @Column(name = "nnova")
    private String nnova;
    @Column(name = "nfebb")
    private String nfebb;
    @Column(name = "nmayb")
    private String nmayb;
    @Column(name = "nagob")
    private String nagob;
    @Column(name = "nnovb")
    private String nnovb;
    @Column(name = "nmara")
    private String nmara;
    @Column(name = "njuna")
    private String njuna;
    @Column(name = "nseta")
    private String nseta;
    @Column(name = "ndica")
    private String ndica;
    @Column(name = "nmarb")
    private String nmarb;
    @Column(name = "njunb")
    private String njunb;
    @Column(name = "nsetb")
    private String nsetb;
    @Column(name = "ndicb")
    private String ndicb;

    @Column(name = "elevminn")
    private Integer elevminn;
    @Column(name = "elevmaxn")
    private Integer elevmaxn;
    @Column(name = "longitud")
    private Integer longitud;
    @Column(name = "peso")
    private Integer peso;

    @Column(name = "nacion")
    private String nacion;
    @Column(name = "nombreg")
    private String nombreg;
    @Column(name = "autor")
    private String autor;
    @Column(name = "nombren")
    private String nombren;
    @Column(name = "nomcomunn")
    private String nomcomunn;
    @Column(name = "clasetax")
    private String clasetax;
    @Column(name = "orden")
    private String orden;
    @Column(name = "familia")
    private String familia;
    @Column(name = "genero")
    private String genero;
    @Column(name = "comtaxg")
    private String comtaxg;
    @Column(name = "comsubespn")
    private String comsubespn;
    @Column(name = "rangog")
    private String rangog;
    @Column(name = "cites")
    private String cites;
    @Column(name = "uicn")
    private String uicn;
    @Column(name = "aepeu")
    private String aepeu;
    @Column(name = "fechaaepeu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaaepeu;
    @Column(name = "endemismo")
    private String endemismo;
    @Column(name = "comstatg")
    private String comstatg;
    @Column(name = "rangon")
    private String rangon;
    @Column(name = "protnacion")
    private String protnacion;
    @Column(name = "rastreolen")
    private String rastreolen;
    @Column(name = "espdeportn")
    private String espdeportn;
    @Column(name = "espcomern")
    private String espcomern;
    @Column(name = "pezdeport")
    private String pezdeport;
    @Column(name = "ndeportpro")
    private String ndeportpro;
    @Column(name = "cazapieln")
    private String cazapieln;
    @Column(name = "pesten")
    private String pesten;
    @Column(name = "comstatn")
    private String comstatn;
    @Column(name = "comdistg")
    private String comdistg;
    @Column(name = "comdistn")
    private String comdistn;
    @Column(name = "residente")
    private String residente;
    @Column(name = "miglocal")
    private String miglocal;
    @Column(name = "migdist")
    private String migdist;
    @Column(name = "repn")
    private String repn;
    @Column(name = "norepn")
    private String norepn;
    @Column(name = "transmign")
    private String transmign;
    @Column(name = "aparirregn")
    private String aparirregn;
    @Column(name = "mign")
    private String mign;
    @Column(name = "commigg")
    private String commigg;
    @Column(name = "commign")
    private String commign;
    @Column(name = "marino")
    private String marino;
    @Column(name = "estuarino")
    private String estuarino;
    @Column(name = "fluvial")
    private String fluvial;
    @Column(name = "lacustre")
    private String lacustre;
    @Column(name = "palustre")
    private String palustre;
    @Column(name = "terrestre")
    private String terrestre;
    @Column(name = "subterran")
    private String subterran;
    @Column(name = "factorespe")
    private String factorespe;
    @Column(name = "comhabg")
    private String comhabg;
    @Column(name = "comhabrep")
    private String comhabrep;
    @Column(name = "comhabn")
    private String comhabn;
    @Column(name = "habitosalim")
    private String habitosalim;
    @Column(name = "comalimg")
    private String comalimg;
    @Column(name = "comalimn")
    private String comalimn;
    @Column(name = "comecolg")
    private String comecolg;
    @Column(name = "comecoln")
    private String comecoln;
    @Column(name = "fenologia")
    private String fenologia;
    @Column(name = "comfenolg")
    private String comfenolg;
    @Column(name = "comfenoln")
    private String comfenoln;
    @Column(name = "colrep")
    private String colrep;
    @Column(name = "comrepg")
    private String comrepg;
    @Column(name = "comrepn")
    private String comrepn;
    @Column(name = "commanejog")
    private String commanejog;
    @Column(name = "commanejon")
    private String commanejon;
    @Column(name = "usoeconom")
    private String usoeconom;
    @Column(name = "rcvnopc1")
    private String rcvnopc1;
    @Column(name = "rcvnopc2")
    private String rcvnopc2;
    @Column(name = "rcvnopc3")
    private String rcvnopc3;
    @Column(name = "rcvnopc4")
    private String rcvnopc4;
    @Column(name = "rcvnopc5")
    private String rcvnopc5;
    @Column(name = "refg")
    private String refg;
    @Column(name = "refn")
    private String refn;
    @Column(name = "ediciong")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ediciong;
    @Column(name = "actualizag")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizag;
    @Column(name = "edicionn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date edicionn;
    @Column(name = "actualizan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizan;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vertebrado_id")
    private Integer vertebradoId;
    @Column(name = "codigoe")
    private String codigoe;
    @JoinColumn(name = "CARACTERIZACION_caracterizacion_id", referencedColumnName = "caracterizacion_id")
    @ManyToOne
    private Caracterizacion cARACTERIZACIONcaracterizacionid;
    @OneToMany(mappedBy = "vERTEBRADOvertebradoid")
    private List<Foto> fotoList;
    @OneToMany(mappedBy = "vERTEBRADOvertebradoid")
    private List<Distribucion> distribucionList;

    public Vertebrado() {
    }

    public Vertebrado(Integer vertebradoId) {
        this.vertebradoId = vertebradoId;
    }

    public Integer getVertebradoId() {
        return vertebradoId;
    }

    public void setVertebradoId(Integer vertebradoId) {
        this.vertebradoId = vertebradoId;
    }

    public String getCodigoe() {
        return codigoe;
    }

    public void setCodigoe(String codigoe) {
        this.codigoe = codigoe;
    }

    public Caracterizacion getCARACTERIZACIONcaracterizacionid() {
        return cARACTERIZACIONcaracterizacionid;
    }

    public void setCARACTERIZACIONcaracterizacionid(Caracterizacion cARACTERIZACIONcaracterizacionid) {
        this.cARACTERIZACIONcaracterizacionid = cARACTERIZACIONcaracterizacionid;
    }

    @XmlTransient
    public List<Foto> getFotoList() {
        return fotoList;
    }

    public void setFotoList(List<Foto> fotoList) {
        this.fotoList = fotoList;
    }

    @XmlTransient
    public List<Distribucion> getDistribucionList() {
        return distribucionList;
    }

    public void setDistribucionList(List<Distribucion> distribucionList) {
        this.distribucionList = distribucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vertebradoId != null ? vertebradoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vertebrado)) {
            return false;
        }
        Vertebrado other = (Vertebrado) object;
        if ((this.vertebradoId == null && other.vertebradoId != null) || (this.vertebradoId != null && !this.vertebradoId.equals(other.vertebradoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Vertebrado[ vertebradoId=" + vertebradoId + " ]";
    }

    public String getNacion() {
        return nacion;
    }

    public void setNacion(String nacion) {
        this.nacion = nacion;
    }

    public String getNombreg() {
        return nombreg;
    }

    public void setNombreg(String nombreg) {
        this.nombreg = nombreg;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombren() {
        return nombren;
    }

    public void setNombren(String nombren) {
        this.nombren = nombren;
    }

    public String getNomcomunn() {
        return nomcomunn;
    }

    public void setNomcomunn(String nomcomunn) {
        this.nomcomunn = nomcomunn;
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

    public String getComtaxg() {
        return comtaxg;
    }

    public void setComtaxg(String comtaxg) {
        this.comtaxg = comtaxg;
    }

    public String getComsubespn() {
        return comsubespn;
    }

    public void setComsubespn(String comsubespn) {
        this.comsubespn = comsubespn;
    }

    public String getRangog() {
        return rangog;
    }

    public void setRangog(String rangog) {
        this.rangog = rangog;
    }

    public String getCites() {
        return cites;
    }

    public void setCites(String cites) {
        this.cites = cites;
    }

    public String getUicn() {
        return uicn;
    }

    public void setUicn(String uicn) {
        this.uicn = uicn;
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

    public String getEndemismo() {
        return endemismo;
    }

    public void setEndemismo(String endemismo) {
        this.endemismo = endemismo;
    }

    public String getComstatg() {
        return comstatg;
    }

    public void setComstatg(String comstatg) {
        this.comstatg = comstatg;
    }

    public String getRangon() {
        return rangon;
    }

    public void setRangon(String rangon) {
        this.rangon = rangon;
    }

    public String getProtnacion() {
        return protnacion;
    }

    public void setProtnacion(String protnacion) {
        this.protnacion = protnacion;
    }

    public String getRastreolen() {
        return rastreolen;
    }

    public void setRastreolen(String rastreolen) {
        this.rastreolen = rastreolen;
    }

    public String getEspdeportn() {
        return espdeportn;
    }

    public void setEspdeportn(String espdeportn) {
        this.espdeportn = espdeportn;
    }

    public String getEspcomern() {
        return espcomern;
    }

    public void setEspcomern(String espcomern) {
        this.espcomern = espcomern;
    }

    public String getPezdeport() {
        return pezdeport;
    }

    public void setPezdeport(String pezdeport) {
        this.pezdeport = pezdeport;
    }

    public String getNdeportpro() {
        return ndeportpro;
    }

    public void setNdeportpro(String ndeportpro) {
        this.ndeportpro = ndeportpro;
    }

    public String getCazapieln() {
        return cazapieln;
    }

    public void setCazapieln(String cazapieln) {
        this.cazapieln = cazapieln;
    }

    public String getPesten() {
        return pesten;
    }

    public void setPesten(String pesten) {
        this.pesten = pesten;
    }

    public String getComstatn() {
        return comstatn;
    }

    public void setComstatn(String comstatn) {
        this.comstatn = comstatn;
    }


    public String getComdistg() {
        return comdistg;
    }

    public void setComdistg(String comdistg) {
        this.comdistg = comdistg;
    }

    public String getComdistn() {
        return comdistn;
    }

    public void setComdistn(String comdistn) {
        this.comdistn = comdistn;
    }

    public String getResidente() {
        return residente;
    }

    public void setResidente(String residente) {
        this.residente = residente;
    }

    public String getMiglocal() {
        return miglocal;
    }

    public void setMiglocal(String miglocal) {
        this.miglocal = miglocal;
    }

    public String getMigdist() {
        return migdist;
    }

    public void setMigdist(String migdist) {
        this.migdist = migdist;
    }

    public String getRepn() {
        return repn;
    }

    public void setRepn(String repn) {
        this.repn = repn;
    }

    public String getNorepn() {
        return norepn;
    }

    public void setNorepn(String norepn) {
        this.norepn = norepn;
    }

    public String getTransmign() {
        return transmign;
    }

    public void setTransmign(String transmign) {
        this.transmign = transmign;
    }

    public String getAparirregn() {
        return aparirregn;
    }

    public void setAparirregn(String aparirregn) {
        this.aparirregn = aparirregn;
    }

    public String getMign() {
        return mign;
    }

    public void setMign(String mign) {
        this.mign = mign;
    }

    public String getCommigg() {
        return commigg;
    }

    public void setCommigg(String commigg) {
        this.commigg = commigg;
    }

    public String getCommign() {
        return commign;
    }

    public void setCommign(String commign) {
        this.commign = commign;
    }

    public String getMarino() {
        return marino;
    }

    public void setMarino(String marino) {
        this.marino = marino;
    }

    public String getEstuarino() {
        return estuarino;
    }

    public void setEstuarino(String estuarino) {
        this.estuarino = estuarino;
    }

    public String getFluvial() {
        return fluvial;
    }

    public void setFluvial(String fluvial) {
        this.fluvial = fluvial;
    }

    public String getLacustre() {
        return lacustre;
    }

    public void setLacustre(String lacustre) {
        this.lacustre = lacustre;
    }

    public String getPalustre() {
        return palustre;
    }

    public void setPalustre(String palustre) {
        this.palustre = palustre;
    }

    public String getTerrestre() {
        return terrestre;
    }

    public void setTerrestre(String terrestre) {
        this.terrestre = terrestre;
    }

    public String getSubterran() {
        return subterran;
    }

    public void setSubterran(String subterran) {
        this.subterran = subterran;
    }

    public String getFactorespe() {
        return factorespe;
    }

    public void setFactorespe(String factorespe) {
        this.factorespe = factorespe;
    }

    public String getComhabg() {
        return comhabg;
    }

    public void setComhabg(String comhabg) {
        this.comhabg = comhabg;
    }

    public String getComhabrep() {
        return comhabrep;
    }

    public void setComhabrep(String comhabrep) {
        this.comhabrep = comhabrep;
    }

    public String getComhabn() {
        return comhabn;
    }

    public void setComhabn(String comhabn) {
        this.comhabn = comhabn;
    }

    public String getHabitosalim() {
        return habitosalim;
    }

    public void setHabitosalim(String habitosalim) {
        this.habitosalim = habitosalim;
    }

    public String getComalimg() {
        return comalimg;
    }

    public void setComalimg(String comalimg) {
        this.comalimg = comalimg;
    }

    public String getComalimn() {
        return comalimn;
    }

    public void setComalimn(String comalimn) {
        this.comalimn = comalimn;
    }

    public String getComecolg() {
        return comecolg;
    }

    public void setComecolg(String comecolg) {
        this.comecolg = comecolg;
    }

    public String getComecoln() {
        return comecoln;
    }

    public void setComecoln(String comecoln) {
        this.comecoln = comecoln;
    }

    public String getFenologia() {
        return fenologia;
    }

    public void setFenologia(String fenologia) {
        this.fenologia = fenologia;
    }

    public String getComfenolg() {
        return comfenolg;
    }

    public void setComfenolg(String comfenolg) {
        this.comfenolg = comfenolg;
    }

    public String getComfenoln() {
        return comfenoln;
    }

    public void setComfenoln(String comfenoln) {
        this.comfenoln = comfenoln;
    }

    public String getColrep() {
        return colrep;
    }

    public void setColrep(String colrep) {
        this.colrep = colrep;
    }

    public String getComrepg() {
        return comrepg;
    }

    public void setComrepg(String comrepg) {
        this.comrepg = comrepg;
    }

    public String getComrepn() {
        return comrepn;
    }

    public void setComrepn(String comrepn) {
        this.comrepn = comrepn;
    }

    public String getCommanejog() {
        return commanejog;
    }

    public void setCommanejog(String commanejog) {
        this.commanejog = commanejog;
    }

    public String getCommanejon() {
        return commanejon;
    }

    public void setCommanejon(String commanejon) {
        this.commanejon = commanejon;
    }

    public String getUsoeconom() {
        return usoeconom;
    }

    public void setUsoeconom(String usoeconom) {
        this.usoeconom = usoeconom;
    }


    public String getRcvnopc1() {
        return rcvnopc1;
    }

    public void setRcvnopc1(String rcvnopc1) {
        this.rcvnopc1 = rcvnopc1;
    }

    public String getRcvnopc2() {
        return rcvnopc2;
    }

    public void setRcvnopc2(String rcvnopc2) {
        this.rcvnopc2 = rcvnopc2;
    }

    public String getRcvnopc3() {
        return rcvnopc3;
    }

    public void setRcvnopc3(String rcvnopc3) {
        this.rcvnopc3 = rcvnopc3;
    }

    public String getRcvnopc4() {
        return rcvnopc4;
    }

    public void setRcvnopc4(String rcvnopc4) {
        this.rcvnopc4 = rcvnopc4;
    }

    public String getRcvnopc5() {
        return rcvnopc5;
    }

    public void setRcvnopc5(String rcvnopc5) {
        this.rcvnopc5 = rcvnopc5;
    }

    public String getRefg() {
        return refg;
    }

    public void setRefg(String refg) {
        this.refg = refg;
    }

    public String getRefn() {
        return refn;
    }

    public void setRefn(String refn) {
        this.refn = refn;
    }

    public Date getEdiciong() {
        return ediciong;
    }

    public void setEdiciong(Date ediciong) {
        this.ediciong = ediciong;
    }

    public Date getActualizag() {
        return actualizag;
    }

    public void setActualizag(Date actualizag) {
        this.actualizag = actualizag;
    }

    public Date getEdicionn() {
        return edicionn;
    }

    public void setEdicionn(Date edicionn) {
        this.edicionn = edicionn;
    }

    public Date getActualizan() {
        return actualizan;
    }

    public void setActualizan(Date actualizan) {
        this.actualizan = actualizan;
    }

    public Integer getElevminn() {
        return elevminn;
    }

    public void setElevminn(Integer elevminn) {
        this.elevminn = elevminn;
    }

    public Integer getElevmaxn() {
        return elevmaxn;
    }

    public void setElevmaxn(Integer elevmaxn) {
        this.elevmaxn = elevmaxn;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getNenea() {
        return nenea;
    }

    public void setNenea(String nenea) {
        this.nenea = nenea;
    }

    public String getNabra() {
        return nabra;
    }

    public void setNabra(String nabra) {
        this.nabra = nabra;
    }

    public String getNjula() {
        return njula;
    }

    public void setNjula(String njula) {
        this.njula = njula;
    }

    public String getNocta() {
        return nocta;
    }

    public void setNocta(String nocta) {
        this.nocta = nocta;
    }

    public String getNeneb() {
        return neneb;
    }

    public void setNeneb(String neneb) {
        this.neneb = neneb;
    }

    public String getNabrb() {
        return nabrb;
    }

    public void setNabrb(String nabrb) {
        this.nabrb = nabrb;
    }

    public String getNjulb() {
        return njulb;
    }

    public void setNjulb(String njulb) {
        this.njulb = njulb;
    }

    public String getNoctb() {
        return noctb;
    }

    public void setNoctb(String noctb) {
        this.noctb = noctb;
    }

    public String getNfeba() {
        return nfeba;
    }

    public void setNfeba(String nfeba) {
        this.nfeba = nfeba;
    }

    public String getNmaya() {
        return nmaya;
    }

    public void setNmaya(String nmaya) {
        this.nmaya = nmaya;
    }

    public String getNagoa() {
        return nagoa;
    }

    public void setNagoa(String nagoa) {
        this.nagoa = nagoa;
    }

    public String getNnova() {
        return nnova;
    }

    public void setNnova(String nnova) {
        this.nnova = nnova;
    }

    public String getNfebb() {
        return nfebb;
    }

    public void setNfebb(String nfebb) {
        this.nfebb = nfebb;
    }

    public String getNmayb() {
        return nmayb;
    }

    public void setNmayb(String nmayb) {
        this.nmayb = nmayb;
    }

    public String getNagob() {
        return nagob;
    }

    public void setNagob(String nagob) {
        this.nagob = nagob;
    }

    public String getNnovb() {
        return nnovb;
    }

    public void setNnovb(String nnovb) {
        this.nnovb = nnovb;
    }

    public String getNmara() {
        return nmara;
    }

    public void setNmara(String nmara) {
        this.nmara = nmara;
    }

    public String getNjuna() {
        return njuna;
    }

    public void setNjuna(String njuna) {
        this.njuna = njuna;
    }

    public String getNseta() {
        return nseta;
    }

    public void setNseta(String nseta) {
        this.nseta = nseta;
    }

    public String getNdica() {
        return ndica;
    }

    public void setNdica(String ndica) {
        this.ndica = ndica;
    }

    public String getNmarb() {
        return nmarb;
    }

    public void setNmarb(String nmarb) {
        this.nmarb = nmarb;
    }

    public String getNjunb() {
        return njunb;
    }

    public void setNjunb(String njunb) {
        this.njunb = njunb;
    }

    public String getNsetb() {
        return nsetb;
    }

    public void setNsetb(String nsetb) {
        this.nsetb = nsetb;
    }

    public String getNdicb() {
        return ndicb;
    }

    public void setNdicb(String ndicb) {
        this.ndicb = ndicb;
    }

    @XmlTransient
    public List<Distribucion2> getDistribucion2List() {
        return distribucion2List;
    }

    public void setDistribucion2List(List<Distribucion2> distribucion2List) {
        this.distribucion2List = distribucion2List;
    }

}
