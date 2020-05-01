/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Familia;
import cdc.com.api.modelo.Orden;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface FamiliaService {
    public List<Familia> buscar_Familia(Orden orden);
}
