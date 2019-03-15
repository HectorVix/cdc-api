/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.FuenteDao;
//import cdc.com.api.modelo.Area;
import cdc.com.api.modelo.Fuente;
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
public class FuenteDaoImpl implements FuenteDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;
    private int fuente_id;

    public int save(Fuente fuente) {
        fuente.setCodfuente(fuente.getCodfuente().replaceAll("\\s", ""));
        entityManager.persist(fuente);
        entityManager.flush();
        return fuente.getFuenteId();
    }

    public void update(Fuente fuente) {
        fuente.setCodfuente(fuente.getCodfuente().replaceAll("\\s", ""));
        entityManager.merge(fuente);
    }

    public void delete(Long id) {
        Fuente fuente = find(id);
        entityManager.remove(fuente);
    }

    public Fuente find(Long id) {
        TypedQuery<Fuente> query = entityManager.createQuery("SELECT f FROM Fuente f WHERE f.fuenteId = :fuenteId", Fuente.class);
        query.setParameter("fuenteId", id);
        Fuente fuente = query.getSingleResult();
        return fuente;
    }

    @Override
    public List<Fuente> all() {
        return entityManager.createQuery("SELECT f FROM Fuente f", Fuente.class).getResultList();

    }

    public List<Fuente> buscarFuente(
            String naturalezadocumento,
            String codfuente,
            String cita,
            String archivado,
            String clave) {
        codfuente = codfuente.replaceAll("\\s", "");
        TypedQuery<Fuente> query = entityManager.createQuery("SELECT f FROM Fuente f"
                + " WHERE (f.naturalezadocumento like '%" + naturalezadocumento + "%'"
                + "OR f.codfuente like '%" + codfuente + "%'"
                + "OR f.cita like '%" + cita + "%'"
                + "OR f.archivado like '%" + archivado + "%'"
                + " OR f.clave like '%" + clave + "%')", Fuente.class);
        return query.getResultList();
    }

    public boolean findFuente(String codfuente) {
        codfuente = codfuente.replaceAll("\\s", "");
        TypedQuery<Fuente> query = entityManager.createQuery("SELECT f FROM Fuente f WHERE f.codfuente = :codfuente", Fuente.class);
        query.setParameter("codfuente", codfuente);
        Fuente fuente = query.getResultList().stream().findFirst().orElse(null);
        if (fuente == null) {
            return false;
        } else {
            fuente_id = fuente.getFuenteId();
            return true;
        }
    }

    public int getFuente_id() {
        return fuente_id;
    }

}
