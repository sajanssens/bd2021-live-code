package nl.belastingdienst.rest.dao;

import nl.belastingdienst.rest.domain.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactDao {

    private final Contact.ContactBuilder cb = Contact.builder();

    private final List<Contact> contacts = new ArrayList<>(List.of(
            cb.firstName("Bram").surname("Janssens").email("s.a.janssens@gmail.com").id(1L).build(),
            cb.firstName("Joop").surname("Janssens").email("j.janssens@gmail.com").id(2L).build(),
            cb.firstName("Mieke").surname("Janssens").email("m.janssens@gmail.com").id(3L).build()
    ));

    public List<Contact> getContacts() {
        return contacts;
    }
}
