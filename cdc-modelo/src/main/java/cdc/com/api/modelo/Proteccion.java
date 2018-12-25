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
@Table(name = "proteccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proteccion.findAll", query = "SELECT p FROM Proteccion p")
    , @NamedQuery(name = "Proteccion.findByProteccionId", query = "SELECT p FROM Proteccion p WHERE p.proteccionId = :proteccionId")
    , @NamedQuery(name = "Proteccion.findByCodigoam", query = "SELECT p FROM Proteccion p WHERE p.codigoam = :codigoam")
    , @NamedQuery(name = "Proteccion.findByNombream", query = "SELECT p FROM Proteccion p WHERE p.nombream = :nombream")
    , @NamedQuery(name = "Proteccion.findByContenido", query = "SELECT p FROM Proteccion p WHERE p.contenido = :contenido")})
public class Proteccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proteccion_id")
    private Integer proteccionId;
    @Column(name = "codigoam")
    private String codigoam;
    @Column(name = "nombream")
    private String nombream;
    @Column(name = "contenido")
    private String contenido;
    @JoinColumn(name = "LOCALIZACION_localizacion_id", referencedColumnName = "localizacion_id")
    @ManyToOne
    private Localizacion lOCALIZACIONlocalizacionid;

    public Proteccion() {
    }

    public Proteccion(Integer proteccionId) {
        this.proteccionId = proteccionId;
    }

    public Integer getProteccionId() {
        return proteccionId;
    }

    public void setProteccionId(Integer proteccionId) {
        this.proteccionId = proteccionId;
    }

    public String getCodigoam() {
        return codigoam;
    }

    public void setCodigoam(String codigoam) {
        this.codigoam = codigoam;
    }

    public String getNombream() {
        return nombream;
    }

    public void setNombream(String nombream) {
        this.nombream = nombream;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Localizacion getLOCALIZACIONlocalizacionid() {
        return lOCALIZACIONlocalizacionid;
    }

    public void setLOCALIZACIONlocalizacionid(Localizacion lOCALIZACIONlocalizacionid) {
        this.lOCALIZACIONlocalizacionid = lOCALIZACIONlocalizacionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proteccionId != null ? proteccionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proteccion)) {
            return false;
        }
        Proteccion other = (Proteccion) object;
        if ((this.proteccionId == null && other.proteccionId != null) || (this.proteccionId != null && !this.proteccionId.equals(other.proteccionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Proteccion[ proteccionId=" + proteccionId + " ]";
    }
    
}
