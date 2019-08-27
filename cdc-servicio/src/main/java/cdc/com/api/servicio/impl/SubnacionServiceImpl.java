/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.SubnacionDao;
import cdc.com.api.modelo.Subnacion;
import cdc.com.api.servicio.SubnacionService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class SubnacionServiceImpl implements SubnacionService {

    @Inject
    private SubnacionDao subnacionDao;

    public List<Subnacion> all() {
        return subnacionDao.all();
    }

}
