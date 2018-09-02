/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.RastreoDao;
import cdc.com.api.modelo.Rastreo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class RastreoDaoImpl implements RastreoDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Rastreo rastreo) {
        entityManager.persist(rastreo);
    }

    public void update(Rastreo rastreo) {
        entityManager.merge(rastreo);
    }

    public void delete(Long id) {
        Rastreo rastreo = find(id);
        entityManager.remove(rastreo);
    }

    public Rastreo find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rastreo> all() {
        return entityManager.createQuery("SELECT r FROM Rastreo r", Rastreo.class).getResultList();
    }

    public List<Rastreo> buscarRastreo(String codigoe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
