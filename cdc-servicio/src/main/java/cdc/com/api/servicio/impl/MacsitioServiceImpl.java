/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.MacsitioDao;
import cdc.com.api.modelo.Macsitio;
import cdc.com.api.servicio.MacsitioService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class MacsitioServiceImpl implements MacsitioService {

    @Inject
    private MacsitioDao macsitioDao;

    public void save(Macsitio macsitio) {
        macsitioDao.save(macsitio);
    }

    public void update(Macsitio macsitio) {
        macsitioDao.update(macsitio);
    }

    public void delete(Long id) {
        macsitioDao.delete(id);
    }

    public Macsitio find(Long id) {
        return macsitioDao.find(id);
    }

    public List<Macsitio> all() {
        return macsitioDao.all();
    }

}
