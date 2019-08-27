/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.RangosDao;
import cdc.com.api.modelo.Rangos;
import cdc.com.api.servicio.RangosService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
public class RangosServiceImpl implements RangosService {

    @Inject
    private RangosDao rangosDao;

    public List<Rangos> all() {
        return rangosDao.all();
    }
}
