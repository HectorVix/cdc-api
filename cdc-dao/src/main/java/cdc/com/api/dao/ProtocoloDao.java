/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.Protocolo;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface ProtocoloDao {

    public int save(Protocolo protocolo);

    public void update(Protocolo protocolo);

    public void delete(Long id);

    public Protocolo find(Long id);

    public List<Protocolo> all();

    public List<Protocolo> buscarProtocolo(String codigoe, String nombre, String nomcomun);

    public boolean findProtocolo(String codigoe);
}
