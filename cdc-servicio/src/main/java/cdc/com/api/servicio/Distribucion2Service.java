/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Distribucion2;
import cdc.com.api.modelo.Planta;
import cdc.com.api.modelo.Vertebrado;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface Distribucion2Service {

    public void save(Distribucion2 distribucion2);

    public void update(Distribucion2 distribucion2);

    public void delete(Long id);

    public Distribucion2 find(Long id);

    public List<Distribucion2> all();

    public List<Distribucion2> buscarDistribucion2_plantaId(Planta planta);

    public List<Distribucion2> buscarDistribucion2_vertebradoId(Vertebrado vertebrado);
}
