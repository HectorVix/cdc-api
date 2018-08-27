/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Jerarquizacion;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface JerarquizacionService {

    public int save(Jerarquizacion jerarquizacion);

    public void update(Jerarquizacion jerarquizacion);

    public void delete(Long id);

    public Jerarquizacion find(Long id);

    public List<Jerarquizacion> all();

    public List<Jerarquizacion> buscarJerarquia(String codigoe);
}
