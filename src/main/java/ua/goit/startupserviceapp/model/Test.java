package ua.goit.startupserviceapp.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.goit.startupserviceapp.configuration.DataConfig;
import ua.goit.startupserviceapp.controller.UserController;
import ua.goit.startupserviceapp.service.UserService;
import ua.goit.startupserviceapp.service.UserServiceImpl;

import java.io.File;

/**
 * Created by Galinka on 18.05.2017.
 */
public class Test {
//    static SessionFactory sessionFactory;
    private UserController userController = new UserController();
//    static {
//        System.out.println("Connecting to DB...");
//        try {
//            File file = new File("hibernate.cfg.xml");
//            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//            sessionFactory = configuration.buildSessionFactory();
//            System.out.println("Successfully connected to DB.\n");
//        } catch (Throwable t) {
//            System.out.println(t.getMessage());
//        }
//    }

    public static void main(String[] args) {
//        Category category = new Category("new category");
//
//        Session session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        session.save(category);
//        session.getTransaction().commit();
//
//        Startup startup = new Startup("new startup",1000,category);
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        session.save(startup);
//        session.getTransaction().commit();
//
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Category c = session.get(Category.class,category.getId());
//        System.out.println(c.getStartups());
//        session.getTransaction().commit();
//
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        User user = new User("gala","zubenko","gala@mail.ru","gala6ap","gala");
//        session.save(user);
//        System.out.println(c.getStartups());
//        session.getTransaction().commit();
//
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        StartupEvaluation mark = new StartupEvaluation(user, startup, 5);
//        session.save(mark);
//        System.out.println(c.getStartups());
//        session.getTransaction().commit();
//
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        UserStartup us = new UserStartup(user, startup);
//        session.save(us);
//        session.getTransaction().commit();
//
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Startup s = session.get(Startup.class,startup.getId());
//        System.out.println(s.getMarks());
//        System.out.println(s.getUsers());
//        User u = session.get(User.class,user.getId());
//        System.out.println(u.getMarks());
//        System.out.println(u.getStartups());
//        session.getTransaction().commit();
//
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Permission p = new Permission("new permission");
//        session.save(p);
//        session.getTransaction().commit();
//
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Role r = new Role("new role");
//        r.getPermissions().add(p);
//        session.save(r);
//        session.getTransaction().commit();
//
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        p = session.get(Permission.class, p.getId());
//        System.out.println(p.getRoles());
//        session.getTransaction().commit();

//        sessionFactory.getCurrentSession().beginTransaction();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DataConfig.class);
        applicationContext.getBean("test", Test.class).start();

//        sessionFactory.close();
    }

    private void start() {
        userController.printAllUsers().forEach(System.out::println);
    }

//    public static void setSessionFactory(SessionFactory sessionFactory) {
//        Test.sessionFactory = sessionFactory;
//    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }
}
