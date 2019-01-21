/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

import cdc.com.api.modelo.Area;
import cdc.com.api.modelo.ListaElemento;
import cdc.com.api.servicio.AreaService;
import cdc.com.api.servicio.ListaElementoService;
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
@Path("area")
@ManagedBean
public class AreaResource {

    @Inject
    AreaService areaServicio;
    @Inject
    ListaElementoService listaElementoServicio;

    List<ListaElemento> lista_elemento;

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Area> all() {
        System.out.println("***->Lista de Areas");
        return areaServicio.all();
    }

    @POST
    @Path("/registro")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarAreasManejadas(Area area) throws JSONException {
        ListaElemento listaElemento = new ListaElemento();

        lista_elemento = area.getListaElementoList();
        area.setListaElementoList(null);
        JSONObject object = new JSONObject();
        int areaManejada_id = areaServicio.save(area);
        area.setAreaId(areaManejada_id);

        //Lista elementos
        if (lista_elemento.size() >= 1) {
            int tam_listaElemento = lista_elemento.size();
            for (int i = 0; i < tam_listaElemento; i++) {
                listaElemento = lista_elemento.get(i);
                listaElemento.setAREAareaid(area);
                listaElementoServicio.save(listaElemento);
                System.out.println("***->Registro exitoso lista elementos:" + listaElemento.getCodigoe());
            }
        }
        object.put("codigoam", area.getCodigoam());
        System.out.println("***->Registro Exitoso Area :" + area.getCodigoam());
        return Response.status(202).entity(object.toString()).build();
    }

    @GET
    @Path("/buscar/{codigoam}/{nombream}/{sinam}/{codsitio}/{nomsitio}/{nacion}/{subnacion}/{subdivision}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Area> buscarArea(
            @PathParam("codigoam") String codigoam,
            @PathParam("nombream") String nombream,
            @PathParam("sinam") String sinam,
            @PathParam("codsitio") String codsitio,
            @PathParam("nomsitio") String nomsitio,
            @PathParam("nacion") String nacion,
            @PathParam("subnacion") String subnacion,
            @PathParam("subdivision") String subdivision) {
        System.out.println("***->Busqueda Exitosa de Area");
        return areaServicio.buscarArea(codigoam, nombream, sinam, codsitio, nomsitio, nacion, subnacion, subdivision);
    }

    @POST
    @Path("/editar")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarArea(Area area) throws JSONException {
        areaServicio.update(area);
        JSONObject object = new JSONObject();
        object.put("codigoam", area.getCodigoam());
        System.out.println("***->Editado exitoso area:" + area.getCodigoam());
        return Response.status(202).entity(object.toString()).build();
    }
}
