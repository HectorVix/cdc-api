/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.RangosDao;
import cdc.com.api.modelo.Rangos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class RangosDaoImpl implements RangosDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Rangos rangos) {
        entityManager.persist(rangos);
    }

    public void update(Rangos rangos) {
        entityManager.merge(rangos);
    }

    public void delete(Long id) {
        Rangos rangos = find(id);
        entityManager.remove(rangos);
    }

    public Rangos find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Rangos> all() {
        return entityManager.createQuery("SELECT r FROM Rangos r", Rangos.class).getResultList();
    }

}
