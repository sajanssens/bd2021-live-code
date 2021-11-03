package nl.belastingdienst.jpa.dao;

import nl.belastingdienst.jpa.domain.Team;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Singleton
public class TeamDao {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    public void save(Team team) {
        log.info("Saving " + team);
        // Application managed transaction! Zelf doen.
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(team);
        transaction.commit();
    }

    public Team find(int id) {
        return em.find(Team.class, id); // find by PK
    }

    public List<Team> findAll() {
        TypedQuery<Team> query = em.createQuery("SELECT t FROM Team t", Team.class);// JPQL = Java Persistence Query Language
        return query.getResultList();
    }

    public List<Team> findAllNamed() {
        var query = em.createNamedQuery("Team.findAll", Team.class);
        return query.getResultList();
    }

    public List<Team> findBy(String name) {
        var query = em.createQuery("SELECT e FROM Team e WHERE e.name LIKE :aName", Team.class);
        query.setParameter("aName", name);
        return query.getResultList();
    }

    public void remove(Team e) {
        performAsTransaction(() -> em.remove(e));
    }

    public void update(Team e) {
        performAsTransaction(() -> em.merge(e));
    }

    public void performAsTransaction(Runnable function){
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            function.run();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void updateFirstname(String newName, int tId) {
        Team e = find(tId);

        logIsTransactionActive();

        em.getTransaction().begin();
        logIsTransactionActive();
        e.setName(newName);
        em.flush();
        em.getTransaction().commit();
        logIsTransactionActive();

    }

    private void logIsTransactionActive() {
        log.info("updateFirstname getTransaction().isActive() = {}", em.getTransaction().isActive());
    }

}
