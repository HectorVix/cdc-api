/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.EspecieDao;
import cdc.com.api.modelo.Especie;
import cdc.com.api.modelo.Genero;
import cdc.com.api.servicio.EspecieService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class EspecieServiceImpl implements EspecieService {

    @Inject
    private EspecieDao especieDao;

    public List<Especie> buscar_Especie(Genero genero) {
        return especieDao.buscar_Especie(genero);
    }

}
