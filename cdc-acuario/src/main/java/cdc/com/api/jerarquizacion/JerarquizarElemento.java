/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.jerarquizacion;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author Héctor Vix
 */
@Path("jer")
public class JerarquizarElemento {
     @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got jer!";
    }
}
