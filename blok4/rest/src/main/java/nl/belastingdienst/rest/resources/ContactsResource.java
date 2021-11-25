package nl.belastingdienst.rest.resources;

import nl.belastingdienst.rest.dao.ContactDao;
import nl.belastingdienst.rest.domain.Contact;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static nl.belastingdienst.rest.util.Responses.badRequest;

@Path("contacts")
public class ContactsResource {

    private final ContactDao contactDao = new ContactDao();

    @GET
    @Produces(APPLICATION_JSON)
    public List<Contact> getAll() {
        return contactDao.getContacts();
    }

    @GET @Path("{id}")
    @Produces(APPLICATION_JSON)
    public Contact get(@PathParam("id") long id) {
        return contactDao.getContact(id).orElseThrow(() -> badRequest(id));
    }

    // ....???
    // public ??? getByQ(String q){
    // zoek alle contacts met q in de naam of in het emailadres
    // en return deze
    // }

    // public ???    add(???) {
    //      ???
    // }

    // public ??? put(???) {
    //      ???
    // }

    // public ??? delete(???) {
    //      ???
    // }
}
