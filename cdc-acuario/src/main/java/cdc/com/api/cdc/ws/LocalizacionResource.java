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
import cdc.com.api.modelo.Localizacion;
import cdc.com.api.modelo.Proteccion;
import cdc.com.api.servicio.LocalizacionService;
import cdc.com.api.servicio.ProteccionService;
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

@Path("localizacion")
@ManagedBean
public class LocalizacionResource {

    @Inject
    LocalizacionService localizacionServicio;
    @Inject
    ProteccionService proteccionServicio;

    List<Proteccion> lista_proteccion;

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Localizacion> all() {
        System.out.println("***->Lista de Localizacion");
        return localizacionServicio.all();
    }

    @POST
    @Path("/registro")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarLocalizacion(Localizacion localizacion) throws JSONException {
        JSONObject object = new JSONObject();
        Proteccion proteccion = new Proteccion();

        lista_proteccion = localizacion.getProteccionList();
        localizacion.setProteccionList(null);
        int localizacion_id = localizacionServicio.save(localizacion);
        localizacion.setLocalizacionId(localizacion_id);
        //Protección LE
        if (lista_proteccion.size() >= 1) {
            int tam_proteccion = lista_proteccion.size();
            for (int i = 0; i < tam_proteccion; i++) {
                proteccion = lista_proteccion.get(i);
                proteccion.setLOCALIZACIONlocalizacionid(localizacion);
                proteccionServicio.save(proteccion);
                System.out.println("***->Registro exitoso proteccion LE:" + proteccion.getCodigoam());
            }
        }
        object.put("codigole", localizacion.getCodigole());
        System.out.println("***->Registro Exitoso Localizacion :" + localizacion.getCodigole());
        return Response.status(202).entity(object.toString()).build();
    }

    @GET
    @Path("/buscar/{codigole}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Localizacion> buscarLocalizacion(@PathParam("codigole") String codigole) {
        System.out.println("***->Busqueda Exitosa LE");
        return localizacionServicio.buscarLocalizacion(codigole);
    }

    @POST
    @Path("/editar")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarLocalizacionElemento(Localizacion le) throws JSONException {
        //Elemento el = new Elemento();
        // el.setElementoId(4);
        // le.setELEMENTOelementoid(le);   
        localizacionServicio.update(le);
        JSONObject object = new JSONObject();
        object.put("codigole", le.getCodigole());
        System.out.println("***->Editado exitoso LE:" + le.getCodigole());
        return Response.status(202).entity(object.toString()).build();
    }

    @GET
    @Path("/proteccion/{localizacionId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Proteccion> buscarProteccion(@PathParam("localizacionId") Integer localizacionId) {
        System.out.println("***->Busqueda Exitosa Proteccion:" + localizacionId);
        Localizacion le = new Localizacion();
        le.setLocalizacionId(localizacionId);
        return proteccionServicio.buscarProteccion_LocalizacionId(le);
    }

    @POST
    @Path("/registrar/proteccion/{localizacionId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarProteccion(@PathParam("localizacionId") Integer localizacionId, Proteccion proteccion) throws JSONException {
        JSONObject object = new JSONObject();
        Localizacion le = new Localizacion();
        le.setProteccionList(null);
        le.setLocalizacionId(localizacionId);
        proteccion.setLOCALIZACIONlocalizacionid(le);
        proteccionServicio.save(proteccion);
        object.put("codigoam", proteccion.getCodigoam());
        System.out.println("***->Registro Exitoso Proteccion :" + proteccion.getCodigoam());
        return Response.status(202).entity(object.toString()).build();
    }

    @POST
    @Path("/delete/proteccion/{proteccionId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response borrarProteccion(@PathParam("proteccionId") Long proteccionId) throws JSONException {
        JSONObject object = new JSONObject();
        proteccionServicio.delete(proteccionId);
        object.put("proteccionId", proteccionId);
        System.out.println("***->Delete Exitoso Proteccion :" + proteccionId);
        return Response.status(202).entity(object.toString()).build();
    }

    @POST
    @Path("/update/proteccion/{localizacionId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response actualizarProteccion(@PathParam("localizacionId") Integer localizacionId, Proteccion proteccion) throws JSONException {
        JSONObject object = new JSONObject();
        Localizacion le = new Localizacion();
        le.setLocalizacionId(localizacionId);
        proteccion.setLOCALIZACIONlocalizacionid(le);
        proteccionServicio.update(proteccion);
        object.put("proteccionId", proteccion.getProteccionId());
        System.out.println("***->Update Exitoso Proteccion :" + proteccion.getProteccionId());
        return Response.status(202).entity(object.toString()).build();
    }
}
