/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.LocalizacionDao;
import cdc.com.api.modelo.Localizacion;
import cdc.com.api.servicio.LocalizacionService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class LocalizacionServiceImpl implements LocalizacionService {

    @Inject
    private LocalizacionDao localizacionDao;

    public int save(Localizacion localizacion) {
        return localizacionDao.save(localizacion);
    }

    public void update(Localizacion localizacion) {
        localizacionDao.update(localizacion);
    }

    public void delete(Long id) {
        localizacionDao.delete(id);
    }

    public Localizacion find(Long id) {
        return localizacionDao.find(id);
    }

    @Override
    public List<Localizacion> all() {
        return localizacionDao.all();
    }

    public List<Localizacion> buscarLocalizacion(String codigole) {
        return localizacionDao.buscarLocalizacion(codigole);
    }

}
