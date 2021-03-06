/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.ElementoDao;
import cdc.com.api.modelo.Elemento;
import cdc.com.api.servicio.ElementoService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class ElementoServiceImpl implements ElementoService {

    @Inject
    private ElementoDao elementoDao;

    public int save(Elemento elemento) {
        return elementoDao.save(elemento);
    }

    public void update(Elemento elemento) {
        elementoDao.update(elemento);
    }

    public void delete(Long id) {
        elementoDao.delete(id);
    }

    public Elemento find(Long id) {
        return elementoDao.find(id);
    }

    @Override
    public List<Elemento> all(String rol) {
        return elementoDao.all(rol);
    }

    public List<Elemento> buscarElemento(String codigo, String nombren, String nombrecomun, String clase, String comunidad,
            String rol) {
        return elementoDao.buscarElemento(codigo, nombren, nombrecomun, clase, comunidad, rol);
    }

    public boolean findElemento(String codigoe) {
        return elementoDao.findElemento(codigoe);
    }

    public int getElemento_id() {
        return elementoDao.getElemento_id();
    }

}
