/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.SitioDao;
import cdc.com.api.modelo.Sitio;
import cdc.com.api.servicio.SitioService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class SitioServiceImpl implements SitioService {

    @Inject
    private SitioDao sitioDao;

    public int save(Sitio sitio) {
        return sitioDao.save(sitio);
    }

    public void update(Sitio sitio) {
        sitioDao.update(sitio);
    }

    public void delete(Long id) {
        sitioDao.delete(id);
    }

    public Sitio find(Long id) {
        return sitioDao.find(id);
    }

    public boolean find_Sitio(String codigositio, String nombre) {
        return sitioDao.find_Sitio(codigositio, nombre);
    }

    public int getSitio_id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sitio> all() {
        return sitioDao.all();
    }

    public List<Sitio> buscarSitio(String codSitio, String nomSitio, String sinSitio, String subnacion) {
        return sitioDao.buscarSitio(codSitio, nomSitio, sinSitio, subnacion);
    }

}
