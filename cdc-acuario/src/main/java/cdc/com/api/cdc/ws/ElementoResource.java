/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

import cdc.com.api.modelo.Area;
import javax.annotation.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import cdc.com.api.servicio.ElementoService;
import cdc.com.api.modelo.Elemento;
import cdc.com.api.modelo.Foto;
import cdc.com.api.modelo.Planta;
import cdc.com.api.modelo.Sitio;
import cdc.com.api.modelo.Usuario;
import cdc.com.api.modelo.Vertebrado;
import cdc.com.api.servicio.FotoService;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
//import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import static javax.ws.rs.core.MediaType.MULTIPART_FORM_DATA;
import java.io.InputStream;
import java.io.OutputStream;
import com.sun.jersey.multipart.FormDataParam;
import com.sun.jersey.core.header.FormDataContentDisposition;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
//import java.util.List;
//import javax.imageio.ImageIO;
import javax.ws.rs.HeaderParam;
//import javax.ws.rs.WebApplicationException;
//import javax.ws.rs.core.StreamingOutput;
//import static jdk.nashorn.internal.objects.Global.undefined;

/**
 *
 * @author Héctor Vix
 */
@Path("/cecon/elemento")
@ManagedBean
public class ElementoResource {

    @Inject
    ElementoService elementoServicio;
    @Inject
    FotoService fotoServicio;

    @GET
    @Path("/buscar/{codigoe}/{nombren}/{nombrecomunn}/{clase}/{comunidad}/{rol}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Elemento> buscarElemento(@PathParam("codigoe") String codigoe,
            @PathParam("nombren") String nombren,
            @PathParam("nombrecomunn") String nombrecomunn,
            @PathParam("clase") String clase,
            @PathParam("comunidad") String comunidad,
            @PathParam("rol") String rol) {
        System.out.println("***->Busqueda Exitosa de Elementos");
        return elementoServicio.buscarElemento(codigoe, nombren, nombrecomunn, clase, comunidad, rol);
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Elemento find(@PathParam("id") Long id) {
        System.out.println("***->Elemento" + id);
        Elemento el = elementoServicio.find(id);
        return el;
    }

    @GET
    @Path("/validar/{codigoe}")
    @Produces(APPLICATION_JSON)
    public Response findElemento(@PathParam("codigoe") String codigoe) throws JSONException, Exception {
        System.out.println("***->Encontrando elemento:" + codigoe);
        boolean elemento = elementoServicio.findElemento(codigoe);
        JSONObject object = new JSONObject();
        object.put("codigoe", codigoe);
        if (elemento) {
            return Response.status(200).entity(object.toString()).build();
        } else {
            return Response.status(404).entity(object.toString()).build();
        }
    }

    @POST
    @Path("/registro/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarElemento(Elemento elemento, @PathParam("id") int id) throws JSONException {

        Usuario us = new Usuario();
        us.setUsuarioId(id);
        elemento.setUSUARIOusuarioid(us);
        int elemento_id = elementoServicio.save(elemento);
        System.out.println("***->Registro Elemento Exitoso" + elemento.getCodigoe());
        JSONObject object = new JSONObject();
        object.put("codigoe", elemento.getCodigoe());
        object.put("elementoId", elemento_id);
        return Response.status(200).entity(object.toString()).build();
    }

    @POST
    @Path("/cargarFoto/{id}/{tipo}")
    @Consumes(MULTIPART_FORM_DATA)
    @Produces(APPLICATION_JSON)
    public Response uploadFile(
            @HeaderParam("content-length") long contentLength,
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail,
            @FormDataParam("descripcion") String descripcion,
            @FormDataParam("comentario") String comentario,
            @FormDataParam("autor") String autor,
            @FormDataParam("posicion") int posicion,
            @FormDataParam("fecha") String fecha,
            @PathParam("id") int id, // el id puede ser de elemento, sitio, area, planta y vertebrado
            @PathParam("tipo") int tipo // para diferenciar elemento, sitio, area, planta y vertebrado
    )
            throws JSONException, FileNotFoundException, IOException {
        JSONObject object = new JSONObject();
        String uploadedFileLocation = "/" + fileDetail.getFileName();
        //String uploadedFileLocation = "C://Users/FLORA/Documents/ServiciosCDC/temporal/" + fileDetail.getFileName();
        //String uploadedFileLocation = "C://Users/HP/Documents/AplicacionServicios/temporal/" + fileDetail.getFileName();
        int tam = (int) contentLength;
        escribirArchivoTemporal(uploadedInputStream, uploadedFileLocation, tam);
        File ruta = new File(uploadedFileLocation);
        byte[] archivo = new byte[(int) ruta.length()];
        InputStream input = new FileInputStream(ruta);
        input.read(archivo);
        Date fechaCreacion = toFecha(fecha);
        Foto foto = new Foto();

        switch (tipo) {
            case 1: {
                Elemento elemento = new Elemento();
                elemento.setElementoId(id);
                foto.setELEMENTOelementoid(elemento);
            }
            break;
            case 2: {
                Sitio sitio = new Sitio();
                sitio.setSitioId(id);
                foto.setSITIOsitioid(sitio);
            }
            break;
            case 3: {
                Area area = new Area();
                area.setAreaId(id);
                foto.setAREAareaid(area);
            }
            break;
            case 4: {
                Planta planta = new Planta();
                planta.setPlantaId(id);
                foto.setPLANTAplantaid(planta);
            }
            break;
            case 5: {
                Vertebrado vertebrado = new Vertebrado();
                vertebrado.setVertebradoId(id);
                foto.setVERTEBRADOvertebradoid(vertebrado);
            }
            break;
        }

        foto.setDescripcion(descripcion);
        foto.setComentario(comentario);
        foto.setAutor(autor);
        foto.setNombre(fileDetail.getFileName());
        foto.setPosicion(posicion);
        if (fechaCreacion != null) {
            foto.setFecha(fechaCreacion);
        }
        foto.setImagen(archivo);
        fotoServicio.save(foto);
        input.close();
        ruta.delete();

        object.put("foto", fileDetail.getFileName());
        System.out.println("***->Foto cargada exitosamente:" + fileDetail.getFileName());
        return Response.status(200).entity(object.toString()).build();
    }

    @POST
    @Path("/updateFoto/{id}/{fotoId}/{tipo}")
    @Consumes(MULTIPART_FORM_DATA)
    @Produces(APPLICATION_JSON)
    public Response updateElementoFotos(
            @HeaderParam("content-length") long contentLength,
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail,
            @FormDataParam("descripcion") String descripcion,
            @FormDataParam("comentario") String comentario,
            @FormDataParam("autor") String autor,
            @FormDataParam("posicion") int posicion,
            @FormDataParam("fecha") String fecha,
            @PathParam("id") int id,// el id puede ser de elemento, sitio, area, planta y vertebrado
            @PathParam("fotoId") int fotoId,
            @PathParam("tipo") int tipo // para diferenciar elemento, sitio, area, planta y vertebrado
    )
            throws JSONException, FileNotFoundException, IOException {
        JSONObject object = new JSONObject();
        String uploadedFileLocation = "/" + fileDetail.getFileName();
        //String uploadedFileLocation = "C://Users/FLORA/Documents/ServiciosCDC/temporal/" + fileDetail.getFileName();
        //String uploadedFileLocation = "C://Users/HP/Documents/AplicacionServicios/temporal/" + fileDetail.getFileName();
        int tam = (int) contentLength;
        escribirArchivoTemporal(uploadedInputStream, uploadedFileLocation, tam);
        File ruta = new File(uploadedFileLocation);
        byte[] archivo = new byte[(int) ruta.length()];
        InputStream input = new FileInputStream(ruta);
        input.read(archivo);
        Date fechaCreacion = toFecha(fecha);
        Foto foto = new Foto();
        //
        switch (tipo) {
            case 1: {
                Elemento elemento = new Elemento();
                elemento.setElementoId(id);
                foto.setELEMENTOelementoid(elemento);
            }
            break;
            case 2: {
                Sitio sitio = new Sitio();
                sitio.setSitioId(id);
                foto.setSITIOsitioid(sitio);
            }
            break;
            case 3: {
                Area area = new Area();
                area.setAreaId(id);
                foto.setAREAareaid(area);
            }
            break;
            case 4: {
                Planta planta = new Planta();
                planta.setPlantaId(id);
                foto.setPLANTAplantaid(planta);
            }
            break;
            case 5: {
                Vertebrado vertebrado = new Vertebrado();
                vertebrado.setVertebradoId(id);
                foto.setVERTEBRADOvertebradoid(vertebrado);
            }
            break;
        }

        foto.setFotoId(fotoId);
        foto.setDescripcion(descripcion);
        foto.setComentario(comentario);
        foto.setAutor(autor);
        foto.setNombre(fileDetail.getFileName());
        foto.setPosicion(posicion);
        if (fechaCreacion != null) {
            foto.setFecha(fechaCreacion);
        }
        foto.setImagen(archivo);
        fotoServicio.update(foto);
        input.close();
        ruta.delete();

        object.put("foto", fileDetail.getFileName());
        System.out.println("***->Foto actualizada exitosamente:" + fileDetail.getFileName());
        return Response.status(200).entity(object.toString()).build();
    }

    private Date toFecha(String fecha) {
        System.out.println("Fecha foto:" + fecha);
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaCreacion;
        try {
            fechaCreacion = formatter1.parse(fecha);
            return fechaCreacion;
        } catch (ParseException ex) {
            return null;
        }
    }

    private void escribirArchivoTemporal(InputStream uploadedInputStream,
            String uploadedFileLocation, int tam) {
        try {
            int read = 0;
            byte[] bytes = new byte[tam];
            OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("/buscarFotos/{id}/{tipo}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Foto> buscarFoto_Id(@PathParam("id") Integer id, @PathParam("tipo") Integer tipo) {

        System.out.println("***->Busqueda Exitosa Fotos");
        switch (tipo) {
            case 1: {
                Elemento elemento = new Elemento();
                elemento.setElementoId(id);
                return fotoServicio.buscarFoto_ElementoId(elemento);
            }

            case 2: {
                Sitio sitio = new Sitio();
                sitio.setSitioId(id);
                return fotoServicio.buscarFoto_SitioId(sitio);
            }

            case 3: {
                Area area = new Area();
                area.setAreaId(id);
                return fotoServicio.buscarFoto_AreaId(area);
            }

            case 4: {
                Planta planta = new Planta();
                planta.setPlantaId(id);
                return fotoServicio.buscarFoto_PlantaId(planta);
            }

            case 5: {
                Vertebrado vertebrado = new Vertebrado();
                vertebrado.setVertebradoId(id);
                return fotoServicio.buscarFoto_VertebradoId(vertebrado);
            }

        }
        return null;
    }

    @POST
    @Path("/editar/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarElemento(Elemento elemento, @PathParam("id") Integer usuarioId) throws JSONException {
        Usuario us = new Usuario();
        us.setUsuarioId(usuarioId);
        elemento.setUSUARIOusuarioid(us);
        elementoServicio.update(elemento);
        JSONObject object = new JSONObject();
        object.put("codigoe", elemento.getCodigoe());
        System.out.println("***->Editado exitoso:" + elemento.getCodigoe());
        return Response.status(200).entity(object.toString()).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(APPLICATION_JSON)
    public Response eliminarFoto(@PathParam("id") long id) throws JSONException {
        fotoServicio.delete(id);
        JSONObject object = new JSONObject();
        object.put("fotoId", id);
        System.out.println("***->Delete exitoso:" + id);
        return Response.status(200).entity(object.toString()).build();
    }

    @GET
    @Path("/all/{rol}")
    @Produces(APPLICATION_JSON)
    public List<Elemento> all(@PathParam("rol") String rol) {
        System.out.println("***->All");
        return elementoServicio.all(rol);
    }
}
