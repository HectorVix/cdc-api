/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.ElementoDao;
import cdc.com.api.modelo.Elemento;
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
public class ElementoDaoImpl implements ElementoDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;
    private int elemento_id;

    public int save(Elemento elemento) {
        entityManager.persist(elemento);
        entityManager.flush();
        return elemento.getElementoId();
    }

    public void update(Elemento elemento) {
        entityManager.merge(elemento);
    }

    public void delete(Long id) {
        Elemento elemento = find(id);
        entityManager.remove(elemento);
    }

    public Elemento find(Long id) {
        TypedQuery<Elemento> query = entityManager.createQuery("SELECT e FROM Elemento e WHERE e.elementoId = :elementoId", Elemento.class);
        query.setParameter("elementoId", id);
        Elemento elemento = query.getSingleResult();
        return elemento;
    }

    @Override
    public List<Elemento> all() {
        return entityManager.createQuery("SELECT e FROM Elemento e", Elemento.class).getResultList();

    }

    public List<Elemento> buscarElemento(String codigo, String nombrecomun, String nombrecientifico) {
        System.out.print("codigo:" + codigo);
        System.out.print("nombrecomun:" + nombrecomun);
        System.out.print("nombrecientifico:" + nombrecientifico);
        TypedQuery<Elemento> query = entityManager.createQuery("SELECT e FROM Elemento e"
                + " WHERE (e.codigo like '%" + codigo + "%'"
                + "OR e.nombrecomun like '%" + nombrecomun + "%'"
                + " OR e.nombrecientifico like '%" + nombrecientifico + "%')", Elemento.class);
        return query.getResultList();
    }

    public boolean findElemento(String codigoe) {
        TypedQuery<Elemento> query = entityManager.createQuery("SELECT e FROM Elemento e WHERE e.codigo = :codigo", Elemento.class);
        query.setParameter("codigo", codigoe);
        Elemento elemento = query.getSingleResult();
        if (elemento == null) {
            return false;
        } else {
            elemento_id = elemento.getElementoId();
            return true;
        }
    }
      public int getElemento_id() {
        return elemento_id;
    }
}
