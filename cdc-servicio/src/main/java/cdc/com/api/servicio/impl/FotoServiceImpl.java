/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.FotoDao;
import cdc.com.api.modelo.Foto;
import cdc.com.api.servicio.FotoService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class FotoServiceImpl implements FotoService {

    @Inject
    private FotoDao fotoDao;

    public void save(Foto foto) {
        fotoDao.save(foto);
    }

    public void update(Foto foto) {
        fotoDao.update(foto);
    }

    public void delete(Long id) {
        fotoDao.delete(id);
    }

    public Foto find(Long id) {
        return fotoDao.find(id);
    }

    @Override
    public List<Foto> all() {
        return fotoDao.all();
    }

    public List<Foto> buscarFotoId(String elementoId, String plantaId, String sitioId, String areaId, String vertebradoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Foto> buscarFotoNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}