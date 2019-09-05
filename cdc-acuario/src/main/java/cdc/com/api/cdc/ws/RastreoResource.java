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
import cdc.com.api.modelo.Elemento;
import cdc.com.api.modelo.Global;
import cdc.com.api.modelo.Rastreo;
import cdc.com.api.servicio.ElementoService;
import cdc.com.api.servicio.RastreoService;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import modelo.datos.representativos.IdentificadoresLE;
import modelo.datos.representativos.StatusGlobal;
import modelo.datos.representativos.StatusNacional;
import modelo.datos.representativos.StatusSubnacional;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("/cecon/rastreo")
@ManagedBean
public class RastreoResource {

    @Inject
    RastreoService rastreoServicio;
    @Inject
    ElementoService elementoServicio;

    @POST
    @Path("/registro")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarRastreo(Rastreo rastreo) throws JSONException {
        JSONObject object = new JSONObject();
        Elemento elemento = new Elemento();
        if (elementoServicio.findElemento(rastreo.getCodigoe())) {
            elemento.setElementoId(elementoServicio.getElemento_id());
            rastreo.setELEMENTOelementoid(elemento);
            rastreoServicio.save(rastreo);
            object.put("codigoe", rastreo.getCodigoe());
            System.out.println("***->Registro Exitoso Rastreo :" + rastreo.getCodigoe());
            return Response.status(200).entity(object.toString()).build();
        } else {
            return Response.status(404).entity(object.toString()).build();
        }

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

    @POST
    @Path("/editar/{elemento_id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarRastreoElemento(Rastreo rastreo, @PathParam("elemento_id") int elemento_id) throws JSONException {
        Elemento elemento = new Elemento();
        elemento.setElementoId(elemento_id);
        rastreo.setELEMENTOelementoid(elemento);
        rastreoServicio.update(rastreo);
        JSONObject object = new JSONObject();
        object.put("codigoe", rastreo.getCodigoe());
        System.out.println("***->Editado exitoso RE:" + rastreo.getCodigoe());
        return Response.status(200).entity(object.toString()).build();
    }

    @GET
    @Path("/status/global/{codigoe}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public StatusGlobal status_Global(@PathParam("codigoe") String codigoe) {
        System.out.println("***->Status global");
        return rastreoServicio.status_Global(codigoe);
    }

    @GET
    @Path("/status/nacional/{codigoe}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public StatusNacional status_Nacional(@PathParam("codigoe") String codigoe) {
        System.out.println("***->Status nacional");
        return rastreoServicio.status_Nacional(codigoe);
    }

    @GET
    @Path("/status/subnacional/{codigoe}/{subnacion}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public StatusSubnacional status_Subnacional(@PathParam("codigoe") String codigoe, @PathParam("subnacion") String subnacion) {
        System.out.println("***->Status subnacional");
        return rastreoServicio.status_Subnacional(codigoe, subnacion);
    }
}
