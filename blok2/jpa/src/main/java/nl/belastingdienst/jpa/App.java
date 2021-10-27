package nl.belastingdienst.jpa;

import nl.belastingdienst.jpa.dao.PersonDao;
import nl.belastingdienst.jpa.domain.Person;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.inject.Inject;
import java.util.List;

public class App {

    @Inject
    private PersonDao dao;

    public static void main(String[] args) {
        // CDI = Contexts and Dependency Injection
        //          Contexts is/was voor als je Front End in Java schrijft,
        //          tegenwoordig vaak in JS, dus C gebruiken we (bijna) niet meer.

        // CDI = specificatie, verzameling interfaces
        //       implementatie: Weld DI engine / DI container.

        // kan: 1) instanties van al mijn eigen klasses aanmaken of van andere klasses via @Produces-methode(s)
        //      2) instanties injecteren in andere klasses (@Inject)
        //         voorwaarde: de andere klasse moet zelf ook door stap 1 zijn aangemaakt, i.e. door Weld gemanaged zijn.

        Weld weld = new Weld();
        WeldContainer weldContainer = weld.initialize(); // de engine/container

        App app = weldContainer.select(App.class).get(); // vanaf hier kan ik in App en zijn dependencies (dao) @Inject gebruiken.
        app.start();
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
