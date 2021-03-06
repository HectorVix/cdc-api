/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.Vertebrado;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface VertebradoDao {

    public int save(Vertebrado vertebrado);

    public void update(Vertebrado vertebrado);

    public void delete(Long id);

    public Vertebrado find(Long id);

    public List<Vertebrado> all();

    public List<Vertebrado> buscarVertebrado(
            String codigoe,
            String nacion,
            String nombreg,
            String autor,
            String nombren,
            String nomcomunn);

    public boolean findVertebrado(String codigoe);
}
