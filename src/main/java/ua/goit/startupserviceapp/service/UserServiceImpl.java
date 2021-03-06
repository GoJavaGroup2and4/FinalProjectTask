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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserDB user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
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
                .anyMatch(s -> s.getId() == startupId);
    }

    public void setUserDBRepository(UserDBRepository userDBRepository) {
        this.userDBRepository = userDBRepository;
    }

    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
}
