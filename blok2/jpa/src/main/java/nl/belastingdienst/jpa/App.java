package nl.belastingdienst.jpa;

import nl.belastingdienst.jpa.dao.DepartmentDao;
import nl.belastingdienst.jpa.dao.OfficeDao;
import nl.belastingdienst.jpa.dao.PersonDao;
import nl.belastingdienst.jpa.dao.TeamDao;
import nl.belastingdienst.jpa.domain.Department;
import nl.belastingdienst.jpa.domain.Office;
import nl.belastingdienst.jpa.domain.Person;
import nl.belastingdienst.jpa.domain.Team;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import java.util.List;

@Singleton
public class App {

    @Inject
    private EntityManager em;

    @Inject
    private Logger log; // injection point

    @Inject
    private PersonDao personDao;

    @Inject
    private TeamDao teamDao;

    @Inject
    private DepartmentDao departmentDao;

    @Inject
    private OfficeDao officeDao;

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

        // data:
        Person bram = Person.builder().name("Bram").age(42).build();
        Person christian = Person.builder().name("Christian").age(28).build();
        Person pepijn = Person.builder().name("Pepijn").age(25).build();

        Team bdjava2021_2 = Team.builder().name("Java-team najaar 2021").build();

        Department hr = Department.builder().name("Human Resources Man.").build();
        Department reclame = Department.builder().name("Reclame").build();
        Department marloes = Department.builder().name("Marloes").build();

        Office o = Office.builder().name("Multil*l").build();

        // actions

        personDao.save(bram);

        Person ps = personDao.find(bram.getId());
        log.info(ps.toString());

        List<Person> all = personDao.findAll();
        all.forEach(p -> log.info(p.toString()));

        personDao.updateFirstname("Baas", bram.getId());

        bram.setTeam(bdjava2021_2);
        christian.setTeam(bdjava2021_2);
        pepijn.setTeam(bdjava2021_2);

        personDao.save(bram); // team is also saved because of cascade in person
        personDao.save(christian);
        personDao.save(pepijn);

        List<Person> byTeamName = personDao.findByTeamName("Java-team");
        byTeamName.forEach(p -> log.info(p.toString()));

        bram.setWorksAt(hr);
        pepijn.setWorksAt(hr);
        personDao.update(bram);
        personDao.update(pepijn);

        personDao.save(bram);

        // bidi synchronize both sides of the relationship:
        Person foutje = Person.builder().name("Foutje").age(21).build();
        Department dev = Department.builder().name("Dev").build();

        personDao.save(foutje);
        foutje.setWorksAt(dev);
        personDao.update(foutje);
        // departmentDao.save(dev); // saved by "cascade = persist" in person

        // find office:
        officeDao.save(o);

        o.addDepartment(hr);
        o.addDepartment(reclame);
        o.addDepartment(marloes);
        officeDao.update(o);

        // ... do something else...

        // works only when office is managed (i.e. "hot"):
        Office officeManaged = officeDao.find(1);
        officeManaged.getDepartments().forEach(d -> log.info(d.toString()));

        Office officeDetached = officeDao.findDetached(1);
        officeDetached.getDepartments().forEach(d -> log.info(d.toString()));
    }
}
