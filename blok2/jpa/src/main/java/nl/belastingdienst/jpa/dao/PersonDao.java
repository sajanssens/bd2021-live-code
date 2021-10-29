package nl.belastingdienst.jpa.dao;

import nl.belastingdienst.jpa.domain.Person;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Singleton
public class PersonDao extends Dao<Person, Integer> {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    public Person find(int id) {
        return em.find(Person.class, id); // find by PK
    }

    public List<Person> findBy(String name) {
        var query = em.createQuery("SELECT p FROM Person p WHERE p.name LIKE :aName", Person.class);
        query.setParameter("aName", name);
        return query.getResultList();
    }

    public List<Person> findByTeamName(String teamName) {
        var query = em.createNamedQuery("Person.findByTeamNamePart", Person.class);
        query.setParameter("teamName", "%" + teamName + "%");
        return query.getResultList();
    }


    public void updateFirstname(String newName, int pId) {
        Person person = find(pId);

        logIsTransactionActive();

        em.getTransaction().begin();
        logIsTransactionActive();
        person.setName(newName);
        em.flush();
        em.getTransaction().commit();
        logIsTransactionActive();

    }

    private void logIsTransactionActive() {
        log.info("updateFirstname getTransaction().isActive() = {}", em.getTransaction().isActive());
    }

}
