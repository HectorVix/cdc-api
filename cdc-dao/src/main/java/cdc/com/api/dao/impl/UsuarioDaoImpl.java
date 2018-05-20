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
/**
 *
 * @author Héctor Vix
 */

@Stateless
public class UsuarioDaoImpl implements UsuarioDao {
    
   @PersistenceContext(unitName ="cdcPU")
    private EntityManager entityManager;
    
    public void save(Usuario usuario) {
        entityManager.persist(usuario);
     }

    public void update(Usuario usuario) {
        entityManager.merge(usuario);
    }

    public void delete(Long id) {
        Usuario usuario =find(id);
        entityManager.remove(usuario);
     }

    public Usuario find(Long id) {
      return  entityManager.find(Usuario.class, id);
    }
      @Override
    public List<Usuario> all() {
        return entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    
     }

}
