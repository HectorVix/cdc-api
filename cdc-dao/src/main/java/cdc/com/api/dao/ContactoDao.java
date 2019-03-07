/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.Contacto;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface ContactoDao {

    public void save(Contacto contacto);

    public void update(Contacto contacto);

    public void delete(Long id);

    public Contacto find(Long id);

    public List<Contacto> all();

    public List<Contacto> buscarContacto(
            String numident, 
            String nombreident, 
            String nombre,
            String apellido1,
            String apellido2,
            String email);

    public boolean findContacto(String numident);
}
