/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.TemaDao;
import cdc.com.api.modelo.Tema;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class TemaDaoImpl implements TemaDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Tema tema) {
        entityManager.persist(tema);
    }

    public void update(Tema tema) {
        entityManager.merge(tema);
    }

    public void delete(Long id) {
        Tema tema = find(id);
        entityManager.remove(tema);
    }

    public Tema find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tema> all() {
        return entityManager.createQuery("SELECT t FROM Tema t", Tema.class).getResultList();
    }

    public List<Tema> buscarTema(String nombre, int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
