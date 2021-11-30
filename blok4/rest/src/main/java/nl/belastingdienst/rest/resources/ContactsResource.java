package nl.belastingdienst.rest.resources;

import nl.belastingdienst.rest.dao.ContactDao;
import nl.belastingdienst.rest.domain.Contact;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

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
    @Operation(description = "Gets all contacts or filtered by q.")
    // Add API documentation for mpOpenAPI, see https://openliberty.io/blog/2018/05/22/microprofile-openapi-intro.html
    // and for a quick overview: https://github.com/eclipse/microprofile-open-api/blob/master/spec/src/main/asciidoc/microprofile-openapi-spec.asciidoc#annotations
    public List<Contact> getAll(@Parameter(description = "Search on firstname and/or surname")
                                @QueryParam("q") String q) {
        return contactDao.getContacts(q);
    }

    // Met een subresource:
    @Path("{contactId}")
    public ContactResource contactResource(@PathParam("contactId") long id) {
        this.contactResource.setId(id);
        return this.contactResource; // forward all requests on  contacts/{id} to ContactResource
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Contact add(Contact input) {
        return contactDao.add(input);
    }
}
