package nl.belastingdienst.rest.resources;

import nl.belastingdienst.rest.dao.ContactDao;
import nl.belastingdienst.rest.domain.Contact;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/contacts")
public class ContactsResource {

    private final ContactDao contactDao = new ContactDao();

    @GET
    @Produces(APPLICATION_JSON)
    public List<Contact> getAll_MaarJeMagDitZelfWeten() {
        return contactDao.getContacts();
    }
}
