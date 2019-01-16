/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.ContactosDao;
import cdc.com.api.modelo.Contactos;
import cdc.com.api.servicio.ContactosService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class ContactosServiceImpl implements ContactosService {

    @Inject
    private ContactosDao contactosDao;

    public void save(Contactos contactos) {
        contactosDao.save(contactos);
    }

    public void update(Contactos contactos) {
        contactosDao.update(contactos);
    }

    public void delete(Long id) {
        contactosDao.delete(id);
    }

    public Contactos find(Long id) {
        return contactosDao.find(id);
    }

    @Override
    public List<Contactos> all() {
        return contactosDao.all();
    }

    public boolean findContacto(String numident) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Contactos> buscarContacto(String numident, String nombreident, String nombre, String apellido1, String apellido2, String email) {
        return contactosDao.buscarContacto(numident, nombreident, nombre, apellido1, apellido2, email);
    }

}
