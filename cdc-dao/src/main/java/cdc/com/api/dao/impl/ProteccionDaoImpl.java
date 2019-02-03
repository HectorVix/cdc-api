/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.ProteccionDao;
import cdc.com.api.modelo.Localizacion;
import cdc.com.api.modelo.Proteccion;
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
public class ProteccionDaoImpl implements ProteccionDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Proteccion proteccion) {

        entityManager.persist(proteccion);
    }

    public void update(Proteccion proteccion) {
        entityManager.merge(proteccion);
    }

    public void delete(Long id) {
        Proteccion proteccion = find(id);
        entityManager.remove(proteccion);
    }

    public Proteccion find(Long id) {
        TypedQuery<Proteccion> query = entityManager.createQuery("SELECT p FROM Proteccion p WHERE p.proteccionId = :proteccionId", Proteccion.class);
        query.setParameter("proteccionId", id);
        Proteccion proteccion = query.getSingleResult();
        return proteccion;
    }

    public List<Proteccion> buscarProteccion_LocalizacionId(Localizacion localizacion) {
        TypedQuery<Proteccion> query = entityManager.createQuery("SELECT p FROM Proteccion p WHERE p.lOCALIZACIONlocalizacionid = :localizacion", Proteccion.class);
        query.setParameter("localizacion", localizacion);
        return query.getResultList();
    }

}
