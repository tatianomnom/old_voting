package com.tatianomnom.choozorro.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.tatianomnom.choozorro.model.Poll;

/**
 * TODO add description
 */
@Path("/polls")
public class PollResource {

    @GET
    @Produces("application/json")
    public Poll getSome() {
        Poll poll = new Poll("LALA");
        return poll;
    }


    //test with
    //curl -X POST -d '{"description":"Meow"}' -H "Content-Type: application/json" http://localhost:8080/polls
    //TODO this guy should accept only list and description, maybe separate poll and internal poll?
    //or simply parse JSON
/*    @POST
    @Consumes("application/json")
    public Response eatSome(Poll poll) {
        System.out.println("I've got a " + poll.getDescription());
        return Response.ok().build();
    }*/
}
