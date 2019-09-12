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
        elemento.setCodigoe(elemento.getCodigoe().replaceAll("\\s", ""));
        entityManager.persist(elemento);
        entityManager.flush();
        return elemento.getElementoId();
    }

    public void update(Elemento elemento) {
        elemento.setCodigoe(elemento.getCodigoe().replaceAll("\\s", ""));
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

    public List<Elemento> buscarElemento(String codigoe, String nombrecomunn, String nombren, String clase, String comunidad) {
        codigoe = codigoe.replaceAll("\\s", "");
        System.out.print("codigoe:" + codigoe);
        System.out.print("nombrecomunn:" + nombrecomunn);
        System.out.print("nombren:" + nombren);
        TypedQuery<Elemento> query = entityManager.createQuery("SELECT e FROM Elemento e"
                + " WHERE (e.codigoe like '%" + codigoe + "%'"
                + "OR e.nombrecomunn like '%" + nombrecomunn + "%'"
                + "OR e.nombren like '%" + nombren + "%'"
                + "OR e.clase like '%" + clase + "%'"
                + " OR e.comunidad like '%" + comunidad + "%')", Elemento.class);
        return query.getResultList();
    }

    public boolean findElemento(String codigoe) {
        codigoe = codigoe.replaceAll("\\s", "");
        TypedQuery<Elemento> query = entityManager.createQuery("SELECT e FROM Elemento e WHERE e.codigoe = :codigoe", Elemento.class);
        query.setParameter("codigoe", codigoe);
        Elemento elemento = query.getResultList().stream().findFirst().orElse(null);
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
