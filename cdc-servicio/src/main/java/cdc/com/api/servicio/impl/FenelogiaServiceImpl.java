/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.FenelogiaDao;
import cdc.com.api.modelo.Fenelogia;
import cdc.com.api.servicio.FenelogiaService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
public class FenelogiaServiceImpl implements FenelogiaService {

    @Inject
    private FenelogiaDao fenelogiaDao;

    public List<Fenelogia> all() {
        return fenelogiaDao.all();
    }

}
