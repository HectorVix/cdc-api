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
@Table(name = "fenelogia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fenelogia.findAll", query = "SELECT f FROM Fenelogia f")
    , @NamedQuery(name = "Fenelogia.findByIdFenelogia", query = "SELECT f FROM Fenelogia f WHERE f.idFenelogia = :idFenelogia")
    , @NamedQuery(name = "Fenelogia.findByValor", query = "SELECT f FROM Fenelogia f WHERE f.valor = :valor")
    , @NamedQuery(name = "Fenelogia.findByFenelogia", query = "SELECT f FROM Fenelogia f WHERE f.fenelogia = :fenelogia")})
public class Fenelogia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fenelogia")
    private Integer idFenelogia;
    @Column(name = "valor")
    private String valor;
    @Column(name = "fenelogia")
    private String fenelogia;
    @JoinColumn(name = "USUARIO_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario uSUARIOusuarioid;

    public Fenelogia() {
    }

    public Fenelogia(Integer idFenelogia) {
        this.idFenelogia = idFenelogia;
    }

    public Integer getIdFenelogia() {
        return idFenelogia;
    }

    public void setIdFenelogia(Integer idFenelogia) {
        this.idFenelogia = idFenelogia;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFenelogia() {
        return fenelogia;
    }

    public void setFenelogia(String fenelogia) {
        this.fenelogia = fenelogia;
    }

    public Usuario getUSUARIOusuarioid() {
        return uSUARIOusuarioid;
    }

    public void setUSUARIOusuarioid(Usuario uSUARIOusuarioid) {
        this.uSUARIOusuarioid = uSUARIOusuarioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFenelogia != null ? idFenelogia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fenelogia)) {
            return false;
        }
        Fenelogia other = (Fenelogia) object;
        if ((this.idFenelogia == null && other.idFenelogia != null) || (this.idFenelogia != null && !this.idFenelogia.equals(other.idFenelogia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Fenelogia[ idFenelogia=" + idFenelogia + " ]";
    }
    
}
