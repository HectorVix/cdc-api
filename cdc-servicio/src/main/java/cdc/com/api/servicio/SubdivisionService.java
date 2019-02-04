/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Sitio;
import cdc.com.api.modelo.Subdivision;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface SubdivisionService {

    public void save(Subdivision subdivision);

    public void update(Subdivision subdivision);

    public void delete(Long id);

    public Subdivision find(Long id);

    public List<Subdivision> all();
    
    public List<Subdivision> buscarSubdivision_sitioId(Sitio sitio);
}
