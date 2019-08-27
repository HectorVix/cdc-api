/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.RangogDao;
import cdc.com.api.modelo.Rangog;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class RangogDaoImpl implements RangogDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Rangog rangog) {
        entityManager.persist(rangog);
    }

    public void update(Rangog rangog) {
        entityManager.merge(rangog);
    }

    public void delete(Long id) {
        Rangog rangog = find(id);
        entityManager.remove(rangog);
    }

    public Rangog find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Rangog> all() {
       return entityManager.createQuery("SELECT r FROM Rangog r", Rangog.class).getResultList(); 
    }

}
