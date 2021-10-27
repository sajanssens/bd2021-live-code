package nl.belastingdienst.jpa.dao;

import nl.belastingdienst.jpa.domain.Person;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonDao {

    @Inject
    private Logger log;

    private final EntityManager em;

    @Inject
    public PersonDao(EntityManager em) { // DIY dependency injection
        this.em = em;
    }

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
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);// JPQL = Java Persistence QL
        return query.getResultList();
    }
}
