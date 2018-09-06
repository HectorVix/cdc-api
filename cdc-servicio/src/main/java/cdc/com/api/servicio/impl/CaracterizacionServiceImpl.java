/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.CaracterizacionDao;
import cdc.com.api.modelo.Caracterizacion;
import cdc.com.api.servicio.CaracterizacionService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class CaracterizacionServiceImpl implements CaracterizacionService {

    @Inject
    private CaracterizacionDao caracterizacionDao;

    public void save(Caracterizacion caracterizacion) {
        caracterizacionDao.save(caracterizacion);
    }

    public void update(Caracterizacion caracterizacion) {
        caracterizacionDao.update(caracterizacion);
    }

    public void delete(Long id) {
        caracterizacionDao.delete(id);
    }

    public Caracterizacion find(Long id) {
        return caracterizacionDao.find(id);
    }

    @Override
    public List<Caracterizacion> all() {
        return caracterizacionDao.all();
    }

    public List<Caracterizacion> buscarCaracterizacion(String codigoe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean findCaracterizacion(String codigoe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
