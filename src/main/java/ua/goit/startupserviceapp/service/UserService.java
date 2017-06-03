package ua.goit.startupserviceapp.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import ua.goit.startupserviceapp.model.Startup;
import ua.goit.startupserviceapp.model.UserDB;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Service class for {@link ua.goit.startupserviceapp.model.UserDB}
 *
 * @author Illia Kulinich, Anastasiya Kravchenko
 * @version 1.0
 */
@Service
public interface UserService {

    void save(UserDB user);

    void saveWithoutEncode(UserDB user);

    UserDB findByLogin(String login);

    public UserDB getAuthenticatedUser(HttpServletRequest request);

    public boolean isAuthenticated(HttpServletRequest request);

    public boolean isAdmin(HttpServletRequest request);

    public boolean isStartupOwner(long id, HttpServletRequest request);
}
