/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.FotoDao;
import cdc.com.api.modelo.Foto;
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
public class FotoDaoImpl implements FotoDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Foto foto) {
        entityManager.persist(foto);
    }

    public void update(Foto foto) {
        entityManager.merge(foto);
    }

    public void delete(Long id) {
        Foto foto = find(id);
        entityManager.remove(foto);
    }

    public Foto find(Long id) {
        TypedQuery<Foto> query = entityManager.createQuery("SELECT f FROM Foto f WHERE f.fotoId = :fotoId", Foto.class);
        query.setParameter("fotoId", id);
        Foto foto = query.getSingleResult();
        return foto;
    }

    @Override
    public List<Foto> all() {
        return entityManager.createQuery("SELECT f FROM Foto f", Foto.class).getResultList();

    }

    public List<Foto> buscarFotoId(String elementoId, String plantaId, String sitioId, String areaId, String vertebradoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Foto> buscarFotoNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
