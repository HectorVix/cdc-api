/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

/**
 *
 * @author Héctor Vix
 */
import cdc.com.api.modelo.Rastreo;
import cdc.com.api.servicio.RastreoService;
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

@Path("rastreo")
@ManagedBean
public class RastreoResource {

    @Inject
    RastreoService rastreoServicio;

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Rastreo> all() {
        System.out.println("***->Lista de Rastreo");
        return rastreoServicio.all();
    }

    @POST
    @Path("/registro")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarRastreo(Rastreo rastreo) throws JSONException {
        JSONObject object = new JSONObject();
        rastreoServicio.save(rastreo);
        object.put("codigoe", rastreo.getCodigoe());
        System.out.println("***->Registro Exitoso Rastreo :" + rastreo.getCodigoe());
        return Response.status(202).entity(object.toString()).build();
    }

    @GET
    @Path("/buscar/{codigoe}/{subnacion}/{nombreg}/{nombren}/{nombrecomunnn}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Rastreo> buscarRastreo(
            @PathParam("codigoe") String codigoe,
            @PathParam("subnacion") String subnacion,
            @PathParam("nombreg") String nombreg,
            @PathParam("nombren") String nombren,
            @PathParam("nombrecomunnn") String nombrecomunnn) {
        System.out.println("***->Busqueda Exitosa de RE");
        return rastreoServicio.buscarRastreo(codigoe, subnacion, nombreg, nombren, nombrecomunnn);

    }
}
