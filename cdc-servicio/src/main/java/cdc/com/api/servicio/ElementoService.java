/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import java.util.List;
import cdc.com.api.modelo.Elemento;

/**
 *
 * @author Héctor Vix
 */
public interface ElementoService {

    public int save(Elemento elemento);

    public void update(Elemento elemento);

    public void delete(Long id);

    public Elemento find(Long id);

    public List<Elemento> all();

    public List<Elemento> buscarElemento(String codigo, String nombrecomun, String nombrecientifico, String clase, String comunidad);

    public boolean findElemento(String codigoe);

    public int getElemento_id();

}
