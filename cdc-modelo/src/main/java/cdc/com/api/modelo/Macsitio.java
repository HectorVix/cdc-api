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
@Table(name = "macsitio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Macsitio.findAll", query = "SELECT m FROM Macsitio m")
    , @NamedQuery(name = "Macsitio.findByMacsitioId", query = "SELECT m FROM Macsitio m WHERE m.macsitioId = :macsitioId")
    , @NamedQuery(name = "Macsitio.findByCodmacsitio", query = "SELECT m FROM Macsitio m WHERE m.codmacsitio = :codmacsitio")
    , @NamedQuery(name = "Macsitio.findByNommacsitio", query = "SELECT m FROM Macsitio m WHERE m.nommacsitio = :nommacsitio")})
public class Macsitio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "macsitio_id")
    private Integer macsitioId;
    @Column(name = "codmacsitio")
    private String codmacsitio;
    @Column(name = "nommacsitio")
    private String nommacsitio;
    @JoinColumn(name = "SITIO_sitio_id", referencedColumnName = "sitio_id")
    @ManyToOne
    private Sitio sITIOsitioid;

    public Macsitio() {
    }

    public Macsitio(Integer macsitioId) {
        this.macsitioId = macsitioId;
    }

    public Integer getMacsitioId() {
        return macsitioId;
    }

    public void setMacsitioId(Integer macsitioId) {
        this.macsitioId = macsitioId;
    }

    public String getCodmacsitio() {
        return codmacsitio;
    }

    public void setCodmacsitio(String codmacsitio) {
        this.codmacsitio = codmacsitio;
    }

    public String getNommacsitio() {
        return nommacsitio;
    }

    public void setNommacsitio(String nommacsitio) {
        this.nommacsitio = nommacsitio;
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
        hash += (macsitioId != null ? macsitioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Macsitio)) {
            return false;
        }
        Macsitio other = (Macsitio) object;
        if ((this.macsitioId == null && other.macsitioId != null) || (this.macsitioId != null && !this.macsitioId.equals(other.macsitioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Macsitio[ macsitioId=" + macsitioId + " ]";
    }
    
}
