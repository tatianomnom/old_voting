package com.tatianomnom.choozorro.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.tatianomnom.choozorro.service.StringIdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * TODO add description
 */
@Path("/polls")
public class PollResource {

    @Context
    UriInfo uriInfo;

    private final StringIdGenerator idGenerator;

    @Inject
    public PollResource(StringIdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public static final Logger logger = LogManager.getLogger();

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(PollCommand pollCommand) {
        logger.debug(pollCommand.toString());

        String id = idGenerator.generateId();

        logger.debug(uriInfo.getAbsolutePath());
        return Response.status(Response.Status.CREATED)
                .header("Location", uriInfo.getAbsolutePath() +  "/" + id)
                .build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response get(@PathParam("id") String id) {
        PollCommand pollCommand = new PollCommand("aaa", Arrays.asList("a", "b"));
        logger.debug(id);
        return Response.status(Response.Status.OK).entity(pollCommand).build();
    }

}
