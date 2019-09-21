package cdc.com.api.loginws;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import cdc.com.api.servicio.UsuarioService;
//import cdc.com.api.servicio.ElementoService;
import cdc.com.api.modelo.Usuario;
//import cdc.com.api.modelo.Elemento;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

//import static javax.ws.rs.Priorities.AUTHORIZATION;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

//import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.security.Key;
//import java.util.logging.Level;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
//import java.util.List;
//import java.util.logging.Logger;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
//import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

/**
 *
 * @author Héctor Vix
 */
@Path("/cecon/usuario")
@ManagedBean
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @Inject
    private KeyGenerator keyGenerator;
    @Context
    private UriInfo uriInfo;

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Usuario find(@PathParam("id") Long id) {
        System.out.println("***->Usuario");
        Usuario us = usuarioService.find(id);
        return us;
    }

    @Path("/token")
    @POST
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_JSON)
    public Response authenticateUser(@FormParam("username") String username,
            @FormParam("password") String password) {
        System.out.println("***->logiando..." + username);
        System.out.println("***->logiando..." + password);
        try {
            authenticate(username, password);
            String token = issueToken(usuarioService.getUsuario_id());
            System.out.println("***->Id usuario..." + usuarioService.getUsuario_id());
            JSONObject object = new JSONObject();
            object.put("access_token", token);
            object.put("token_type", "bearer");
            object.put("expires_in", 3599);
            return Response.ok().entity(object.toString()).header(AUTHORIZATION, "Bearer " + token).build();
        } catch (Exception e) {
            return Response.status(UNAUTHORIZED).build();
        }
    }

    private void authenticate(String username, String password) throws Exception {
        boolean us = usuarioService.find_Usuario(username, password);
        if (us == false) {
            throw new SecurityException("Correo o password invalido");
        }
    }

    private String issueToken(int Usuario_id) {
        Usuario us = usuarioService.find((long) Usuario_id);
        Key key = keyGenerator.generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(us.getRolrolid().getNombre())
                .setId(String.valueOf(Usuario_id))
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

        return jwtToken;

    }

    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    @POST
    @Path("/registrar")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response registrarUsuario(Usuario usuario) throws JSONException {
        usuarioService.save(usuario);
        JSONObject object = new JSONObject();
        object.put("nombre", usuario.getNombre());
        object.put("apellido", usuario.getApellido());
        System.out.println("***->Registro exitoso usuario" + usuario.getNombre() + " " + usuario.getApellido());
        return Response.status(202).entity(object.toString()).build();
    }
}
