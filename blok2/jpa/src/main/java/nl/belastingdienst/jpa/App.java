package nl.belastingdienst.jpa;

import nl.belastingdienst.jpa.domain.Person;

import javax.persistence.*;
import java.util.List;

public class App {

    // Application managed EntityManager
    private EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();

    public static void main(String[] args) {
        new App().start();
    }

    private void start() {
        Person bram = Person.builder().name("Bram").age(42).build();

        // Application managed transaction! Zelf doen.
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(bram);
        transaction.commit();

        Person person = em.find(Person.class, 1); // find by PK
        System.out.println(person);

        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);// JPQL = Java Persistence QL
        List<Person> resultList = query.getResultList();
        resultList.forEach(System.out::println);

    }
}
