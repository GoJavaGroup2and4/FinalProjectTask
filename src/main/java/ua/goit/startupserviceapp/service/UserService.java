package ua.goit.startupserviceapp.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import ua.goit.startupserviceapp.model.Startup;
import ua.goit.startupserviceapp.model.UserDB;

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

    UserDB findByLogin(String login);

    @Secured("Investor")
    void invest(UserDB user_id, Startup startup_id, int investment);

    void edit(UserDB user);

    void delete(UserDB user);

    void deleteById(int id);

    UserDB getUserById(int id);

    List<UserDB> getAllUsers();

    List<UserDB> getAllFounders();

    List<UserDB> getAllInvestors();

    List<UserDB> getAllAdministrators();
}
