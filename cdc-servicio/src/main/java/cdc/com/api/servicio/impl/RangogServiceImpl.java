/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.RangogDao;
import cdc.com.api.modelo.Rangog;
import cdc.com.api.servicio.RangogService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class RangogServiceImpl implements RangogService {

    @Inject
    private RangogDao rangogDao;

    public List<Rangog> all() {
        return rangogDao.all();
    }
}
