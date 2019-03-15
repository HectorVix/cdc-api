/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.ContactoHasAreaDao;
import cdc.com.api.modelo.ContactoHasArea;
import cdc.com.api.servicio.ContactoHasAreaService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class ContactoHasAreaServiceImpl implements ContactoHasAreaService {

    @Inject
    private ContactoHasAreaDao ContactoHasAreaDao;

    public void save(ContactoHasArea ContactoHasArea) {
        ContactoHasAreaDao.save(ContactoHasArea);
    }

    public void update(ContactoHasArea ContactoHasArea) {
        ContactoHasAreaDao.update(ContactoHasArea);
    }

    public void delete(Long id) {
        ContactoHasAreaDao.delete(id);
    }

    public ContactoHasArea find(Long id) {
        return ContactoHasAreaDao.find(id);
    }

    public List<ContactoHasArea> all() {
        return ContactoHasAreaDao.all();
    }

    public List<ContactoHasArea> buscarContactoHasArea(int contactoId, int codigoam) {
        return ContactoHasAreaDao.buscarContactoHasArea(contactoId, codigoam);
    }

}
