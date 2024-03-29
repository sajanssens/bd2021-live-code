package nl.belastingdienst.jpa.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Singleton
public class Producers {

    @Produces // instantie aanmaken en aanmelden bij de DI container (Weld)
    public static EntityManager em() {
        // Application managed EntityManager
        return Persistence.createEntityManagerFactory("MySQL").createEntityManager();
    }

    @Produces
    public Logger logger(InjectionPoint ip) {
        return LoggerFactory.getLogger(ip.getMember().getDeclaringClass());
    }

}
