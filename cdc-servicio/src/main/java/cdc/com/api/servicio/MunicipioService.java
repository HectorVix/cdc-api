/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Municipio;
import cdc.com.api.modelo.Subnacion;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface MunicipioService {

    public List<Municipio> all(Subnacion subnacion);
}
