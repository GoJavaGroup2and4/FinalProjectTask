package ua.goit.startupserviceapp.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.goit.startupserviceapp.model.User;

import java.util.List;

/**
 * implementation of {@link ua.goit.startupserviceapp.service.UserService}
 *
 * @author Illia Kulinich
 * @version 1.0
 */

public class UserServiceImpl implements UserService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("select u from User u").list();
    }

    @Override
    public List<User> getAllFounders() {
        return null;
    }

    @Override
    public List<User> getAllInvestors() {
        return null;
    }

    @Override
    public List<User> getAllAdministrators() {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
