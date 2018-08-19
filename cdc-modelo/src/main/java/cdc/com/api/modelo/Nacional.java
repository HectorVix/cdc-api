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
@Table(name = "nacional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nacional.findAll", query = "SELECT n FROM Nacional n")
    , @NamedQuery(name = "Nacional.findByNacionalId", query = "SELECT n FROM Nacional n WHERE n.nacionalId = :nacionalId")})
public class Nacional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nacional_id")
    private Integer nacionalId;
    @JoinColumn(name = "JERARQUIZACION_jerarquizacion_id", referencedColumnName = "jerarquizacion_id")
    @ManyToOne
    private Jerarquizacion jERARQUIZACIONjerarquizacionid;

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

    public Jerarquizacion getJERARQUIZACIONjerarquizacionid() {
        return jERARQUIZACIONjerarquizacionid;
    }

    public void setJERARQUIZACIONjerarquizacionid(Jerarquizacion jERARQUIZACIONjerarquizacionid) {
        this.jERARQUIZACIONjerarquizacionid = jERARQUIZACIONjerarquizacionid;
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
