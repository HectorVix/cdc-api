/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.Dispersion;
import cdc.com.api.modelo.Protocolo;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface DispersionDao {

    public void save(Dispersion dispersion);

    public void update(Dispersion dispersion);

    public void delete(Long id);

    public Dispersion find(Long id);

    public List<Dispersion> all();

    public List<Dispersion> buscarDispersion_ProtocoloId(Protocolo protocolo);
}
