/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.MunicipioDao;
import cdc.com.api.modelo.Municipio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class MunicipioDaoImpl implements MunicipioDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public List<Municipio> all() {
        return entityManager.createQuery("SELECT m FROM Municipio m", Municipio.class).getResultList();
    }

}
