/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.FamiliaDao;
import cdc.com.api.modelo.Familia;
import cdc.com.api.modelo.Orden;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Héctor Vix
 */
public class FamiliaDaoImpl implements FamiliaDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public List<Familia> buscar_Familia(Orden orden) {
        TypedQuery<Familia> query = entityManager.createQuery("SELECT f FROM Familia f WHERE f.oRDENordenid = :orden ORDER BY f.nombre ASC", Familia.class);
        query.setParameter("orden", orden);
        return query.getResultList();
    }

}
