/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

import javax.annotation.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import cdc.com.api.servicio.ElementoService;
import cdc.com.api.modelo.Elemento;
import cdc.com.api.modelo.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

/**
 *
 * @author Héctor Vix
 */
@Path("elemento")
@ManagedBean
public class ElementoResource {

    @Inject
    ElementoService elementoServicio;

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Elemento> all() {
        System.out.println("***->Lista de Elementos");
        return elementoServicio.all();
    }

    @GET
    @Path("/buscar/{codigo}/{nombrecomun}/{nombrecientifico}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Elemento> buscarElemento(@PathParam("codigo") String codigo,
            @PathParam("nombrecomun") String nombrecomun,
            @PathParam("nombrecientifico") String nombrecientifico) {
        System.out.println("***->Lista de Elementos buscados");
        return elementoServicio.buscarElemento(codigo, nombrecomun, nombrecientifico);
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Elemento find(@PathParam("id") Long id) {
        System.out.println("***->Elemento" + id);
        Elemento el = elementoServicio.find(id);
        return el;
    }

    @GET
    @Path("/validar/{codigoe}")
    @Produces(APPLICATION_JSON)
    public Elemento findElemento(@PathParam("codigoe") String codigoe) throws JSONException, Exception {
        System.out.println("***->Enontrando elemento:" + codigoe);
        validarElemento(codigoe);
        Elemento el = new Elemento();
        el.setElementoId(elementoServicio.getElemento_id());
        return el;
    }

    private void validarElemento(String codigoe) throws Exception {
        boolean elemento = elementoServicio.findElemento(codigoe);
        if (elemento == false) {
            throw new SecurityException("No existe el elemento");
        }
    }

    @POST
    @Path("/registro/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarElemento(Elemento elemento, @PathParam("id") int id) throws JSONException {
        System.out.println("***->Registrando Elemento..." + elemento.getCodigo());
        Usuario us = new Usuario();
        us.setUsuarioId(id);
        elemento.setUSUARIOusuarioid(us);
        elementoServicio.save(elemento);
        JSONObject object = new JSONObject();
        object.put("codigo", elemento.getCodigo());
        return Response.status(202).entity(object.toString()).build();
    }
}
