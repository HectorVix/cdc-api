/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.RangonDao;
import cdc.com.api.modelo.Rangon;
import cdc.com.api.servicio.RangonService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
public class RangonServiceImpl implements RangonService {

    @Inject
    private RangonDao rangonDao;

    public List<Rangon> all() {
        return rangonDao.all();
    }
}
