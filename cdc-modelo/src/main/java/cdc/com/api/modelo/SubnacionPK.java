/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Héctor Vix
 */
@Embeddable
public class SubnacionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "subnacion_id")
    private int subnacionId;
    @Basic(optional = false)
    @Column(name = "codigo")
    private int codigo;

    public SubnacionPK() {
    }

    public SubnacionPK(int subnacionId, int codigo) {
        this.subnacionId = subnacionId;
        this.codigo = codigo;
    }

    public int getSubnacionId() {
        return subnacionId;
    }

    public void setSubnacionId(int subnacionId) {
        this.subnacionId = subnacionId;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) subnacionId;
        hash += (int) codigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubnacionPK)) {
            return false;
        }
        SubnacionPK other = (SubnacionPK) object;
        if (this.subnacionId != other.subnacionId) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.SubnacionPK[ subnacionId=" + subnacionId + ", codigo=" + codigo + " ]";
    }
    
}
