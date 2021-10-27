package nl.belastingdienst.jpa.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerProducer {

    @Produces // instantie aanmaken en aanmelden bij de DI container (Weld)
    public EntityManager em() {
        // Application managed EntityManager
        return Persistence.createEntityManagerFactory("MySQL").createEntityManager();
    }

}
