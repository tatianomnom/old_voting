package com.tatianomnom.choozorro.api;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.tatianomnom.choozorro.service.StringIdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * TODO add description
 */
@Path("/polls")
public class PollResource {

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
        Map<String, String> response = new HashMap<>();
        response.put("url", idGenerator.generateId());
        return Response.ok(response).build();
    }

}
