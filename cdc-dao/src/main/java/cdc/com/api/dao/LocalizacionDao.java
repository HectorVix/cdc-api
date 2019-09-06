/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.Localizacion;
import modelo.datos.representativos.IdentificadoresLE;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface LocalizacionDao {

    public int save(Localizacion localizacion);

    public void update(Localizacion localizacion);

    public boolean findRastreo(String codigoe);

    public int getRastreo_id();

    public List<Localizacion> all();

    public List<Localizacion> buscarLocalizacion(String codigole);

    public IdentificadoresLE buscar_Identificadores_NombreS_RangoS(String codigoe, String departamento);

    public IdentificadoresLE buscar_Identificadores_RangoG(String codigoe);

    public IdentificadoresLE buscar_Identificadores_RangoN(String codigoe);

    public IdentificadoresLE buscar_Identificadores_NombreComunN(String codigoe);

}
