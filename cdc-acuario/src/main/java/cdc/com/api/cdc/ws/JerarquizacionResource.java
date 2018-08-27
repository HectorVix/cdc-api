/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;
import cdc.com.api.modelo.Elemento;
import javax.annotation.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import cdc.com.api.servicio.JerarquizacionService;
import cdc.com.api.modelo.Jerarquizacion;



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
@Path("jerarquizacion")
@ManagedBean
public class JerarquizacionResource {
    @Inject
    JerarquizacionService jerarquizacionServicio;

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Jerarquizacion> all() {
        System.out.println("***->Lista de Jeraquia");
        return jerarquizacionServicio.all();
    }
      @POST
    @Path("/registro")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarJerarquia(Jerarquizacion jerarquizacion) throws JSONException {
        Elemento elemento = new Elemento();
       String  codigoe=jerarquizacion.getGlobalList().get(0).getCodigoe();
      /*  elemento.setElementoId(1);
        Jerarquizacion jer = new Jerarquizacion();
        jer.setCodigoe("alfaomega");
        jer.setELEMENTOelementoid(elemento);
        jerarquizacionServicio.save(jer);*/
        System.out.println("jerarquizacion codigoe:"+codigoe);
     
        JSONObject object = new JSONObject();
        object.put("codigo", "ok");
        return Response.status(202).entity(object.toString()).build();
    }
}
