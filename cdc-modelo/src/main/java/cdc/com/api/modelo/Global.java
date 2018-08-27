/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Héctor Vix
 */
@Entity
@Table(name = "global")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Global.findAll", query = "SELECT g FROM Global g")
    , @NamedQuery(name = "Global.findByGloblalId", query = "SELECT g FROM Global g WHERE g.globlalId = :globlalId")})
public class Global implements Serializable {

    @Column(name = "codigoe")
    private String codigoe;
    @Column(name = "nombreg")
    private String nombreg;
    @Column(name = "descrielem")
    private String descrielem;
    @Column(name = "especle")
    private String especle;
    @Column(name = "especranga")
    private String especranga;
    @Column(name = "especrangb")
    private String especrangb;
    @Column(name = "especrangc")
    private String especrangc;
    @Column(name = "especrangd")
    private String especrangd;
    @Column(name = "habitat")
    private String habitat;
    @Column(name = "permanencia")
    private String permanencia;
    @Column(name = "gloctip")
    private String gloctip;
    @Column(name = "comtax")
    private String comtax;
    @Column(name = "glestim")
    private String glestim;
    @Column(name = "glestimcom")
    private String glestimcom;
    @Column(name = "gabund")
    private String gabund;
    @Column(name = "gabundcom")
    private String gabundcom;
    @Column(name = "gdist")
    private String gdist;
    @Column(name = "gdistcom")
    private String gdistcom;
    @Column(name = "gleprot")
    private String gleprot;
    @Column(name = "gleprotcom")
    private String gleprotcom;
    @Column(name = "gamenaz")
    private String gamenaz;
    @Column(name = "gamenazcom")
    private String gamenazcom;
    @Column(name = "gfragil")
    private String gfragil;
    @Column(name = "gfragilcom")
    private String gfragilcom;
    @Column(name = "gotroconsi")
    private String gotroconsi;
    @Column(name = "rangog")
    private String rangog;
    @Column(name = "fecharg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharg;
    @Column(name = "granrazon")
    private String granrazon;
    @Column(name = "gnecprotec")
    private String gnecprotec;
    @Column(name = "gnecinvent")
    private String gnecinvent;
    @Column(name = "gnecestudi")
    private String gnecestudi;
    @Column(name = "gnecmanejo")
    private String gnecmanejo;
    @Column(name = "resrg")
    private String resrg;
    @Column(name = "edautor")
    private String edautor;
    @Column(name = "edicion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date edicion;
    @Column(name = "actualizar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizar;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "globlal_id")
    private Integer globlalId;
    @JoinColumn(name = "JERARQUIZACION_jerarquizacion_id", referencedColumnName = "jerarquizacion_id")
    @ManyToOne
    private Jerarquizacion jERARQUIZACIONjerarquizacionid;

    public Global() {
    }

    public Global(Integer globlalId) {
        this.globlalId = globlalId;
    }

    public Integer getGloblalId() {
        return globlalId;
    }

    public void setGloblalId(Integer globlalId) {
        this.globlalId = globlalId;
    }

    public Jerarquizacion getJERARQUIZACIONjerarquizacionid() {
        return jERARQUIZACIONjerarquizacionid;
    }

    public void setJERARQUIZACIONjerarquizacionid(Jerarquizacion jERARQUIZACIONjerarquizacionid) {
        this.jERARQUIZACIONjerarquizacionid = jERARQUIZACIONjerarquizacionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (globlalId != null ? globlalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Global)) {
            return false;
        }
        Global other = (Global) object;
        if ((this.globlalId == null && other.globlalId != null) || (this.globlalId != null && !this.globlalId.equals(other.globlalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Global[ globlalId=" + globlalId + " ]";
    }

    public String getCodigoe() {
        return codigoe;
    }

    public void setCodigoe(String codigoe) {
        this.codigoe = codigoe;
    }

    public String getNombreg() {
        return nombreg;
    }

    public void setNombreg(String nombreg) {
        this.nombreg = nombreg;
    }

    public String getDescrielem() {
        return descrielem;
    }

    public void setDescrielem(String descrielem) {
        this.descrielem = descrielem;
    }

    public String getEspecle() {
        return especle;
    }

    public void setEspecle(String especle) {
        this.especle = especle;
    }

    public String getEspecranga() {
        return especranga;
    }

    public void setEspecranga(String especranga) {
        this.especranga = especranga;
    }

    public String getEspecrangb() {
        return especrangb;
    }

    public void setEspecrangb(String especrangb) {
        this.especrangb = especrangb;
    }

    public String getEspecrangc() {
        return especrangc;
    }

    public void setEspecrangc(String especrangc) {
        this.especrangc = especrangc;
    }

    public String getEspecrangd() {
        return especrangd;
    }

    public void setEspecrangd(String especrangd) {
        this.especrangd = especrangd;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getPermanencia() {
        return permanencia;
    }

    public void setPermanencia(String permanencia) {
        this.permanencia = permanencia;
    }

    public String getGloctip() {
        return gloctip;
    }

    public void setGloctip(String gloctip) {
        this.gloctip = gloctip;
    }

    public String getComtax() {
        return comtax;
    }

    public void setComtax(String comtax) {
        this.comtax = comtax;
    }

    public String getGlestim() {
        return glestim;
    }

    public void setGlestim(String glestim) {
        this.glestim = glestim;
    }

    public String getGlestimcom() {
        return glestimcom;
    }

    public void setGlestimcom(String glestimcom) {
        this.glestimcom = glestimcom;
    }

    public String getGabund() {
        return gabund;
    }

    public void setGabund(String gabund) {
        this.gabund = gabund;
    }

    public String getGabundcom() {
        return gabundcom;
    }

    public void setGabundcom(String gabundcom) {
        this.gabundcom = gabundcom;
    }

    public String getGdist() {
        return gdist;
    }

    public void setGdist(String gdist) {
        this.gdist = gdist;
    }

    public String getGdistcom() {
        return gdistcom;
    }

    public void setGdistcom(String gdistcom) {
        this.gdistcom = gdistcom;
    }

    public String getGleprot() {
        return gleprot;
    }

    public void setGleprot(String gleprot) {
        this.gleprot = gleprot;
    }

    public String getGleprotcom() {
        return gleprotcom;
    }

    public void setGleprotcom(String gleprotcom) {
        this.gleprotcom = gleprotcom;
    }

    public String getGamenaz() {
        return gamenaz;
    }

    public void setGamenaz(String gamenaz) {
        this.gamenaz = gamenaz;
    }

    public String getGamenazcom() {
        return gamenazcom;
    }

    public void setGamenazcom(String gamenazcom) {
        this.gamenazcom = gamenazcom;
    }

    public String getGfragil() {
        return gfragil;
    }

    public void setGfragil(String gfragil) {
        this.gfragil = gfragil;
    }

    public String getGfragilcom() {
        return gfragilcom;
    }

    public void setGfragilcom(String gfragilcom) {
        this.gfragilcom = gfragilcom;
    }

    public String getGotroconsi() {
        return gotroconsi;
    }

    public void setGotroconsi(String gotroconsi) {
        this.gotroconsi = gotroconsi;
    }

    public String getRangog() {
        return rangog;
    }

    public void setRangog(String rangog) {
        this.rangog = rangog;
    }

    public Date getFecharg() {
        return fecharg;
    }

    public void setFecharg(Date fecharg) {
        this.fecharg = fecharg;
    }

    public String getGranrazon() {
        return granrazon;
    }

    public void setGranrazon(String granrazon) {
        this.granrazon = granrazon;
    }

    public String getGnecprotec() {
        return gnecprotec;
    }

    public void setGnecprotec(String gnecprotec) {
        this.gnecprotec = gnecprotec;
    }

    public String getGnecinvent() {
        return gnecinvent;
    }

    public void setGnecinvent(String gnecinvent) {
        this.gnecinvent = gnecinvent;
    }

    public String getGnecestudi() {
        return gnecestudi;
    }

    public void setGnecestudi(String gnecestudi) {
        this.gnecestudi = gnecestudi;
    }

    public String getGnecmanejo() {
        return gnecmanejo;
    }

    public void setGnecmanejo(String gnecmanejo) {
        this.gnecmanejo = gnecmanejo;
    }

    public String getResrg() {
        return resrg;
    }

    public void setResrg(String resrg) {
        this.resrg = resrg;
    }

    public String getEdautor() {
        return edautor;
    }

    public void setEdautor(String edautor) {
        this.edautor = edautor;
    }

    public Date getEdicion() {
        return edicion;
    }

    public void setEdicion(Date edicion) {
        this.edicion = edicion;
    }

    public Date getActualizar() {
        return actualizar;
    }

    public void setActualizar(Date actualizar) {
        this.actualizar = actualizar;
    }
    
}
