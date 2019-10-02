/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.RolDao;
import cdc.com.api.modelo.Rol;
import cdc.com.api.servicio.RolService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class RolServiceImpl implements RolService {

    @Inject
    private RolDao rolDao;

    public List<Rol> all() {
        return rolDao.all();
    }

}
