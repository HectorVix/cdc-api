/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.MacsitioDao;
import cdc.com.api.modelo.Macsitio;
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
public class MacsitioDaoImpl implements MacsitioDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Macsitio macsitio) {
        entityManager.persist(macsitio);
    }

    public void update(Macsitio macsitio) {
        entityManager.merge(macsitio);
    }

    public void delete(Long id) {
        Macsitio macsitio = find(id);
        entityManager.remove(macsitio);
    }

    public Macsitio find(Long id) {
        TypedQuery<Macsitio> query = entityManager.createQuery("SELECT m FROM Macsitio m WHERE m.macsitioId = :macsitioId", Macsitio.class);
        query.setParameter("macsitioId", id);
        Macsitio macsitio = query.getSingleResult();
        return macsitio;
    }

    @Override
    public List<Macsitio> all() {
        return entityManager.createQuery("SELECT m FROM Macsitio m", Macsitio.class).getResultList();
    }

}
