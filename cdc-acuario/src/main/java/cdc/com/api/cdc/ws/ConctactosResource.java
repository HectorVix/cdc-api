/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

import cdc.com.api.modelo.Contactos;
import cdc.com.api.servicio.ContactosService;
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
@Path("contactos")
@ManagedBean
public class ConctactosResource {

    @Inject
    ContactosService contactosServicio;

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Contactos> all() {
        System.out.println("***->Lista de Contactos");
        return contactosServicio.all();
    }

    @POST
    @Path("/registro")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarLocalizacion(Contactos contactos) throws JSONException {
        JSONObject object = new JSONObject();

        Contactos contactos1 = new Contactos();
        contactos1.setNumident("xdxdxd");

        contactosServicio.save(contactos1);
        object.put("codsitio", contactos.getNumident());
        System.out.println("***->Registro Exitoso Contactos :" + contactos.getNumident());
        return Response.status(202).entity(object.toString()).build();
    }
}
