/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.SubnacionalDao;
import cdc.com.api.modelo.Subnacional;
import cdc.com.api.servicio.SubnacionalService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class SubnacionalServiceImpl implements SubnacionalService {

    @Inject
    private SubnacionalDao subnacionalDao;

    public void save(Subnacional subnacional) {
        subnacionalDao.save(subnacional);
    }

    public void update(Subnacional subnacional) {
        subnacionalDao.update(subnacional);
    }

    public void delete(Long id) {
        subnacionalDao.delete(id);
    }

    public Subnacional find(Long id) {
        return subnacionalDao.find(id);
    }

    @Override
    public List<Subnacional> all(String rol) {
        return subnacionalDao.all(rol);
    }

    public List<Subnacional> buscarSubnacional(String codigoe,
            String depto,
            String nombres,
            String nombren, String nombrecomunnn, String clase, String comunidad,
            String rol) {
        return subnacionalDao.buscarSubnacional(codigoe, depto, nombres, nombren, nombrecomunnn, clase, comunidad, rol);
    }
}
