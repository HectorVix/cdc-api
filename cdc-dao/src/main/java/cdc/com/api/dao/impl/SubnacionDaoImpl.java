/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.SubnacionDao;
import cdc.com.api.modelo.Subnacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class SubnacionDaoImpl implements SubnacionDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public List<Subnacion> all() {
        return entityManager.createQuery("SELECT s FROM Subnacion s", Subnacion.class).getResultList();
    }

}
