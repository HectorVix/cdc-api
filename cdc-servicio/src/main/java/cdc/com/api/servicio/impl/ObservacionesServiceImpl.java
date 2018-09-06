/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.ObservacionesDao;
import cdc.com.api.modelo.Observaciones;
import cdc.com.api.servicio.ObservacionesService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class ObservacionesServiceImpl implements ObservacionesService {

    @Inject
    private ObservacionesDao observacionesDao;

    public void save(Observaciones observaciones) {
        observacionesDao.save(observaciones);
    }

    public void update(Observaciones observaciones) {
        observacionesDao.update(observaciones);
    }

    public void delete(Long id) {
        observacionesDao.delete(id);
    }

    public Observaciones find(Long id) {
        return observacionesDao.find(id);
    }

    @Override
    public List<Observaciones> all() {
        return observacionesDao.all();
    }

    public List<Observaciones> buscarObservaciones(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean findObservaciones(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
