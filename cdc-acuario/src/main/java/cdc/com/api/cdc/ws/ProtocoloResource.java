/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

import cdc.com.api.modelo.Dispersion;
import cdc.com.api.modelo.Elemento;
import cdc.com.api.modelo.Protocolo;
import cdc.com.api.servicio.DispersionService;
import cdc.com.api.servicio.ElementoService;
import cdc.com.api.servicio.ProtocoloService;
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
@Path("/cecon/protocolo")
@ManagedBean
public class ProtocoloResource {
    
    @Inject
    ProtocoloService protocoloServicio;
    @Inject
    ElementoService elementoServicio;
    @Inject
    DispersionService dispersionServicio;
    
    List<Dispersion> lista_dispersion;
    
    @POST
    @Path("/registro")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarProtocolo(Protocolo protocolo) throws JSONException {
        JSONObject object = new JSONObject();
        Dispersion dispersion = new Dispersion();
        Elemento elemento = new Elemento();
        lista_dispersion = protocolo.getDispersionList();
        protocolo.setDispersionList(null);
        if (elementoServicio.findElemento(protocolo.getCodigoe())) {
            elemento.setElementoId(elementoServicio.getElemento_id());
            protocolo.setELEMENTOelementoid(elemento);
            int protocolo_id = protocoloServicio.save(protocolo);
            protocolo.setProtocoloId(protocolo_id);
            //Dispersión
            if (lista_dispersion.size() >= 1) {
                int tam_listaDispersion = lista_dispersion.size();
                for (int i = 0; i < tam_listaDispersion; i++) {
                    dispersion = lista_dispersion.get(i);
                    dispersion.setPROTOCOLOprotocoloid(protocolo);
                    dispersionServicio.save(dispersion);
                    System.out.println("***->Registro exitoso dispersion:" + dispersion.getLe());
                }
            }
            object.put("codigoe", protocolo.getCodigoe());
            System.out.println("***->Registro Exitoso Protocolo :" + protocolo.getCodigoe());
            return Response.status(200).entity(object.toString()).build();
        } else {
            object.put("codigoe", protocolo.getCodigoe());
            return Response.status(404).entity(object.toString()).build();
        }
        
    }
    
    @GET
    @Path("/buscar/{codigoe}/{nombre}/{nomcomun}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Protocolo> buscarProtocolo(
            @PathParam("codigoe") String codigoe,
            @PathParam("nombre") String nombre,
            @PathParam("nomcomun") String nomcomun) {
        System.out.println("***->Busqueda exitosa de protocolo");
        return protocoloServicio.buscarProtocolo(codigoe, nombre, nomcomun);
    }
    
    @POST
    @Path("/editar/{elemento_id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarProtocolo(Protocolo protocolo, @PathParam("elemento_id") int elemento_id) throws JSONException {
        Elemento elemento = new Elemento();
        elemento.setElementoId(elemento_id);
        protocolo.setELEMENTOelementoid(elemento);
        protocoloServicio.update(protocolo);
        JSONObject object = new JSONObject();
        object.put("codigoe", protocolo.getCodigoe());
        System.out.println("***->Editado exitoso protocolo:" + protocolo.getCodigoe());
        return Response.status(200).entity(object.toString()).build();
    }
    
    @GET
    @Path("/dispersion/{protocoloId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Dispersion> buscarDispersion(@PathParam("protocoloId") Integer protocoloId) {
        System.out.println("***->Busqueda Exitosa Dispersion:" + protocoloId);
        Protocolo protocolo = new Protocolo();
        protocolo.setProtocoloId(protocoloId);
        return dispersionServicio.buscarDispersion_ProtocoloId(protocolo);
    }
    
    @POST
    @Path("/registrar/dispersion/{protocoloId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarProteccion(@PathParam("protocoloId") Integer protocoloId, Dispersion dispersion) throws JSONException {
        JSONObject object = new JSONObject();
        Protocolo protocolo = new Protocolo();
        protocolo.setDispersionList(null);//
        protocolo.setProtocoloId(protocoloId);
        dispersion.setPROTOCOLOprotocoloid(protocolo);
        dispersionServicio.save(dispersion);
        object.put("protocoloId", protocoloId);
        System.out.println("***->Registro Exitoso Dispersion :" + protocoloId);
        return Response.status(200).entity(object.toString()).build();
    }
    
    @POST
    @Path("/delete/dispersion/{dispersionId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response borrarDispersion(@PathParam("dispersionId") Long dispersionId) throws JSONException {
        JSONObject object = new JSONObject();
        dispersionServicio.delete(dispersionId);
        object.put("dipsersionId", dispersionId);
        System.out.println("***->Delete Exitoso Dispersion :" + dispersionId);
        return Response.status(200).entity(object.toString()).build();
    }
    
    @POST
    @Path("/update/dispersion/{protocoloId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response actualizarDispersion(@PathParam("protocoloId") Integer protocoloId, Dispersion dispersion) throws JSONException {
        JSONObject object = new JSONObject();
        Protocolo protocolo = new Protocolo();
        protocolo.setProtocoloId(protocoloId);
        dispersion.setPROTOCOLOprotocoloid(protocolo);
        dispersionServicio.update(dispersion);
        object.put("dispersionId", dispersion.getDispersionId());
        System.out.println("***->Update Exitoso Dispersion :" + dispersion.getDispersionId());
        return Response.status(200).entity(object.toString()).build();
    }
}
