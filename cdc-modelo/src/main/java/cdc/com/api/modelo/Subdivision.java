/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.modelo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Héctor Vix
 */
@Entity
@Table(name = "subdivision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subdivision.findAll", query = "SELECT s FROM Subdivision s")
    , @NamedQuery(name = "Subdivision.findBySubdivisionId", query = "SELECT s FROM Subdivision s WHERE s.subdivisionId = :subdivisionId")
    , @NamedQuery(name = "Subdivision.findByCodsubdiv", query = "SELECT s FROM Subdivision s WHERE s.codsubdiv = :codsubdiv")
    , @NamedQuery(name = "Subdivision.findByNomsubdiv", query = "SELECT s FROM Subdivision s WHERE s.nomsubdiv = :nomsubdiv")
    , @NamedQuery(name = "Subdivision.findByNommapa", query = "SELECT s FROM Subdivision s WHERE s.nommapa = :nommapa")
    , @NamedQuery(name = "Subdivision.findByCodmapa", query = "SELECT s FROM Subdivision s WHERE s.codmapa = :codmapa")})
public class Subdivision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subdivision_id")
    private Integer subdivisionId;
    @Column(name = "codsubdiv")
    private String codsubdiv;
    @Column(name = "nomsubdiv")
    private String nomsubdiv;
    @Column(name = "nommapa")
    private String nommapa;
    @Column(name = "codmapa")
    private String codmapa;
    @JoinColumn(name = "SITIO_sitio_id", referencedColumnName = "sitio_id")
    @ManyToOne
    private Sitio sITIOsitioid;

    public Subdivision() {
    }

    public Subdivision(Integer subdivisionId) {
        this.subdivisionId = subdivisionId;
    }

    public Integer getSubdivisionId() {
        return subdivisionId;
    }

    public void setSubdivisionId(Integer subdivisionId) {
        this.subdivisionId = subdivisionId;
    }

    public String getCodsubdiv() {
        return codsubdiv;
    }

    public void setCodsubdiv(String codsubdiv) {
        this.codsubdiv = codsubdiv;
    }

    public String getNomsubdiv() {
        return nomsubdiv;
    }

    public void setNomsubdiv(String nomsubdiv) {
        this.nomsubdiv = nomsubdiv;
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

    public Sitio getSITIOsitioid() {
        return sITIOsitioid;
    }

    public void setSITIOsitioid(Sitio sITIOsitioid) {
        this.sITIOsitioid = sITIOsitioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subdivisionId != null ? subdivisionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subdivision)) {
            return false;
        }
        Subdivision other = (Subdivision) object;
        if ((this.subdivisionId == null && other.subdivisionId != null) || (this.subdivisionId != null && !this.subdivisionId.equals(other.subdivisionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Subdivision[ subdivisionId=" + subdivisionId + " ]";
    }
    
}
