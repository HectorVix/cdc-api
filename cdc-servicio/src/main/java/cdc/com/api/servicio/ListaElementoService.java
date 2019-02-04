/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Area;
import cdc.com.api.modelo.ListaElemento;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface ListaElementoService {

    public void save(ListaElemento listaElemento);

    public void update(ListaElemento listaElemento);

    public void delete(Long id);

    public ListaElemento find(Long id);

    public List<ListaElemento> all();

    public List<ListaElemento> buscarListaElemento_areaId(Area area);
}
