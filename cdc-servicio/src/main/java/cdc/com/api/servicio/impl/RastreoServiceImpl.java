/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.RastreoDao;
import cdc.com.api.modelo.Global;
import cdc.com.api.modelo.Rastreo;
import cdc.com.api.servicio.RastreoService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import modelo.datos.representativos.IdentificadoresLE;
import modelo.datos.representativos.StatusGlobal;
import modelo.datos.representativos.StatusNacional;
import modelo.datos.representativos.StatusSubnacional;

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
    public List<Rastreo> all(String rol) {
        return rastreoDao.all(rol);
    }

    public List<Rastreo> buscarRastreo(String codigoe, String subnacion, String nombren, String nombrecomunnn,
            String clase, String comunidad, String rol) {
        return rastreoDao.buscarRastreo(codigoe, subnacion, nombren, nombrecomunnn, clase, comunidad, rol);
    }

    public Rastreo buscarRastreo_Codigoe(String codigoe) {
        return rastreoDao.buscarRastreo_Codigoe(codigoe);
    }

    public StatusGlobal status_Global(String codigoe) {
        return rastreoDao.status_Global(codigoe);
    }

    public StatusNacional status_Nacional(String codigoe) {
        return rastreoDao.status_Nacional(codigoe);
    }

    public StatusSubnacional status_Subnacional(String codigoe, String subnacion) {
        return rastreoDao.status_Subnacional(codigoe, subnacion);
    }

}
