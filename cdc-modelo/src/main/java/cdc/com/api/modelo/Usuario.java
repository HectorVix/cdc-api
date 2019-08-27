/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Héctor Vix
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuarioId", query = "SELECT u FROM Usuario u WHERE u.usuarioId = :usuarioId")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApellido", query = "SELECT u FROM Usuario u WHERE u.apellido = :apellido")
    , @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "Usuario.findBySexo", query = "SELECT u FROM Usuario u WHERE u.sexo = :sexo")
    , @NamedQuery(name = "Usuario.findByFechaNacimiento", query = "SELECT u FROM Usuario u WHERE u.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_id")
    private Integer usuarioId;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "sexo")
    private Integer sexo;
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Column(name = "email")
    private String email;
    @Column(name = "contrasena")
    private String contrasena;
    @OneToMany(mappedBy = "uSUARIOusuarioid")
    private List<Accion> accionList;
    @OneToMany(mappedBy = "uSUARIOusuarioid")
    private List<Nacion> nacionList;
    @OneToMany(mappedBy = "uSUARIOusuarioid")
    private List<Sitio> sitioList;
    @OneToMany(mappedBy = "uSUARIOusuarioid")
    private List<Fuente> fuenteList;
    @OneToMany(mappedBy = "uSUARIOusuarioid")
    private List<Rangog> rangogList;
    @OneToMany(mappedBy = "uSUARIOusuarioid")
    private List<Rangon> rangonList;
    @OneToMany(mappedBy = "uSUARIOusuarioid")
    private List<Rangos> rangosList;
    @OneToMany(mappedBy = "uSUARIOusuarioid")
    private List<Area> areaList;
    @OneToMany(mappedBy = "uSUARIOusuarioid")
    private List<Fenelogia> fenelogiaList;
    @OneToMany(mappedBy = "uSUARIOusuarioid")
    private List<Contacto> contactoList;
    @OneToMany(mappedBy = "uSUARIOusuarioid")
    private List<Elemento> elementoList;
    @JoinColumn(name = "Rol_rol_id", referencedColumnName = "rol_id")
    @ManyToOne
    private Rol rolrolid;

    public Usuario() {
    }

    public Usuario(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @XmlTransient
    public List<Accion> getAccionList() {
        return accionList;
    }

    public void setAccionList(List<Accion> accionList) {
        this.accionList = accionList;
    }

    @XmlTransient
    public List<Nacion> getNacionList() {
        return nacionList;
    }

    public void setNacionList(List<Nacion> nacionList) {
        this.nacionList = nacionList;
    }

    @XmlTransient
    public List<Sitio> getSitioList() {
        return sitioList;
    }

    public void setSitioList(List<Sitio> sitioList) {
        this.sitioList = sitioList;
    }

    @XmlTransient
    public List<Fuente> getFuenteList() {
        return fuenteList;
    }

    public void setFuenteList(List<Fuente> fuenteList) {
        this.fuenteList = fuenteList;
    }

    @XmlTransient
    public List<Rangog> getRangogList() {
        return rangogList;
    }

    public void setRangogList(List<Rangog> rangogList) {
        this.rangogList = rangogList;
    }

    @XmlTransient
    public List<Rangon> getRangonList() {
        return rangonList;
    }

    public void setRangonList(List<Rangon> rangonList) {
        this.rangonList = rangonList;
    }

    @XmlTransient
    public List<Rangos> getRangosList() {
        return rangosList;
    }

    public void setRangosList(List<Rangos> rangosList) {
        this.rangosList = rangosList;
    }

    @XmlTransient
    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    @XmlTransient
    public List<Fenelogia> getFenelogiaList() {
        return fenelogiaList;
    }

    public void setFenelogiaList(List<Fenelogia> fenelogiaList) {
        this.fenelogiaList = fenelogiaList;
    }

    @XmlTransient
    public List<Contacto> getContactoList() {
        return contactoList;
    }

    public void setContactoList(List<Contacto> contactoList) {
        this.contactoList = contactoList;
    }

    @XmlTransient
    public List<Elemento> getElementoList() {
        return elementoList;
    }

    public void setElementoList(List<Elemento> elementoList) {
        this.elementoList = elementoList;
    }

    public Rol getRolrolid() {
        return rolrolid;
    }

    public void setRolrolid(Rol rolrolid) {
        this.rolrolid = rolrolid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Usuario[ usuarioId=" + usuarioId + " ]";
    }
    
}
