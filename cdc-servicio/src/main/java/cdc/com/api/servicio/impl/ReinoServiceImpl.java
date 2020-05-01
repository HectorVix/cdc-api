/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.ReinoDao;
import cdc.com.api.modelo.Reino;
import cdc.com.api.servicio.ReinoService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */

@Stateless
public class ReinoServiceImpl implements ReinoService {
    
    @Inject
    private ReinoDao reinoDao;

    public List<Reino> buscar_Reino() {
        return reinoDao.buscar_Reino();
    }
}
