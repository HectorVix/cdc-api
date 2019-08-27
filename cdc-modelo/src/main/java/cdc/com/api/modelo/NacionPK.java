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
public class NacionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "nacion_id")
    private int nacionId;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;

    public NacionPK() {
    }

    public NacionPK(int nacionId, String codigo) {
        this.nacionId = nacionId;
        this.codigo = codigo;
    }

    public int getNacionId() {
        return nacionId;
    }

    public void setNacionId(int nacionId) {
        this.nacionId = nacionId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nacionId;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NacionPK)) {
            return false;
        }
        NacionPK other = (NacionPK) object;
        if (this.nacionId != other.nacionId) {
            return false;
        }
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.NacionPK[ nacionId=" + nacionId + ", codigo=" + codigo + " ]";
    }
    
}
