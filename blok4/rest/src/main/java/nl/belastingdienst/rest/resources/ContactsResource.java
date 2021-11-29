package nl.belastingdienst.rest.resources;

import nl.belastingdienst.rest.dao.ContactDao;
import nl.belastingdienst.rest.domain.Contact;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("contacts")
public class ContactsResource {

    @Inject
    private ContactDao contactDao;

    @Inject
    private ContactResource contactResource;

    @GET
    @Produces(APPLICATION_JSON)
    public List<Contact> getAll(@QueryParam("q") String q) {
        return contactDao.getContacts(q);
    }

    // ....???
    // public ??? getByQ(String q){
    //  zoek alle contacts met q in de naam of in het emailadres
    //  en return deze

    // Met een subresource:
    @Path("{id}")
    public ContactResource contactResource(@PathParam("id") long id) {
        this.contactResource.setId(id);
        return this.contactResource; // forward all requests on  contacts/{id} to ContactResource
    }

    // Zonder een subresource:
    // @Path("{id}")
    // public Contact contact(@PathParam("id") long id) {
    //     // ...
    // }
    //
    // @Path("{id}/laptops")
    // public List<Laptop> laptops(@PathParam("id") long cid) {
    //     // ...
    // }
    //
    // @Path("{id}/laptops/{lapId}")
    // public List<Laptop> laptop(@PathParam("id") long id, @PathParam("lapId") long lapId) {
    //     // ...
    // }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Contact add(Contact input) {
        return contactDao.add(input);
    }
    // }
}
