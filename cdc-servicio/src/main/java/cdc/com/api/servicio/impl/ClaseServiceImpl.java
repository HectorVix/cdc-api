/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.ClaseDao;
import cdc.com.api.modelo.Clase;
import cdc.com.api.modelo.Phylum;
import cdc.com.api.servicio.ClaseService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class ClaseServiceImpl implements ClaseService {

    @Inject
    private ClaseDao claseDao;

    public List<Clase> buscar_Clase(Phylum p) {
        return claseDao.buscar_Clase(p);
    }

}
