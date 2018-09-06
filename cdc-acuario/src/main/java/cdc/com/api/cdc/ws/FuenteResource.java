/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

import cdc.com.api.modelo.Fuente;
import cdc.com.api.servicio.FuenteService;
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
@Path("fuente")
@ManagedBean
public class FuenteResource {

    @Inject
    FuenteService fuenteServicio;

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Fuente> all() {
        System.out.println("***->Lista de Fuente");
        return fuenteServicio.all();
    }

    @POST
    @Path("/registro")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarLocalizacion(Fuente fuente) throws JSONException {
        JSONObject object = new JSONObject();

        Fuente fuente1 = new Fuente();
        fuente1.setCodfuente("codigo fuente bienbien");

        fuenteServicio.save(fuente1);
        object.put("codfuente", fuente.getCodfuente());
        System.out.println("***->Registro Exitoso Fuente :" + fuente.getCodfuente());
        return Response.status(202).entity(object.toString()).build();
    }
}
