/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Archivo;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface ArchivoService {

    public void save(Archivo archivo);

    public void update(Archivo archivo);

    public void delete(Long id);

    public Archivo find(Long id);

    public List<Archivo> all();

    public List<Archivo> buscarArchivo(String nombre, String fuente_id);
}
