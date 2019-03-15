/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.ContactoHasLote;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface ContactoHasLoteService {

    public void save(ContactoHasLote ContactoHasLote);

    public void update(ContactoHasLote ContactoHasLote);

    public void delete(Long id);

    public ContactoHasLote find(Long id);

    public List<ContactoHasLote> all();

    public List<ContactoHasLote> buscarContactoHasLote(int contactoId, int codlote);
}
