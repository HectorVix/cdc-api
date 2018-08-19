/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;
import cdc.com.api.dao.ElementoDao;
import cdc.com.api.modelo.Elemento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Héctor Vix
 */@Stateless
public class ElementoDaoImpl implements ElementoDao {
    @PersistenceContext(unitName ="cdcPU")
     private EntityManager entityManager;
    public void save(Elemento elemento) {
        entityManager.persist(elemento);
    }

    public void update(Elemento elemento) {
        entityManager.merge(elemento);
    }

    public void delete(Long id) {
        Elemento elemento = find (id);
        entityManager.remove(elemento);
    }

    public Elemento find(Long id) {
        return  entityManager.find(Elemento.class, id);
   }
@Override
    public List<Elemento> all() {
          return entityManager.createQuery("SELECT e FROM Elemento e", Elemento.class).getResultList();
    
   }
    
}
