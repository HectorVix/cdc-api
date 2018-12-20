/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.Distribucion2Dao;
import cdc.com.api.modelo.Distribucion2;
import cdc.com.api.servicio.Distribucion2Service;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class Distribucion2ServiceImpl implements Distribucion2Service {

    @Inject
    private Distribucion2Dao distribucion2Dao;

    public void save(Distribucion2 distribucion2) {
        distribucion2Dao.save(distribucion2);
    }

    public void update(Distribucion2 distribucion2) {
        distribucion2Dao.update(distribucion2);
    }

    public void delete(Long id) {
        distribucion2Dao.delete(id);
    }

    public Distribucion2 find(Long id) {
        return distribucion2Dao.find(id);
    }

    public List<Distribucion2> all() {
        return distribucion2Dao.all();
    }

}
