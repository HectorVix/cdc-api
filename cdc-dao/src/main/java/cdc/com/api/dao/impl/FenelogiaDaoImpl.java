/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.FenelogiaDao;
import cdc.com.api.modelo.Fenelogia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class FenelogiaDaoImpl implements FenelogiaDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Fenelogia fenelogia) {
        entityManager.persist(fenelogia);
    }

    public void update(Fenelogia fenelogia) {
        entityManager.merge(fenelogia);
    }

    public void delete(Long id) {
         Fenelogia fenelogia = find(id);
        entityManager.remove(fenelogia);
    }

    public Fenelogia find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Fenelogia> all() {
        return entityManager.createQuery("SELECT f FROM Fenelogia f", Fenelogia.class).getResultList();
    }

}
