/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.EspecieDao;
import cdc.com.api.modelo.Especie;
import cdc.com.api.modelo.Genero;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Héctor Vix
 */
public class EspecieDaoImpl implements EspecieDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public List<Especie> buscar_Especie(Genero genero) {
        TypedQuery<Especie> query = entityManager.createQuery("SELECT e FROM Especie e WHERE e.gENEROgeneroid = :genero ORDER BY e.nombre ASC", Especie.class);
        query.setParameter("genero", genero);
        return query.getResultList();
    }

}
