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
@Table(name = "subnacional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subnacional.findAll", query = "SELECT s FROM Subnacional s")
    , @NamedQuery(name = "Subnacional.findBySubnacionalId", query = "SELECT s FROM Subnacional s WHERE s.subnacionalId = :subnacionalId")})
public class Subnacional implements Serializable {

    @Column(name = "codigoe")
    private String codigoe;
    @Column(name = "nacion")
    private String nacion;
    @Column(name = "subnacion")
    private String subnacion;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "loctips")
    private String loctips;
    @Column(name = "lestims")
    private String lestims;
    @Column(name = "comlestims")
    private String comlestims;
    @Column(name = "abunds")
    private String abunds;
    @Column(name = "comabunds")
    private String comabunds;
    @Column(name = "dists")
    private String dists;
    @Column(name = "comdists")
    private String comdists;
    @Column(name = "leprots")
    private String leprots;
    @Column(name = "comleprots")
    private String comleprots;
    @Column(name = "amenazs")
    private String amenazs;
    @Column(name = "comamenazs")
    private String comamenazs;
    @Column(name = "otraconsids")
    private String otraconsids;
    @Column(name = "rangos")
    private String rangos;
    @Column(name = "fecharevrs")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharevrs;
    @Column(name = "razonrs")
    private String razonrs;
    @Column(name = "necprotecs")
    private String necprotecs;
    @Column(name = "necinvents")
    private String necinvents;
    @Column(name = "necmanejos")
    private String necmanejos;
    @Column(name = "autored")
    private String autored;
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
    @Column(name = "subnacional_id")
    private Integer subnacionalId;
    @JoinColumn(name = "JERARQUIZACION_jerarquizacion_id", referencedColumnName = "jerarquizacion_id")
    @ManyToOne
    private Jerarquizacion jERARQUIZACIONjerarquizacionid;

    public Subnacional() {
    }

    public Subnacional(Integer subnacionalId) {
        this.subnacionalId = subnacionalId;
    }

    public Integer getSubnacionalId() {
        return subnacionalId;
    }

    public void setSubnacionalId(Integer subnacionalId) {
        this.subnacionalId = subnacionalId;
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
        hash += (subnacionalId != null ? subnacionalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subnacional)) {
            return false;
        }
        Subnacional other = (Subnacional) object;
        if ((this.subnacionalId == null && other.subnacionalId != null) || (this.subnacionalId != null && !this.subnacionalId.equals(other.subnacionalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Subnacional[ subnacionalId=" + subnacionalId + " ]";
    }

    public String getCodigoe() {
        return codigoe;
    }

    public void setCodigoe(String codigoe) {
        this.codigoe = codigoe;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getLoctips() {
        return loctips;
    }

    public void setLoctips(String loctips) {
        this.loctips = loctips;
    }

    public String getLestims() {
        return lestims;
    }

    public void setLestims(String lestims) {
        this.lestims = lestims;
    }

    public String getComlestims() {
        return comlestims;
    }

    public void setComlestims(String comlestims) {
        this.comlestims = comlestims;
    }

    public String getAbunds() {
        return abunds;
    }

    public void setAbunds(String abunds) {
        this.abunds = abunds;
    }

    public String getComabunds() {
        return comabunds;
    }

    public void setComabunds(String comabunds) {
        this.comabunds = comabunds;
    }

    public String getDists() {
        return dists;
    }

    public void setDists(String dists) {
        this.dists = dists;
    }

    public String getComdists() {
        return comdists;
    }

    public void setComdists(String comdists) {
        this.comdists = comdists;
    }

    public String getLeprots() {
        return leprots;
    }

    public void setLeprots(String leprots) {
        this.leprots = leprots;
    }

    public String getComleprots() {
        return comleprots;
    }

    public void setComleprots(String comleprots) {
        this.comleprots = comleprots;
    }

    public String getAmenazs() {
        return amenazs;
    }

    public void setAmenazs(String amenazs) {
        this.amenazs = amenazs;
    }

    public String getComamenazs() {
        return comamenazs;
    }

    public void setComamenazs(String comamenazs) {
        this.comamenazs = comamenazs;
    }

    public String getOtraconsids() {
        return otraconsids;
    }

    public void setOtraconsids(String otraconsids) {
        this.otraconsids = otraconsids;
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

    public String getRazonrs() {
        return razonrs;
    }

    public void setRazonrs(String razonrs) {
        this.razonrs = razonrs;
    }

    public String getNecprotecs() {
        return necprotecs;
    }

    public void setNecprotecs(String necprotecs) {
        this.necprotecs = necprotecs;
    }

    public String getNecinvents() {
        return necinvents;
    }

    public void setNecinvents(String necinvents) {
        this.necinvents = necinvents;
    }

    public String getNecmanejos() {
        return necmanejos;
    }

    public void setNecmanejos(String necmanejos) {
        this.necmanejos = necmanejos;
    }

    public String getAutored() {
        return autored;
    }

    public void setAutored(String autored) {
        this.autored = autored;
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
