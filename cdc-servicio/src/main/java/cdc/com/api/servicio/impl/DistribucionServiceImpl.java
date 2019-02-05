/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.DistribucionDao;
import cdc.com.api.modelo.Distribucion;
import cdc.com.api.modelo.Planta;
import cdc.com.api.modelo.Vertebrado;
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

    @Override
    public List<Distribucion> all() {
        return distribucionDao.all();
    }

    public List<Distribucion> buscarDistribucion1_plantaId(Planta planta) {
        return distribucionDao.buscarDistribucion1_plantaId(planta);
    }

    public List<Distribucion> buscarDistribucion1_vertebradoId(Vertebrado vertebrado) {
        return distribucionDao.buscarDistribucion1_vertebradoId(vertebrado);
    }
}
