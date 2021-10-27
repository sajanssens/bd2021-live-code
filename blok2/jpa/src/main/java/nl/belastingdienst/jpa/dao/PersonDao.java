package nl.belastingdienst.jpa.dao;

import nl.belastingdienst.jpa.domain.Person;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonDao {

    private final EntityManager em;

    @Inject
    public PersonDao(EntityManager em) { // DIY dependency injection
        this.em = em;
    }

    public void save(Person p) {
        // Application managed transaction! Zelf doen.
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(p);
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
