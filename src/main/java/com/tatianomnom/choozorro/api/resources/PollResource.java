package com.tatianomnom.choozorro.api.resources;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
    public Map<String, String> getSome() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "zaa");
        map.put("b", "zbb");
        return map;
    }
}
