package org.example.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/helloworld")
public class HelloWorldResource {

    @GET
    public Response get() {
        return Response.status(400)
                .type(MediaType.TEXT_PLAIN_TYPE)
                .entity("Hello world!") // response body
                .build();
    }
}
