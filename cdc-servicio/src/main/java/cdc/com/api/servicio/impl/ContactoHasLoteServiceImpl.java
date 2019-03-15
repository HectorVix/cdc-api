/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.ContactoHasLoteDao;
import cdc.com.api.modelo.ContactoHasLote;
import cdc.com.api.servicio.ContactoHasLoteService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class ContactoHasLoteServiceImpl implements ContactoHasLoteService {

    @Inject
    private ContactoHasLoteDao ContactoHasLoteDao;

    public void save(ContactoHasLote ContactoHasLote) {
        ContactoHasLoteDao.save(ContactoHasLote);
    }

    public void update(ContactoHasLote ContactoHasLote) {
        ContactoHasLoteDao.update(ContactoHasLote);
    }

    public void delete(Long id) {
        ContactoHasLoteDao.delete(id);
    }

    public ContactoHasLote find(Long id) {
        return ContactoHasLoteDao.find(id);
    }

    public List<ContactoHasLote> all() {
        return ContactoHasLoteDao.all();
    }

    public List<ContactoHasLote> buscarContactoHasLote(int contactoId, int codlote) {
        return ContactoHasLoteDao.buscarContactoHasArea(contactoId, codlote);
    }

}
