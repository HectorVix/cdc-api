/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Rastreo;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface RastreoService {

    public void save(Rastreo rastreo);

    public void update(Rastreo rastreo);

    public void delete(Long id);

    public Rastreo find(Long id);

    public List<Rastreo> all();

    public List<Rastreo> buscarRastreo(String codigoe);
}
