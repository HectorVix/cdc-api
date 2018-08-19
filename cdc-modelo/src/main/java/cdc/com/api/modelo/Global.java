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
@Table(name = "global")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Global.findAll", query = "SELECT g FROM Global g")
    , @NamedQuery(name = "Global.findByGloblalId", query = "SELECT g FROM Global g WHERE g.globlalId = :globlalId")})
public class Global implements Serializable {

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
    
}
