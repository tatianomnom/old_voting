package com.tatianomnom.choozorro.api.resources;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * TODO add description
 */
@Path("/options")
public class OptionResource {

    @GET
    @Produces("application/json")
    public Map<String, String> getSome() {
        Map<String, String> map = new HashMap<>();
        map.put("AA", "AAAA");
        return map;
    }
}
