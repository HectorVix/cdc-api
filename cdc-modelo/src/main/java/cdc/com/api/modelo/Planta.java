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
@Table(name = "planta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planta.findAll", query = "SELECT p FROM Planta p")
    , @NamedQuery(name = "Planta.findByPlantaId", query = "SELECT p FROM Planta p WHERE p.plantaId = :plantaId")
    , @NamedQuery(name = "Planta.findByCodigoe", query = "SELECT p FROM Planta p WHERE p.codigoe = :codigoe")})
public class Planta implements Serializable {

    @Column(name = "comfenoln")
    private String comfenoln;
    
    @Column(name = "comrepn")
    private String comrepn;
    @Column(name = "commanejon")
    private String commanejon;
    @Column(name = "rcpnopc1")
    private String rcpnopc1;
    @Column(name = "rcpnopc2")
    private String rcpnopc2;
    @Column(name = "rcpnopc3")
    private String rcpnopc3;
    @Column(name = "rcpnopc4")
    private String rcpnopc4;
    @Column(name = "rcpnopc5")
    private String rcpnopc5;
    @Column(name = "codfuente")
    private String codfuente;
    @Column(name = "cita")
    private String cita;
    @Column(name = "transparen")
    private String transparen;
    @Column(name = "refg")
    private String refg;
    @Column(name = "refn")
    private String refn;
    @Column(name = "edicionn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date edicionn;
    @Column(name = "autoredn")
    private String autoredn;
    @Column(name = "actualizan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizan;

    @Column(name = "marinon")
    private String marinon;
    @Column(name = "estuarinon")
    private String estuarinon;
    @Column(name = "fluvialn")
    private String fluvialn;
    @Column(name = "lacustren")
    private String lacustren;
    @Column(name = "palustren")
    private String palustren;
    @Column(name = "terrestren")
    private String terrestren;
    @Column(name = "comhabn")
    private String comhabn;
    @Column(name = "comecoln")
    private String comecoln;

    @Column(name = "priinventn")
    private String priinventn;
    @Column(name = "necinventn")
    private String necinventn;
    @Column(name = "cominventn")
    private String cominventn;
    @Column(name = "respropn")
    private String respropn;
    @Column(name = "elevminn")
    private Integer elevminn;
    @Column(name = "elevmaxn")
    private Integer elevmaxn;
    @Column(name = "disyuntn")
    private String disyuntn;
    @Column(name = "periferican")
    private String periferican;
    @Column(name = "comdistn")
    private String comdistn;

    @Column(name = "rangog")
    private String rangog;
    @Column(name = "rangon")
    private String rangon;
    @Column(name = "aepeu")
    private String aepeu;
    @Column(name = "cites")
    private String cites;
    @Column(name = "uicn")
    private String uicn;
    @Column(name = "rastreolen")
    private String rastreolen;
    @Column(name = "protnacion")
    private String protnacion;
    @Column(name = "malezan")
    private String malezan;
    @Column(name = "clasifinstn")
    private String clasifinstn;
    @Column(name = "comstatn")
    private String comstatn;

    @Column(name = "nacion")
    private String nacion;
    @Column(name = "nombren")
    private String nombren;
    @Column(name = "nomcomunn")
    private String nomcomunn;
    @Column(name = "comsubespn")
    private String comsubespn;
    @Column(name = "taxasimiln")
    private String taxasimiln;
    @Column(name = "comidentn")
    private String comidentn;
    @Column(name = "comtaxn")
    private String comtaxn;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "planta_id")
    private Integer plantaId;
    @Column(name = "codigoe")
    private String codigoe;
    @JoinColumn(name = "CARACTERIZACION_caracterizacion_id", referencedColumnName = "caracterizacion_id")
    @ManyToOne
    private Caracterizacion cARACTERIZACIONcaracterizacionid;
    @OneToMany(mappedBy = "pLANTAplantaid")
    private List<Foto> fotoList;
    @OneToMany(mappedBy = "pLANTAplantaid")
    private List<Distribucion> distribucionList;

    public Planta() {
    }

    public Planta(Integer plantaId) {
        this.plantaId = plantaId;
    }

    public Integer getPlantaId() {
        return plantaId;
    }

    public void setPlantaId(Integer plantaId) {
        this.plantaId = plantaId;
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
        hash += (plantaId != null ? plantaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planta)) {
            return false;
        }
        Planta other = (Planta) object;
        if ((this.plantaId == null && other.plantaId != null) || (this.plantaId != null && !this.plantaId.equals(other.plantaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Planta[ plantaId=" + plantaId + " ]";
    }

    public String getNacion() {
        return nacion;
    }

    public void setNacion(String nacion) {
        this.nacion = nacion;
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

    public String getComsubespn() {
        return comsubespn;
    }

    public void setComsubespn(String comsubespn) {
        this.comsubespn = comsubespn;
    }

    public String getTaxasimiln() {
        return taxasimiln;
    }

    public void setTaxasimiln(String taxasimiln) {
        this.taxasimiln = taxasimiln;
    }

    public String getComidentn() {
        return comidentn;
    }

    public void setComidentn(String comidentn) {
        this.comidentn = comidentn;
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

    public String getRangon() {
        return rangon;
    }

    public void setRangon(String rangon) {
        this.rangon = rangon;
    }

    public String getAepeu() {
        return aepeu;
    }

    public void setAepeu(String aepeu) {
        this.aepeu = aepeu;
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

    public String getRastreolen() {
        return rastreolen;
    }

    public void setRastreolen(String rastreolen) {
        this.rastreolen = rastreolen;
    }

    public String getProtnacion() {
        return protnacion;
    }

    public void setProtnacion(String protnacion) {
        this.protnacion = protnacion;
    }

    public String getMalezan() {
        return malezan;
    }

    public void setMalezan(String malezan) {
        this.malezan = malezan;
    }

    public String getClasifinstn() {
        return clasifinstn;
    }

    public void setClasifinstn(String clasifinstn) {
        this.clasifinstn = clasifinstn;
    }

    public String getComstatn() {
        return comstatn;
    }

    public void setComstatn(String comstatn) {
        this.comstatn = comstatn;
    }

    public String getPriinventn() {
        return priinventn;
    }

    public void setPriinventn(String priinventn) {
        this.priinventn = priinventn;
    }

    public String getNecinventn() {
        return necinventn;
    }

    public void setNecinventn(String necinventn) {
        this.necinventn = necinventn;
    }

    public String getCominventn() {
        return cominventn;
    }

    public void setCominventn(String cominventn) {
        this.cominventn = cominventn;
    }

    public String getRespropn() {
        return respropn;
    }

    public void setRespropn(String respropn) {
        this.respropn = respropn;
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

    public String getDisyuntn() {
        return disyuntn;
    }

    public void setDisyuntn(String disyuntn) {
        this.disyuntn = disyuntn;
    }

    public String getPeriferican() {
        return periferican;
    }

    public void setPeriferican(String periferican) {
        this.periferican = periferican;
    }

    public String getComdistn() {
        return comdistn;
    }

    public void setComdistn(String comdistn) {
        this.comdistn = comdistn;
    }

    public String getMarinon() {
        return marinon;
    }

    public void setMarinon(String marinon) {
        this.marinon = marinon;
    }

    public String getEstuarinon() {
        return estuarinon;
    }

    public void setEstuarinon(String estuarinon) {
        this.estuarinon = estuarinon;
    }

    public String getFluvialn() {
        return fluvialn;
    }

    public void setFluvialn(String fluvialn) {
        this.fluvialn = fluvialn;
    }

    public String getLacustren() {
        return lacustren;
    }

    public void setLacustren(String lacustren) {
        this.lacustren = lacustren;
    }

    public String getPalustren() {
        return palustren;
    }

    public void setPalustren(String palustren) {
        this.palustren = palustren;
    }

    public String getTerrestren() {
        return terrestren;
    }

    public void setTerrestren(String terrestren) {
        this.terrestren = terrestren;
    }

    public String getComhabn() {
        return comhabn;
    }

    public void setComhabn(String comhabn) {
        this.comhabn = comhabn;
    }

    public String getComecoln() {
        return comecoln;
    }

    public void setComecoln(String comecoln) {
        this.comecoln = comecoln;
    }

    public String getComfenoln() {
        return comfenoln;
    }

    public void setComfenoln(String comfenoln) {
        this.comfenoln = comfenoln;
    }

    public String getComrepn() {
        return comrepn;
    }

    public void setComrepn(String comrepn) {
        this.comrepn = comrepn;
    }

    public String getCommanejon() {
        return commanejon;
    }

    public void setCommanejon(String commanejon) {
        this.commanejon = commanejon;
    }

    public String getRcpnopc1() {
        return rcpnopc1;
    }

    public void setRcpnopc1(String rcpnopc1) {
        this.rcpnopc1 = rcpnopc1;
    }

    public String getRcpnopc2() {
        return rcpnopc2;
    }

    public void setRcpnopc2(String rcpnopc2) {
        this.rcpnopc2 = rcpnopc2;
    }

    public String getRcpnopc3() {
        return rcpnopc3;
    }

    public void setRcpnopc3(String rcpnopc3) {
        this.rcpnopc3 = rcpnopc3;
    }

    public String getRcpnopc4() {
        return rcpnopc4;
    }

    public void setRcpnopc4(String rcpnopc4) {
        this.rcpnopc4 = rcpnopc4;
    }

    public String getRcpnopc5() {
        return rcpnopc5;
    }

    public void setRcpnopc5(String rcpnopc5) {
        this.rcpnopc5 = rcpnopc5;
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

    public String getTransparen() {
        return transparen;
    }

    public void setTransparen(String transparen) {
        this.transparen = transparen;
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

    public Date getEdicionn() {
        return edicionn;
    }

    public void setEdicionn(Date edicionn) {
        this.edicionn = edicionn;
    }

    public String getAutoredn() {
        return autoredn;
    }

    public void setAutoredn(String autoredn) {
        this.autoredn = autoredn;
    }

    public Date getActualizan() {
        return actualizan;
    }

    public void setActualizan(Date actualizan) {
        this.actualizan = actualizan;
    }
    
}
