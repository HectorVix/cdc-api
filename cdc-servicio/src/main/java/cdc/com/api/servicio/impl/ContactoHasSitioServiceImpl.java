/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.ContactoHasSitioDao;
import cdc.com.api.modelo.ContactoHasSitio;
import cdc.com.api.servicio.ContactoHasSitioService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class ContactoHasSitioServiceImpl implements ContactoHasSitioService {

    @Inject
    private ContactoHasSitioDao ContactoHasSitioDao;

    public void save(ContactoHasSitio ContactoHasSitio) {
        ContactoHasSitioDao.save(ContactoHasSitio);
    }

    public void update(ContactoHasSitio ContactoHasSitio) {
        ContactoHasSitioDao.update(ContactoHasSitio);
    }

    public void delete(Long id) {
        ContactoHasSitioDao.delete(id);
    }

    public ContactoHasSitio find(Long id) {
        return ContactoHasSitioDao.find(id);
    }

    public List<ContactoHasSitio> all() {
        return ContactoHasSitioDao.all();
    }

    public List<ContactoHasSitio> buscarContactoHasSitio(int contactoId, int codsitio) {
        return ContactoHasSitioDao.buscarContactoHasArea(contactoId, codsitio);
    }

}
