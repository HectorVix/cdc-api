/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.OrdenDao;
import cdc.com.api.modelo.Clase;
import cdc.com.api.modelo.Orden;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Héctor Vix
 */
public class OrdenDaoImpl implements OrdenDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public List<Orden> buscar_Orden(Clase clase) {
        TypedQuery<Orden> query = entityManager.createQuery("SELECT o FROM Orden o WHERE o.cLASEclaseid = :clase ORDER BY o.nombre ASC", Orden.class);
        query.setParameter("clase", clase);
        return query.getResultList();
    }

}
