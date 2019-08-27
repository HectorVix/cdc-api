/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.NacionDao;
import cdc.com.api.modelo.Nacion;
import cdc.com.api.servicio.NacionService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class NacionServiceImpl implements NacionService {

    @Inject
    private NacionDao nacionDao;

    public List<Nacion> all() {
        return nacionDao.all();
    }

}
