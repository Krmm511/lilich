package il.cshaifasweng.OCSFMediatorExample.server;

import il.cshaifasweng.OCSFMediatorExample.entities.CatalogItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DatabaseInitializer {

    private static SessionFactory getSessionFactory()throws
            HibernateException
    {
            Configuration configuration = new Configuration();

            // Add all your entities
            configuration.addAnnotatedClass(CatalogItem.class);

            // Service registry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            return configuration.buildSessionFactory(serviceRegistry);


    }

    public static void init() {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            long count = (long) session.createQuery("SELECT COUNT(c) FROM CatalogItem c")
                    .getSingleResult();
            if (count == 0) {
                CatalogItem rose = new CatalogItem("Rose Bouquet", "Flower", 50.0, "C:\\Users\\karam\\IdeaProjects\\Lilich-V2\\images\\rose.jpeg");
                CatalogItem tulip = new CatalogItem("Tulip Bouquet", "Flower", 40.0, "C:\\Users\\karam\\IdeaProjects\\Lilich-V2\\images\\tulip.avif");
                CatalogItem orchid = new CatalogItem("Orchid Plant", "Plant", 120.0, "C:\\Users\\karam\\IdeaProjects\\Lilich-V2\\images\\orchid.webp");

                session.save(rose);
                session.save(tulip);
                session.save(orchid);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}