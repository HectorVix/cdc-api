/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.PlantaDao;
import cdc.com.api.modelo.Planta;
import cdc.com.api.servicio.PlantaService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class PlantaServiceImpl implements PlantaService {

    @Inject
    private PlantaDao plantaDao;

    public int save(Planta planta) {
        return plantaDao.save(planta);
    }

    public void update(Planta planta) {
        plantaDao.update(planta);
    }

    public void delete(Long id) {
        plantaDao.delete(id);
    }

    public Planta find(Long id) {
        return plantaDao.find(id);
    }

    @Override
    public List<Planta> all() {
        return plantaDao.all();
    }

    public List<Planta> buscarPlanta(String codigoe, String nombren) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean findPlanta(String codigoe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
