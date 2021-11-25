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

    @GET
    @Produces(APPLICATION_JSON)
    public List<Contact> getAll(@QueryParam("q") String q) {
        return contactDao.getContacts(q);
    }

    @Path("{id}")
    @Produces(APPLICATION_JSON)
    public ContactResource get(@PathParam("id") long id) {
        return new ContactResource();
    }

    // ....???
    // public ??? getByQ(String q){
    //  zoek alle contacts met q in de naam of in het emailadres
    //  en return deze
    // }

    @POST
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Contact add(Contact input) {
        return contactDao.add(input);
    }

    // public ??? put(???) {
    //      ???
    // }

    // public ??? delete(???) {
    //      ???
    // }
}
