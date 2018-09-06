/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.Observaciones;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface ObservacionesDao {

    public void save(Observaciones observaciones);

    public void update(Observaciones observaciones);

    public void delete(Long id);

    public Observaciones find(Long id);

    public List<Observaciones> all();

    public List<Observaciones> buscarObservaciones(String nombre);

    public boolean findObservaciones(String codigo);
}
