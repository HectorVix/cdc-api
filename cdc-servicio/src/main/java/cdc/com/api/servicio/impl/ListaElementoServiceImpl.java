/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.ListaElementoDao;
import cdc.com.api.modelo.ListaElemento;
import cdc.com.api.servicio.ListaElementoService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class ListaElementoServiceImpl implements ListaElementoService {

    @Inject
    private ListaElementoDao listaElementoDao;

    public void save(ListaElemento listaElemento) {
        listaElementoDao.save(listaElemento);
    }

    public void update(ListaElemento listaElemento) {
        listaElementoDao.update(listaElemento);
    }

    public void delete(Long id) {
        listaElementoDao.delete(id);
    }

    public ListaElemento find(Long id) {
        return listaElementoDao.find(id);
    }

    public List<ListaElemento> all() {
        return listaElementoDao.all();
    }

}
