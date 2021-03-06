/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.Sitio;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface SitioDao {

    public int save(Sitio sitio);

    public void update(Sitio sitio);

    public void delete(Long id);

    public Sitio find(Long id);

    public boolean findSitio(String codsitio);

    public int getSitio_Id();

    public List<Sitio> all();

    public List<Sitio> buscarSitio(String codSitio, String nomSitio, String sinSitio, String nacion, String subnacion);
}
