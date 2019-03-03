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

    public int save(Planta planta) {
        planta.setCodigoe(planta.getCodigoe().replaceAll("\\s", ""));
        entityManager.persist(planta);
        entityManager.flush();
        return planta.getPlantaId();
    }

    public void update(Planta planta) {
        planta.setCodigoe(planta.getCodigoe().replaceAll("\\s", ""));
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

    public boolean findPlanta(String codigoe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Planta> buscarPlanta(String codigoe, String nacion, String nombren, String nomcomunn) {
        codigoe = codigoe.replaceAll("\\s", "");
        TypedQuery<Planta> query = entityManager.createQuery("SELECT p FROM Planta p"
                + " WHERE (p.codigoe like '%" + codigoe + "%'"
                + "OR p.nacion like '%" + nacion + "%'"
                + "OR p.nombren like '%" + nombren + "%'"
                + " OR p.nomcomunn like '%" + nomcomunn + "%')", Planta.class);
        return query.getResultList();
    }
}
