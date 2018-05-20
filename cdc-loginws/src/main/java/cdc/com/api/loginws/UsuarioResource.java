/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.loginws;


import javax.ws.rs.Path;
import cdc.com.api.servicio.UsuarioService;
import cdc.com.api.modelo.Usuario;

import java.awt.List;
import java.net.URISyntaxException;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 *
 * @author Héctor Vix
 */
@Path("us")
@ManagedBean
public class UsuarioResource {
    
    @Inject
    UsuarioService us;
    
   

    
    @GET
    @Produces( MediaType.APPLICATION_JSON)
    public java.util.List<Usuario> all() {
        return us.all();
    }
    
    @Path("/token") 
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("username") String username, 
                                     @FormParam("password") String password) {

        try {

            // Authenticate the user using the credentials provided
           // authenticate(username, password);

            // Issue a token for the user
            String token = "{\"access_token\":\"ddddda2345-ssdfdf222-222aadfd\",\"token_type\":\"bearer\",\"expires_in\":3599}";//issueToken(username);

            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }      
    }
    
}
