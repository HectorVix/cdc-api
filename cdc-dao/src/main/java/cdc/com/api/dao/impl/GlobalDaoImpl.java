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
        global.setCodigoe(global.getCodigoe().replaceAll("\\s", ""));
        entityManager.persist(global);
    }

    public void update(Global global) {
        global.setCodigoe(global.getCodigoe().replaceAll("\\s", ""));
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
    public List<Global> all(String rol) {
        // return entityManager.createQuery("SELECT g FROM Global g", Global.class).getResultList();
        TypedQuery<Global> query = null;
        if (rol.equals("Admin")) {
            return entityManager.createQuery("SELECT g FROM Global g", Global.class).getResultList();
        } else {
            query = entityManager.createQuery("SELECT g FROM Global g"
                    + " INNER JOIN Elemento as e"
                    + " ON g.eLEMENTOelementoid.elemento_id=e.elemento_id"
                    + " WHERE e.clase !=:clase ",
                    Global.class);
            if (rol.equals("Botanica")) {
                query.setParameter("clase", "A");
                return query.getResultList();
            }
            if (rol.equals("Zoologia")) {
                query.setParameter("clase", "P");
                return query.getResultList();
            }
            return null;
        }
    }

    public List<Global> buscarGlobal(String codigoe, String nombreg, String descrielem,
            String rol) {
        codigoe = codigoe.replaceAll("\\s", "");
        /* TypedQuery<Global> query = entityManager.createQuery("SELECT g FROM Global g"
                + " WHERE (g.codigoe like '%" + codigoe + "%'"
                + "OR g.nombreg like '%" + nombreg + "%'"
                + " OR g.descrielem like '%" + descrielem + "%')", Global.class);
        return query.getResultList();

         */
        TypedQuery<Global> query = null;
        if (rol.equals("Admin")) {
            return entityManager.createQuery("SELECT g FROM Global g"
                    + " INNER JOIN Elemento as e"
                    + " ON g.eLEMENTOelementoid.elemento_id=e.elemento_id"
                    + " WHERE (g.codigoe like '%" + codigoe + "%'"
                    + " OR g.nombreg like '%" + nombreg + "%'"
                    + " OR g.descrielem like '%" + descrielem + "%')", Global.class).getResultList();

        } else {
            query = entityManager.createQuery("SELECT g FROM Global g"
                    + " INNER JOIN Elemento as e"
                    + " ON g.eLEMENTOelementoid.elemento_id=e.elemento_id"
                    + " WHERE (g.codigoe like '%" + codigoe + "%'"
                    + " OR g.nombreg like '%" + nombreg + "%'"
                    + " OR g.descrielem like '%" + descrielem + "%')"
                    + " AND e.clase !=:clase",
                    Global.class);
            if (rol.equals("Botanica")) {
                query.setParameter("clase", "A");
                return query.getResultList();
            }
            if (rol.equals("Zoologia")) {
                query.setParameter("clase", "P");
                return query.getResultList();
            }
            return null;
        }
    }

}
