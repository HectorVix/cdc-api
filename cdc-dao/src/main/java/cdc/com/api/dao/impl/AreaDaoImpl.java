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
    private int area_id;

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

    public List<Area> buscarArea(String codigoam,
            String nombream,
            String sinam,
            String codsitio,
            String nomsitio,
            String nacion, String subnacion, String subdivision) {
        TypedQuery<Area> query = entityManager.createQuery("SELECT a FROM Area a"
                + " WHERE (a.codigoam like '%" + codigoam + "%'"
                + "OR a.nombream like '%" + nombream + "%'"
                + "OR a.sinam like '%" + sinam + "%'"
                + "OR a.codsitio like '%" + codsitio + "%'"
                + "OR a.nomsitio like '%" + nomsitio + "%'"
                + "OR a.nacion like '%" + nacion + "%'"
                + "OR a.subnacion like '%" + subnacion + "%'"
                + " OR a.subdivision like '%" + subdivision + "%')", Area.class);
        return query.getResultList();
    }

    public boolean findArea(String codigoam) {
        codigoam = codigoam.replaceAll("\\s", "");
        TypedQuery<Area> query = entityManager.createQuery("SELECT a FROM Area a WHERE a.codigoam = :codigoam", Area.class);
        query.setParameter("codigoam", codigoam);
        Area area = query.getResultList().stream().findFirst().orElse(null);
        if (area == null) {
            return false;
        } else {
            area_id = area.getAreaId();
            return true;
        }
    }

    public int getArea_Id() {
        return area_id;
    }

}
