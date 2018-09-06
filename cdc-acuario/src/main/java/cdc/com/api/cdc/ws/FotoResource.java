/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

import cdc.com.api.modelo.Foto;
import cdc.com.api.servicio.FotoService;
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
@Path("foto")
@ManagedBean
public class FotoResource {

    @Inject
    FotoService fotoServicio;

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Foto> all() {
        System.out.println("***->Lista de Fotos");
        return fotoServicio.all();
    }

    @POST
    @Path("/registro")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarLocalizacion(Foto foto) throws JSONException {
        JSONObject object = new JSONObject();

        Foto foto1 = new Foto();
        foto1.setNombre("foto 0.1");

        fotoServicio.save(foto1);
        object.put("nombre", foto.getNombre());
        System.out.println("***->Registro Exitoso Foto :" + foto.getNombre());
        return Response.status(202).entity(object.toString()).build();
    }
}
