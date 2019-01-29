/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.ArchivoDao;
import cdc.com.api.modelo.Archivo;
import cdc.com.api.modelo.Fuente;
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
public class ArchivoDaoImpl implements ArchivoDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Archivo archivo) {
        entityManager.persist(archivo);
    }

    public void update(Archivo archivo) {
        entityManager.merge(archivo);
    }

    public void delete(Long id) {
        Archivo archivo = find(id);
        entityManager.remove(archivo);
    }

    public Archivo find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Archivo> all() {
        return entityManager.createQuery("SELECT a FROM Archivo a", Archivo.class).getResultList();
    }

    public List<Archivo> buscarArchivo_FuenteId(Fuente fuente) {
        TypedQuery<Archivo> query = entityManager.createQuery("SELECT a FROM Archivo a WHERE a.fUENTEfuenteid = :fuente", Archivo.class);
        query.setParameter("fuente", fuente);
        return query.getResultList();
    }

}
