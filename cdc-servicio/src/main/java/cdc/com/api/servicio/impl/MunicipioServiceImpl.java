/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.MunicipioDao;
import cdc.com.api.modelo.Municipio;
import cdc.com.api.servicio.MunicipioService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class MunicipioServiceImpl implements MunicipioService {

    @Inject
    private MunicipioDao municipioDao;

    public List<Municipio> all() {
        return municipioDao.all();
    }

}
