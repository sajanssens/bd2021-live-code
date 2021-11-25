package nl.belastingdienst.rest.dao;

import nl.belastingdienst.rest.domain.Contact;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Singleton // uit CDI
public class ContactDao {

    private final Contact.ContactBuilder cb = Contact.builder();

    private List<Contact> contacts = new ArrayList<>(List.of(
            cb.firstName("Bram").surname("Janssens").email("s.a.janssens@gmail.com").id(1L).build(),
            cb.firstName("Joop").surname("Janssens").email("j.janssens@gmail.com").id(2L).build(),
            cb.firstName("Mieke").surname("Janssens").email("m.janssens@gmail.com").id(3L).build()
    ));

    public List<Contact> getContacts(String q) {
        return q == null ? this.contacts :
                contacts.stream()
                        .filter(c -> c.getFirstName().contains(q))
                        .collect(toList());
    }

    public Optional<Contact> getContact(long id) {
        return contacts.stream() // 1) create a stream
                .filter(c -> c.getId() == id) // 2) bewerk de elementen in de stream
                .findAny();          // 3) reduce the stream
    }

    public Contact add(Contact input) {
        input.setId(getMaxId() + 1);
        this.contacts.add(input);
        return input;
    }

    private long getMaxId() {
        return this.contacts.stream()
                .mapToLong(Contact::getId)
                .max().orElseThrow(() -> new RuntimeException("Add contact failed; no id generated."));
    }

    public void remove(long id) {
        Contact contact = getContact(id).get();
        this.contacts.remove(contact);
    }

    public Contact update(long id, Contact updatedContact) {
        Contact contact = getContact(id).get();
        int i = this.contacts.indexOf(contact);
        this.contacts.add(i, updatedContact);
        return updatedContact;
    }
}
