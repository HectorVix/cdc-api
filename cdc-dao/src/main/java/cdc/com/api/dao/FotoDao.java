/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.Area;
import cdc.com.api.modelo.Elemento;
import cdc.com.api.modelo.Foto;
import cdc.com.api.modelo.Planta;
import cdc.com.api.modelo.Sitio;
import cdc.com.api.modelo.Vertebrado;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface FotoDao {

    public void save(Foto foto);

    public void update(Foto foto);

    public void delete(Long id);

    public Foto find(Long id);

    public List<Foto> all();

    public List<Foto> buscarFoto_ElementoId(Elemento elemento);

    public List<Foto> buscarFoto_SitioId(Sitio sitio);

    public List<Foto> buscarFoto_AreaId(Area area);

    public List<Foto> buscarFoto_PlantaId(Planta planta);

    public List<Foto> buscarFoto_VertebradoId(Vertebrado vertebrado);

}
