/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.ContactoHasFuente;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface ContactoHasFuenteService {

    public void save(ContactoHasFuente ContactoHasFuente);

    public void update(ContactoHasFuente ContactoHasFuente);

    public void delete(Long id);

    public ContactoHasFuente find(Long id);

    public List<ContactoHasFuente> all();

    public List<ContactoHasFuente> buscarContactoHasFuente(int contactoId, int codfuente);
}
