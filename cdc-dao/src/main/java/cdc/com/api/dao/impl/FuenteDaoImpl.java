/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.FuenteDao;
import cdc.com.api.modelo.Area;
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

    public int save(Fuente fuente) {
        entityManager.persist(fuente);
        entityManager.flush();
        return fuente.getFuenteId();
    }

    public void update(Fuente fuente) {
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

    public List<Fuente> buscarFuente(String codfuente, String cita) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean findFuente(String codfuente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
