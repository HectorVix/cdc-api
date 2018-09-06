/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.VertebradoDao;
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
public class VertebradoDaoImpl implements VertebradoDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public void save(Vertebrado vertebrado) {
        entityManager.persist(vertebrado);
    }

    public void update(Vertebrado vertebrado) {
        entityManager.merge(vertebrado);
    }

    public void delete(Long id) {
        Vertebrado vertebrado = find(id);
        entityManager.remove(vertebrado);
    }

    public Vertebrado find(Long id) {
        TypedQuery<Vertebrado> query = entityManager.createQuery("SELECT v FROM Vertebrado v WHERE v.vertebradoId = :vertebradoId", Vertebrado.class);
        query.setParameter("vertebradoId", id);
        Vertebrado vertebrado = query.getSingleResult();
        return vertebrado;
    }

    @Override
    public List<Vertebrado> all() {
        return entityManager.createQuery("SELECT v FROM Vertebrado v", Vertebrado.class).getResultList();

    }

    public List<Vertebrado> buscarVertebrado(String codigoe, String nombreg, String nombren, String nomcomun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean findVertebrado(String codigoe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}