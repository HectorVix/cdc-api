/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.RastreoDao;
import cdc.com.api.modelo.Rastreo;
import cdc.com.api.servicio.RastreoService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class RastreoServiceImpl implements RastreoService {

    @Inject
    private RastreoDao rastreoDao;

    public void save(Rastreo rastreo) {
        rastreoDao.save(rastreo);
    }

    public void update(Rastreo rastreo) {
        rastreoDao.update(rastreo);
    }

    public void delete(Long id) {
        rastreoDao.delete(id);
    }

    public Rastreo find(Long id) {
        return rastreoDao.find(id);
    }

    @Override
    public List<Rastreo> all() {
        return rastreoDao.all();
    }

    public List<Rastreo> buscarRastreo(String codigoe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}