/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.FotoDao;
import cdc.com.api.modelo.Area;
import cdc.com.api.modelo.Elemento;
import cdc.com.api.modelo.Foto;
import cdc.com.api.modelo.Planta;
import cdc.com.api.modelo.Sitio;
import cdc.com.api.modelo.Vertebrado;
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

    public List<Foto> buscarFoto_ElementoId(Elemento elemento) {
        TypedQuery<Foto> query = entityManager.createQuery("SELECT f FROM Foto f WHERE f.eLEMENTOelementoid = :elemento ORDER BY f.posicion ASC", Foto.class);
        query.setParameter("elemento", elemento);
        return query.getResultList();
    }

    public List<Foto> buscarFoto_SitioId(Sitio sitio) {
        TypedQuery<Foto> query = entityManager.createQuery("SELECT f FROM Foto f WHERE f.sITIOsitioid = :sitio ORDER BY f.posicion ASC", Foto.class);
        query.setParameter("sitio", sitio);
        return query.getResultList();
    }

    public List<Foto> buscarFoto_AreaId(Area area) {
        TypedQuery<Foto> query = entityManager.createQuery("SELECT f FROM Foto f WHERE f.aREAareaid = :area ORDER BY f.posicion ASC", Foto.class);
        query.setParameter("area", area);
        return query.getResultList();
    }

    public List<Foto> buscarFoto_PlantaId(Planta planta) {
        TypedQuery<Foto> query = entityManager.createQuery("SELECT f FROM Foto f WHERE f.pLANTAplantaid = :planta ORDER BY f.posicion ASC", Foto.class);
        query.setParameter("planta", planta);
        return query.getResultList();
    }

    public List<Foto> buscarFoto_VertebradoId(Vertebrado vertebrado) {
        TypedQuery<Foto> query = entityManager.createQuery("SELECT f FROM Foto f WHERE f.vERTEBRADOvertebradoid = :vertebrado ORDER BY f.posicion ASC", Foto.class);
        query.setParameter("vertebrado", vertebrado);
        return query.getResultList();
    }
}
