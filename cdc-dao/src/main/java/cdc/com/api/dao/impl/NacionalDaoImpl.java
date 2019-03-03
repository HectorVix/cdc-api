/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.NacionalDao;
import cdc.com.api.modelo.Nacional;
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
public class NacionalDaoImpl implements NacionalDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Nacional nacional) {
        nacional.setCodigoe(nacional.getCodigoe().replaceAll("\\s", ""));
        entityManager.persist(nacional);
    }

    public void update(Nacional nacional) {
        nacional.setCodigoe(nacional.getCodigoe().replaceAll("\\s", ""));
        entityManager.merge(nacional);
    }

    public void delete(Long id) {
        Nacional nacional = find(id);
        entityManager.remove(nacional);
    }

    public Nacional find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Nacional> all() {
        return entityManager.createQuery("SELECT n FROM Nacional n", Nacional.class).getResultList();

    }

    public List<Nacional> buscarNacional(String codigoe, String nombren, String nacion) {
        codigoe = codigoe.replaceAll("\\s", "");
        TypedQuery<Nacional> query = entityManager.createQuery("SELECT n FROM Nacional n"
                + " WHERE (n.codigoe like '%" + codigoe + "%'"
                + "OR n.nombren like '%" + nombren + "%'"
                + " OR n.nacion like '%" + nacion + "%')", Nacional.class);
        return query.getResultList();
    }
}
