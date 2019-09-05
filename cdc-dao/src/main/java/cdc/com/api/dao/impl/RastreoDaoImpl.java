/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.RastreoDao;
import cdc.com.api.modelo.Global;
import cdc.com.api.modelo.Rastreo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import modelo.datos.representativos.IdentificadoresLE;
import modelo.datos.representativos.StatusGlobal;
import modelo.datos.representativos.StatusNacional;
import modelo.datos.representativos.StatusSubnacional;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class RastreoDaoImpl implements RastreoDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Rastreo rastreo) {
        rastreo.setCodigoe(rastreo.getCodigoe().replaceAll("\\s", ""));
        entityManager.persist(rastreo);
    }

    public void update(Rastreo rastreo) {
        rastreo.setCodigoe(rastreo.getCodigoe().replaceAll("\\s", ""));
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
        codigoe = codigoe.replaceAll("\\s", "");
        TypedQuery<Rastreo> query = entityManager.createQuery("SELECT r FROM Rastreo r"
                + " WHERE (r.codigoe like '%" + codigoe + "%'"
                + "OR r.subnacion like '%" + subnacion + "%'"
                + "OR r.nombreg like '%" + nombreg + "%'"
                + "OR r.nombren like '%" + nombren + "%'"
                + " OR r.nomcomunn like '%" + nombrecomunnn + "%')", Rastreo.class);
        return query.getResultList();
    }

    public Rastreo buscarRastreo_Codigoe(String codigoe) {
        codigoe = codigoe.replaceAll("\\s", "");
        TypedQuery<Rastreo> query = entityManager.createQuery("SELECT r FROM Rastreo r WHERE r.codigoe = :codigoe", Rastreo.class);
        query.setParameter("codigoe", codigoe);
        Rastreo rastreo = query.getResultList().stream().findFirst().orElse(null);
        return rastreo;
    }

    public StatusGlobal status_Global(String codigoe) {
        codigoe = codigoe.replaceAll("\\s", "");
        String queryStr
                = "SELECT NEW modelo.datos.representativos.StatusGlobal "
                + "(g.nombreg,g.rangog,g.resrg,g.fecharg) "
                + "FROM Global g "
                + "WHERE  g.codigoe = :codigoe";
        TypedQuery<StatusGlobal> query
                = entityManager.createQuery(queryStr, StatusGlobal.class);
        query.setParameter("codigoe", codigoe);
        StatusGlobal statusGlobal = query.getResultList().stream().findFirst().orElse(null);
        return statusGlobal;
    }

    public StatusNacional status_Nacional(String codigoe) {
        codigoe = codigoe.replaceAll("\\s", "");
        String queryStr
                = "SELECT NEW modelo.datos.representativos.StatusNacional "
                + "(n.rangon,n.fecharn,n.nlestim,n.nleprot,n.nabund ) "
                + "FROM Nacional n "
                + "WHERE  n.codigoe = :codigoe";
        TypedQuery<StatusNacional> query
                = entityManager.createQuery(queryStr, StatusNacional.class);
        query.setParameter("codigoe", codigoe);
        StatusNacional statusNacional = query.getSingleResult();
        return statusNacional;
    }

    public StatusSubnacional status_Subnacional(String codigoe, String departamento) {
        codigoe = codigoe.replaceAll("\\s", "");
        String queryStr
                = "SELECT NEW modelo.datos.representativos.StatusSubnacional "
                + "(s.rangos,s.fecharevrs,s.lestims,s.leprots,s.abunds) "
                + "FROM Subnacional s "
                + "WHERE  "
                + "s.subnacion = :departamento "
                + "AND   s.codigoe = :codigoe";
        TypedQuery<StatusSubnacional> query
                = entityManager.createQuery(queryStr, StatusSubnacional.class);
        query.setParameter("departamento", departamento);
        query.setParameter("codigoe", codigoe);
        StatusSubnacional statusSubnacional = query.getSingleResult();
        return statusSubnacional;
    }
}
