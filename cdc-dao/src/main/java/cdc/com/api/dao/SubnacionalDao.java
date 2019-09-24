/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.dao;

import cdc.com.api.modelo.Subnacional;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface SubnacionalDao {

    public void save(Subnacional subnacional);

    public void update(Subnacional subnacional);

    public void delete(Long id);

    public Subnacional find(Long id);

    public List<Subnacional> all(String rol);

    public List<Subnacional> buscarSubnacional(
            String codigoe,
            String nacion,
            String subnacion,
            String nombres,
            String loctips, String rol);
}
