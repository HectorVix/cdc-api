package cdc.com.api.loginws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;




import cdc.com.api.servicio.UsuarioService;
import cdc.com.api.modelo.Usuario;


import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import javax.ws.rs.Path;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.persistence.EntityManager;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import static javax.ws.rs.Priorities.AUTHORIZATION;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;
import javax.ws.rs.core.UriInfo;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


/**
 *
 * @author Héctor Vix
 */
@Path("us")
@ManagedBean
public class UsuarioResource {
    
    @Inject
    UsuarioService us;
    // @Inject
   // Usuario usuarioModelo;
    
   // @Inject
    private KeyGenerator keyGenerator;
    @Context
    private UriInfo uriInfo;

    
    @GET
     @Produces(MediaType.APPLICATION_JSON)
    public java.util.List<Usuario> all() {
        System.out.println("***->Lista de usuarios");
        return us.all();
    }
    
    @POST
    @Path("/token") 
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateUser(@FormParam("username") String username, 
                                     @FormParam("password") String password) {

        try {

            // Authenticate the user using the credentials provided
           // authenticate(username, password);
        
            // Issue a token for the user
              String token = issueToken(username);
          
            // Return the token on the response
            return Response.status(202).entity("validando").build();

        } catch (Exception e) {
           return Response.status(UNAUTHORIZED).build();
        }      
    }
    
    
     private String issueToken(String username) {
        Key key = keyGenerator.generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(username)
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
	@Path("/reg")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
	public Response registrarUsuario(UsuarioReg usReg) throws JSONException {
            
               
                System.out.println("***->registrando..."+usReg.getNombre());
                
		String result = "Product created : " + usReg;
              JSONObject object = new JSONObject();
              object.put("nombre", usReg.getNombre());
              
		return Response.status(202).entity(object.toString()).build();
		
	}
      
      
}