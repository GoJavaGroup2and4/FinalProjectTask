package ua.goit.startupserviceapp.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

/**
 * Created by Galinka on 18.05.2017.
 */
public class Test {
    static SessionFactory sessionFactory;
    static {
        System.out.println("Connecting to DB...");
        try {
            File file = new File("hibernate.cfg.xml");
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
            System.out.println("Successfully connected to DB.\n");
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
    }

    public static void main(String[] args) {
        Category category = new Category("new category");

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();

        Startup startup = new Startup("new startup",1000,category);
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(startup);
        session.getTransaction().commit();

        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Category c = session.get(Category.class,category.getId());
        System.out.println(c.getStartups());
        session.getTransaction().commit();
    }
}
