package nl.belastingdienst.jpa.dao;

import nl.belastingdienst.jpa.domain.Person;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Singleton
public class PersonDaoMock {

    @Inject
    private Logger log;

    private Map<Integer, Person> persons = new HashMap<>();

    public void save(Person privateRyan) {
        this.persons.putIfAbsent(privateRyan.getId(), privateRyan);
    }

    public Person find(int id) {
        return persons.get(id);
    }

    public Collection<Person> findAll() {
        return persons.values();
    }

    public List<Person> findBy(String name) {
        return persons.values().stream()               // from
                .filter(p -> p.getName().equals(name)) // where
                .collect(toList());                    // select
    }

    public void remove(Person p) {
        persons.remove(p.getId());
    }

    public void update(Person p) {
        persons.put(p.getId(), p);
    }

    public void updateFirstname(String newName, int pId) {
        Person person = find(pId);
        person.setName(newName);
        update(person);
    }

}
