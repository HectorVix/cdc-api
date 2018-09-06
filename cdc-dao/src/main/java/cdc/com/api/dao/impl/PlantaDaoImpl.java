/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.PlantaDao;
import cdc.com.api.modelo.Planta;
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
public class PlantaDaoImpl implements PlantaDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Planta planta) {
        entityManager.persist(planta);
    }

    public void update(Planta planta) {
        entityManager.merge(planta);
    }

    public void delete(Long id) {
        Planta planta = find(id);
        entityManager.remove(planta);
    }

    public Planta find(Long id) {
        TypedQuery<Planta> query = entityManager.createQuery("SELECT p FROM Planta p WHERE p.plantaId = :plantaId", Planta.class);
        query.setParameter("plantaId", id);
        Planta planta = query.getSingleResult();
        return planta;
    }

    @Override
    public List<Planta> all() {
        return entityManager.createQuery("SELECT p FROM Planta p", Planta.class).getResultList();

    }

    public List<Planta> buscarPlanta(String codigoe, String nombren) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean findPlanta(String codigoe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
