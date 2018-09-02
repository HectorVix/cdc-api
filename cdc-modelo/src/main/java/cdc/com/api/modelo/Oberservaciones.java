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
@Table(name = "oberservaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oberservaciones.findAll", query = "SELECT o FROM Oberservaciones o")
    , @NamedQuery(name = "Oberservaciones.findByOberservacionesId", query = "SELECT o FROM Oberservaciones o WHERE o.oberservacionesId = :oberservacionesId")
    , @NamedQuery(name = "Oberservaciones.findByNombre", query = "SELECT o FROM Oberservaciones o WHERE o.nombre = :nombre")})
public class Oberservaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "oberservaciones_id")
    private Integer oberservacionesId;
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "AREA_area_id", referencedColumnName = "area_id")
    @ManyToOne
    private Area aREAareaid;
    @JoinColumn(name = "LOCALIZACION_localizacion_id", referencedColumnName = "localizacion_id")
    @ManyToOne
    private Localizacion lOCALIZACIONlocalizacionid;
    @JoinColumn(name = "RASTREO_rastreo_id", referencedColumnName = "rastreo_id")
    @ManyToOne
    private Rastreo rASTREOrastreoid;
    @JoinColumn(name = "SITIO_sitio_id", referencedColumnName = "sitio_id")
    @ManyToOne
    private Sitio sITIOsitioid;

    public Oberservaciones() {
    }

    public Oberservaciones(Integer oberservacionesId) {
        this.oberservacionesId = oberservacionesId;
    }

    public Integer getOberservacionesId() {
        return oberservacionesId;
    }

    public void setOberservacionesId(Integer oberservacionesId) {
        this.oberservacionesId = oberservacionesId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Area getAREAareaid() {
        return aREAareaid;
    }

    public void setAREAareaid(Area aREAareaid) {
        this.aREAareaid = aREAareaid;
    }

    public Localizacion getLOCALIZACIONlocalizacionid() {
        return lOCALIZACIONlocalizacionid;
    }

    public void setLOCALIZACIONlocalizacionid(Localizacion lOCALIZACIONlocalizacionid) {
        this.lOCALIZACIONlocalizacionid = lOCALIZACIONlocalizacionid;
    }

    public Rastreo getRASTREOrastreoid() {
        return rASTREOrastreoid;
    }

    public void setRASTREOrastreoid(Rastreo rASTREOrastreoid) {
        this.rASTREOrastreoid = rASTREOrastreoid;
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
        hash += (oberservacionesId != null ? oberservacionesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oberservaciones)) {
            return false;
        }
        Oberservaciones other = (Oberservaciones) object;
        if ((this.oberservacionesId == null && other.oberservacionesId != null) || (this.oberservacionesId != null && !this.oberservacionesId.equals(other.oberservacionesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Oberservaciones[ oberservacionesId=" + oberservacionesId + " ]";
    }
    
}
