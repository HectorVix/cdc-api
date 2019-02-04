/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.SubdivisionDao;
import cdc.com.api.modelo.Sitio;
import cdc.com.api.modelo.Subdivision;
import cdc.com.api.servicio.SubdivisionService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class SubdivisionServiceImpl implements SubdivisionService {

    @Inject
    private SubdivisionDao subdivisionDao;

    public void save(Subdivision subdivision) {
        subdivisionDao.save(subdivision);
    }

    public void update(Subdivision subdivision) {
        subdivisionDao.update(subdivision);
    }

    public void delete(Long id) {
        subdivisionDao.delete(id);
    }

    public Subdivision find(Long id) {
        return subdivisionDao.find(id);
    }

    public List<Subdivision> all() {
        return subdivisionDao.all();
    }

    public List<Subdivision> buscarSubdivision_sitioId(Sitio sitio) {
        return subdivisionDao.buscarSubdivision_sitioId(sitio);
    }

}
