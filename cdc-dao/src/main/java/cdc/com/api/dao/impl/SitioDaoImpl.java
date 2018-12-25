/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.SitioDao;
import cdc.com.api.modelo.Sitio;
import cdc.com.api.modelo.Usuario;
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
public class SitioDaoImpl implements SitioDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public int save(Sitio sitio) {
        entityManager.persist(sitio);
        entityManager.flush();
        return sitio.getSitioId();
    }

    public void update(Sitio sitio) {
        entityManager.merge(sitio);
    }

    public void delete(Long id) {
        Sitio sitio = find(id);
        entityManager.remove(sitio);
    }

    public Sitio find(Long id) {

        TypedQuery<Sitio> query = entityManager.createQuery("SELECT s FROM Sitio s WHERE s.sitioId = :sitioId", Sitio.class);
        query.setParameter("sitioId", id);
        Sitio user = query.getSingleResult();
        return user;
    }

    public boolean find_Sitio(String codsitio, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getSitio_id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sitio> all() {
        return entityManager.createQuery("SELECT s FROM Sitio s", Sitio.class).getResultList();

    }

}
