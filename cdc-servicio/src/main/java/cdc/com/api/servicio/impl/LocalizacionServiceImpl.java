/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.LocalizacionDao;
import cdc.com.api.modelo.Localizacion;
import cdc.com.api.modelo.datos.representativos.IdentificadoresLE;
import cdc.com.api.servicio.LocalizacionService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class LocalizacionServiceImpl implements LocalizacionService {

    @Inject
    private LocalizacionDao localizacionDao;

    public int save(Localizacion localizacion) {
        return localizacionDao.save(localizacion);
    }

    public void update(Localizacion localizacion) {
        localizacionDao.update(localizacion);
    }

    public List<Localizacion> buscarLocalizacion(String codigole) {
        return localizacionDao.buscarLocalizacion(codigole);
    }

    public boolean findRastreo(String codigoe) {
        return localizacionDao.findRastreo(codigoe);
    }

    public int getRastreo_id() {
        return localizacionDao.getRastreo_id();
    }

    public IdentificadoresLE buscar_Identificadores_NombreS_RangoS(String codigoe, String departamento) {
        return localizacionDao.buscar_Identificadores_NombreS_RangoS(codigoe, departamento);
    }

    public IdentificadoresLE buscar_Identificadores_RangoG(String codigoe) {
        return localizacionDao.buscar_Identificadores_RangoG(codigoe);
    }

    public IdentificadoresLE buscar_Identificadores_RangoN(String codigoe) {
        return localizacionDao.buscar_Identificadores_RangoN(codigoe);
    }

    public IdentificadoresLE buscar_Identificadores_NombreComunN(String codigoe) {
        return localizacionDao.buscar_Identificadores_NombreComunN(codigoe);
    }

}
