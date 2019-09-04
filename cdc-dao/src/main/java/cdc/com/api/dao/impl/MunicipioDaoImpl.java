/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.MunicipioDao;
import cdc.com.api.modelo.Fuente;
import cdc.com.api.modelo.Municipio;
import cdc.com.api.modelo.Subnacion;
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
public class MunicipioDaoImpl implements MunicipioDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public List<Municipio> all(Subnacion subnacion) {
        TypedQuery<Municipio> query = entityManager.createQuery("SELECT m FROM Municipio m WHERE m.sUBNACIONsubnacionid =:subnacion", Municipio.class);
        query.setParameter("subnacion", subnacion);
        return query.getResultList();
    }

}
