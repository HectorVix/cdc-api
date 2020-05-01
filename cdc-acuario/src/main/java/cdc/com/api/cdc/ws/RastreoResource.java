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
import cdc.com.api.modelo.Clase;
import cdc.com.api.modelo.Elemento;
import cdc.com.api.modelo.Especie;
import cdc.com.api.modelo.Familia;
import cdc.com.api.modelo.Genero;
import cdc.com.api.modelo.Infraspecificepithet;
import cdc.com.api.modelo.Orden;
//import cdc.com.api.modelo.Global;
import cdc.com.api.modelo.Phylum;
import cdc.com.api.modelo.Rastreo;
import cdc.com.api.modelo.Reino;
import cdc.com.api.servicio.ClaseService;
import cdc.com.api.servicio.ElementoService;
import cdc.com.api.servicio.EspecieService;
import cdc.com.api.servicio.FamiliaService;
import cdc.com.api.servicio.GeneroService;
import cdc.com.api.servicio.InfraspecificepithetService;
import cdc.com.api.servicio.OrdenService;
import cdc.com.api.servicio.PhylumService;
import cdc.com.api.servicio.RastreoService;
import cdc.com.api.servicio.ReinoService;
//import com.fasterxml.jackson.databind.SerializationFeature;
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
//import modelo.datos.representativos.IdentificadoresLE;
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
    @Inject
    ReinoService reinoServicio;
    @Inject
    PhylumService phylumServicio;
    @Inject
    ClaseService claseServicio;
    @Inject
    OrdenService ordenServicio;
    @Inject
    FamiliaService familiaServicio;
    @Inject
    GeneroService generoServicio;
    @Inject
    EspecieService especieServicio;
    @Inject
    InfraspecificepithetService infraspecificepithetServicio;

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
    @Path("/buscar/{codigoe}/{subnacion}/{nombren}/{nombrecomunnn}/{clase}/{comunidad}/{rol}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Rastreo> buscarRastreo(
            @PathParam("codigoe") String codigoe,
            @PathParam("subnacion") String subnacion,
            @PathParam("nombren") String nombren,
            @PathParam("nombrecomunnn") String nombrecomunnn,
            @PathParam("clase") String clase,
            @PathParam("comunidad") String comunidad,
            @PathParam("rol") String rol) {
        System.out.println("***->Busqueda Exitosa de RE");
        return rastreoServicio.buscarRastreo(codigoe, subnacion, nombren, nombrecomunnn, clase, comunidad, rol);

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

    @GET
    @Path("/all/{rol}")
    @Produces(APPLICATION_JSON)
    public List<Rastreo> all(@PathParam("rol") String rol) {
        System.out.println("***->All");
        return rastreoServicio.all(rol);
    }

    //Catalogos Taxones
    @GET
    @Path("/all/reino")
    @Produces(APPLICATION_JSON)
    public List<Reino> all() {
        System.out.println("***->Catalogo Reino");
        return reinoServicio.buscar_Reino();
    }

    @GET
    @Path("/phylum/{reino_id}")
    @Produces(APPLICATION_JSON)
    public List<Phylum> buscar_Phylum(@PathParam("reino_id") int reino_id) {
        System.out.println("***->Catalogo Phylum");
        Reino r = new Reino();
        r.setReinoId(reino_id);
        return phylumServicio.buscar_Phylum(r);
    }

    @GET
    @Path("/clase/{phylum_id}")
    @Produces(APPLICATION_JSON)
    public List<Clase> buscar_Clase(@PathParam("phylum_id") int phylum_id) {
        System.out.println("***->Catalogo Clase");
        Phylum p = new Phylum();
        p.setPhylumId(phylum_id);
        return claseServicio.buscar_Clase(p);
    }

    @GET
    @Path("/orden/{clase_id}")
    @Produces(APPLICATION_JSON)
    public List<Orden> buscar_Orden(@PathParam("clase_id") int clase_id) {
        System.out.println("***->Catalogo Orden");
        Clase c = new Clase();
        c.setClaseId(clase_id);
        return ordenServicio.buscar_Orden(c);
    }

    @GET
    @Path("/familia/{orden_id}")
    @Produces(APPLICATION_JSON)
    public List<Familia> buscar_Familia(@PathParam("orden_id") int orden_id) {
        System.out.println("***->Catalogo Familia");
        Orden o = new Orden();
        o.setOrdenId(orden_id);
        return familiaServicio.buscar_Familia(o);
    }

    @GET
    @Path("/genero/{familia_id}")
    @Produces(APPLICATION_JSON)
    public List<Genero> buscar_Genero(@PathParam("familia_id") int familia_id) {
        System.out.println("***->Catalogo Genero");
        Familia f = new Familia();
        f.setFamiliaId(familia_id);
        return generoServicio.buscar_Genero(f);
    }

    @GET
    @Path("/especie/{genero_id}")
    @Produces(APPLICATION_JSON)
    public List<Especie> buscar_Especie(@PathParam("genero_id") int genero_id) {
        System.out.println("***->Catalogo Especie");
        Genero g = new Genero();
        g.setGeneroId(genero_id);
        return especieServicio.buscar_Especie(g);
    }

    @GET
    @Path("/infraspecificepithet/{especie_id}")
    @Produces(APPLICATION_JSON)
    public List<Infraspecificepithet> buscar_Infraspecificepithet(@PathParam("especie_id") int especie_id) {
        System.out.println("***->Catalogo Infraspecificepithet");
        Especie e = new Especie();
        e.setEspecieId(especie_id);
        return infraspecificepithetServicio.buscar_Infraspecificepithet(e);
    }
}
