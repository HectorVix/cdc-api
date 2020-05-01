/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.InfraspecificepithetDao;
import cdc.com.api.modelo.Especie;
import cdc.com.api.modelo.Infraspecificepithet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Héctor Vix
 */
public class InfraspecificepithetDaoImpl implements InfraspecificepithetDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;

    public List<Infraspecificepithet> buscar_Infraspecificepithet(Especie especie) {
        TypedQuery<Infraspecificepithet> query = entityManager.createQuery("SELECT i FROM Infraspecificepithet i WHERE i.eSPECIEespecieid = :especie ORDER BY i.nombre ASC", Infraspecificepithet.class);
        query.setParameter("especie", especie);
        return query.getResultList();
    }

}
