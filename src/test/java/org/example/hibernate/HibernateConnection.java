package org.example.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConnection {
    private final Logger logger;
    private final SessionFactory sessionFactory;
    public final Session session;

    public HibernateConnection(Class entityName, String queryClass) {
        logger = Logger.getLogger(queryClass);
        logger.trace(queryClass);
        sessionFactory = buildSessionFactory(entityName);
        session = sessionFactory.openSession();
    }

    private static SessionFactory buildSessionFactory(Class entityName) {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml")
                    .setProperties(SystemProperties.getHibernateConfiguration())
                    .addAnnotatedClass(entityName);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();


            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void shutDown() {
        session.close();
    }
}
