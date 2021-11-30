package nl.belastingdienst.rest.resources;

import nl.belastingdienst.rest.dao.ContactDao;
import nl.belastingdienst.rest.domain.Contact;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static nl.belastingdienst.rest.util.Responses.badRequest;

// No @Path in a subresource!
// This runs @ contacts/{id}
@Dependent // deze is injecteerbaar (als discovery-mode=annotated) en
//            de levensduur van deze CDI-bean is hetzelfde (dependent) van de klasse waarin hij geinjecteerd wordt
public class ContactResource {

    private long id;

    @Inject
    private ContactDao contactDao;

    @Inject
    private ContactLaptopsResource contactLaptopsResource;

    @GET
    @Produces(APPLICATION_JSON)
    public Contact get() {
        return contactDao.getContact(this.id).orElseThrow(() -> badRequest(this.id));
    }

    @DELETE
    public void delete() {
        contactDao.remove(this.id);
    }

    @PUT
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Contact put(Contact updatedContact) {
        return contactDao.update(this.id, updatedContact);
    }

    // no http-method annotation!
    // no content type annotation!
    @Path("laptops")
    public ContactLaptopsResource laptops() {
        return contactLaptopsResource;
    }

    public void setId(long id) {
        this.id = id;
    }
}
