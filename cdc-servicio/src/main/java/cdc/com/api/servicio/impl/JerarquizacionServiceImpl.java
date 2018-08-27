/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.JerarquizacionDao;
import cdc.com.api.modelo.Jerarquizacion;
import cdc.com.api.servicio.JerarquizacionService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
public class JerarquizacionServiceImpl implements JerarquizacionService {

    @Inject
    private JerarquizacionDao jerarquizacionDao;

    public int save(Jerarquizacion jerarquizacion) {
        return jerarquizacionDao.save(jerarquizacion);
    }

    public void update(Jerarquizacion jerarquizacion) {
        jerarquizacionDao.update(jerarquizacion);
    }

    public void delete(Long id) {
        jerarquizacionDao.delete(id);
    }

    public Jerarquizacion find(Long id) {
        return jerarquizacionDao.find(id);
    }

    public List<Jerarquizacion> all() {
        return jerarquizacionDao.all();
    }

    public List<Jerarquizacion> buscarJerarquia(String codigoe) {
        return jerarquizacionDao.buscarJerarquia(codigoe);
    }

}
