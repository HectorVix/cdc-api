/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.LocalizacionDao;
import cdc.com.api.modelo.Localizacion;
import cdc.com.api.modelo.Rastreo;
import cdc.com.api.modelo.datos.representativos.IdentificadoresLE;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class LocalizacionDaoImpl implements LocalizacionDao {

    @PersistenceContext(unitName = "cdcPU")
    private EntityManager entityManager;
    private int rastreo_id;

    public int save(Localizacion localizacion) {
        entityManager.persist(localizacion);
        entityManager.flush();
        return localizacion.getLocalizacionId();
    }

    public void update(Localizacion localizacion) {
        entityManager.merge(localizacion);
    }

    public List<Localizacion> buscarLocalizacion(String codigole) {
        System.out.print("codigole:" + codigole);
        TypedQuery<Localizacion> query = entityManager.createQuery("SELECT l FROM Localizacion l"
                + " WHERE (l.codigole like '%" + codigole + "%')", Localizacion.class);
        return query.getResultList();
    }

    public boolean findRastreo(String codigoe) {
        TypedQuery<Rastreo> query = entityManager.createQuery("SELECT r FROM Rastreo r WHERE r.codigoe = :codigoe", Rastreo.class);
        query.setParameter("codigoe", codigoe);
        Rastreo re = query.getSingleResult();
        if (re == null) {
            return false;
        } else {
            rastreo_id = re.getRastreoId();
            return true;
        }
    }

    public int getRastreo_id() {
        return rastreo_id;
    }

    public IdentificadoresLE buscar_Identificadores_NombreS_RangoS(String codigoe, String departamento) {
        codigoe = codigoe.replaceAll("\\s", "");
        String queryStr
                = "SELECT NEW cdc.com.api.modelo.datos.representativos.IdentificadoresLE "
                + "(s.nombres,s.rangos) "
                + "FROM Subnacional s "
                + "WHERE  "
                + "s.subnacion = :departamento "
                + "AND   s.codigoe = :codigoe";
        TypedQuery<IdentificadoresLE> query
                = entityManager.createQuery(queryStr, IdentificadoresLE.class);
        query.setParameter("departamento", departamento);
        query.setParameter("codigoe", codigoe);
        IdentificadoresLE idenLE = query.getSingleResult();
        return idenLE;

    }

    public IdentificadoresLE buscar_Identificadores_RangoG(String codigoe) {
        codigoe = codigoe.replaceAll("\\s", "");
        String queryStr
                = "SELECT NEW cdc.com.api.modelo.datos.representativos.IdentificadoresLE "
                + "(g.rangog,1) "
                + "FROM Global g "
                + "WHERE  g.codigoe = :codigoe";
        TypedQuery<IdentificadoresLE> query
                = entityManager.createQuery(queryStr, IdentificadoresLE.class);
        query.setParameter("codigoe", codigoe);
        IdentificadoresLE idenLE = query.getSingleResult();
        return idenLE;
    }

    public IdentificadoresLE buscar_Identificadores_RangoN(String codigoe) {
        codigoe = codigoe.replaceAll("\\s", "");
        String queryStr
                = "SELECT NEW cdc.com.api.modelo.datos.representativos.IdentificadoresLE "
                + "(n.rangon,2) "
                + "FROM Nacional n "
                + "WHERE  n.codigoe = :codigoe";
        TypedQuery<IdentificadoresLE> query
                = entityManager.createQuery(queryStr, IdentificadoresLE.class);
        query.setParameter("codigoe", codigoe);
        IdentificadoresLE idenLE = query.getSingleResult();
        return idenLE;
    }

    public IdentificadoresLE buscar_Identificadores_NombreComunN(String codigoe) {
        codigoe = codigoe.replaceAll("\\s", "");
        String queryStr
                = "SELECT NEW cdc.com.api.modelo.datos.representativos.IdentificadoresLE "
                + "(e.nombrecomun ,3) "
                + "FROM Elemento e "
                + "WHERE  e.codigo = :codigoe";
        TypedQuery<IdentificadoresLE> query
                = entityManager.createQuery(queryStr, IdentificadoresLE.class);
        query.setParameter("codigoe", codigoe);
        IdentificadoresLE idenLE = query.getSingleResult();
        return idenLE;
    }
}
