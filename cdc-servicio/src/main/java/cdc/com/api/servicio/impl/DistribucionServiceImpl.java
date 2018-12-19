/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.DistribucionDao;
import cdc.com.api.modelo.Distribucion;
import cdc.com.api.servicio.DistribucionService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class DistribucionServiceImpl implements DistribucionService {

    @Inject
    private DistribucionDao distribucionDao;

    public void save(Distribucion distribucion) {
        distribucionDao.save(distribucion);
    }

    public void update(Distribucion distribucion) {
        distribucionDao.update(distribucion);
    }

    public void delete(Long id) {
        distribucionDao.delete(id);
    }

    public Distribucion find(Long id) {
        return distribucionDao.find(id);
    }

    public List<Distribucion> all() {
        return distribucionDao.all();
    }

}
