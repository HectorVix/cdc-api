/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.ArchivoDao;
import cdc.com.api.modelo.Archivo;
import cdc.com.api.modelo.Fuente;
import cdc.com.api.servicio.ArchivoService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class ArchivoServiceImpl implements ArchivoService {

    @Inject
    ArchivoDao archivoDao;

    public void save(Archivo archivo) {
        archivoDao.save(archivo);
    }

    public void update(Archivo archivo) {
        archivoDao.update(archivo);
    }

    public void delete(Long id) {
        archivoDao.delete(id);
    }

    public Archivo find(Long id) {
        return archivoDao.find(id);
    }

    public List<Archivo> all() {

        return archivoDao.all();
    }

    public List<Archivo> buscarArchivo_FuenteId(Fuente fuente) {
        return archivoDao.buscarArchivo_FuenteId(fuente);
    }

}
