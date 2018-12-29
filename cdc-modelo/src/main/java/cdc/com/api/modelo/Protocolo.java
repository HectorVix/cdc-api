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
@Table(name = "protocolo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Protocolo.findAll", query = "SELECT p FROM Protocolo p")
    , @NamedQuery(name = "Protocolo.findByProtocoloId", query = "SELECT p FROM Protocolo p WHERE p.protocoloId = :protocoloId")
    , @NamedQuery(name = "Protocolo.findByCodigoe", query = "SELECT p FROM Protocolo p WHERE p.codigoe = :codigoe")})
public class Protocolo implements Serializable {

    @Column(name = "rangog")
    private String rangog;
    @Column(name = "rangon")
    private String rangon;
    @Column(name = "rangos")
    private String rangos;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nomcomun")
    private String nomcomun;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "protocolo_id")
    private Integer protocoloId;
    @Column(name = "codigoe")
    private String codigoe;
    @JoinColumn(name = "ELEMENTO_elemento_id", referencedColumnName = "elemento_id")
    @ManyToOne
    private Elemento eLEMENTOelementoid;
    @OneToMany(mappedBy = "pROTOCOLOprotocoloid")
    private List<Dispersion> dispersionList;

    public Protocolo() {
    }

    public Protocolo(Integer protocoloId) {
        this.protocoloId = protocoloId;
    }

    public Integer getProtocoloId() {
        return protocoloId;
    }

    public void setProtocoloId(Integer protocoloId) {
        this.protocoloId = protocoloId;
    }

    public String getCodigoe() {
        return codigoe;
    }

    public void setCodigoe(String codigoe) {
        this.codigoe = codigoe;
    }

    public Elemento getELEMENTOelementoid() {
        return eLEMENTOelementoid;
    }

    public void setELEMENTOelementoid(Elemento eLEMENTOelementoid) {
        this.eLEMENTOelementoid = eLEMENTOelementoid;
    }

    @XmlTransient
    public List<Dispersion> getDispersionList() {
        return dispersionList;
    }

    public void setDispersionList(List<Dispersion> dispersionList) {
        this.dispersionList = dispersionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (protocoloId != null ? protocoloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Protocolo)) {
            return false;
        }
        Protocolo other = (Protocolo) object;
        if ((this.protocoloId == null && other.protocoloId != null) || (this.protocoloId != null && !this.protocoloId.equals(other.protocoloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Protocolo[ protocoloId=" + protocoloId + " ]";
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomcomun() {
        return nomcomun;
    }

    public void setNomcomun(String nomcomun) {
        this.nomcomun = nomcomun;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
