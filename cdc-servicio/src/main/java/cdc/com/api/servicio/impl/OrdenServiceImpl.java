/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.OrdenDao;
import cdc.com.api.modelo.Clase;
import cdc.com.api.modelo.Orden;
import cdc.com.api.servicio.OrdenService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class OrdenServiceImpl implements OrdenService {

    @Inject
    private OrdenDao ordenDao;

    public List<Orden> buscar_Orden(Clase clase) {
        return ordenDao.buscar_Orden(clase);
    }

}
