/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

import cdc.com.api.modelo.Fuente;
import cdc.com.api.modelo.Rastreo;
import cdc.com.api.modelo.Tema;
import cdc.com.api.modelo.Usuario;
import cdc.com.api.servicio.FuenteService;
import cdc.com.api.servicio.TemaService;
import java.util.List;
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
    @Inject
    TemaService temaServicio;

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Fuente> all() {
        System.out.println("***->Lista de Fuente");
        return fuenteServicio.all();
    }

    @POST
    @Path("/registro/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarLocalizacion(Fuente fuente, @PathParam("id") int id) throws JSONException {
        JSONObject object = new JSONObject();
        Usuario us = new Usuario();
        List<Tema> temaList = fuente.getTemaList();
        Tema tema = new Tema();
        
        us.setUsuarioId(id);
        fuente.setUSUARIOusuarioid(us);
        fuente.setTemaList(null);
        int fuente_id = fuenteServicio.save(fuente);
        fuente.setFuenteId(fuente_id);
        tema.setFUENTEfuenteid(fuente);
        for (int _i = 0; _i < temaList.size(); _i++) {
            tema.setNombre(temaList.get(_i).getNombre());
            tema.setTipo(temaList.get(_i).getTipo());
            temaServicio.save(tema);
        }
        object.put("codfuente", fuente.getCodfuente());
        System.out.println("***->Registro Exitoso Fuente:" + fuente.getCodfuente());
        return Response.status(202).entity(object.toString()).build();
    }
}
