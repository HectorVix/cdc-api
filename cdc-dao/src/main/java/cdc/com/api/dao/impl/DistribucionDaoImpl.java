/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.DistribucionDao;
import cdc.com.api.modelo.Distribucion;
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
public class DistribucionDaoImpl implements DistribucionDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Distribucion distribucion) {
        entityManager.persist(distribucion);
    }

    public void update(Distribucion distribucion) {
        entityManager.merge(distribucion);
    }

    public void delete(Long id) {
        Distribucion distribucion = find(id);
        entityManager.remove(distribucion);
    }

    public Distribucion find(Long id) {
        TypedQuery<Distribucion> query = entityManager.createQuery("SELECT d FROM Distribucion d WHERE d.distribucionId = :distribucionId", Distribucion.class);
        query.setParameter("distribucionId", id);
        Distribucion distribucion = query.getSingleResult();
        return distribucion;
    }
@Override
    public List<Distribucion> all() {
       return entityManager.createQuery("SELECT d FROM Distribucion d", Distribucion.class).getResultList();
    }

}
