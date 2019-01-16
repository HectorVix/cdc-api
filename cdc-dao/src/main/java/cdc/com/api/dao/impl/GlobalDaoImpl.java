/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.GlobalDao;
import cdc.com.api.modelo.Global;
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
public class GlobalDaoImpl implements GlobalDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Global global) {
        entityManager.persist(global);
    }

    public void update(Global global) {
        entityManager.merge(global);
    }

    public void delete(Long id) {
        Global global = find(id);
        entityManager.remove(global);
    }

    public Global find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Global> all() {
        return entityManager.createQuery("SELECT g FROM Global g", Global.class).getResultList();

    }

    public List<Global> buscarGlobal(String codigoe, String nombreg, String descrielem) {
        TypedQuery<Global> query = entityManager.createQuery("SELECT g FROM Global g"
                + " WHERE (g.codigoe like '%" + codigoe + "%'"
                + "OR g.nombreg like '%" + nombreg + "%'"
                + " OR g.descrielem like '%" + descrielem + "%')", Global.class);
        return query.getResultList();
    }

}
