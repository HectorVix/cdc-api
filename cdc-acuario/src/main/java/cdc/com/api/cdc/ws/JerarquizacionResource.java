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
import cdc.com.api.servicio.ElementoService;
import cdc.com.api.servicio.GlobalService;
import cdc.com.api.modelo.Global;
import cdc.com.api.modelo.Municipio;
import cdc.com.api.modelo.Nacion;
import cdc.com.api.modelo.Nacional;
import cdc.com.api.modelo.Rangog;
import cdc.com.api.modelo.Rangon;
import cdc.com.api.modelo.Rangos;
import cdc.com.api.modelo.Subnacion;
import cdc.com.api.modelo.Subnacional;
import cdc.com.api.servicio.MunicipioService;
import cdc.com.api.servicio.NacionService;
import cdc.com.api.servicio.NacionalService;
import cdc.com.api.servicio.RangogService;
import cdc.com.api.servicio.RangonService;
import cdc.com.api.servicio.RangosService;
import cdc.com.api.servicio.SubnacionService;
import cdc.com.api.servicio.SubnacionalService;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
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
    ElementoService elementoServicio;
    @Inject
    GlobalService globalServicio;
    @Inject
    NacionalService nacionalServicio;
    @Inject
    SubnacionalService subnacionalServicio;
    @Inject
    RangogService rangogServicio;
    @Inject
    RangonService rangonServicio;
    @Inject
    RangosService rangosServicio;
    @Inject
    NacionService nacionServicio;
    @Inject
    SubnacionService subnacionServicio;
    @Inject
    MunicipioService municipioServicio;

    @POST
    @Path("/registro/global")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarJerarquizacionGlobal(Global global) throws JSONException {
        Elemento elemento = new Elemento();
        JSONObject object = new JSONObject();
        if (elementoServicio.findElemento(global.getCodigoe())) {
            elemento.setElementoId(elementoServicio.getElemento_id());
            global.setELEMENTOelementoid(elemento);
            globalServicio.save(global);
            object.put("codigoe", global.getCodigoe());
            System.out.println("***->Registro jeraquizacion Global:" + global.getCodigoe());
            return Response.status(200).entity(object.toString()).build();
        } else {
            object.put("codigoe", global.getCodigoe());
            return Response.status(404).entity(object.toString()).build();
        }

    }

    @POST
    @Path("/registro/nacional")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarJerarquizacionNacional(Nacional nacional) throws JSONException {
        Elemento elemento = new Elemento();
        JSONObject object = new JSONObject();

        if (elementoServicio.findElemento(nacional.getCodigoe())) {
            elemento.setElementoId(elementoServicio.getElemento_id());
            nacional.setELEMENTOelementoid(elemento);
            nacionalServicio.save(nacional);
            object.put("codigoe", nacional.getCodigoe());
            System.out.println("***->Registro jeraquizacion Nacional:" + nacional.getCodigoe());
            return Response.status(200).entity(object.toString()).build();
        } else {
            object.put("codigoe", nacional.getCodigoe());
            return Response.status(404).entity(object.toString()).build();
        }

    }

    @POST
    @Path("/registro/subnacional")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarJerarquizacionSubNacional(Subnacional subnacional) throws JSONException {
        Elemento elemento = new Elemento();
        JSONObject object = new JSONObject();
        if (elementoServicio.findElemento(subnacional.getCodigoe())) {
            elemento.setElementoId(elementoServicio.getElemento_id());
            subnacional.setELEMENTOelementoid(elemento);
            subnacionalServicio.save(subnacional);
            object.put("codigoe", subnacional.getCodigoe());
            System.out.println("***->Registro jeraquizacion Subnacional:" + subnacional.getCodigoe());
            return Response.status(200).entity(object.toString()).build();
        } else {
            object.put("codigoe", subnacional.getCodigoe());
            return Response.status(404).entity(object.toString()).build();
        }
    }

    @GET
    @Path("/buscar/global/{codigoe}/{nombreg}/{descrielem}/{rol}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Global> buscarJeraquizacion_Global(
            @PathParam("codigoe") String codigoe,
            @PathParam("nombreg") String nombre,
            @PathParam("descrielem") String nomcomun,
            @PathParam("rol") String rol) {
        System.out.println("***->Busqueda exitosa jerarquizacion global");
        return globalServicio.buscarGlobal(codigoe, nombre, nombre, rol);
    }

    @POST
    @Path("/editar/global/{elemento_id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarJerarquizacion_Global(Global global, @PathParam("elemento_id") int elemento_id) throws JSONException {
        Elemento elemento = new Elemento();
        elemento.setElementoId(elemento_id);
        global.setELEMENTOelementoid(elemento);
        globalServicio.update(global);
        JSONObject object = new JSONObject();
        object.put("codigoe", global.getCodigoe());
        System.out.println("***->Editado exitoso jerarquizacion global:" + global.getCodigoe());
        return Response.status(200).entity(object.toString()).build();
    }

    @GET
    @Path("/buscar/nacional/{codigoe}/{nombren}/{nacion}/{rol}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Nacional> buscarJeraquizacion_Nacional(
            @PathParam("codigoe") String codigoe,
            @PathParam("nombren") String nombre,
            @PathParam("nacion") String nomcomun,
            @PathParam("rol") String rol) {
        System.out.println("***->Busqueda exitosa jerarquizacion nacional");
        return nacionalServicio.buscarNacional(codigoe, nombre, nomcomun, rol);
    }

    @POST
    @Path("/editar/nacional/{elemento_id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarJerarquizacion_Nacional(Nacional nacional, @PathParam("elemento_id") int elemento_id) throws JSONException {
        Elemento elemento = new Elemento();
        elemento.setElementoId(elemento_id);
        nacional.setELEMENTOelementoid(elemento);
        nacionalServicio.update(nacional);
        JSONObject object = new JSONObject();
        object.put("codigoe", nacional.getCodigoe());
        System.out.println("***->Editado exitoso jerarquizacion nacional:" + nacional.getCodigoe());
        return Response.status(200).entity(object.toString()).build();
    }

    @GET
    @Path("/buscar/subnacional/{codigoe}/{nacion}/{subnacion}/{nombres}/{loctips}/{rol}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Subnacional> buscarJeraquizacion_Subnacional(
            @PathParam("codigoe") String codigoe,
            @PathParam("nacion") String nacion,
            @PathParam("subnacion") String subnacion,
            @PathParam("nombres") String nombres,
            @PathParam("loctips") String loctips,
            @PathParam("rol") String rol) {
        System.out.println("***->Busqueda exitosa jerarquizacion subnacional");
        return subnacionalServicio.buscarSubnacional(codigoe, nacion, subnacion, nombres, loctips, rol);
    }

    @POST
    @Path("/editar/subnacional/{elemento_id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarJerarquizacion_Subnacional(Subnacional subnacional, @PathParam("elemento_id") int elemento_id) throws JSONException {
        Elemento elemento = new Elemento();
        elemento.setElementoId(elemento_id);
        subnacional.setELEMENTOelementoid(elemento);
        subnacionalServicio.update(subnacional);
        JSONObject object = new JSONObject();
        object.put("codigoe", subnacional.getCodigoe());
        System.out.println("***->Editado exitoso jerarquizacion subnacional:" + subnacional.getCodigoe());
        return Response.status(200).entity(object.toString()).build();
    }

    //Catalogos de rango
    @GET
    @Path("/rangog")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Rangog> catalogo_Rangog() {
        System.out.println("***->Obteniendo rangog");
        return rangogServicio.all();
    }

    @GET
    @Path("/rangon")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Rangon> catalogo_Rangon() {
        System.out.println("***->Obteniendo rangon");
        return rangonServicio.all();
    }

    @GET
    @Path("/rangos")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Rangos> catalogo_Rangos() {
        System.out.println("***->Obteniendo rangos");
        return rangosServicio.all();
    }

    //Catalogos de Nación, Subnacion(Depto.) y Municipio
    @GET
    @Path("/nacion")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Nacion> catalogo_Nacion() {
        System.out.println("***->Obteniendo nacion");
        return nacionServicio.all();
    }

    @GET
    @Path("/subnacion")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Subnacion> catalogo_Subnacion() {
        System.out.println("***->Obteniendo subnacion");
        return subnacionServicio.all();
    }

    @GET
    @Path("/municipio/{departamento_codigo}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Municipio> catalogo_Municipio(@PathParam("departamento_codigo") int departamento_codigo) {
        Subnacion subnacion = new Subnacion();
        subnacion.setSubnacionId(departamento_codigo);
        System.out.println("***->Obteniendo municipios");
        return municipioServicio.all(subnacion);
    }

    @GET
    @Path("/global/all/{rol}")
    @Produces(APPLICATION_JSON)
    public List<Global> all(@PathParam("rol") String rol) {
        System.out.println("***->All");
        return globalServicio.all(rol);
    }

    @GET
    @Path("/nacional/all/{rol}")
    @Produces(APPLICATION_JSON)
    public List<Nacional> all2(@PathParam("rol") String rol) {
        System.out.println("***->All2");
        return nacionalServicio.all(rol);
    }

    @GET
    @Path("/subnacional/all/{rol}")
    @Produces(APPLICATION_JSON)
    public List<Subnacional> all3(@PathParam("rol") String rol) {
        System.out.println("***->All3");
        return subnacionalServicio.all(rol);
    }
}
