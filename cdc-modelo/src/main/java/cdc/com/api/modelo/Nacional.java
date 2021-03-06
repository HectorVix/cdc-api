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
@Table(name = "nacional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nacional.findAll", query = "SELECT n FROM Nacional n")
    , @NamedQuery(name = "Nacional.findByNacionalId", query = "SELECT n FROM Nacional n WHERE n.nacionalId = :nacionalId")
    , @NamedQuery(name = "Nacional.findByCodigoe", query = "SELECT n FROM Nacional n WHERE n.codigoe = :codigoe")
    , @NamedQuery(name = "Nacional.findByNombren", query = "SELECT n FROM Nacional n WHERE n.nombren = :nombren")
    , @NamedQuery(name = "Nacional.findByNacion", query = "SELECT n FROM Nacional n WHERE n.nacion = :nacion")
    , @NamedQuery(name = "Nacional.findByNloctip", query = "SELECT n FROM Nacional n WHERE n.nloctip = :nloctip")
    , @NamedQuery(name = "Nacional.findByNlestim", query = "SELECT n FROM Nacional n WHERE n.nlestim = :nlestim")
    , @NamedQuery(name = "Nacional.findByNlestimcom", query = "SELECT n FROM Nacional n WHERE n.nlestimcom = :nlestimcom")
    , @NamedQuery(name = "Nacional.findByNabund", query = "SELECT n FROM Nacional n WHERE n.nabund = :nabund")
    , @NamedQuery(name = "Nacional.findByNabundcom", query = "SELECT n FROM Nacional n WHERE n.nabundcom = :nabundcom")
    , @NamedQuery(name = "Nacional.findByNdist", query = "SELECT n FROM Nacional n WHERE n.ndist = :ndist")
    , @NamedQuery(name = "Nacional.findByNdistcom", query = "SELECT n FROM Nacional n WHERE n.ndistcom = :ndistcom")
    , @NamedQuery(name = "Nacional.findByNleprot", query = "SELECT n FROM Nacional n WHERE n.nleprot = :nleprot")
    , @NamedQuery(name = "Nacional.findByNleprotcom", query = "SELECT n FROM Nacional n WHERE n.nleprotcom = :nleprotcom")
    , @NamedQuery(name = "Nacional.findByNamenaz", query = "SELECT n FROM Nacional n WHERE n.namenaz = :namenaz")
    , @NamedQuery(name = "Nacional.findByNamenazcom", query = "SELECT n FROM Nacional n WHERE n.namenazcom = :namenazcom")
    , @NamedQuery(name = "Nacional.findByNotroconsi", query = "SELECT n FROM Nacional n WHERE n.notroconsi = :notroconsi")
    , @NamedQuery(name = "Nacional.findByRangon", query = "SELECT n FROM Nacional n WHERE n.rangon = :rangon")
    , @NamedQuery(name = "Nacional.findByFecharn", query = "SELECT n FROM Nacional n WHERE n.fecharn = :fecharn")
    , @NamedQuery(name = "Nacional.findByNranrzon", query = "SELECT n FROM Nacional n WHERE n.nranrzon = :nranrzon")
    , @NamedQuery(name = "Nacional.findByNnecprotec", query = "SELECT n FROM Nacional n WHERE n.nnecprotec = :nnecprotec")
    , @NamedQuery(name = "Nacional.findByNnecinvent", query = "SELECT n FROM Nacional n WHERE n.nnecinvent = :nnecinvent")
    , @NamedQuery(name = "Nacional.findByNnecestudi", query = "SELECT n FROM Nacional n WHERE n.nnecestudi = :nnecestudi")
    , @NamedQuery(name = "Nacional.findByNnecmaejo", query = "SELECT n FROM Nacional n WHERE n.nnecmaejo = :nnecmaejo")
    , @NamedQuery(name = "Nacional.findByResrn", query = "SELECT n FROM Nacional n WHERE n.resrn = :resrn")
    , @NamedQuery(name = "Nacional.findByEdautor", query = "SELECT n FROM Nacional n WHERE n.edautor = :edautor")
    , @NamedQuery(name = "Nacional.findByEdicion", query = "SELECT n FROM Nacional n WHERE n.edicion = :edicion")
    , @NamedQuery(name = "Nacional.findByActualizar", query = "SELECT n FROM Nacional n WHERE n.actualizar = :actualizar")})
public class Nacional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nacional_id")
    private Integer nacionalId;
    @Column(name = "codigoe")
    private String codigoe;
    @Column(name = "nombren")
    private String nombren;
    @Column(name = "nacion")
    private String nacion;
    @Column(name = "nloctip")
    private String nloctip;
    @Column(name = "nlestim")
    private String nlestim;
    @Column(name = "nlestimcom")
    private String nlestimcom;
    @Column(name = "nabund")
    private String nabund;
    @Column(name = "nabundcom")
    private String nabundcom;
    @Column(name = "ndist")
    private String ndist;
    @Column(name = "ndistcom")
    private String ndistcom;
    @Column(name = "nleprot")
    private String nleprot;
    @Column(name = "nleprotcom")
    private String nleprotcom;
    @Column(name = "namenaz")
    private String namenaz;
    @Column(name = "namenazcom")
    private String namenazcom;
    @Column(name = "notroconsi")
    private String notroconsi;
    @Column(name = "rangon")
    private String rangon;
    @Column(name = "fecharn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharn;
    @Column(name = "nranrzon")
    private String nranrzon;
    @Column(name = "nnecprotec")
    private String nnecprotec;
    @Column(name = "nnecinvent")
    private String nnecinvent;
    @Column(name = "nnecestudi")
    private String nnecestudi;
    @Column(name = "nnecmaejo")
    private String nnecmaejo;
    @Column(name = "resrn")
    private String resrn;
    @Column(name = "edautor")
    private String edautor;
    @Column(name = "edicion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date edicion;
    @Column(name = "actualizar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizar;
    @JoinColumn(name = "ELEMENTO_elemento_id", referencedColumnName = "elemento_id")
    @ManyToOne
    private Elemento eLEMENTOelementoid;

    public Nacional() {
    }

    public Nacional(Integer nacionalId) {
        this.nacionalId = nacionalId;
    }

    public Integer getNacionalId() {
        return nacionalId;
    }

    public void setNacionalId(Integer nacionalId) {
        this.nacionalId = nacionalId;
    }

    public String getCodigoe() {
        return codigoe;
    }

    public void setCodigoe(String codigoe) {
        this.codigoe = codigoe;
    }

    public String getNombren() {
        return nombren;
    }

    public void setNombren(String nombren) {
        this.nombren = nombren;
    }

    public String getNacion() {
        return nacion;
    }

    public void setNacion(String nacion) {
        this.nacion = nacion;
    }

    public String getNloctip() {
        return nloctip;
    }

    public void setNloctip(String nloctip) {
        this.nloctip = nloctip;
    }

    public String getNlestim() {
        return nlestim;
    }

    public void setNlestim(String nlestim) {
        this.nlestim = nlestim;
    }

    public String getNlestimcom() {
        return nlestimcom;
    }

    public void setNlestimcom(String nlestimcom) {
        this.nlestimcom = nlestimcom;
    }

    public String getNabund() {
        return nabund;
    }

    public void setNabund(String nabund) {
        this.nabund = nabund;
    }

    public String getNabundcom() {
        return nabundcom;
    }

    public void setNabundcom(String nabundcom) {
        this.nabundcom = nabundcom;
    }

    public String getNdist() {
        return ndist;
    }

    public void setNdist(String ndist) {
        this.ndist = ndist;
    }

    public String getNdistcom() {
        return ndistcom;
    }

    public void setNdistcom(String ndistcom) {
        this.ndistcom = ndistcom;
    }

    public String getNleprot() {
        return nleprot;
    }

    public void setNleprot(String nleprot) {
        this.nleprot = nleprot;
    }

    public String getNleprotcom() {
        return nleprotcom;
    }

    public void setNleprotcom(String nleprotcom) {
        this.nleprotcom = nleprotcom;
    }

    public String getNamenaz() {
        return namenaz;
    }

    public void setNamenaz(String namenaz) {
        this.namenaz = namenaz;
    }

    public String getNamenazcom() {
        return namenazcom;
    }

    public void setNamenazcom(String namenazcom) {
        this.namenazcom = namenazcom;
    }

    public String getNotroconsi() {
        return notroconsi;
    }

    public void setNotroconsi(String notroconsi) {
        this.notroconsi = notroconsi;
    }

    public String getRangon() {
        return rangon;
    }

    public void setRangon(String rangon) {
        this.rangon = rangon;
    }

    public Date getFecharn() {
        return fecharn;
    }

    public void setFecharn(Date fecharn) {
        this.fecharn = fecharn;
    }

    public String getNranrzon() {
        return nranrzon;
    }

    public void setNranrzon(String nranrzon) {
        this.nranrzon = nranrzon;
    }

    public String getNnecprotec() {
        return nnecprotec;
    }

    public void setNnecprotec(String nnecprotec) {
        this.nnecprotec = nnecprotec;
    }

    public String getNnecinvent() {
        return nnecinvent;
    }

    public void setNnecinvent(String nnecinvent) {
        this.nnecinvent = nnecinvent;
    }

    public String getNnecestudi() {
        return nnecestudi;
    }

    public void setNnecestudi(String nnecestudi) {
        this.nnecestudi = nnecestudi;
    }

    public String getNnecmaejo() {
        return nnecmaejo;
    }

    public void setNnecmaejo(String nnecmaejo) {
        this.nnecmaejo = nnecmaejo;
    }

    public String getResrn() {
        return resrn;
    }

    public void setResrn(String resrn) {
        this.resrn = resrn;
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

    public Elemento getELEMENTOelementoid() {
        return eLEMENTOelementoid;
    }

    public void setELEMENTOelementoid(Elemento eLEMENTOelementoid) {
        this.eLEMENTOelementoid = eLEMENTOelementoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nacionalId != null ? nacionalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nacional)) {
            return false;
        }
        Nacional other = (Nacional) object;
        if ((this.nacionalId == null && other.nacionalId != null) || (this.nacionalId != null && !this.nacionalId.equals(other.nacionalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Nacional[ nacionalId=" + nacionalId + " ]";
    }
    
}
