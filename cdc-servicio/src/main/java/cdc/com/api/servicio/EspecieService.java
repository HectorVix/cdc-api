/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Especie;
import cdc.com.api.modelo.Genero;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface EspecieService {

    public List<Especie> buscar_Especie(Genero genero);
}
