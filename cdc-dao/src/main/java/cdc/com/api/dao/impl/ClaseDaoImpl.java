/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.ClaseDao;
import cdc.com.api.modelo.Clase;
import cdc.com.api.modelo.Phylum;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Héctor Vix
 */
public class ClaseDaoImpl implements ClaseDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public List<Clase> buscar_Clase(Phylum phylum) {
        TypedQuery<Clase> query = entityManager.createQuery("SELECT c FROM Clase c WHERE c.pHYLUMphylumid = :phylum ORDER BY c.nombre ASC", Clase.class);
        query.setParameter("phylum", phylum);
        return query.getResultList();
    }

}
