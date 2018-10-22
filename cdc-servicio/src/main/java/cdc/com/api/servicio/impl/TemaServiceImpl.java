/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.TemaDao;
import cdc.com.api.modelo.Tema;
import cdc.com.api.servicio.TemaService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class TemaServiceImpl implements TemaService {

    @Inject
    private TemaDao temaDao;

    public void save(Tema tema) {
        temaDao.save(tema);
    }

    public void update(Tema tema) {
        temaDao.update(tema);
    }

    public void delete(Long id) {
        temaDao.delete(id);
    }

    public Tema find(Long id) {
        return temaDao.find(id);
    }

    @Override
    public List<Tema> all() {
        return temaDao.all();
    }

    public List<Tema> buscarTema(String nombre, int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
