/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

import cdc.com.api.modelo.Caracterizacion;
import cdc.com.api.modelo.Distribucion;
import cdc.com.api.modelo.Distribucion2;
import cdc.com.api.modelo.Elemento;
import cdc.com.api.modelo.Planta;
import cdc.com.api.modelo.Vertebrado;
import cdc.com.api.servicio.CaracterizacionService;
import cdc.com.api.servicio.Distribucion2Service;
import cdc.com.api.servicio.DistribucionService;
import cdc.com.api.servicio.ElementoService;
import cdc.com.api.servicio.PlantaService;
import cdc.com.api.servicio.VertebradoService;
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
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Héctor Vix
 */
@Path("/cecon/caracterizacion")
@ManagedBean
public class CaracterizacionResource {

    @Inject
    CaracterizacionService caracterizacionServicio;
    @Inject
    PlantaService plantaServicio;
    @Inject
    VertebradoService vertebradoServicio;
    @Inject
    ElementoService elementoServicio;
    @Inject
    DistribucionService distribucionServicio;
    @Inject
    Distribucion2Service distribucion2Servicio;

    List<Distribucion> lista_distribucion;
    List<Distribucion2> lista_distribucion2;

    @POST
    @Path("/registro/planta")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarCaracterizacion_Planta(Caracterizacion caracterizacion) throws JSONException {
        JSONObject object = new JSONObject();
        Elemento elemento = new Elemento();
        Planta planta = new Planta();
        Caracterizacion caracterizacionBase = new Caracterizacion();
        Distribucion distribucion = new Distribucion();
        Distribucion2 distribucion2 = new Distribucion2();

        planta = caracterizacion.getPlantaList().get(0);
        lista_distribucion = planta.getDistribucionList();
        lista_distribucion2 = planta.getDistribucion2List();
        planta.setDistribucionList(null);//necesario dado que se necesita :marked cascade PERSIST
        planta.setDistribucion2List(null);
        String codigoe = planta.getCodigoe();
        boolean existe = elementoServicio.findElemento(codigoe);
        if (existe == false) {
            throw new SecurityException("No existe el elemento");
        }
        elemento.setElementoId(elementoServicio.getElemento_id());
        caracterizacionBase.setCodigoe(planta.getCodigoe());
        caracterizacionBase.setTipo(1);//tipo planta
        caracterizacionBase.setELEMENTOelementoid(elemento);
        int caracterizacion_id = caracterizacionServicio.save(caracterizacionBase);
        caracterizacionBase.setCaracterizacionId(caracterizacion_id);
        planta.setCARACTERIZACIONcaracterizacionid(caracterizacionBase);
        int planta_id = plantaServicio.save(planta);
        planta.setPlantaId(planta_id);//para las distribuciones
        //Distribución 1 planta datos 
        if (lista_distribucion.size() >= 1) {
            int tam_distribucion = lista_distribucion.size();
            for (int i = 0; i < tam_distribucion; i++) {
                distribucion = lista_distribucion.get(i);
                distribucion.setPLANTAplantaid(planta);
                distribucionServicio.save(distribucion);
                System.out.println("***->Registro exitoso distribucion:" + distribucion.getCodsubnac());
            }
        }
        //Distribución 2 planta datos 
        if (lista_distribucion2.size() >= 1) {
            int tam_distribucion2 = lista_distribucion2.size();
            for (int i = 0; i < tam_distribucion2; i++) {
                distribucion2 = lista_distribucion2.get(i);
                distribucion2.setPLANTAplantaid(planta);
                distribucion2Servicio.save(distribucion2);
                System.out.println("***->Registro exitoso distribucion 2:" + distribucion2.getCodecoregn());
            }
        }
        object.put("plantaId", planta_id);
        object.put("codigoe", caracterizacionBase.getCodigoe());
        System.out.println("***->Registro Exitoso Caracterizacion Planta:" + caracterizacionBase.getCodigoe());
        return Response.status(202).entity(object.toString()).build();
    }

    @POST
    @Path("/registro/vertebrado")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarCaracterizacion_Vertebrado(Caracterizacion caracterizacion) throws JSONException {
        JSONObject object = new JSONObject();
        Elemento elemento = new Elemento();
        Vertebrado vertebrado = new Vertebrado();
        Caracterizacion caracterizacionBase = new Caracterizacion();
        Distribucion distribucion = new Distribucion();
        Distribucion2 distribucion2 = new Distribucion2();

        vertebrado = caracterizacion.getVertebradoList().get(0);
        lista_distribucion = vertebrado.getDistribucionList();
        lista_distribucion2 = vertebrado.getDistribucion2List();
        vertebrado.setDistribucionList(null);//necesario dado que se necesita :marked cascade PERSIST
        vertebrado.setDistribucion2List(null);
        String codigoe = vertebrado.getCodigoe();
        boolean existe = elementoServicio.findElemento(codigoe);
        if (existe == false) {
            throw new SecurityException("No existe el elemento");
        }
        elemento.setElementoId(elementoServicio.getElemento_id());
        caracterizacionBase.setCodigoe(codigoe);
        caracterizacionBase.setTipo(2);//tipo vertebrado
        caracterizacionBase.setELEMENTOelementoid(elemento);
        int caracterizacion_id = caracterizacionServicio.save(caracterizacionBase);
        caracterizacionBase.setCaracterizacionId(caracterizacion_id);
        vertebrado.setCARACTERIZACIONcaracterizacionid(caracterizacionBase);
        int vertebrado_id = vertebradoServicio.save(vertebrado);
        vertebrado.setVertebradoId(vertebrado_id);//para las distribuciones

        //Distribución 1 vertebrado datos 
        if (lista_distribucion.size() >= 1) {
            int tam_distribucion = lista_distribucion.size();
            for (int i = 0; i < tam_distribucion; i++) {
                distribucion = lista_distribucion.get(i);
                distribucion.setVERTEBRADOvertebradoid(vertebrado);
                distribucionServicio.save(distribucion);
                System.out.println("***->Registro exitoso distribucion:" + distribucion.getCodsubnac());
            }
        }
        //Distribución 2 vertebrado datos 
        if (lista_distribucion2.size() >= 1) {
            int tam_distribucion2 = lista_distribucion2.size();
            for (int i = 0; i < tam_distribucion2; i++) {
                distribucion2 = lista_distribucion2.get(i);
                distribucion2.setVERTEBRADOvertebradoid(vertebrado);
                distribucion2Servicio.save(distribucion2);
                System.out.println("***->Registro exitoso distribucion 2:" + distribucion2.getCodecoregn());
            }
        }
        object.put("vertebradoId", vertebrado_id);
        object.put("codigoe", caracterizacionBase.getCodigoe());
        System.out.println("***->Registro Exitoso Caracterizacion Vertebrado:" + caracterizacionBase.getCodigoe());
        return Response.status(202).entity(object.toString()).build();
    }

    @GET
    @Path("/buscar/planta/{codigoe}/{nacion}/{nombren}/{nomcomunn}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Planta> buscarPlanta(
            @PathParam("codigoe") String codigoe,
            @PathParam("nacion") String nacion,
            @PathParam("nombren") String nombren,
            @PathParam("nomcomunn") String nomcomunn) {
        System.out.println("***->Busqueda exitosa de planta");
        return plantaServicio.buscarPlanta(codigoe, nacion, nombren, nomcomunn);
    }

    @POST
    @Path("/editar/planta/{caracterizacion_id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarPlanta(Planta planta, @PathParam("caracterizacion_id") int caracterizacion_id) throws JSONException {
        Caracterizacion caracterizacion = new Caracterizacion();
        caracterizacion.setCaracterizacionId(caracterizacion_id);
        planta.setCARACTERIZACIONcaracterizacionid(caracterizacion);
        plantaServicio.update(planta);
        JSONObject object = new JSONObject();
        object.put("codigoe", planta.getCodigoe());
        System.out.println("***->Editado exitoso planta:" + planta.getCodigoe());
        return Response.status(202).entity(object.toString()).build();
    }

    @GET
    @Path("/buscar/vertebrado/{codigoe}/{nacion}/{nombreg}/{autor}/{nombren}/{nomcomunn}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Vertebrado> buscarVertebrado(
            @PathParam("codigoe") String codigoe,
            @PathParam("nacion") String nacion,
            @PathParam("nombreg") String nombreg,
            @PathParam("autor") String autor,
            @PathParam("nombren") String nombren,
            @PathParam("nomcomunn") String nomcomunn) {
        System.out.println("***->Busqueda exitosa de vertebrado");
        return vertebradoServicio.buscarVertebrado(codigoe, nacion, nombreg, autor, nombren, nomcomunn);
    }

    @POST
    @Path("/editar/vertebrado/{caracterizacion_id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarVertebrado(Vertebrado vertebrado, @PathParam("caracterizacion_id") int caracterizacion_id) throws JSONException {
        Caracterizacion caracterizacion = new Caracterizacion();
        caracterizacion.setCaracterizacionId(caracterizacion_id);
        vertebrado.setCARACTERIZACIONcaracterizacionid(caracterizacion);
        vertebradoServicio.update(vertebrado);
        JSONObject object = new JSONObject();
        object.put("codigoe", vertebrado.getCodigoe());
        System.out.println("***->Editado exitoso vertebrado:" + vertebrado.getCodigoe());
        return Response.status(202).entity(object.toString()).build();
    }
    //----------------------Planta Get distribución 1 y 2---------------------------------------------------

    @GET
    @Path("/planta/distribucion1/{plantaId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Distribucion> buscarDistribucion1_Planta(@PathParam("plantaId") Integer plantaId) {
        System.out.println("***->Busqueda Exitosa Distribucion1:" + plantaId);
        Planta planta = new Planta();
        planta.setPlantaId(plantaId);
        return distribucionServicio.buscarDistribucion1_plantaId(planta);
    }

    @GET
    @Path("/planta/distribucion2/{plantaId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Distribucion2> buscarDistribucion2_Planta(@PathParam("plantaId") Integer plantaId) {
        System.out.println("***->Busqueda Exitosa Distribucion2:" + plantaId);
        Planta planta = new Planta();
        planta.setPlantaId(plantaId);
        return distribucion2Servicio.buscarDistribucion2_plantaId(planta);
    }
    //----------------------Vertebrado Get distribución 1 y 2---------------------------------------------------

    @GET
    @Path("/vertebrado/distribucion1/{vertebradoId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Distribucion> buscarDistribucion1_Vertebrado(@PathParam("vertebradoId") Integer vertebradoId) {
        System.out.println("***->Busqueda Exitosa Distribucion1:" + vertebradoId);
        Vertebrado vertebrado = new Vertebrado();
        vertebrado.setVertebradoId(vertebradoId);
        return distribucionServicio.buscarDistribucion1_vertebradoId(vertebrado);
    }

    @GET
    @Path("/vertebrado/distribucion2/{vertebradoId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Distribucion2> buscarDistribucion2_Vertebrado(@PathParam("vertebradoId") Integer vertebradoId) {
        System.out.println("***->Busqueda Exitosa Distribucion2:" + vertebradoId);
        Vertebrado vertebrado = new Vertebrado();
        vertebrado.setVertebradoId(vertebradoId);
        return distribucion2Servicio.buscarDistribucion2_vertebradoId(vertebrado);
    }

    //---------------Registrar distribuciónn 1 y 2 planta--------------------------
    @POST
    @Path("/planta/registrar/distribucion1/{plantaId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarDistribucion1_Planta(@PathParam("plantaId") Integer plantaId, Distribucion distribucion) throws JSONException {
        JSONObject object = new JSONObject();
        Planta planta = new Planta();
        planta.setPlantaId(plantaId);
        distribucion.setPLANTAplantaid(planta);
        distribucionServicio.save(distribucion);
        object.put("plantaId", plantaId);
        System.out.println("***->Registro Exitoso Distribucion1 :" + plantaId);
        return Response.status(202).entity(object.toString()).build();
    }

    @POST
    @Path("/planta/registrar/distribucion2/{plantaId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarDistribucion2_Planta(@PathParam("plantaId") Integer plantaId, Distribucion2 distribucion2) throws JSONException {
        JSONObject object = new JSONObject();
        Planta planta = new Planta();
        planta.setPlantaId(plantaId);
        distribucion2.setPLANTAplantaid(planta);
        distribucion2Servicio.save(distribucion2);
        object.put("plantaId", plantaId);
        System.out.println("***->Registro Exitoso Distribucion2 :" + plantaId);
        return Response.status(202).entity(object.toString()).build();
    }
    //------------------Registrar distribución 1 y 2 vertebrado--------------

    @POST
    @Path("/vertebrado/registrar/distribucion1/{vertebradoId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarDistribucion1_Vertebrado(@PathParam("vertebradoId") Integer vertebradoId, Distribucion distribucion) throws JSONException {
        JSONObject object = new JSONObject();
        Vertebrado vertebrado = new Vertebrado();
        vertebrado.setVertebradoId(vertebradoId);
        distribucion.setVERTEBRADOvertebradoid(vertebrado);
        distribucionServicio.save(distribucion);
        object.put("vertebradoId", vertebradoId);
        System.out.println("***->Registro Exitoso Distribucion1 :" + vertebradoId);
        return Response.status(202).entity(object.toString()).build();
    }

    @POST
    @Path("/vertebrado/registrar/distribucion2/{vertebradoId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarDistribucion2_Vertebrado(@PathParam("vertebradoId") Integer vertebradoId, Distribucion2 distribucion2) throws JSONException {
        JSONObject object = new JSONObject();
        Vertebrado vertebrado = new Vertebrado();
        vertebrado.setVertebradoId(vertebradoId);
        distribucion2.setVERTEBRADOvertebradoid(vertebrado);
        distribucion2Servicio.save(distribucion2);
        object.put("vertebradoId", vertebradoId);
        System.out.println("***->Registro Exitoso Distribucion2 :" + vertebradoId);
        return Response.status(202).entity(object.toString()).build();
    }

    //--------------Delete distribución 1 y 2 planta y vertebrado------------
    @POST
    @Path("/delete/distribucion1/{distribucion1Id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response borrarDistribucion1(@PathParam("distribucion1Id") Long distribucion1Id) throws JSONException {
        JSONObject object = new JSONObject();
        distribucionServicio.delete(distribucion1Id);
        object.put("distribucion1Id", distribucion1Id);
        System.out.println("***->Delete Exitoso Distribucion1 :" + distribucion1Id);
        return Response.status(202).entity(object.toString()).build();
    }

    @POST
    @Path("/delete/distribucion2/{distribucion2Id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response borrarDistribucion2(@PathParam("distribucion2Id") Long distribucion2Id) throws JSONException {
        JSONObject object = new JSONObject();
        distribucion2Servicio.delete(distribucion2Id);
        object.put("distribucion2Id", distribucion2Id);
        System.out.println("***->Delete Exitoso Distribucion2 :" + distribucion2Id);
        return Response.status(202).entity(object.toString()).build();
    }

    //-----------Actualizar distribución 1 y 2 planta------------
    @POST
    @Path("/planta/update/distribucion1/{plantaId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response actualizarDitribucion1_Planta(@PathParam("plantaId") Integer plantaId, Distribucion distribucion) throws JSONException {
        JSONObject object = new JSONObject();
        Planta planta = new Planta();
        planta.setPlantaId(plantaId);
        distribucion.setPLANTAplantaid(planta);
        distribucionServicio.update(distribucion);
        object.put("plantaId", plantaId);
        System.out.println("***->Update Exitoso Distribucion :" + plantaId);
        return Response.status(202).entity(object.toString()).build();
    }

    @POST
    @Path("/planta/update/distribucion2/{plantaId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response actualizarDitribucion2_Planta(@PathParam("plantaId") Integer plantaId, Distribucion2 distribucion2) throws JSONException {
        JSONObject object = new JSONObject();
        Planta planta = new Planta();
        planta.setPlantaId(plantaId);
        distribucion2.setPLANTAplantaid(planta);
        distribucion2Servicio.update(distribucion2);
        object.put("plantaId", plantaId);
        System.out.println("***->Update Exitoso Distribucion2:" + plantaId);
        return Response.status(202).entity(object.toString()).build();
    }
    //-----------Actualizar distribución 1 y 2 vertebrado------------

    @POST
    @Path("/vertebrado/update/distribucion1/{vertebradoId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response actualizarDitribucion1_Veretebrado(@PathParam("vertebradoId") Integer vertebradoId, Distribucion distribucion) throws JSONException {
        JSONObject object = new JSONObject();
        Vertebrado vertebrado = new Vertebrado();
        vertebrado.setVertebradoId(vertebradoId);
        distribucion.setVERTEBRADOvertebradoid(vertebrado);
        distribucionServicio.update(distribucion);
        object.put("vertebradoId", vertebradoId);
        System.out.println("***->Update Exitoso Distribucion :" + vertebradoId);
        return Response.status(202).entity(object.toString()).build();
    }

    @POST
    @Path("/vertebrado/update/distribucion2/{vertebradoId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response actualizarDitribucion2_Vertebrado(@PathParam("vertebradoId") Integer vertebradoId, Distribucion2 distribucion2) throws JSONException {
        JSONObject object = new JSONObject();
        Vertebrado vertebrado = new Vertebrado();
        vertebrado.setVertebradoId(vertebradoId);
        distribucion2.setVERTEBRADOvertebradoid(vertebrado);
        distribucion2Servicio.update(distribucion2);
        object.put("vertebradoId", vertebradoId);
        System.out.println("***->Update Exitoso Distribucion2:" + vertebradoId);
        return Response.status(202).entity(object.toString()).build();
    }

    @GET
    @Path("/planta/all")
    @Produces(APPLICATION_JSON)
    public List<Planta> all() {
        System.out.println("***->All");
        return plantaServicio.all();
    }

    @GET
    @Path("/vertebrado/all")
    @Produces(APPLICATION_JSON)
    public List<Vertebrado> all2() {
        System.out.println("***->All2");
        return vertebradoServicio.all();
    }
}
