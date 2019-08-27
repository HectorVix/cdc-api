/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.NacionDao;
import cdc.com.api.modelo.Nacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class NacionDaoImpl implements NacionDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public List<Nacion> all() {
        return entityManager.createQuery("SELECT n FROM Nacion n", Nacion.class).getResultList();
    }

}
