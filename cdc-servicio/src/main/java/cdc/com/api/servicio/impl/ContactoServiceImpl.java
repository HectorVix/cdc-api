/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.modelo.Contacto;
//import java.util.List;
//import javax.ejb.Stateless;
//import javax.inject.Inject;
//import cdc.com.api.dao.ContactoDao;
import cdc.com.api.servicio.ContactoService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import cdc.com.api.dao.ContactoDao;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class ContactoServiceImpl implements ContactoService {

    @Inject
    private ContactoDao contactoDao;

    public void save(Contacto contacto) {
        contactoDao.save(contacto);
    }

    public void update(Contacto contacto) {
        contactoDao.update(contacto);
    }

    public void delete(Long id) {
        contactoDao.delete(id);
    }

    public Contacto find(Long id) {
        return contactoDao.find(id);
    }

    @Override
    public List<Contacto> all() {
        return contactoDao.all();
    }

    public boolean findContacto(String numident) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Contacto> buscarContacto(String numident, String nombreident, String nombre, String apellido1, String apellido2, String email) {
        return contactoDao.buscarContacto(numident, nombreident, nombre, apellido1, apellido2, email);
    }

}
