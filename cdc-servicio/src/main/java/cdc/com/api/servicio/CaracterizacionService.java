/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Caracterizacion;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface CaracterizacionService {

    public int save(Caracterizacion caracterizacion);

    public void update(Caracterizacion caracterizacion);

    public void delete(Long id);

    public Caracterizacion find(Long id);

    public List<Caracterizacion> all();

    public List<Caracterizacion> buscarCaracterizacion(String codigoe);

    public boolean findCaracterizacion(String codigoe);
}
