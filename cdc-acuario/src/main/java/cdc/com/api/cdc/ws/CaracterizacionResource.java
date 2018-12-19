/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

import cdc.com.api.modelo.Caracterizacion;
import cdc.com.api.modelo.Distribucion;
import cdc.com.api.modelo.Elemento;
import cdc.com.api.modelo.Planta;
import cdc.com.api.modelo.Vertebrado;
import cdc.com.api.servicio.CaracterizacionService;
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
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Héctor Vix
 */
@Path("caracterizacion")
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
    List<Distribucion> lista_distribucion;

    //necesario dado que da error si se define de forma temporal
    public List<Distribucion> getLista_distribucion() {
        return lista_distribucion;
    }

    public void setLista_distribucion(List<Distribucion> lista_distribucion) {
        this.lista_distribucion = lista_distribucion;
    }

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Caracterizacion> all() {
        System.out.println("***->Lista de Caracterizacion");
        return caracterizacionServicio.all();
    }

    @Path("planta")
    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Planta> ListaPlantas() {
        System.out.println("***->Lista de Plantas");
        return plantaServicio.all();
    }

    @Path("vertebrado")
    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Vertebrado> ListaVertebrados() {
        System.out.println("***->Lista de Vertebrados");
        return vertebradoServicio.all();
    }

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

        planta = caracterizacion.getPlantaList().get(0);
        System.out.println("***->Distribucion Tam:" + planta.getDistribucionList().size());
        lista_distribucion = planta.getDistribucionList();
        planta.setDistribucionList(null);//neceario dado que se necesita :marked cascade PERSIST
        String codigoe = planta.getCodigoe();
        boolean existe = elementoServicio.findElemento(codigoe);
        if (existe == false) {
            throw new SecurityException("No existe el elemento");
        }
        elemento.setElementoId(elementoServicio.getElemento_id());
        caracterizacionBase.setCodigoe(planta.getCodigoe());
        caracterizacionBase.setELEMENTOelementoid(elemento);
        int caracterizacion_id = caracterizacionServicio.save(caracterizacionBase);
        caracterizacionBase.setCaracterizacionId(caracterizacion_id);
        planta.setCARACTERIZACIONcaracterizacionid(caracterizacionBase);
        plantaServicio.save(planta);
        //Distribucion planta datos 
        if (lista_distribucion.size() >= 1) {
            int tam_distribucion = lista_distribucion.size();
            for (int i = 0; i < tam_distribucion; i++) {
                distribucion = lista_distribucion.get(i);
                distribucionServicio.save(distribucion);
                System.out.println("***->recorrido distribucion:" + i);
                System.out.println("***->Infor distribucion:" + distribucion.getCodsubnac());
                System.out.println("***->Registro exitoso distribucion:" + distribucion.getCodsubnac());
            }
        }
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

        Caracterizacion caracterizacion1 = new Caracterizacion();
        caracterizacion1.setCodigoe("codigo caracterizacion good");

        caracterizacionServicio.save(caracterizacion1);
        object.put("codsitio", caracterizacion1.getCodigoe());
        System.out.println("***->Registro Exitoso Caracterizacion Vertebrado:" + caracterizacion1.getCodigoe());
        return Response.status(202).entity(object.toString()).build();
    }

}
