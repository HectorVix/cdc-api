/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.Familia;
import cdc.com.api.modelo.Genero;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface GeneroDao {
    public List<Genero> buscar_Genero(Familia familia);
}
