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

    void save (UserDB user);

    UserDB findByUsername(String login);

    @Secured("Investor")
    void invest(UserDB user_id, Startup startup_id, int investment);

    public void edit (UserDB user);

    public void delete (UserDB user);

    public void deleteById (int id);

    public UserDB getUserById (int id);

    public List<UserDB> getAllUsers ();

    public List<UserDB> getAllFounders ();

    public List<UserDB> getAllInvestors ();

    public List<UserDB> getAllAdministrators ();


}
