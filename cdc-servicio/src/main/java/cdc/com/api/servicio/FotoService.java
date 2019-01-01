/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Elemento;
import cdc.com.api.modelo.Foto;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface FotoService {

    public void save(Foto foto);

    public void update(Foto foto);

    public void delete(Long id);

    public Foto find(Long id);

    public List<Foto> all();

   public List<Foto> buscarFoto_ElementoId(Elemento elemento) ;

}
