/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.Area;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface AreaService {

    public int save(Area area);

    public void update(Area area);

    public void delete(Long id);

    public Area find(Long id);

    public List<Area> all();

    public List<Area> buscarArea(String codigoam,
            String nombream,
            String sinam,
            String codsitio,
            String nomsitio,
            String nacion, String subnacion, String subdivision);

    public boolean findArea(String codigoam);

    public int getArea_Id();
}
