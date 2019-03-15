/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

import cdc.com.api.modelo.Contacto;
import cdc.com.api.modelo.Usuario;
import cdc.com.api.servicio.AreaService;
import cdc.com.api.servicio.ContactoService;
import cdc.com.api.servicio.FuenteService;
import cdc.com.api.servicio.SitioService;
import javax.annotation.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Héctor Vix
 */
@Path("/cecon/contacto")
@ManagedBean
public class ConctactoResource {

    @Inject
    ContactoService contactoServicio;
    @Inject
    FuenteService fuenteServicio;
    @Inject
    AreaService areaServicio;
    @Inject
    SitioService sitioServicio;

    @POST
    @Path("/registro/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarContacto(Contacto contacto, @PathParam("id") int id) throws JSONException {
        JSONObject object = new JSONObject();
        Usuario us = new Usuario();
        us.setUsuarioId(id);
        contacto.setUSUARIOusuarioid(us);
        contactoServicio.save(contacto);
        object.put("numident", contacto.getNumident());
        System.out.println("***->Registro Exitoso Contacto:" + contacto.getNumident());
        return Response.status(200).entity(object.toString()).build();
    }

    @GET
    @Path("/buscar/{numident}/{nombreident}/{nombre}/{apellido1}/{apellido2}/{email}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Contacto> buscarContactos(
            @PathParam("numident") String numident,
            @PathParam("nombreident") String nombreident,
            @PathParam("nombre") String nombre,
            @PathParam("apellido1") String apellido1,
            @PathParam("apellido2") String apellido2,
            @PathParam("email") String email) {
        System.out.println("***->Busqueda Exitosa de Contactos");
        return contactoServicio.buscarContacto(numident, nombreident, nombre, apellido1, apellido2, email);
    }

    @POST
    @Path("/editar/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarContactos(Contacto contacto, @PathParam("id") Integer id) throws JSONException {
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(id);
        contacto.setUSUARIOusuarioid(usuario);
        contactoServicio.update(contacto);
        JSONObject object = new JSONObject();
        object.put("numident", contacto.getNumident());
        System.out.println("***->Editado exitoso contacto:" + contacto.getNumident());
        return Response.status(200).entity(object.toString()).build();
    }

    @GET
    @Path("/validar/fuente/{codfuente}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response validarFuente(@PathParam("codfuente") String codfuente) throws JSONException {
        JSONObject object = new JSONObject();
        object.put("codfuente", codfuente);
        System.out.println("***->Encontrando fuente:" + codfuente);
        boolean fuente = fuenteServicio.findFuente(codfuente);
        if (fuente) {
            return Response.status(200).entity(object.toString()).build();
        } else {
            return Response.status(404).entity(object.toString()).build();
        }
    }

    @GET
    @Path("/validar/area/{codigoam}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response validarArea(@PathParam("codigoam") String codigoam) throws JSONException {
        JSONObject object = new JSONObject();
        object.put("codigoam", codigoam);
        System.out.println("***->Encontrando area:" + codigoam);
        boolean area = areaServicio.findArea(codigoam);
        if (area) {
            return Response.status(200).entity(object.toString()).build();
        } else {
            return Response.status(404).entity(object.toString()).build();
        }
    }

    @GET
    @Path("/validar/sitio/{codsitio}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response validarSitio(@PathParam("codsitio") String codsitio) throws JSONException {
        JSONObject object = new JSONObject();
        object.put("codsitio", codsitio);
        System.out.println("***->Encontrando sitio:" + codsitio);
        boolean sitio = sitioServicio.findSitio(codsitio);
        if (sitio) {
            return Response.status(200).entity(object.toString()).build();
        } else {
            return Response.status(404).entity(object.toString()).build();
        }
    }
}
