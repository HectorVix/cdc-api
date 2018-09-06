/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.ObservacionesDao;
import cdc.com.api.modelo.Observaciones;
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
public class ObservacionesDaoImpl implements ObservacionesDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Observaciones observaciones) {
        entityManager.persist(observaciones);
    }

    public void update(Observaciones observaciones) {
        entityManager.merge(observaciones);
    }

    public void delete(Long id) {
        Observaciones observaciones = find(id);
        entityManager.remove(observaciones);
    }

    public Observaciones find(Long id) {
        TypedQuery<Observaciones> query = entityManager.createQuery("SELECT o FROM Observaciones o WHERE o.observacionesId = :observacionesId", Observaciones.class);
        query.setParameter("observacionesId", id);
        Observaciones observaciones = query.getSingleResult();
        return observaciones;
    }

    @Override
    public List<Observaciones> all() {
        return entityManager.createQuery("SELECT o FROM Observaciones o", Observaciones.class).getResultList();

    }

    public List<Observaciones> buscarObservaciones(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean findObservaciones(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
