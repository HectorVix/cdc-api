/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Nacional;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface NacionalService {

    public void save(Nacional nacional);

    public void update(Nacional nacional);

    public void delete(Long id);

    public Nacional find(Long id);

    public List<Nacional> all();

    public List<Nacional> buscarGlobal(String codigo, String nombreNacional);
}
