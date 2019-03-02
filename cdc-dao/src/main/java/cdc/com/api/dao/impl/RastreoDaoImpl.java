/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.RastreoDao;
import cdc.com.api.modelo.Rastreo;
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
public class RastreoDaoImpl implements RastreoDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Rastreo rastreo) {
        entityManager.persist(rastreo);
    }

    public void update(Rastreo rastreo) {
        entityManager.merge(rastreo);
    }

    public void delete(Long id) {
        Rastreo rastreo = find(id);
        entityManager.remove(rastreo);
    }

    public Rastreo find(Long id) {
        TypedQuery<Rastreo> query = entityManager.createQuery("SELECT r FROM Rastreo r WHERE r.rastreoId = :rastreoId", Rastreo.class);
        query.setParameter("rastreoId", id);
        Rastreo rastreo = query.getSingleResult();
        return rastreo;
    }

    @Override
    public List<Rastreo> all() {
        return entityManager.createQuery("SELECT r FROM Rastreo r", Rastreo.class).getResultList();
    }

    public List<Rastreo> buscarRastreo(String codigoe, String subnacion, String nombreg, String nombren, String nombrecomunnn) {
        System.out.print("codigoe:" + codigoe);
        System.out.print("subnacion:" + subnacion);
        System.out.print("nombreg:" + nombreg);
        System.out.print("nombrecomunnn:" + nombrecomunnn);
        TypedQuery<Rastreo> query = entityManager.createQuery("SELECT r FROM Rastreo r"
                + " WHERE (r.codigoe like '%" + codigoe + "%'"
                + "OR r.subnacion like '%" + subnacion + "%'"
                + "OR r.nombreg like '%" + nombreg + "%'"
                + "OR r.nombren like '%" + nombren + "%'"
                + " OR r.nomcomunn like '%" + nombrecomunnn + "%')", Rastreo.class);
        return query.getResultList();
    }

    public Rastreo buscarRastreo_Codigoe(String codigoe) {
        TypedQuery<Rastreo> query = entityManager.createQuery("SELECT r FROM Rastreo r WHERE r.codigoe = :codigoe", Rastreo.class);
        query.setParameter("codigoe", codigoe);
        Rastreo rastreo = query.getSingleResult();
        return rastreo;
    }
}
