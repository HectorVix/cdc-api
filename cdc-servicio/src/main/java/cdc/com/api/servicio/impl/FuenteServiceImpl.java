/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.FuenteDao;
import cdc.com.api.modelo.Fuente;
import cdc.com.api.servicio.FuenteService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class FuenteServiceImpl implements FuenteService {

    @Inject
    private FuenteDao fuenteDao;

    public int save(Fuente fuente) {
        return   fuenteDao.save(fuente);
    }

    public void update(Fuente fuente) {
        fuenteDao.update(fuente);
    }

    public void delete(Long id) {
        fuenteDao.delete(id);
    }

    public Fuente find(Long id) {
        return fuenteDao.find(id);
    }

    @Override
    public List<Fuente> all() {
        return fuenteDao.all();
    }

    public List<Fuente> buscarFuente(String codfuente, String cita) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean findFuente(String codfuente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
