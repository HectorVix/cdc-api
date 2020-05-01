/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.GeneroDao;
import cdc.com.api.modelo.Familia;
import cdc.com.api.modelo.Genero;
import cdc.com.api.servicio.GeneroService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class GeneroServiceImpl implements GeneroService {

    @Inject
    private GeneroDao generoDao;

    public List<Genero> buscar_Genero(Familia familia) {
        return generoDao.buscar_Genero(familia);
    }

}
