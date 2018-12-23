/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Proteccion;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface ProteccionService {

    public void save(Proteccion proteccion);

    public void update(Proteccion proteccion);

    public void delete(Long id);

    public Proteccion find(Long id);

    public List<Proteccion> all();
}
