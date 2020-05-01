/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.FamiliaDao;
import cdc.com.api.modelo.Familia;
import cdc.com.api.modelo.Orden;
import cdc.com.api.servicio.FamiliaService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class FamiliaServiceImpl implements FamiliaService {

    @Inject
    private FamiliaDao familiaDao;

    public List<Familia> buscar_Familia(Orden orden) {
        return familiaDao.buscar_Familia(orden);
    }

}
