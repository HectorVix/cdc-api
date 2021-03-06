/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.VertebradoDao;
import cdc.com.api.modelo.Vertebrado;
import cdc.com.api.servicio.VertebradoService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class VertebradoServiceImpl implements VertebradoService {

    @Inject
    private VertebradoDao vertebradoDao;

    public int save(Vertebrado vertebrado) {
        return vertebradoDao.save(vertebrado);
    }

    public void update(Vertebrado vertebrado) {
        vertebradoDao.update(vertebrado);
    }

    public void delete(Long id) {
        vertebradoDao.delete(id);
    }

    public Vertebrado find(Long id) {
        return vertebradoDao.find(id);
    }

    @Override
    public List<Vertebrado> all() {
        return vertebradoDao.all();
    }

    public boolean findVertebrado(String codigoe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Vertebrado> buscarVertebrado(String codigoe, String nacion, String nombreg, String autor, String nombren, String nomcomunn) {
        return vertebradoDao.buscarVertebrado(codigoe, nacion, nombreg, autor, nombren, nomcomunn);
    }

}
