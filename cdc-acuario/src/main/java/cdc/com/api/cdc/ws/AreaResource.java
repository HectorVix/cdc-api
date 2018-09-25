/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

import cdc.com.api.modelo.Area;
import cdc.com.api.servicio.AreaService;
import javax.annotation.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Héctor Vix
 */
@Path("area")
@ManagedBean
public class AreaResource {

    @Inject
    AreaService areaServicio;

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Area> all() {
        System.out.println("***->Lista de Areas");
        return areaServicio.all();
    }

    @POST
    @Path("/registro")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarLocalizacion(Area area) throws JSONException {
        JSONObject object = new JSONObject();     
        areaServicio.save(area);
        object.put("codigoam", area.getCodigoam());
        System.out.println("***->Registro Exitoso Area :" +area.getCodigoam());
        return Response.status(202).entity(object.toString()).build();
    }
}
