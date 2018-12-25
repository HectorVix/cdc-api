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
@Table(name = "lista_elemento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaElemento.findAll", query = "SELECT l FROM ListaElemento l")
    , @NamedQuery(name = "ListaElemento.findByListaElementoId", query = "SELECT l FROM ListaElemento l WHERE l.listaElementoId = :listaElementoId")
    , @NamedQuery(name = "ListaElemento.findByCodigoe", query = "SELECT l FROM ListaElemento l WHERE l.codigoe = :codigoe")
    , @NamedQuery(name = "ListaElemento.findByNombres", query = "SELECT l FROM ListaElemento l WHERE l.nombres = :nombres")
    , @NamedQuery(name = "ListaElemento.findByStatus", query = "SELECT l FROM ListaElemento l WHERE l.status = :status")
    , @NamedQuery(name = "ListaElemento.findByCodfuente", query = "SELECT l FROM ListaElemento l WHERE l.codfuente = :codfuente")})
public class ListaElemento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lista_elemento_id")
    private Integer listaElementoId;
    @Column(name = "codigoe")
    private String codigoe;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "status")
    private String status;
    @Column(name = "codfuente")
    private String codfuente;
    @JoinColumn(name = "AREA_area_id", referencedColumnName = "area_id")
    @ManyToOne
    private Area aREAareaid;

    public ListaElemento() {
    }

    public ListaElemento(Integer listaElementoId) {
        this.listaElementoId = listaElementoId;
    }

    public Integer getListaElementoId() {
        return listaElementoId;
    }

    public void setListaElementoId(Integer listaElementoId) {
        this.listaElementoId = listaElementoId;
    }

    public String getCodigoe() {
        return codigoe;
    }

    public void setCodigoe(String codigoe) {
        this.codigoe = codigoe;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodfuente() {
        return codfuente;
    }

    public void setCodfuente(String codfuente) {
        this.codfuente = codfuente;
    }

    public Area getAREAareaid() {
        return aREAareaid;
    }

    public void setAREAareaid(Area aREAareaid) {
        this.aREAareaid = aREAareaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listaElementoId != null ? listaElementoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaElemento)) {
            return false;
        }
        ListaElemento other = (ListaElemento) object;
        if ((this.listaElementoId == null && other.listaElementoId != null) || (this.listaElementoId != null && !this.listaElementoId.equals(other.listaElementoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.ListaElemento[ listaElementoId=" + listaElementoId + " ]";
    }
    
}
