/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.SubnacionalDao;
import cdc.com.api.modelo.Subnacional;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class SubnacionalDaoImp implements SubnacionalDao{
 @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;
    public void save(Subnacional subnacional) {
      entityManager.persist(subnacional);
    }

    public void update(Subnacional subnacional) {
    entityManager.merge(subnacional);
    }

    public void delete(Long id) {
        Subnacional subnacional = find(id);
    entityManager.remove(subnacional);
    }

    public Subnacional find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  @Override
    public List<Subnacional> all() {
       return entityManager.createQuery("SELECT s FROM Subnacional s", Subnacional.class).getResultList();
  }

    public List<Subnacional> buscarSubnacional(String codigoe, String nombreSubnacional) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
