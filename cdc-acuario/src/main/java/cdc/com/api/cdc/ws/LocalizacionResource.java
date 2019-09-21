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
import cdc.com.api.modelo.Rastreo;
import modelo.datos.representativos.IdentificadoresLE;
import cdc.com.api.servicio.ElementoService;
import cdc.com.api.servicio.LocalizacionService;
import cdc.com.api.servicio.ProteccionService;
import cdc.com.api.servicio.RastreoService;
import java.util.List;
import java.util.StringTokenizer;
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

@Path("/cecon/localizacion")
@ManagedBean
public class LocalizacionResource {

    @Inject
    LocalizacionService localizacionServicio;
    @Inject
    ProteccionService proteccionServicio;
    @Inject
    RastreoService rastreoServicio;
    @Inject
    ElementoService elementoServicio;

    List<Proteccion> lista_proteccion;

    @POST
    @Path("/registro")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarLocalizacion(Localizacion localizacion) throws JSONException {
        JSONObject object = new JSONObject();
        Proteccion proteccion = new Proteccion();
        Rastreo rastreo = new Rastreo();
        StringTokenizer codigole = new StringTokenizer(localizacion.getCodigole(), "*");
        String codigoe = codigole.nextToken();
        if (elementoServicio.findElemento(codigoe)) {
            rastreo = rastreoServicio.buscarRastreo_Codigoe(codigoe);
            if (rastreo == null) {
                object.put("codigoe", codigoe);
                return Response.status(406).entity(object.toString()).build();
            } else {
                localizacion.setRASTREOrastreoid(rastreo);
            }
            lista_proteccion = localizacion.getProteccionList();
            localizacion.setProteccionList(null);
            localizacion.setCodigole(localizacion.getCodigole().replaceAll("\\s", ""));
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
            return Response.status(200).entity(object.toString()).build();
        } else {
            object.put("codigoe", codigoe);
            return Response.status(404).entity(object.toString()).build();
        }

    }

    @GET
    @Path("/buscar/{codigole}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public List<Localizacion> buscarLocalizacion(@PathParam("codigole") String codigole) {
        System.out.println("***->Busqueda Exitosa LE");
        return localizacionServicio.buscarLocalizacion(codigole);
    }

    @POST
    @Path("/editar/{rastreo_id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarLocalizacionElemento(Localizacion le, @PathParam("rastreo_id") int rastreo_id) throws JSONException {
        Rastreo rastreo = new Rastreo();
        rastreo.setRastreoId(rastreo_id);
        le.setRASTREOrastreoid(rastreo);
        localizacionServicio.update(le);
        JSONObject object = new JSONObject();
        object.put("codigole", le.getCodigole());
        System.out.println("***->Editado exitoso LE:" + le.getCodigole());
        return Response.status(200).entity(object.toString()).build();
    }

    @GET
    @Path("/proteccion/{localizacionId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public List<Proteccion> buscarProteccion(@PathParam("localizacionId") Integer localizacionId) {
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
        return Response.status(200).entity(object.toString()).build();
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
        return Response.status(200).entity(object.toString()).build();
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
        return Response.status(200).entity(object.toString()).build();
    }

    @GET
    @Path("/validar/{codigole}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response validarCodigoLE(@PathParam("codigole") String codigole) throws JSONException {
        System.out.println("***->Validando CODIGOLE:" + codigole);
        JSONObject object = new JSONObject();
        StringTokenizer codigo_le = new StringTokenizer(codigole, "*");
        String codigoe = codigo_le.nextToken();
        object.put("codigoe", codigoe);
        if (elementoServicio.findElemento(codigoe)) {
            return Response.status(200).entity(object.toString()).build();
        } else {
            return Response.status(404).entity(object.toString()).build();
        }
    }

    @GET
    @Path("/identificadores/NombreS/RangoS/{codigoe}/{departamento}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public IdentificadoresLE buscar_IdentificadoresLE_NombresS_RangoS(@PathParam("codigoe") String codigoe, @PathParam("departamento") String departamento) {
        System.out.println("***->Buscando identificadores LE: NombreS y RangoS");
        return localizacionServicio.buscar_Identificadores_NombreS_RangoS(codigoe, departamento);
    }

    @GET
    @Path("/identificadores/RangoN/{codigoe}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public IdentificadoresLE buscar_IdentificadoresLE_RangoN(@PathParam("codigoe") String codigoe) throws JSONException {
        System.out.println("***->Buscando identificadores LE: RangoN");
        return localizacionServicio.buscar_Identificadores_RangoN(codigoe);
    }

    @GET
    @Path("/identificadores/RangoG/{codigoe}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public IdentificadoresLE buscar_IdentificadoresLE_RangoG(@PathParam("codigoe") String codigoe) throws JSONException {
        System.out.println("***->Buscando identificadores LE: RangoG");
        return localizacionServicio.buscar_Identificadores_RangoG(codigoe);
    }

    @GET
    @Path("/identificadores/NombreComunN/{codigoe}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public IdentificadoresLE buscar_IdentificadoresLE_NombreComunN(@PathParam("codigoe") String codigoe) throws JSONException {
        System.out.println("***->Buscando identificadores LE: NombreComunN");
        return localizacionServicio.buscar_Identificadores_NombreComunN(codigoe);
    }

    @GET
    @Path("/all")
    @Produces(APPLICATION_JSON)
    public List<Localizacion> all() {
        System.out.println("***->All");
        return localizacionServicio.all();
    }
}
