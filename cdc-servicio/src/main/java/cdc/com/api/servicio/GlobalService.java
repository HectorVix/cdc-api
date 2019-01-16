/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Global;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface GlobalService {

    public void save(Global global);

    public void update(Global global);

    public void delete(Long id);

    public Global find(Long id);

    public List<Global> all();

    public List<Global> buscarGlobal(String codigo, String nombreg, String descrielem);
}
