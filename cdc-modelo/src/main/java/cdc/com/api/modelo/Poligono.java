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
@Table(name = "poligono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poligono.findAll", query = "SELECT p FROM Poligono p")
    , @NamedQuery(name = "Poligono.findByPoligonoId", query = "SELECT p FROM Poligono p WHERE p.poligonoId = :poligonoId")
    , @NamedQuery(name = "Poligono.findByX", query = "SELECT p FROM Poligono p WHERE p.x = :x")
    , @NamedQuery(name = "Poligono.findByY", query = "SELECT p FROM Poligono p WHERE p.y = :y")})
public class Poligono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "poligono_id")
    private Integer poligonoId;
    @Column(name = "x")
    private Integer x;
    @Column(name = "y")
    private Integer y;
    @JoinColumn(name = "MUNICIPIO_municipio_id", referencedColumnName = "municipio_id")
    @ManyToOne
    private Municipio mUNICIPIOmunicipioid;

    public Poligono() {
    }

    public Poligono(Integer poligonoId) {
        this.poligonoId = poligonoId;
    }

    public Integer getPoligonoId() {
        return poligonoId;
    }

    public void setPoligonoId(Integer poligonoId) {
        this.poligonoId = poligonoId;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Municipio getMUNICIPIOmunicipioid() {
        return mUNICIPIOmunicipioid;
    }

    public void setMUNICIPIOmunicipioid(Municipio mUNICIPIOmunicipioid) {
        this.mUNICIPIOmunicipioid = mUNICIPIOmunicipioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poligonoId != null ? poligonoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poligono)) {
            return false;
        }
        Poligono other = (Poligono) object;
        if ((this.poligonoId == null && other.poligonoId != null) || (this.poligonoId != null && !this.poligonoId.equals(other.poligonoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Poligono[ poligonoId=" + poligonoId + " ]";
    }
    
}
