/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.JerarquizacionDao;
import cdc.com.api.modelo.Jerarquizacion;
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
public class JerarquizacionDaoImpl implements JerarquizacionDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Jerarquizacion jerarquizacion) {
        entityManager.persist(jerarquizacion);
        entityManager.flush();
        
        System.out.println("Id generado:"+jerarquizacion.getJerarquizacionId());
     /*   TypedQuery query = entityManager.createQuery("INSERT INTO `cdc`.`jerarquizacion`(`codigoe`,`ELEMENTO_elemento_id`)\n"
                + "VALUES('" + jerarquizacion.getCodigoe() + "'," + jerarquizacion.getELEMENTOelementoid().getElementoId() + ");\n"
                + " SELECT DISTINCT LAST_INSERT_ID() FROM jerarquizacion ;", Jerarquizacion.class);*/

        //   jerarquizacion = query.getSingleResult();
    }

    public void update(Jerarquizacion jerarquizacion) {
        entityManager.merge(jerarquizacion);
    }

    public void delete(Long id) {
        Jerarquizacion jerarquizacion = find(id);
        entityManager.remove(jerarquizacion);
    }

    public Jerarquizacion find(Long id) {
        TypedQuery<Jerarquizacion> query = entityManager.createQuery("SELECT j FROM Jerarquizacion j WHERE j.jerarquizacionId = :jerarquizacionId", Jerarquizacion.class);
        query.setParameter("jerarquizacionId", id);
        Jerarquizacion jerarquizacion = query.getSingleResult();
        return jerarquizacion;
    }

    @Override
    public List<Jerarquizacion> all() {
        return entityManager.createQuery("SELECT j FROM Jerarquizacion j", Jerarquizacion.class).getResultList();
    }

    public List<Jerarquizacion> buscarJerarquia(String codigoe) {
        System.out.print("codigo:" + codigoe);
        TypedQuery<Jerarquizacion> query = entityManager.createQuery("SELECT j FROM Jerarquizacion h"
                + " WHERE (j.codigoe like '%" + codigoe + "%')", Jerarquizacion.class);
        return query.getResultList();
    }

}
