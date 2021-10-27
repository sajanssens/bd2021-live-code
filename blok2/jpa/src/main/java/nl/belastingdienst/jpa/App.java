package nl.belastingdienst.jpa;

import nl.belastingdienst.jpa.dao.PersonDao;
import nl.belastingdienst.jpa.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class App {

    // Application managed EntityManager
    private static final EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();
    private static final PersonDao dao = new PersonDao(em);

    public static void main(String[] args) {
        new App().start();
    }

    private void start() {
        Person bram = Person.builder().name("Bram").age(42).build();

        dao.save(bram);

        Person p = dao.find(bram.getId());
        System.out.println(p);

        List<Person> all = dao.findAll();
        all.forEach(System.out::println);
    }
}
