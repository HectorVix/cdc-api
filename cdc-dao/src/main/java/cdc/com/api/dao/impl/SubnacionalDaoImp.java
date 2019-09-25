/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.SubnacionalDao;
import cdc.com.api.modelo.Subnacional;
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
public class SubnacionalDaoImp implements SubnacionalDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Subnacional subnacional) {
        subnacional.setCodigoe(subnacional.getCodigoe().replaceAll("\\s", ""));
        entityManager.persist(subnacional);
    }

    public void update(Subnacional subnacional) {
        subnacional.setCodigoe(subnacional.getCodigoe().replaceAll("\\s", ""));
        entityManager.merge(subnacional);
    }

    public void delete(Long id) {
        Subnacional subnacional = find(id);
        entityManager.remove(subnacional);
    }

    public Subnacional find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Subnacional> all(String rol) {
        TypedQuery<Subnacional> query = null;
        if (rol.equals("Admin")) {
            return entityManager.createQuery("SELECT s FROM Subnacional s", Subnacional.class).getResultList();
        } else {
            query = entityManager.createQuery("SELECT s FROM Subnacional s"
                    + " INNER JOIN Elemento as e"
                    + " ON s.eLEMENTOelementoid.elemento_id=e.elemento_id"
                    + " WHERE e.clase !=:clase ",
                    Subnacional.class);
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

    public List<Subnacional> buscarSubnacional(
            String codigoe,
            String depto,
            String nombres,
            String nombren, String nombrecomunn, String clase, String comunidad,
            String rol) {
        codigoe = codigoe.replaceAll("\\s", "");
        TypedQuery<Subnacional> query = null;
        if (rol.equals("Admin")) {
            return entityManager.createQuery("SELECT s FROM Subnacional s"
                    + " INNER JOIN Elemento as e"
                    + " ON s.eLEMENTOelementoid.elemento_id=e.elemento_id"
                    + " WHERE (s.codigoe like '%" + codigoe + "%'"
                    + " OR e.nombren like '%" + nombren + "%'"
                    + " OR e.nombrecomunn like '%" + nombrecomunn + "%'"
                    + " OR e.clase like '%" + clase + "%'"
                    + " OR e.comunidad like '%" + comunidad + "%')", Subnacional.class).getResultList();
        } else {
            query = entityManager.createQuery("SELECT s FROM Subnacional s"
                    + " INNER JOIN Elemento as e"
                    + " ON s.eLEMENTOelementoid.elemento_id=e.elemento_id"
                    + " WHERE (s.codigoe like '%" + codigoe + "%'"
                    + " OR e.nombren like '%" + nombren + "%'"
                    + " OR e.nombrecomunn like '%" + nombrecomunn + "%'"
                    + " OR e.clase like '%" + clase + "%'"
                    + " OR e.comunidad like '%" + comunidad + "%')"
                    + " AND e.clase !=:clase",
                    Subnacional.class
            );
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
