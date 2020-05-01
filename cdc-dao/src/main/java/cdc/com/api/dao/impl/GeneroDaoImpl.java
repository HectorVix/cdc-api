/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.GeneroDao;
import cdc.com.api.modelo.Familia;
import cdc.com.api.modelo.Genero;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Héctor Vix
 */
public class GeneroDaoImpl implements GeneroDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public List<Genero> buscar_Genero(Familia familia) {
        TypedQuery<Genero> query = entityManager.createQuery("SELECT g FROM Genero g WHERE g.fAMILIAfamiliaid = :familia ORDER BY g.nombre ASC", Genero.class);
        query.setParameter("familia", familia);
        return query.getResultList();
    }

}
