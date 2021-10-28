package nl.belastingdienst.jpa;

import nl.belastingdienst.jpa.dao.PersonDao;
import nl.belastingdienst.jpa.domain.Person;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class App {

    @Inject
    private Logger log; // injection point

    @Inject
    private PersonDao dao;

    public static void main(String[] args) {
        // CDI = Contexts and Dependency Injection
        //          Contexts is/was voor als je Front End in Java schrijft,
        //          tegenwoordig vaak in JS, dus Contexts gebruiken we (bijna) niet meer.
        //      = specificatie, verzameling interfaces

        // Weld = Implementatie = DI engine / DI container.
        //  Kan: 1) instanties van al mijn eigen klasses aanmaken of van andere klasses via @Produces-methode(s)
        //       2) instanties injecteren in andere klasses (@Inject)
        //          voorwaarde: de andere klasse moet zélf ook door stap 1 zijn aangemaakt, i.e. door Weld gemanaged zijn.

        Weld weld = new Weld();
        WeldContainer weldContainer = weld.initialize(); // de engine/container

        App app = weldContainer.select(App.class).get(); // vanaf nu kan ik in App en zijn dependencies (dao) @Inject gebruiken.
        app.start();

        weld.shutdown();
    }

    private void start() {
        log.info("Starting app...");

        Person bram = Person.builder().name("Bram").age(42).build();

        dao.save(bram);

        Person ps = dao.find(bram.getId());
        log.info(ps.toString());

        List<Person> all = dao.findAll();
        all.forEach(p -> log.info(p.toString()));

        dao.updateFirstname("Baas", bram.getId());

    }
}
