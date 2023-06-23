package braggins.biblio.auto;


import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Path("/ping")
public interface PingPongApi {
    @GET
    String ping();
}
