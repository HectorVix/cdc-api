/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.ContactosDao;
import cdc.com.api.modelo.Contactos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class ContactosDaoImpl implements ContactosDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Contactos contactos) {
        entityManager.persist(contactos);
    }

    public void update(Contactos contactos) {
        entityManager.merge(contactos);
    }

    public void delete(Long id) {
        Contactos contactos = find(id);
        entityManager.remove(contactos);
    }

    public Contactos find(Long id) {
        TypedQuery<Contactos> query = entityManager.createQuery("SELECT c FROM Contactos c WHERE c.contactosId = :contactosId", Contactos.class);
        query.setParameter("contactosId", id);
        Contactos contactos = query.getSingleResult();
        return contactos;
    }

    @Override
    public List<Contactos> all() {
        return entityManager.createQuery("SELECT c FROM Contactos c", Contactos.class).getResultList();
    }

    public List<Contactos> buscarContacto(String numident, String nombre, String apellido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean findContacto(String numident) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
