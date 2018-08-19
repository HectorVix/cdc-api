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
@Table(name = "subnacional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subnacional.findAll", query = "SELECT s FROM Subnacional s")
    , @NamedQuery(name = "Subnacional.findBySubnacionalId", query = "SELECT s FROM Subnacional s WHERE s.subnacionalId = :subnacionalId")})
public class Subnacional implements Serializable {

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
    
}
