/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.DispersionDao;
import cdc.com.api.modelo.Dispersion;
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
public class DispersionDaoImpl implements DispersionDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Dispersion dispersion) {
        entityManager.persist(dispersion);
    }

    public void update(Dispersion dispersion) {
        entityManager.merge(dispersion);
    }

    public void delete(Long id) {
        Dispersion dispersion = find(id);
        entityManager.remove(dispersion);
    }

    public Dispersion find(Long id) {
        TypedQuery<Dispersion> query = entityManager.createQuery("SELECT d FROM Dispersion d WHERE d.dispersionId = :dispersionId", Dispersion.class);
        query.setParameter("dispersionId", id);
        Dispersion dispersion = query.getSingleResult();
        return dispersion;
    }

    @Override
    public List<Dispersion> all() {
        return entityManager.createQuery("SELECT d FROM Dispersion d", Dispersion.class).getResultList();
    }

}
