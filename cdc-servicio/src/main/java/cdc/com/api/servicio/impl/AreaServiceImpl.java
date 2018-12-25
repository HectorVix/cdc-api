/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.AreaDao;
import cdc.com.api.modelo.Area;
import cdc.com.api.servicio.AreaService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class AreaServiceImpl implements AreaService {

    @Inject
    private AreaDao areaDao;

    public int save(Area area) {
        return areaDao.save(area);
    }

    public void update(Area area) {
        areaDao.update(area);
    }

    public void delete(Long id) {
        areaDao.delete(id);
    }

    public Area find(Long id) {
        return areaDao.find(id);
    }

    @Override
    public List<Area> all() {
        return areaDao.all();
    }

    public List<Area> buscarArea(String codigoam, String nombream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean findArea(String codigoam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
