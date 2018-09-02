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
import cdc.com.api.modelo.Localizacion;
import cdc.com.api.modelo.Rastreo;
import cdc.com.api.servicio.LocalizacionService;
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

@Path("localizacion")
@ManagedBean
public class LocalizacionResource {
    
    @Inject
    LocalizacionService localizacionServicio;
    
    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Localizacion> all() {
        System.out.println("***->Lista de Localizacion");
        return localizacionServicio.all();
    }

    @POST
    @Path("/registro/{codigole}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarLocalizacion(Localizacion localizacion) throws JSONException {
        JSONObject object = new JSONObject();
        
        Localizacion loc = new Localizacion();
        loc.setCodigole("hola goooo");
        
        localizacionServicio.save(loc);
        object.put("codigole", localizacion.getCodigole());
        System.out.println("***->Registro Exitoso Localizacion :" + localizacion.getCodigole());
        //System.out.println("***->Prueba datos :" + localizacion.getRespdatos());
        return Response.status(202).entity(object.toString()).build();
    }
}
