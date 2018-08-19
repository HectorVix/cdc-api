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
@Table(name = "localizador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localizador.findAll", query = "SELECT l FROM Localizador l")
    , @NamedQuery(name = "Localizador.findByLocalizadorId", query = "SELECT l FROM Localizador l WHERE l.localizadorId = :localizadorId")})
public class Localizador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "localizador_id")
    private Integer localizadorId;
    @JoinColumn(name = "SITIO_sitio_id", referencedColumnName = "sitio_id")
    @ManyToOne
    private Sitio sITIOsitioid;

    public Localizador() {
    }

    public Localizador(Integer localizadorId) {
        this.localizadorId = localizadorId;
    }

    public Integer getLocalizadorId() {
        return localizadorId;
    }

    public void setLocalizadorId(Integer localizadorId) {
        this.localizadorId = localizadorId;
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
        hash += (localizadorId != null ? localizadorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localizador)) {
            return false;
        }
        Localizador other = (Localizador) object;
        if ((this.localizadorId == null && other.localizadorId != null) || (this.localizadorId != null && !this.localizadorId.equals(other.localizadorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Localizador[ localizadorId=" + localizadorId + " ]";
    }
    
}
