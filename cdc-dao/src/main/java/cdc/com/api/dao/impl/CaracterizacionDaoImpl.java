/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.CaracterizacionDao;
import cdc.com.api.modelo.Caracterizacion;
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
public class CaracterizacionDaoImpl implements CaracterizacionDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Caracterizacion caracterizacion) {
        entityManager.persist(caracterizacion);
    }

    public void update(Caracterizacion caracterizacion) {
        entityManager.merge(caracterizacion);
    }

    public void delete(Long id) {
        Caracterizacion caracterizacion = find(id);
        entityManager.remove(caracterizacion);
    }

    public Caracterizacion find(Long id) {
        TypedQuery<Caracterizacion> query = entityManager.createQuery("SELECT c FROM Caracterizacion c WHERE c.caracterizacionId = :caracterizacionId", Caracterizacion.class);
        query.setParameter("caracterizacionId", id);
        Caracterizacion caracterizacion = query.getSingleResult();
        return caracterizacion;
    }

    @Override
    public List<Caracterizacion> all() {
        return entityManager.createQuery("SELECT c FROM Caracterizacion c", Caracterizacion.class).getResultList();

    }

    public List<Caracterizacion> buscarCaracterizacion(String codigoe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean findCaracterizacion(String codigoe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
