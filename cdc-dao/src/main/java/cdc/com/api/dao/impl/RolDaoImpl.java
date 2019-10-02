/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.RolDao;
import cdc.com.api.modelo.Rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class RolDaoImpl implements RolDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public List<Rol> all() {
        return entityManager.createQuery("SELECT r FROM Rol r", Rol.class).getResultList();
    }
}
