/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.ReinoDao;
import cdc.com.api.modelo.Reino;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author Héctor Vix
 */
@Stateless
public class ReinoDaoImpl implements ReinoDao {
    
    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public List<Reino> buscar_Reino() {
        return entityManager.createQuery("SELECT r FROM Reino r ORDER BY r.nombre ASC", Reino.class).getResultList();
    }
}
