/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.modelo;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Héctor Vix
 */
@Entity
@Table(name = "vertebrado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vertebrado.findAll", query = "SELECT v FROM Vertebrado v")
    , @NamedQuery(name = "Vertebrado.findByVertebradoId", query = "SELECT v FROM Vertebrado v WHERE v.vertebradoId = :vertebradoId")
    , @NamedQuery(name = "Vertebrado.findByCodigoe", query = "SELECT v FROM Vertebrado v WHERE v.codigoe = :codigoe")})
public class Vertebrado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vertebrado_id")
    private Integer vertebradoId;
    @Column(name = "codigoe")
    private String codigoe;
    @JoinColumn(name = "CARACTERIZACION_caracterizacion_id", referencedColumnName = "caracterizacion_id")
    @ManyToOne
    private Caracterizacion cARACTERIZACIONcaracterizacionid;
    @OneToMany(mappedBy = "vERTEBRADOvertebradoid")
    private List<Foto> fotoList;
    @OneToMany(mappedBy = "vERTEBRADOvertebradoid")
    private List<Distribucion> distribucionList;

    public Vertebrado() {
    }

    public Vertebrado(Integer vertebradoId) {
        this.vertebradoId = vertebradoId;
    }

    public Integer getVertebradoId() {
        return vertebradoId;
    }

    public void setVertebradoId(Integer vertebradoId) {
        this.vertebradoId = vertebradoId;
    }

    public String getCodigoe() {
        return codigoe;
    }

    public void setCodigoe(String codigoe) {
        this.codigoe = codigoe;
    }

    public Caracterizacion getCARACTERIZACIONcaracterizacionid() {
        return cARACTERIZACIONcaracterizacionid;
    }

    public void setCARACTERIZACIONcaracterizacionid(Caracterizacion cARACTERIZACIONcaracterizacionid) {
        this.cARACTERIZACIONcaracterizacionid = cARACTERIZACIONcaracterizacionid;
    }

    @XmlTransient
    public List<Foto> getFotoList() {
        return fotoList;
    }

    public void setFotoList(List<Foto> fotoList) {
        this.fotoList = fotoList;
    }

    @XmlTransient
    public List<Distribucion> getDistribucionList() {
        return distribucionList;
    }

    public void setDistribucionList(List<Distribucion> distribucionList) {
        this.distribucionList = distribucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vertebradoId != null ? vertebradoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vertebrado)) {
            return false;
        }
        Vertebrado other = (Vertebrado) object;
        if ((this.vertebradoId == null && other.vertebradoId != null) || (this.vertebradoId != null && !this.vertebradoId.equals(other.vertebradoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Vertebrado[ vertebradoId=" + vertebradoId + " ]";
    }
    
}
