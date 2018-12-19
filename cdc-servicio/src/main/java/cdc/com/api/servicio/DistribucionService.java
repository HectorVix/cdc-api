/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Distribucion;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface DistribucionService {

    public void save(Distribucion distribucion);

    public void update(Distribucion distribucion);

    public void delete(Long id);

    public Distribucion find(Long id);

    public List<Distribucion> all();
}
