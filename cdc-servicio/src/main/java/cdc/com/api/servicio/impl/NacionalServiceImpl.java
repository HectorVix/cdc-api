/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.NacionalDao;
import cdc.com.api.modelo.Nacional;
import cdc.com.api.servicio.NacionalService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class NacionalServiceImpl implements NacionalService {

    @Inject
    private NacionalDao nacionalDao;

    public void save(Nacional nacional) {
        nacionalDao.save(nacional);
    }

    public void update(Nacional nacional) {
        nacionalDao.update(nacional);
    }

    public void delete(Long id) {
        nacionalDao.delete(id);
    }

    public Nacional find(Long id) {
        return nacionalDao.find(id);
    }

    @Override
    public List<Nacional> all(String rol) {
        return nacionalDao.all(rol);
    }

    public List<Nacional> buscarNacional(String codigoe, String nombren, String nacion,String rol) {
        return nacionalDao.buscarNacional(codigoe, nombren, nacion,rol);
    }

}
