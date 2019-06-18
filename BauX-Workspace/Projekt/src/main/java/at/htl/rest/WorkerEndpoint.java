package at.htl.rest;


import at.htl.facades.WorkerFacade;
import at.htl.model.Worker;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

@Path("worker")
public class WorkerEndpoint {

    @Inject
    private WorkerFacade workerFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response getWorker(){
        return Response.ok(workerFacade.GetAllWorker()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response loginForeman(@QueryParam("username") String username, @QueryParam("password") String password) {
        Worker worker = workerFacade.loginForeman(username,password);

        if (worker != null) {
            return Response.ok().build();
        }
        else {
            return Response.serverError().build();
        }
    }
}
