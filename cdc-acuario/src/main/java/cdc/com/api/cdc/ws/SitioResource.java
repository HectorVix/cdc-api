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
import cdc.com.api.modelo.Sitio;
import cdc.com.api.servicio.SitioService;
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

@Path("sitio")
@ManagedBean
public class SitioResource {

    @Inject
    SitioService sitioServicio;

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Sitio> all() {
        System.out.println("***->Lista de Sitio");
        return sitioServicio.all();
    }

    @POST
    @Path("/registro")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarLocalizacion(Sitio sitio) throws JSONException {
        JSONObject object = new JSONObject();
        sitioServicio.save(sitio);
        object.put("codsitio", sitio.getCodsitio());
        System.out.println("***->Registro Exitoso Sitio :" + sitio.getCodsitio());
        return Response.status(202).entity(object.toString()).build();
    }
}
