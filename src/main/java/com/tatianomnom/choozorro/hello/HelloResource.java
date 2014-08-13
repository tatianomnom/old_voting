package com.tatianomnom.choozorro.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Inject;

@Path("hello")
public class HelloResource {
    private final Greeter greeter;

    @Inject
    public HelloResource(final Greeter greeter) {
        this.greeter = greeter;
    }

    @GET
    @Path("/get")
    @Produces("application/json")
    public Something getProductInJSON() {

        Something something = new Something();
        something.setAge(22);
        something.setName(greeter.greet("Me"));
        return something;

    }
}
