/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.ContactoHasLote;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface ContactoHasLoteDao {

    public int save(ContactoHasLote ContactoHasLote);

    public void update(ContactoHasLote ContactoHasLote);

    public void delete(Long id);

    public ContactoHasLote find(Long id);

    public List<ContactoHasLote> all();

    public List<ContactoHasLote> buscarContactoHasArea(int contactoId, int codlote);
}
