/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.LocalizacionDao;
import cdc.com.api.modelo.Localizacion;
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
public class LocalizacionDaoImpl implements LocalizacionDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;
    private int rastreo_id;

    public int save(Localizacion localizacion) {
        entityManager.persist(localizacion);
        entityManager.flush();
        return localizacion.getLocalizacionId();
    }

    public void update(Localizacion localizacion) {
        entityManager.merge(localizacion);
    }

    public List<Localizacion> buscarLocalizacion(String codigole) {
        System.out.print("codigole:" + codigole);
        TypedQuery<Localizacion> query = entityManager.createQuery("SELECT l FROM Localizacion l"
                + " WHERE (l.codigole like '%" + codigole + "%')", Localizacion.class);
        return query.getResultList();
    }

    public boolean findRastreo(String codigoe) {
        TypedQuery<Rastreo> query = entityManager.createQuery("SELECT r FROM Rastreo r WHERE r.codigoe = :codigoe", Rastreo.class);
        query.setParameter("codigoe", codigoe);
        Rastreo re = query.getSingleResult();
        if (re == null) {
            return false;
        } else {
            rastreo_id = re.getRastreoId();
            return true;
        }
    }

    public int getRastreo_id() {
        return rastreo_id;
    }
}
