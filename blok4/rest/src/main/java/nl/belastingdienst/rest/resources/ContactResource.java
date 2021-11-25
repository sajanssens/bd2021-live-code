package nl.belastingdienst.rest.resources;

import nl.belastingdienst.rest.dao.ContactDao;
import nl.belastingdienst.rest.domain.Contact;

import javax.inject.Inject;
import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static nl.belastingdienst.rest.util.Responses.badRequest;

public class ContactResource {

    @Inject
    private ContactDao contactDao;

    @GET @Path("{id}")
    @Produces(APPLICATION_JSON)
    public Contact get(@PathParam("id") long id) {
        return contactDao.getContact(id).orElseThrow(() -> badRequest(id));
    }

    @DELETE @Path("{id}")
    @Produces(APPLICATION_JSON)
    public void delete(@PathParam("id") long id) {
        contactDao.remove(id);
    }

    @PUT @Path("{id}")
    public Contact put(@PathParam("id") long id, Contact updatedContact) {
        return contactDao.update(id, updatedContact);
    }
}
