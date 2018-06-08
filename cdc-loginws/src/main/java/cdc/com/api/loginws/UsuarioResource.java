package cdc.com.api.loginws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import cdc.com.api.loginws.KeyGenerator;


import javax.ws.rs.Path;
import cdc.com.api.servicio.UsuarioService;
import cdc.com.api.modelo.Usuario;
import java.awt.List;
import java.net.URISyntaxException;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;
/**
 *
 * @author Héctor Vix
 */
@Path("us")
@ManagedBean
public class UsuarioResource {
    
    @Inject
    UsuarioService us;
    @Inject
    private KeyGenerator keyGenerator;
    @Context
    private UriInfo uriInfo;

    
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
              String token = issueToken(username);
          
            // Return the token on the response
             return Response.ok(token).header(AUTHORIZATION, "Bearer " + token).build();

        } catch (Exception e) {
           return Response.status(UNAUTHORIZED).build();
        }      
    }
    
    
     private String issueToken(String login) {
        Key key = keyGenerator.generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(login)
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
}