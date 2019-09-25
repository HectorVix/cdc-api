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

    public List<Nacional> all(String rol) {
        TypedQuery<Nacional> query = null;
        if (rol.equals("Admin")) {
            return entityManager.createQuery("SELECT n FROM Nacional n", Nacional.class).getResultList();
        } else {
            query = entityManager.createQuery("SELECT n FROM Nacional n"
                    + " INNER JOIN Elemento as e"
                    + " ON n.eLEMENTOelementoid.elemento_id=e.elemento_id"
                    + " WHERE e.clase !=:clase ",
                    Nacional.class);
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

    public List<Nacional> buscarNacional(String codigoe, String nombren, String nombrecomunn, String clase, String comunidad,
            String rol) {
        codigoe = codigoe.replaceAll("\\s", "");
        TypedQuery<Nacional> query = null;
        if (rol.equals("Admin")) {
            return entityManager.createQuery("SELECT n FROM Nacional n"
                    + " INNER JOIN Elemento as e"
                    + " ON n.eLEMENTOelementoid.elemento_id=e.elemento_id"
                    + " WHERE (n.codigoe like '%" + codigoe + "%'"
                    + " OR e.nombren like '%" + nombren + "%'"
                    + " OR e.nombrecomunn like '%" + nombrecomunn + "%'"
                    + " OR e.clase like '%" + clase + "%'"
                    + " OR e.comunidad like '%" + comunidad + "%')", Nacional.class).getResultList();

        } else {
            query = entityManager.createQuery("SELECT n FROM Nacional n"
                    + " INNER JOIN Elemento as e"
                    + " ON n.eLEMENTOelementoid.elemento_id=e.elemento_id"
                    + " WHERE (n.codigoe like '%" + codigoe + "%'"
                    + " OR e.nombren like '%" + nombren + "%'"
                    + " OR e.nombrecomunn like '%" + nombrecomunn + "%'"
                    + " OR e.clase like '%" + clase + "%'"
                    + " OR e.comunidad like '%" + comunidad + "%')"
                    + " AND e.clase !=:clase",
                    Nacional.class);
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
