package com.tatianomnom.choozorro.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * TODO add description
 */
@Path("/polls")
public class PollResource {

    public static final Logger logger = LogManager.getLogger();

    @POST
    @Consumes("application/json")
    public Response create(PollCommand pollCommand) {
        logger.debug(pollCommand.toString());
        return Response.ok().build();
    }

}
