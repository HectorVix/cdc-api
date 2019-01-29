/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.cdc.ws;

import cdc.com.api.modelo.Archivo;
import cdc.com.api.modelo.Fuente;
import cdc.com.api.modelo.Rastreo;
import cdc.com.api.modelo.Usuario;
import cdc.com.api.servicio.ArchivoService;
import cdc.com.api.servicio.FuenteService;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_OCTET_STREAM;
import static javax.ws.rs.core.MediaType.MULTIPART_FORM_DATA;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Héctor Vix
 */
@Path("fuente")
@ManagedBean
public class FuenteResource {

    private int fuenteId;

    @Inject
    FuenteService fuenteServicio;
    @Inject
    ArchivoService archivoServicio;

    @GET
    @Produces(APPLICATION_JSON)
    public java.util.List<Fuente> all() {
        System.out.println("***->Lista de Fuente");
        return fuenteServicio.all();
    }

    @POST
    @Path("/registro/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarFuente(Fuente fuente, @PathParam("id") int id) throws JSONException {
        JSONObject object = new JSONObject();
        Usuario us = new Usuario();
        us.setUsuarioId(id);
        fuente.setUSUARIOusuarioid(us);
        int fuente_id = fuenteServicio.save(fuente);
        object.put("codfuente", fuente.getCodfuente());
        object.put("fuenteId", fuente_id);
        System.out.println("***->Registro Exitoso Fuente:" + fuente.getCodfuente());
        return Response.status(202).entity(object.toString()).build();
    }

    @POST
    @Path("/cargarArchivos/{fuenteid}")
    @Consumes(MULTIPART_FORM_DATA)
    @Produces(APPLICATION_JSON)
    public Response uploadFile(
            @HeaderParam("content-length") long contentLength,
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail,
            @PathParam("fuenteid") int fuenteId)
            throws JSONException, FileNotFoundException, IOException {
        JSONObject object = new JSONObject();
        //String uploadedFileLocation = "C://Users/HP/Documents/AplicacionServicios/temporal/" + fileDetail.getFileName();
        String uploadedFileLocation = "C://temporal/" + fileDetail.getFileName();
        //String uploadedFileLocation = "C://Users/FLORA/Documents/ServiciosCDC/temporal/" + fileDetail.getFileName();
        //tamaño maximo 3355544432 bytes
        int tam = (int) contentLength;
        escribirArchivoTemporal(uploadedInputStream, uploadedFileLocation, tam);
        File ruta = new File(uploadedFileLocation);
        byte[] archivo = new byte[(int) ruta.length()];
        InputStream input = new FileInputStream(ruta);
        input.read(archivo);
        Archivo arch = new Archivo();
        Fuente fuente = new Fuente();
        fuente.setFuenteId(fuenteId);
        arch.setArchivocdc(archivo);
        arch.setNombre(fileDetail.getFileName());
        arch.setFUENTEfuenteid(fuente);
        archivoServicio.save(arch);
        input.close();
        ruta.delete();
        object.put("archivo", fileDetail.getFileName());
        System.out.println("***->Archivo cargado exitosamente:" + fileDetail.getFileName());
        return Response.status(200).entity(object.toString()).build();

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

    public int getFuenteId() {
        return fuenteId;
    }

    public void setFuenteId(int fuenteId) {
        this.fuenteId = fuenteId;
    }

    @GET
    @Path("/buscar/{naturalezadocumento}/{codfuente}/{cita}/{archivado}/{clave}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Fuente> buscarRastreo(
            @PathParam("naturalezadocumento") String naturalezadocumento,
            @PathParam("codfuente") String codfuente,
            @PathParam("cita") String cita,
            @PathParam("archivado") String archivado,
            @PathParam("clave") String clave) {
        System.out.println("***->Busqueda Exitosa de Fuente");
        return fuenteServicio.buscarFuente(naturalezadocumento, codfuente, cita, archivado, clave);
    }

    @POST
    @Path("/editar/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response editarFuente(Fuente fuente, @PathParam("id") Integer id) throws JSONException {
        Usuario us = new Usuario();
        us.setUsuarioId(id);
        fuente.setUSUARIOusuarioid(us);
        fuenteServicio.update(fuente);
        JSONObject object = new JSONObject();
        object.put("codfuente", fuente.getCodfuente());
        System.out.println("***->Editado exitoso fuente:" + fuente.getCodfuente());
        return Response.status(202).entity(object.toString()).build();
    }

    @GET
    @Path("/buscarArchivos/{fuenteId}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public java.util.List<Archivo> buscarArchivo_FuenteId(@PathParam("fuenteId") Integer fuenteId) {
        Fuente fuente = new Fuente();
        fuente.setFuenteId(fuenteId);
        System.out.println("***->Busqueda Exitosa Fuentes:" + fuenteId);
        return archivoServicio.buscarArchivo_FuenteId(fuente);
    }
}
