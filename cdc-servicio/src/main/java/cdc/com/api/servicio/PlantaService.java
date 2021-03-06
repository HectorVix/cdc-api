/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Planta;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface PlantaService {

    public int save(Planta planta);

    public void update(Planta planta);

    public void delete(Long id);

    public Planta find(Long id);

    public List<Planta> all();

    public List<Planta> buscarPlanta(
            String codigoe,
            String nacion,
            String nombren,
            String nomcomunn);

    public boolean findPlanta(String codigoe);
}
