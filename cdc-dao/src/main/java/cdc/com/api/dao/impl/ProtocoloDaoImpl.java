/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.ProtocoloDao;
import cdc.com.api.modelo.Protocolo;
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
public class ProtocoloDaoImpl implements ProtocoloDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public int save(Protocolo protocolo) {
        entityManager.persist(protocolo);
        entityManager.flush();
        return protocolo.getProtocoloId();
    }

    public void update(Protocolo protocolo) {
        entityManager.merge(protocolo);
    }

    public void delete(Long id) {
        Protocolo protocolo = find(id);
        entityManager.remove(protocolo);
    }

    public Protocolo find(Long id) {
        TypedQuery<Protocolo> query = entityManager.createQuery("SELECT p FROM Protocolo p WHERE p.protocoloId = :protocoloId", Protocolo.class);
        query.setParameter("protocoloId", id);
        Protocolo protocolo = query.getSingleResult();
        return protocolo;
    }

    @Override
    public List<Protocolo> all() {
        return entityManager.createQuery("SELECT p FROM Protocolo p", Protocolo.class).getResultList();

    }

    public List<Protocolo> buscarProtocolo(String codigoe, String nombre, String nomcomun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean findProtocolo(String codigoe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
