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
@Table(name = "identificador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Identificador.findAll", query = "SELECT i FROM Identificador i")
    , @NamedQuery(name = "Identificador.findByIdentificadorId", query = "SELECT i FROM Identificador i WHERE i.identificadorId = :identificadorId")})
public class Identificador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "identificador_id")
    private Integer identificadorId;
    @JoinColumn(name = "SITIO_sitio_id", referencedColumnName = "sitio_id")
    @ManyToOne
    private Sitio sITIOsitioid;

    public Identificador() {
    }

    public Identificador(Integer identificadorId) {
        this.identificadorId = identificadorId;
    }

    public Integer getIdentificadorId() {
        return identificadorId;
    }

    public void setIdentificadorId(Integer identificadorId) {
        this.identificadorId = identificadorId;
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
        hash += (identificadorId != null ? identificadorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Identificador)) {
            return false;
        }
        Identificador other = (Identificador) object;
        if ((this.identificadorId == null && other.identificadorId != null) || (this.identificadorId != null && !this.identificadorId.equals(other.identificadorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Identificador[ identificadorId=" + identificadorId + " ]";
    }
    
}
