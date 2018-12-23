/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.ProteccionDao;
import cdc.com.api.modelo.Proteccion;
import cdc.com.api.servicio.ProteccionService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class ProteccionServiceImpl implements ProteccionService {

    @Inject
    private ProteccionDao proteccionDao;

    public void save(Proteccion proteccion) {
        proteccionDao.save(proteccion);
    }

    public void update(Proteccion proteccion) {
        proteccionDao.update(proteccion);
    }

    public void delete(Long id) {
        proteccionDao.delete(id);
    }

    public Proteccion find(Long id) {
        return proteccionDao.find(id);
    }

    public List<Proteccion> all() {
        return proteccionDao.all();
    }

}
