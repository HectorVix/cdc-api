/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.RangonDao;
import cdc.com.api.modelo.Rangon;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class RangonDaoImpl implements RangonDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Rangon rangon) {
        entityManager.persist(rangon);
    }

    public void update(Rangon rangon) {
        entityManager.merge(rangon);
    }

    public void delete(Long id) {
        Rangon rangon = find(id);
        entityManager.remove(rangon);
    }

    public Rangon find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Rangon> all() {
        return entityManager.createQuery("SELECT r FROM Rangon r", Rangon.class).getResultList();
    }

}
