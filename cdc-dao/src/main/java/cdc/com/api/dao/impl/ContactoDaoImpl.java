/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.modelo.Contacto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import cdc.com.api.dao.ContactoDao;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class ContactoDaoImpl implements ContactoDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Contacto contacto) {
        entityManager.persist(contacto);
    }

    public void update(Contacto contacto) {
        entityManager.merge(contacto);
    }

    public void delete(Long id) {
        Contacto contacto = find(id);
        entityManager.remove(contacto);
    }

    public Contacto find(Long id) {
        TypedQuery<Contacto> query = entityManager.createQuery("SELECT c FROM Contacto c WHERE c.contactoId = :contactoId", Contacto.class);
        query.setParameter("contactoId", id);
        Contacto contacto = query.getSingleResult();
        return contacto;
    }

    @Override
    public List<Contacto> all() {
        return entityManager.createQuery("SELECT c FROM Contacto c", Contacto.class).getResultList();
    }

    public boolean findContacto(String numident) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Contacto> buscarContacto(
            String numident,
            String nombreident,
            String nombre,
            String apellido1,
            String apellido2,
            String email) {
        TypedQuery<Contacto> query = entityManager.createQuery("SELECT c FROM Contacto c"
                + " WHERE (c.numident like '%" + numident + "%'"
                + "OR c.nombreident like '%" + nombreident + "%'"
                + "OR c.nombre like '%" + nombre + "%'"
                + "OR c.apellido1 like '%" + apellido1 + "%'"
                + "OR c.apellido2 like '%" + apellido2 + "%'"
                + " OR c.email like '%" + email + "%')", Contacto.class);
        return query.getResultList();
    }

}
