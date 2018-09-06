/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.Foto;
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

    public List<Foto> buscarFotoId(String elementoId, String plantaId, String sitioId, String areaId, String vertebradoId);

    public List<Foto> buscarFotoNombre(String nombre);
}
