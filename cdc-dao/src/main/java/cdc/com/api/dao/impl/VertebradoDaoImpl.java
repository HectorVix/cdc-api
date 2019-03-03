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

    public int save(Vertebrado vertebrado) {
        vertebrado.setCodigoe(vertebrado.getCodigoe().replaceAll("\\s", ""));
        entityManager.persist(vertebrado);
        entityManager.flush();
        return vertebrado.getVertebradoId();
    }

    public void update(Vertebrado vertebrado) {
        vertebrado.setCodigoe(vertebrado.getCodigoe().replaceAll("\\s", ""));
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

    public boolean findVertebrado(String codigoe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Vertebrado> buscarVertebrado(
            String codigoe,
            String nacion,
            String nombreg,
            String autor,
            String nombren,
            String nomcomunn) {
        codigoe = codigoe.replaceAll("\\s", "");
        TypedQuery<Vertebrado> query = entityManager.createQuery("SELECT v FROM Vertebrado v"
                + " WHERE (v.codigoe like '%" + codigoe + "%'"
                + "OR v.nacion like '%" + nacion + "%'"
                + "OR v.nombreg like '%" + nombreg + "%'"
                + "OR v.autor like '%" + autor + "%'"
                + "OR v.nombren like '%" + nombren + "%'"
                + " OR v.nomcomunn like '%" + nomcomunn + "%')", Vertebrado.class);
        return query.getResultList();
    }

}
