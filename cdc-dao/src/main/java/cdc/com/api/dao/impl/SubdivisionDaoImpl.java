/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.SubdivisionDao;
import cdc.com.api.modelo.Subdivision;
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
public class SubdivisionDaoImpl implements SubdivisionDao {
    
    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;
    
    public void save(Subdivision subdivision) {
        entityManager.persist(subdivision);
    }
    
    public void update(Subdivision subdivision) {
        entityManager.merge(subdivision);
    }
    
    public void delete(Long id) {
        Subdivision subdivision = find(id);
        entityManager.remove(subdivision);
    }
    
    public Subdivision find(Long id) {
        TypedQuery<Subdivision> query = entityManager.createQuery("SELECT s FROM Subdivision s WHERE s.subdivisionId = :subdivisionId", Subdivision.class);
        query.setParameter("subdivisionId", id);
        Subdivision subdivision = query.getSingleResult();
        return subdivision;
    }
    
    public List<Subdivision> all() {
        return entityManager.createQuery("SELECT s FROM Subdivision s", Subdivision.class).getResultList();
    }
    
}
