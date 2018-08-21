/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.UsuarioDao;
import cdc.com.api.modelo.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;
    private int usuario_id;

    public void save(Usuario usuario) {
        entityManager.persist(usuario);
    }

    public void update(Usuario usuario) {
        entityManager.merge(usuario);
    }

    public void delete(Long id) {
        Usuario usuario = find(id);
        entityManager.remove(usuario);
    }
 
    public Usuario find(Long id) {
         TypedQuery<Usuario> query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.usuarioId = :usuarioId", Usuario.class);
        query.setParameter("usuarioId", id);     
        Usuario user = query.getSingleResult();
        return user;
    }

    public boolean find_Usuario(String email, String contrasena) {
        TypedQuery<Usuario> query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND  u.contrasena = :contrasena ", Usuario.class);
        query.setParameter("email", email);
        query.setParameter("contrasena", contrasena);
        Usuario user = query.getSingleResult();
        if (user == null) {
            return false;
        } else {
            usuario_id = user.getUsuarioId();
            return true;
        }
    }
    
    public int getUsuario_id() {
        return usuario_id;
    }

    @Override
    public List<Usuario> all() {
        return entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();

    }

}
