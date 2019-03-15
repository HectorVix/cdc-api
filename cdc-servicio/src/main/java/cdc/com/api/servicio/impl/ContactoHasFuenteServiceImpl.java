/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.ContactoHasFuenteDao;
import cdc.com.api.modelo.ContactoHasFuente;
import cdc.com.api.servicio.ContactoHasFuenteService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class ContactoHasFuenteServiceImpl implements ContactoHasFuenteService {

    @Inject
    private ContactoHasFuenteDao ContactoHasFuenteDao;

    public void save(ContactoHasFuente ContactoHasFuente) {
        ContactoHasFuenteDao.save(ContactoHasFuente);
    }

    public void update(ContactoHasFuente ContactoHasFuente) {
        ContactoHasFuenteDao.update(ContactoHasFuente);
    }

    public void delete(Long id) {
        ContactoHasFuenteDao.delete(id);
    }

    public ContactoHasFuente find(Long id) {
        return ContactoHasFuenteDao.find(id);
    }

    public List<ContactoHasFuente> all() {
        return ContactoHasFuenteDao.all();
    }

    public List<ContactoHasFuente> buscarContactoHasFuente(int contactoId, int codfuente) {
        return ContactoHasFuenteDao.buscarContactoHasArea(contactoId, codfuente);
    }

}
