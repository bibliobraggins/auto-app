package ski.komoro.auto;


import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Path("/ping")
public interface PingPongApi {
    @GET
    String ping();
}
