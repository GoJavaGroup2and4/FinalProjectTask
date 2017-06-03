package ua.goit.startupserviceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.startupserviceapp.model.Role;
import ua.goit.startupserviceapp.model.Startup;
import ua.goit.startupserviceapp.model.UserDB;
import ua.goit.startupserviceapp.repository.RoleRepository;
import ua.goit.startupserviceapp.repository.UserDBRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    private UserDBRepository userDBRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserDB user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        /*List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.getOne(2L));
        user.setRoles(roles);*/
        userDBRepository.save(user);
    }

    @Override
    public void saveWithoutEncode(UserDB user) {
        userDBRepository.save(user);
    }

    @Override
    @Transactional
    public UserDB findByLogin(String login) {
        return userDBRepository.findByLogin(login);
    }

    @Override
    @Secured("Investor")
    public void invest(UserDB user_id, Startup startup_id, int investment) {
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

    @Override
    @Transactional (readOnly = true)
    public UserDB getAuthenticatedUser(HttpServletRequest request) {

        UserDB user;

        HttpSession session= request.getSession (true);
        SecurityContextImpl sci = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");

        try {
            UserDetails userDetails = (UserDetails) sci.getAuthentication().getPrincipal();
            user = userDBRepository.findByLogin(userDetails.getUsername());
            return user;
        } catch (NullPointerException e){
            return new UserDB();
        }

    }

    @Override
    public boolean isAuthenticated(HttpServletRequest request) {

        HttpSession session= request.getSession (true);
        SecurityContextImpl sci = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");

        try {
            return sci.getAuthentication().isAuthenticated();
        } catch (NullPointerException e){
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isAdmin(HttpServletRequest request) {

        UserDB user = getAuthenticatedUser(request);

        return user.getRoles().contains(new Role("ROLE_ADMIN"));

    }
    @Override
    @Transactional(readOnly = true)
    public boolean isStartupOwner(long startupId, HttpServletRequest request) {

        UserDB user = getAuthenticatedUser(request);

        return user.getStartups().stream()
                .anyMatch(s -> s.getId() == startupId)
                &&
                user.getRoles().contains(new Role("ROLE_FOUNDER"));
    }
}
