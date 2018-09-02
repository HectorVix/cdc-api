/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.LocalizacionDao;
import cdc.com.api.modelo.Localizacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class LocalizacionDaoImpl implements LocalizacionDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Localizacion localizacion) {
        entityManager.persist(localizacion);
    }

    public void update(Localizacion localizacion) {
        entityManager.merge(localizacion);
    }

    public void delete(Long id) {
        Localizacion localizacion = find(id);
        entityManager.remove(localizacion);
    }

    public Localizacion find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Localizacion> all() {
        return entityManager.createQuery("SELECT l.codigole FROM Localizacion l", Localizacion.class).getResultList();
    }

    public List<Localizacion> buscarLocalizacion(String codigole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
