/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Global;
import cdc.com.api.modelo.Rastreo;
import java.util.List;
import modelo.datos.representativos.IdentificadoresLE;
import modelo.datos.representativos.StatusGlobal;
import modelo.datos.representativos.StatusNacional;
import modelo.datos.representativos.StatusSubnacional;

/**
 *
 * @author Héctor Vix
 */
public interface RastreoService {

    public void save(Rastreo rastreo);

    public void update(Rastreo rastreo);

    public void delete(Long id);

    public Rastreo find(Long id);

    public Rastreo buscarRastreo_Codigoe(String codigoe);

    public List<Rastreo> all(String rol);

    public List<Rastreo> buscarRastreo(String codigoe, String subnacion, String nombren, String nombrecomunnn,
            String clase, String comunidad, String rol);

    public StatusGlobal status_Global(String codigoe);

    public StatusNacional status_Nacional(String codigoe);

    public StatusSubnacional status_Subnacional(String codigoe, String subnacion);
}
