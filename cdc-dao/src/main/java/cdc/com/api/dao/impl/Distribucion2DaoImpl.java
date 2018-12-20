/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.Distribucion2Dao;
import cdc.com.api.modelo.Distribucion2;
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
public class Distribucion2DaoImpl implements Distribucion2Dao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Distribucion2 distribucion2) {
        entityManager.persist(distribucion2);
    }

    public void update(Distribucion2 distribucion2) {
        entityManager.merge(distribucion2);
    }

    public void delete(Long id) {
        Distribucion2 distribucion2 = find(id);
        entityManager.remove(distribucion2);
    }

    public Distribucion2 find(Long id) {
        TypedQuery<Distribucion2> query = entityManager.createQuery("SELECT d FROM Distribucion2 d WHERE d.distribucion2Id = :distribucion2Id", Distribucion2.class);
        query.setParameter("distribucion2Id", id);
        Distribucion2 distribucion2 = query.getSingleResult();
        return distribucion2;
    }

    @Override
    public List<Distribucion2> all() {
        return entityManager.createQuery("SELECT d FROM Distribucion2 d", Distribucion2.class).getResultList();
    }

}
