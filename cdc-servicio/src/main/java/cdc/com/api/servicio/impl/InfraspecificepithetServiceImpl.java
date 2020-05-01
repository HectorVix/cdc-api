/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.InfraspecificepithetDao;
import cdc.com.api.modelo.Especie;
import cdc.com.api.modelo.Infraspecificepithet;
import cdc.com.api.servicio.InfraspecificepithetService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class InfraspecificepithetServiceImpl implements InfraspecificepithetService {

    @Inject
    private InfraspecificepithetDao infraspecificepithetDao;

    public List<Infraspecificepithet> buscar_Infraspecificepithet(Especie especie) {
        return infraspecificepithetDao.buscar_Infraspecificepithet(especie);
    }

}
