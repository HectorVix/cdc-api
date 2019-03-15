/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Fuente;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface FuenteService {

    public int save(Fuente fuente);

    public void update(Fuente fuente);

    public void delete(Long id);

    public Fuente find(Long id);

    public List<Fuente> all();

    public List<Fuente> buscarFuente(String naturalezadocumento, String codfuente, String cita, String archivado, String clave);

    public boolean findFuente(String codfuente);

    public int getFuente_id();
}
