/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.Distribucion2;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface Distribucion2Dao {

    public void save(Distribucion2 distribucion2);

    public void update(Distribucion2 distribucion2);

    public void delete(Long id);

    public Distribucion2 find(Long id);

    public List<Distribucion2> all();
}
