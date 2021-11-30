package nl.belastingdienst.rest.dao;

import nl.belastingdienst.rest.domain.Contact;

import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.ServiceMode;
import java.util.List;
import java.util.Optional;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static nl.belastingdienst.rest.util.Responses.throwBadRequest;

// @ApplicationScoped // Managed CDI bean, dus geen super powers
@Stateless //            Managed Enterprise Java Bean (EJB): hij krijgt super powers (zoals transaction capabilities).
//                       Stateless: de container maakt bij elk request een nieuwe instance;
//                       de class kan dus ook beter geen data-fields bevatten (dat heeft geen zin)!
public class ContactDao {

    // STATE: doesn't make sense in Stateless EJB.
    // private String name;

    @PersistenceContext // Container managed EntityManager, not via @Inject
    private EntityManager em; // container, geef mij een EntityManager

    // BEHAVIOUR:

    public List<Contact> getContacts(String q) {
        return q == null ?
                em.createNamedQuery("Contact.findAll", Contact.class)
                        .getResultList() :
                em.createNamedQuery("Contact.findByQ", Contact.class)
                        .setParameter("q", "%" + q + "%")
                        .getResultList();
    }

    public Optional<Contact> getContact(Long id) {
        return Optional.ofNullable(em.find(Contact.class, id));
    }

    @TransactionAttribute(REQUIRED)  // = default; whole annotation can be omitted when choosing REQUIRED.
    //                                  Deze methode wordt in een databasetransactie op de server uitgevoerd.
    //                                  Als er al een transactie loopt, gebruikt de server die, anders maakt hij een nieuwe transactie aan.
    public Contact add(Contact c) {
        // no em.gettransation.begin/commit/rollback: is managed by (EJB) container at the server
        em.persist(c);
        return c;
    }

    public void remove(Long id) {
        getContact(id).ifPresentOrElse(em::remove, throwBadRequest(id));
    }

    public Contact update(Long id, Contact updatedContact) {
        updatedContact.setId(id);
        return em.merge(updatedContact);
    }

}
