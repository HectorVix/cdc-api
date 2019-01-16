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
import cdc.com.api.modelo.Macsitio;
import cdc.com.api.modelo.Sitio;
import cdc.com.api.modelo.Subdivision;
import cdc.com.api.servicio.MacsitioService;
import cdc.com.api.servicio.SitioService;
import cdc.com.api.servicio.SubdivisionService;
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

@Path("sitio")
@ManagedBean
public class SitioResource {

    @Inject
    SitioService sitioServicio;
    @Inject
    MacsitioService macsitioServicio;
    @Inject
    SubdivisionService subdivisionServicio;

    List<Macsitio> lista_macsitio;
    List<Subdivision> lista_subdivision;

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Sitio> all() {
        System.out.println("***->Lista de Sitio");
        return sitioServicio.all();
    }

    @POST
    @Path("/registro")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarSitio(Sitio sitio) throws JSONException {
        Macsitio macsitio = new Macsitio();
        Subdivision subdivision = new Subdivision();

        lista_macsitio = sitio.getMacsitioList();
        lista_subdivision = sitio.getSubdivisionList();
        sitio.setMacsitioList(null);
        sitio.setSubdivisionList(null);
        JSONObject object = new JSONObject();
        int sitio_id = sitioServicio.save(sitio);
        sitio.setSitioId(sitio_id);
        //Macsitio
        if (lista_macsitio.size() >= 1) {
            int tam_macsitio = lista_macsitio.size();
            for (int i = 0; i < tam_macsitio; i++) {
                macsitio = lista_macsitio.get(i);
                macsitio.setSITIOsitioid(sitio);
                macsitioServicio.save(macsitio);
                System.out.println("***->Registro exitoso macsitio:" + macsitio.getCodmacsitio());
            }
        }
        //Subdivision
        if (lista_subdivision.size() >= 1) {
            int tam_subdivision = lista_subdivision.size();
            for (int i = 0; i < tam_subdivision; i++) {
                subdivision = lista_subdivision.get(i);
                subdivision.setSITIOsitioid(sitio);
                subdivisionServicio.save(subdivision);
                System.out.println("***->Registro exitoso subdivision:" + macsitio.getCodmacsitio());
            }
        }

        object.put("codsitio", sitio.getCodsitio());
        System.out.println("***->Registro Exitoso Sitio :" + sitio.getCodsitio());
        return Response.status(202).entity(object.toString()).build();
    }

    @GET
    @Path("/buscar/{codSitio}/{nomSitio}/{sinSitio}/{subnacion}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Sitio> buscarSitio(
            @PathParam("codSitio") String codSitio,
            @PathParam("nomSitio") String nomSitio,
            @PathParam("sinSitio") String sinSitio,
            @PathParam("subnacion") String subnacion) {
        System.out.println("***->Busqueda Exitosa de Sitio");
        return sitioServicio.buscarSitio(codSitio, nomSitio, sinSitio, subnacion);
    }

    @POST
    @Path("/editar/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarSitio(Sitio sitio) throws JSONException {
        sitioServicio.update(sitio);
        JSONObject object = new JSONObject();
        object.put("codsitio", sitio.getCodsitio());
        System.out.println("***->Editado exitoso sitio:" + sitio.getCodsitio());
        return Response.status(202).entity(object.toString()).build();
    }
}
