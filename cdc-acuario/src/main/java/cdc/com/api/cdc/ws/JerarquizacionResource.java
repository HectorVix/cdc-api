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
import cdc.com.api.servicio.ElementoService;
import cdc.com.api.servicio.GlobalService;
import cdc.com.api.modelo.Global;
import cdc.com.api.modelo.Nacional;
import cdc.com.api.modelo.Subnacional;
import cdc.com.api.servicio.NacionalService;
import cdc.com.api.servicio.SubnacionalService;

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
@Path("/cecon/jerarquizacion")
@ManagedBean
public class JerarquizacionResource {

    @Inject
    JerarquizacionService jerarquizacionServicio;
    @Inject
    ElementoService elementoServicio;
    @Inject
    GlobalService globalServicio;
    @Inject
    NacionalService nacionalServicio;
    @Inject
    SubnacionalService subnacionalServicio;

    @POST
    @Path("/registro/global")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarJerarquizacionGlobal(Jerarquizacion jerarquizacion) throws JSONException {
        Elemento elemento = new Elemento();
        String codigoe = jerarquizacion.getGlobalList().get(0).getCodigoe();
        boolean existe = elementoServicio.findElemento(codigoe);
        if (existe == false) {
            throw new SecurityException("No existe el elemento");
        }
        elemento.setElementoId(elementoServicio.getElemento_id());
        Jerarquizacion jer = new Jerarquizacion();
        jer.setCodigoe(codigoe);
        jer.setELEMENTOelementoid(elemento);
        int jeraquia_id = jerarquizacionServicio.save(jer);
        Global global = new Global();
        global = jerarquizacion.getGlobalList().get(0);
        jer.setJerarquizacionId(jeraquia_id);
        global.setJERARQUIZACIONjerarquizacionid(jer);
        globalServicio.save(global);
        JSONObject object = new JSONObject();
        object.put("codigoe", jerarquizacion.getCodigoe());
        System.out.println("***->Registro jeraquizacion Global:" + codigoe);
        return Response.status(202).entity(object.toString()).build();
    }

    @POST
    @Path("/registro/nacional")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarJerarquizacionNacional(Jerarquizacion jerarquizacion) throws JSONException {
        Elemento elemento = new Elemento();
        String codigoe = jerarquizacion.getNacionalList().get(0).getCodigoe();
        boolean existe = elementoServicio.findElemento(codigoe);
        if (existe == false) {
            throw new SecurityException("No existe el elemento");
        }
        elemento.setElementoId(elementoServicio.getElemento_id());
        Jerarquizacion jer = new Jerarquizacion();
        jer.setCodigoe(codigoe);
        jer.setELEMENTOelementoid(elemento);
        int jeraquia_id = jerarquizacionServicio.save(jer);
        System.out.println("***->Id ligadura jerararquizacion nacional:" + jeraquia_id);
        Nacional nacional = new Nacional();
        nacional = jerarquizacion.getNacionalList().get(0);
        jer.setJerarquizacionId(jeraquia_id);
        nacional.setJERARQUIZACIONjerarquizacionid(jer);
        nacionalServicio.save(nacional);
        JSONObject object = new JSONObject();
        object.put("codigoe", jerarquizacion.getCodigoe());
        System.out.println("***->Registro jeraquizacion Nacional:" + jerarquizacion.getCodigoe());
        return Response.status(202).entity(object.toString()).build();
    }

    @POST
    @Path("/registro/subnacional")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarJerarquizacionSubNacional(Jerarquizacion jerarquizacion) throws JSONException {
        Elemento elemento = new Elemento();
        String codigoe = jerarquizacion.getSubnacionalList().get(0).getCodigoe();
        boolean existe = elementoServicio.findElemento(codigoe);
        if (existe == false) {
            throw new SecurityException("No existe el elemento");
        }
        elemento.setElementoId(elementoServicio.getElemento_id());
        Jerarquizacion jer = new Jerarquizacion();
        jer.setCodigoe(codigoe);
        jer.setELEMENTOelementoid(elemento);
        int jeraquia_id = jerarquizacionServicio.save(jer);
        System.out.println("***->Id ligadura jerararquizacion sub nacional:" + jeraquia_id);
        Subnacional subnacional = jerarquizacion.getSubnacionalList().get(0);
        jer.setJerarquizacionId(jeraquia_id);
        subnacional.setJERARQUIZACIONjerarquizacionid(jer);
        subnacionalServicio.save(subnacional);
        JSONObject object = new JSONObject();
        object.put("codigoe", jerarquizacion.getCodigoe());
        System.out.println("***->Registro jeraquizacion Subnacional:" + jerarquizacion.getCodigoe());
        return Response.status(202).entity(object.toString()).build();
    }

    @GET
    @Path("/buscar/global/{codigoe}/{nombreg}/{descrielem}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Global> buscarJeraquizacion_Global(
            @PathParam("codigoe") String codigoe,
            @PathParam("nombreg") String nombre,
            @PathParam("descrielem") String nomcomun) {
        System.out.println("***->Busqueda exitosa jerarquizacion global");
        return globalServicio.buscarGlobal(codigoe, nombre, nombre);
    }

    @POST
    @Path("/editar/global/{jerarquia_id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarJerarquizacion_Global(Global global, @PathParam("jerarquia_id") int jerarquia_id) throws JSONException {
        Jerarquizacion jerarquizacion = new Jerarquizacion();
        jerarquizacion.setJerarquizacionId(jerarquia_id);
        global.setJERARQUIZACIONjerarquizacionid(jerarquizacion);
        globalServicio.update(global);
        JSONObject object = new JSONObject();
        object.put("codigoe", global.getCodigoe());
        System.out.println("***->Editado exitoso jerarquizacion global:" + global.getCodigoe());
        return Response.status(202).entity(object.toString()).build();
    }

    @GET
    @Path("/buscar/nacional/{codigoe}/{nombren}/{nacion}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Nacional> buscarJeraquizacion_Nacional(
            @PathParam("codigoe") String codigoe,
            @PathParam("nombren") String nombre,
            @PathParam("nacion") String nomcomun) {
        System.out.println("***->Busqueda exitosa jerarquizacion nacional");
        return nacionalServicio.buscarNacional(codigoe, nombre, nomcomun);
    }

    @POST
    @Path("/editar/nacional/{jerarquia_id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarJerarquizacion_Nacional(Nacional nacional, @PathParam("jerarquia_id") int jerarquia_id) throws JSONException {
        Jerarquizacion jerarquizacion = new Jerarquizacion();
        jerarquizacion.setJerarquizacionId(jerarquia_id);
        nacional.setJERARQUIZACIONjerarquizacionid(jerarquizacion);
        nacionalServicio.update(nacional);
        JSONObject object = new JSONObject();
        object.put("codigoe", nacional.getCodigoe());
        System.out.println("***->Editado exitoso jerarquizacion nacional:" + nacional.getCodigoe());
        return Response.status(202).entity(object.toString()).build();
    }

    @GET
    @Path("/buscar/subnacional/{codigoe}/{nacion}/{subnacion}/{nombres}/{loctips}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Subnacional> buscarJeraquizacion_Subnacional(
            @PathParam("codigoe") String codigoe,
            @PathParam("nacion") String nacion,
            @PathParam("subnacion") String subnacion,
            @PathParam("nombres") String nombres,
            @PathParam("loctips") String loctips) {
        System.out.println("***->Busqueda exitosa jerarquizacion subnacional");
        return subnacionalServicio.buscarSubnacional(codigoe, nacion, subnacion, nombres, loctips);
    }

    @POST
    @Path("/editar/subnacional/{jerarquia_id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarJerarquizacion_Subnacional(Subnacional subnacional,@PathParam("jerarquia_id") int jerarquia_id)throws JSONException {
        Jerarquizacion jerarquizacion = new Jerarquizacion();
        jerarquizacion.setJerarquizacionId(jerarquia_id);
        subnacional.setJERARQUIZACIONjerarquizacionid(jerarquizacion);
        subnacionalServicio.update(subnacional);
        JSONObject object = new JSONObject();
        object.put("codigoe", subnacional.getCodigoe());
        System.out.println("***->Editado exitoso jerarquizacion subnacional:" + subnacional.getCodigoe());
        return Response.status(202).entity(object.toString()).build();
    }
}
