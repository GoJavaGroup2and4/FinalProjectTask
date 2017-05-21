package ua.goit.startupserviceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.goit.startupserviceapp.dao.RoleDAO;
import ua.goit.startupserviceapp.dao.UserDAO;
import ua.goit.startupserviceapp.model.Role;
import ua.goit.startupserviceapp.model.Startup;
import ua.goit.startupserviceapp.model.UserDB;

import java.util.ArrayList;
import java.util.List;

/**
 * implementation of {@link ua.goit.startupserviceapp.service.UserService}
 *
 * @author Illia Kulinich, Anastasiya Kravchenko
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserDB user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Role> roles=new ArrayList<>();
        roles.add(roleDAO.getOne(1L));
        user.setRoles(roles);
        userDAO.save(user);

    }

    @Override
    public UserDB findByUsername(String login) {
        return userDAO.findByUsername(login);
    }

    @Override
    public void invest(UserDB user, Startup startup) {

    }

    @Override
    public void edit(UserDB user) {

    }

    @Override
    public void delete(UserDB user) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public UserDB getUserById(int id) {
        return null;
    }

    @Override
    public List<UserDB> getAllUsers() {
        return null;
    }

    @Override
    public List<UserDB> getAllFounders() {
        return null;
    }

    @Override
    public List<UserDB> getAllInvestors() {
        return null;
    }

    @Override
    public List<UserDB> getAllAdministrators() {
        return null;
    }
}
