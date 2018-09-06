/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

import cdc.com.api.modelo.Observaciones;
import cdc.com.api.servicio.ObservacionesService;
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
@Path("observaciones")
@ManagedBean
public class ObservacionesResource {

    @Inject
    ObservacionesService observacionesServicio;

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Observaciones> all() {
        System.out.println("***->Lista de Observaciones");
        return observacionesServicio.all();
    }

    @POST
    @Path("/registro")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarLocalizacion(Observaciones observaciones) throws JSONException {
        JSONObject object = new JSONObject();

        Observaciones observaciones1 = new Observaciones();
        observaciones1.setNombre("nombre observaciones");

        observacionesServicio.save(observaciones1);
        object.put("nombre", observaciones.getNombre());
        System.out.println("***->Registro Exitoso Observaciones :" + observaciones.getNombre());
        return Response.status(202).entity(object.toString()).build();
    }
}
