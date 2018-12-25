/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.AreaDao;
import cdc.com.api.modelo.Area;
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
public class AreaDaoImpl implements AreaDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public int save(Area area) {
        entityManager.persist(area);
        entityManager.flush();
        return area.getAreaId();
    }

    public void update(Area area) {
        entityManager.merge(area);
    }

    public void delete(Long id) {
        Area area = find(id);
        entityManager.remove(area);
    }

    public Area find(Long id) {
        TypedQuery<Area> query = entityManager.createQuery("SELECT a FROM Area a WHERE a.areaId = :areaId", Area.class);
        query.setParameter("areaId", id);
        Area area = query.getSingleResult();
        return area;
    }

    @Override
    public List<Area> all() {
        return entityManager.createQuery("SELECT a FROM Area a", Area.class).getResultList();
    }

    public List<Area> buscarArea(String codigoam, String nombream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean findArea(String codigoam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
