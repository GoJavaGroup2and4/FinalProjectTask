package ua.goit.startupserviceapp.service;

import ua.goit.startupserviceapp.model.UserDB;

import java.util.List;

/**
 * Service class for {@link ua.goit.startupserviceapp.model.UserDB}
 *
 * @author Illia Kulinich
 * @version 1.0
 */

public interface UserService {

    public void save (UserDB user);

    public void edit (UserDB user);

    public void delete (UserDB user);

    public void deleteById (int id);

    public UserDB getUserById (int id);

    public List<UserDB> getAllUsers ();

    public List<UserDB> getAllFounders ();

    public List<UserDB> getAllInvestors ();

    public List<UserDB> getAllAdministrators ();


}
