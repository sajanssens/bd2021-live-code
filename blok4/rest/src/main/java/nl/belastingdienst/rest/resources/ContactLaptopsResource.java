package nl.belastingdienst.rest.resources;

import nl.belastingdienst.rest.domain.Laptop;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

// No @Path in a subresource!
// This runs @ contacts/{id}/laptops
@Dependent
public class ContactLaptopsResource {

    @Inject
    private ContactLaptopResource contactLaptopResource;

    @GET
    @Produces(APPLICATION_JSON)
    public List<Laptop> getAll() {
        return List.of(
                Laptop.builder().id(10).brand("Dell").build(),
                Laptop.builder().id(20).brand("HP").build()
        );
    }

    // no http-method annotation!
    // no content type annotation!
    @Path("{laptopId}")
    public ContactLaptopResource getById(@PathParam("laptopId") long id) {
        this.contactLaptopResource.setId(id);
        return this.contactLaptopResource;
    }
}
