/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.PhylumDao;
import cdc.com.api.modelo.Phylum;
import cdc.com.api.modelo.Reino;
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
public class PhylumDaoImpl implements PhylumDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public List<Phylum> buscar_Phylum(Reino reino) {
        TypedQuery<Phylum> query = entityManager.createQuery("SELECT p FROM Phylum p WHERE p.rEINOreinoid = :reino ORDER BY p.nombre ASC", Phylum.class);
        query.setParameter("reino", reino);
        return query.getResultList();
    }

}
