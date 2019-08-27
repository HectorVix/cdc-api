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
public class MunicipioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "municipio_id")
    private int municipioId;
    @Basic(optional = false)
    @Column(name = "codigo")
    private int codigo;

    public MunicipioPK() {
    }

    public MunicipioPK(int municipioId, int codigo) {
        this.municipioId = municipioId;
        this.codigo = codigo;
    }

    public int getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(int municipioId) {
        this.municipioId = municipioId;
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
        hash += (int) municipioId;
        hash += (int) codigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MunicipioPK)) {
            return false;
        }
        MunicipioPK other = (MunicipioPK) object;
        if (this.municipioId != other.municipioId) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.MunicipioPK[ municipioId=" + municipioId + ", codigo=" + codigo + " ]";
    }
    
}
