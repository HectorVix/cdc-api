/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.PhylumDao;
import cdc.com.api.modelo.Phylum;
import cdc.com.api.modelo.Reino;
import cdc.com.api.servicio.PhylumService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class PhylumServiceImpl implements PhylumService {

    @Inject
    private PhylumDao phylumDao;

    public List<Phylum> buscar_Phylum(Reino reino) {
        return phylumDao.buscar_Phylum(reino);
    }

}
