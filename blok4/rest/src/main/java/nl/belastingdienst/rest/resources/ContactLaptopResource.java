package nl.belastingdienst.rest.resources;

import nl.belastingdienst.rest.domain.Laptop;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

// No @Path in a subresource!
// This runs @ contacts/{id}/laptops/{id}
public class ContactLaptopResource {

    private long id;

    @GET
    @Produces(APPLICATION_JSON)
    public Laptop get() {
        return Laptop.builder().id(10L).brand("Dell").build();
    }

    public void setId(long id) {
        this.id = id;
    }
}
