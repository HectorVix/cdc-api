/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.ListaElementoDao;
import cdc.com.api.modelo.Area;
import cdc.com.api.modelo.ListaElemento;
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
public class ListaElementoDaoImpl implements ListaElementoDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(ListaElemento listaElemento) {
        entityManager.persist(listaElemento);
    }

    public void update(ListaElemento listaElemento) {
        entityManager.merge(listaElemento);
    }

    public void delete(Long id) {
        ListaElemento listaElemento = find(id);
        entityManager.remove(listaElemento);
    }

    public ListaElemento find(Long id) {
        TypedQuery<ListaElemento> query = entityManager.createQuery("SELECT l FROM ListaElemento l WHERE l.listaElementoId = :listaElementoId", ListaElemento.class);
        query.setParameter("listaElementoId", id);
        ListaElemento listaElemento = query.getSingleResult();
        return listaElemento;
    }

    @Override
    public List<ListaElemento> all() {
        return entityManager.createQuery("SELECT l FROM ListaElemento l", ListaElemento.class).getResultList();
    }

    public List<ListaElemento> buscarListaElemento_areaId(Area area) {
        TypedQuery<ListaElemento> query = entityManager.createQuery("SELECT l FROM ListaElemento l WHERE l.aREAareaid = :area", ListaElemento.class);
        query.setParameter("area", area);
        return query.getResultList();
    }

}
