/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.Contactos;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface ContactosDao {

    public void save(Contactos contactos);

    public void update(Contactos contactos);

    public void delete(Long id);

    public Contactos find(Long id);

    public List<Contactos> all();

    public List<Contactos> buscarContacto(
            String numident, 
            String nombreident, 
            String nombre,
            String apellido1,
            String apellido2,
            String email);

    public boolean findContacto(String numident);
}
