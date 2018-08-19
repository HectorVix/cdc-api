/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

/**
 *
 * @author Héctor Vix
 */
import cdc.com.api.modelo.Elemento;
import java.util.List;

public interface ElementoDao {

    public void save(Elemento elemento);

    public void update(Elemento elemento);

    public void delete(Long id);

    public Elemento find(Long id);

    public List<Elemento> all();
}
