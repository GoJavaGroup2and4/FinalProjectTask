package ua.goit.startupserviceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.goit.startupserviceapp.model.Role;
import ua.goit.startupserviceapp.model.Startup;
import ua.goit.startupserviceapp.model.UserDB;
import ua.goit.startupserviceapp.model.UserStartup;
import ua.goit.startupserviceapp.repository.RoleRepository;
import ua.goit.startupserviceapp.repository.UserDBRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * implementation of {@link ua.goit.startupserviceapp.service.UserService}
 *
 * @author Illia Kulinich, Anastasiya Kravchenko
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDBRepository userDBRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserDB user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.getOne(2L));
        user.setRoles(roles);
        userDBRepository.save(user);
    }

    @Override
    public UserDB findByLogin(String login) {
        return userDBRepository.findByLogin(login);
    }

    @Override
    @Secured("Investor")
    public void invest(UserDB user_id, Startup startup_id, int investment) {
        UserStartup userStartup = new UserStartup();
        userStartup.setStartup(startup_id);
        userStartup.setUser(user_id);
        userStartup.setUserInvestment(investment);

        Startup startup = new Startup();
        startup.setCurrent_investment(startup.getCurrent_investment() + investment);
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
