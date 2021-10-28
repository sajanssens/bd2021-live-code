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
public class PersonDao {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    public void save(Person privateRyan) {
        log.info("Saving " + privateRyan);
        // Application managed transaction! Zelf doen.
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(privateRyan);
        transaction.commit();
    }

    public Person find(int id) {
        return em.find(Person.class, id); // find by PK
    }

    public List<Person> findAll() {
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);// JPQL = Java Persistence Query Language
        return query.getResultList();
    }

    public List<Person> findAllNamed() {
        var query = em.createNamedQuery("findAll", Person.class);
        return query.getResultList();
    }

    public List<Person> findBy(String name) {
        var query = em.createQuery("SELECT p FROM Person p WHERE p.name LIKE :aName", Person.class);
        query.setParameter("aName", name);
        return query.getResultList();
    }

    public void remove(Person p) {
        // performAsTransaction((e) -> em.remove(e));
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    public void update(Person p) {
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }

    public void updateFirstname(String newName, int pId) {
        Person person = find(pId);

        logIsTransactionActive();

        em.getTransaction().begin();
        logIsTransactionActive();
        person.setName(newName);
        em.getTransaction().commit();
        logIsTransactionActive();

        em.flush();
    }

    private void logIsTransactionActive() {
        log.info("updateFirstname getTransaction().isActive() = {}", em.getTransaction().isActive());
    }

}
