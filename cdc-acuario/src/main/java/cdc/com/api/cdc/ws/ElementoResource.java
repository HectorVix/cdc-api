/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

import javax.annotation.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import cdc.com.api.servicio.ElementoService;
import cdc.com.api.modelo.Elemento;
import cdc.com.api.modelo.Foto;
import cdc.com.api.modelo.Usuario;
import cdc.com.api.servicio.FotoService;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import static javax.ws.rs.core.MediaType.MULTIPART_FORM_DATA;
import java.io.InputStream;
import java.io.OutputStream;
import com.sun.jersey.multipart.FormDataParam;
import com.sun.jersey.core.header.FormDataContentDisposition;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.imageio.ImageIO;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;
import static jdk.nashorn.internal.objects.Global.undefined;

/**
 *
 * @author Héctor Vix
 */
@Path("elemento")
@ManagedBean
public class ElementoResource {

    @Inject
    ElementoService elementoServicio;
    @Inject
    FotoService fotoServicio;

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Elemento> all() {
        System.out.println("***->Lista de Elementos");
        return elementoServicio.all();
    }

    @GET
    @Path("/buscar/{codigo}/{nombrecomun}/{nombrecientifico}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Elemento> buscarElemento(@PathParam("codigo") String codigo,
            @PathParam("nombrecomun") String nombrecomun,
            @PathParam("nombrecientifico") String nombrecientifico) {
        System.out.println("***->Busqueda Exitosa de Elementos");
        return elementoServicio.buscarElemento(codigo, nombrecomun, nombrecientifico);
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
    public Elemento findElemento(@PathParam("codigoe") String codigoe) throws JSONException, Exception {
        System.out.println("***->Encontrando elemento:" + codigoe);
        validarElemento(codigoe);
        Elemento el = new Elemento();
        el.setElementoId(elementoServicio.getElemento_id());
        return el;
    }

    private void validarElemento(String codigoe) throws Exception {
        boolean elemento = elementoServicio.findElemento(codigoe);
        if (elemento == false) {
            throw new SecurityException("No existe el elemento");
        }
    }

    @POST
    @Path("/registro/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarElemento(Elemento elemento, @PathParam("id") int id) throws JSONException {
        System.out.println("***->Registro Elemento Exitoso" + elemento.getCodigo());
        Usuario us = new Usuario();
        us.setUsuarioId(id);
        elemento.setUSUARIOusuarioid(us);
        int elemento_id = elementoServicio.save(elemento);
        JSONObject object = new JSONObject();
        object.put("codigo", elemento.getCodigo());
        object.put("elementoId", elemento_id);
        return Response.status(202).entity(object.toString()).build();
    }

    @POST
    @Path("/cargarFoto/{elementoid}")
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
            @PathParam("elementoid") int elementoid
    )
            throws JSONException, FileNotFoundException, IOException {
        JSONObject object = new JSONObject();
        String uploadedFileLocation = "/" + fileDetail.getFileName();
        int tam = (int) contentLength;
        escribirArchivoTemporal(uploadedInputStream, uploadedFileLocation, tam);
        File ruta = new File(uploadedFileLocation);
        byte[] archivo = new byte[(int) ruta.length()];
        InputStream input = new FileInputStream(ruta);
        input.read(archivo);
        Date fechaCreacion = toFecha(fecha);
        Foto foto = new Foto();
        Elemento elemento = new Elemento();
        elemento.setElementoId(elementoid);
        foto.setELEMENTOelementoid(elemento);
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
    @Path("/updateFoto/{elementoid}/{fotoId}")
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
            @PathParam("elementoid") int elementoid,
            @PathParam("fotoId") int fotoId
    )
            throws JSONException, FileNotFoundException, IOException {
        JSONObject object = new JSONObject();
        String uploadedFileLocation = "/" + fileDetail.getFileName();
        int tam = (int) contentLength;
        escribirArchivoTemporal(uploadedInputStream, uploadedFileLocation, tam);
        File ruta = new File(uploadedFileLocation);
        byte[] archivo = new byte[(int) ruta.length()];
        InputStream input = new FileInputStream(ruta);
        input.read(archivo);
        Date fechaCreacion = toFecha(fecha);
        Foto foto = new Foto();
        Elemento elemento = new Elemento();
        elemento.setElementoId(elementoid);
        foto.setELEMENTOelementoid(elemento);
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
    @Path("/buscarFotos/{elementoId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Foto> buscarFoto_ElementoId(@PathParam("elementoId") Integer elementoId) {
        Elemento elemento = new Elemento();
        elemento.setElementoId(elementoId);
        System.out.println("***->Busqueda Exitosa Fotos");
        return fotoServicio.buscarFoto_ElementoId(elemento);
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
        object.put("codigo", elemento.getCodigo());
        System.out.println("***->Editado exitoso:" + elemento.getCodigo());
        return Response.status(202).entity(object.toString()).build();
    }

    @POST
    @Path("/delete/{id}")
    @Produces(APPLICATION_JSON)
    public Response eliminarFoto(@PathParam("id") long id) throws JSONException {
        fotoServicio.delete(id);
        JSONObject object = new JSONObject();
        object.put("fotoId", id);
        System.out.println("***->Delete exitoso:" + id);
        return Response.status(202).entity(object.toString()).build();
    }
}
