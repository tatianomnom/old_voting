package com.tatianomnom.choozorro.api.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.tatianomnom.choozorro.model.Poll;
import com.tatianomnom.choozorro.service.UuidGenerator;

/**
 * TODO add description
 */
@Path("/polls")
public class PollResource {

    private final UuidGenerator uuidGenerator;

    @Inject
    public PollResource(UuidGenerator uuidGenerator) {
        this.uuidGenerator = uuidGenerator;
    }

    @GET
    @Path("/z")
    @Produces("text/html")
    public String getUUID() {
        return uuidGenerator.generateUuid();
    }

    @GET
    @Produces("application/json")
    public Poll getSome() {
        Poll poll = new Poll("LALA");
        return poll;
    }


    //test with
    //curl -X POST -d '{"description":"Meow"}' -H "Content-Type: application/json" http://localhost:8080/polls
    @POST
    @Consumes("application/json")
    public Response eatSome(Poll poll) {
        System.out.println("I've got a " + poll.getDescription());
        return Response.ok().build();
    }
}
