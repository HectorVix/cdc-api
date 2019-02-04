/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.DispersionDao;
import cdc.com.api.modelo.Dispersion;
import cdc.com.api.modelo.Protocolo;
import cdc.com.api.servicio.DispersionService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class DispersionServiceImpl implements DispersionService {

    @Inject
    private DispersionDao dispersionDao;

    public void save(Dispersion dispersion) {
        dispersionDao.save(dispersion);
    }

    public void update(Dispersion dispersion) {
        dispersionDao.update(dispersion);
    }

    public void delete(Long id) {
        dispersionDao.delete(id);
    }

    public Dispersion find(Long id) {
        return dispersionDao.find(id);
    }

    @Override
    public List<Dispersion> all() {
        return dispersionDao.all();
    }

    public List<Dispersion> buscarDispersion_ProtocoloId(Protocolo protocolo) {
        return dispersionDao.buscarDispersion_ProtocoloId(protocolo);
    }

}
