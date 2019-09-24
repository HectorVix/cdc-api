/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao.impl;

import cdc.com.api.dao.LocalizacionDao;
import cdc.com.api.modelo.Localizacion;
import cdc.com.api.modelo.Rastreo;
import modelo.datos.representativos.IdentificadoresLE;
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

    public List<Localizacion> buscarLocalizacion(String codigole, String depto, String municipio, String nombren, String nombrecomunn,
            String clase, String comunidad, String rol) {
        TypedQuery<Localizacion> query = null;
        if (rol.equals("Admin")) {
            query = entityManager.createQuery("SELECT l FROM Localizacion l"
                    + " INNER JOIN Rastreo as r"
                    + " ON l.rASTREOrastreoid.rastreo_id=r.rastreo_id"
                    + " INNER JOIN Elemento as e"
                    + " ON r.eLEMENTOelementoid.elemento_id=e.elemento_id"
                    + " WHERE (l.codigole like '%" + codigole + "%'"
                    + " OR l.subnacion =:depto"
                    + " OR l.subdivision =:municipio"
                    + " OR e.nombren like '%" + nombren + "%'"
                    + " OR e.nombrecomunn like '%" + nombrecomunn + "%'"
                    + " OR e.clase = '" + clase + "'"
                    + " OR e.comunidad ='" + comunidad + "')", Localizacion.class);
            query.setParameter("depto", depto);
            query.setParameter("municipio", municipio);
            return query.getResultList();

        } else {
            query = entityManager.createQuery("SELECT l FROM Localizacion l"
                    + " INNER JOIN Rastreo as r"
                    + " ON l.rASTREOrastreoid.rastreo_id=r.rastreo_id"
                    + " INNER JOIN Elemento as e"
                    + " ON r.eLEMENTOelementoid.elemento_id=e.elemento_id"
                    + " WHERE (l.codigole like '%" + codigole + "%'"
                    + " OR l.subnacion like '%" + depto + "%'"
                    + " OR l.subdivision like '%" + municipio + "%'"
                    + " OR e.nombren like '%" + nombren + "%'"
                    + " OR e.nombrecomunn like '%" + nombrecomunn + "%'"
                    + " OR e.clase = '" + clase + "'"
                    + " OR e.comunidad ='" + comunidad + "')"
                    + " AND e.clase !=:clase",
                    Localizacion.class);
            if (rol.equals("Botanica")) {
                query.setParameter("clase", "A");
                return query.getResultList();
            }
            if (rol.equals("Zoologia")) {
                query.setParameter("clase", "P");
                return query.getResultList();
            }
            return null;
        }

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
                = "SELECT NEW modelo.datos.representativos.IdentificadoresLE "
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
                = "SELECT NEW modelo.datos.representativos.IdentificadoresLE "
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
                = "SELECT NEW modelo.datos.representativos.IdentificadoresLE "
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
                = "SELECT NEW modelo.datos.representativos.IdentificadoresLE "
                + "(e.nombrecomunn,3) "
                + "FROM Elemento e "
                + "WHERE  e.codigoe = :codigoe";
        TypedQuery<IdentificadoresLE> query
                = entityManager.createQuery(queryStr, IdentificadoresLE.class);
        query.setParameter("codigoe", codigoe);
        IdentificadoresLE idenLE = query.getSingleResult();
        return idenLE;
    }

    public List<Localizacion> all(String rol) {
        TypedQuery<Localizacion> query = null;
        if (rol.equals("Admin")) {
            return entityManager.createQuery("SELECT l FROM Localizacion l", Localizacion.class).getResultList();
        } else {
            query = entityManager.createQuery("SELECT l FROM Localizacion l"
                    + " INNER JOIN Rastreo as r"
                    + " ON l.rASTREOrastreoid.rastreo_id=r.rastreo_id"
                    + " INNER JOIN Elemento as e"
                    + " ON r.eLEMENTOelementoid.elemento_id=e.elemento_id"
                    + " WHERE e.clase !=:clase", Localizacion.class);
            if (rol.equals("Botanica")) {
                query.setParameter("clase", "A");
                return query.getResultList();
            }
            if (rol.equals("Zoologia")) {
                query.setParameter("clase", "P");
                return query.getResultList();
            }
            return null;
        }

    }
}
