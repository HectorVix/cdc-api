/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.Distribucion;
import cdc.com.api.modelo.Planta;
import cdc.com.api.modelo.Vertebrado;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface DistribucionDao {

    public void save(Distribucion distribucion);

    public void update(Distribucion distribucion);

    public void delete(Long id);

    public Distribucion find(Long id);

    public List<Distribucion> all();

    public List<Distribucion> buscarDistribucion1_plantaId(Planta planta);

    public List<Distribucion> buscarDistribucion1_vertebradoId(Vertebrado vertebrado);
}
