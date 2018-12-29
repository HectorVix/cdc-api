/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

import cdc.com.api.modelo.Protocolo;
import cdc.com.api.servicio.ElementoService;
import cdc.com.api.servicio.ProtocoloService;
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
@Path("protocolo")
@ManagedBean
public class ProtocoloResource {

    @Inject
    ProtocoloService protocoloServicio;
    @Inject
    ElementoService elementoServicio;

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Protocolo> all() {
        System.out.println("***->Lista de Protocolo");
        return protocoloServicio.all();
    }

    @POST
    @Path("/registro")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarProtocolo(Protocolo protocolo) throws JSONException {
        JSONObject object = new JSONObject();
        boolean existe = elementoServicio.findElemento(protocolo.getCodigoe());
        if (existe == false) {
            throw new SecurityException("No existe el elemento");
        }
        protocoloServicio.save(protocolo);
        object.put("codigoe", protocolo.getCodigoe());
        System.out.println("***->Registro Exitoso Protocolo :" + protocolo.getCodigoe());
        return Response.status(202).entity(object.toString()).build();
    }
}
