/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.Macsitio;
import cdc.com.api.modelo.Sitio;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface MacsitioDao {

    public void save(Macsitio macsitio);

    public void update(Macsitio macsitio);

    public void delete(Long id);

    public Macsitio find(Long id);

    public List<Macsitio> all();

    public List<Macsitio> buscarMacsitio_sitioId(Sitio sitio);
}
