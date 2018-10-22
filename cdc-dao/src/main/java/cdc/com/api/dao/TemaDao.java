/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.Tema;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface TemaDao {

    public void save(Tema tema);

    public void update(Tema tema);

    public void delete(Long id);

    public Tema find(Long id);

    public List<Tema> all();

    public List<Tema> buscarTema(String nombre, int tipo);

}
