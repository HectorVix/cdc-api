/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Localizacion;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface LocalizacionService {

    public int save(Localizacion localizacion);

    public void update(Localizacion localizacion);

    public boolean findRastreo(String codigoe);

    public int getRastreo_id();

    public List<Localizacion> buscarLocalizacion(String codigole);

}
