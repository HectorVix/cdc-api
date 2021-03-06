/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.GlobalDao;
import cdc.com.api.modelo.Global;
import cdc.com.api.servicio.GlobalService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class GlobalServiceImpl implements GlobalService {

    @Inject
    private GlobalDao globalDao;

    public void save(Global global) {
        globalDao.save(global);
    }

    public void update(Global global) {
        globalDao.update(global);
    }

    public void delete(Long id) {
        globalDao.delete(id);
    }

    public Global find(Long id) {
        return globalDao.find(id);
    }

    @Override
    public List<Global> all(String rol) {
        return globalDao.all(rol);
    }

    public List<Global> buscarGlobal(String codigoe,
            String nombren, String nombrecomunn, String clase, String comunidad,
            String rol) {
        return globalDao.buscarGlobal(codigoe, nombren, nombrecomunn, clase, comunidad, rol);
    }

}
