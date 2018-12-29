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
            @FormDataParam("fecha") String fecha,
            @PathParam("elementoid") int elementoid)
            throws JSONException, FileNotFoundException, IOException {
        JSONObject object = new JSONObject();
        // String uploadedFileLocation = "C://Users/HP/Documents/AplicacionServicios/temporal/" + fileDetail.getFileName();
        String uploadedFileLocation = "C://temporal/" + fileDetail.getFileName();
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

    private Date toFecha(String fecha) {
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaCreacion;
        try {
            fechaCreacion = formatter1.parse(fecha);
            return fechaCreacion;
        } catch (ParseException ex) {
            // Logger.getLogger(ElementoResource.class.getName()).log(Level.SEVERE, null, ex);
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
    @Path("/imagen/{id}")
    @Produces({"image/png", "image/jpg"})
    public Response getFoto(@PathParam("id") long foto_id) throws JSONException {
        Foto foto = fotoServicio.find(foto_id);
        byte[] imagenData = foto.getImagen();

        /*BufferedImage image = null;
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
            ImageIO.write(image, "png", baos);
            } catch (IOException ex) {
            Logger.getLogger(ElementoResource.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte[] imageData = baos.toByteArray();
            
            // uncomment line below to send non-streamed
            // return Response.ok(imageData).build();
            // uncomment line below to send streamed
            return Response.ok(new ByteArrayInputStream(imageData)).build();
            
         */
        JSONObject object = new JSONObject();
        object.put("foto", "pruebas");
        // object.put("imagen",imagenData);
        System.out.println("***->Obteniendo foto:"+imagenData);
        //return Response.ok(new ByteArrayInputStream(imagenData)).build();
       // return Response.status(200).entity(object.toString()).build();      
       // return Response.ok(imagenData).build();
        // return Response.status(200).entity(object.toString()).build();
        object.put("foto1",foto.getImagen()) ;
         return Response
            .ok()
            //.type("image/*")
            .entity(foto.getImagen()) // Assumes document is a byte array in the domain object.
            .build();
    }

    @GET
    @Path("/pdf")
    public Response downloadPdfFile() {
        StreamingOutput fileStream = new StreamingOutput() {
            @Override
            public void write(java.io.OutputStream output) throws IOException, WebApplicationException {
                try {
                    java.nio.file.Path path = Paths.get("C:/temporal/test.pdf");
                    byte[] data = Files.readAllBytes(path);
                    output.write(data);
                    output.flush();
                } catch (Exception e) {
                    throw new WebApplicationException("File Not Found !!");
                }
            }
        };
        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition", "attachment; filename = myfile.pdf")
                .build();
    }

    @GET
    @Path("/fotoElemento/{id}")
    @Produces({"image/png", "image/jpg"})
    public File FotoElemento(@PathParam("id") long foto_id) {
        File repositoryFile = new File("c:/temporal/bobby.jpg");
        return repositoryFile;
    }
  /*  
    @Path("upload/{id}")
@GET
public Response getPDF(@PathParam("id") Integer id) throws Exception {
    ClientCaseDoc entity = find(id);
    return Response
            .ok()
            .type("application/pdf")
            .entity(entity.getDocument()) // Assumes document is a byte array in the domain object.
            .build();
}*/
}
