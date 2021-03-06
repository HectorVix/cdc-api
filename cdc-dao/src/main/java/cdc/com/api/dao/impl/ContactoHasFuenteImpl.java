/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.ContactoHasFuenteDao;
import cdc.com.api.modelo.ContactoHasFuente;
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
public class ContactoHasFuenteImpl implements ContactoHasFuenteDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(ContactoHasFuente ContactoHasFuente) {
        entityManager.persist(ContactoHasFuente);
    }

    public void update(ContactoHasFuente ContactoHasFuente) {
        entityManager.merge(ContactoHasFuente);
    }

    public void delete(Long id) {
        entityManager.remove(id);
    }

    public ContactoHasFuente find(Long id) {
        TypedQuery<ContactoHasFuente> query = entityManager.createQuery("SELECT c FROM ContactoHasFuente c WHERE c.contactoId = :contactoId", ContactoHasFuente.class);
        query.setParameter("contactoId", id);
        ContactoHasFuente ContactoHasFuente = query.getSingleResult();
        return ContactoHasFuente;
    }

    public List<ContactoHasFuente> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ContactoHasFuente> buscarContactoHasArea(int contactoId, int codfuente) {
        TypedQuery<ContactoHasFuente> query = entityManager.createQuery("SELECT c FROM ContactoHasFuente c"
                + " WHERE (c.contactoId like '%" + contactoId + "%'"
                + "OR c.codfuente like '%" + codfuente + "%')", ContactoHasFuente.class);
        return query.getResultList();
    }

}
