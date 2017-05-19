package ua.goit.startupserviceapp.service;

import ua.goit.startupserviceapp.model.User;

import java.util.List;

/**
 * Service class for {@link User}
 *
 * @author Illia Kulinich
 * @version 1.0
 */

public interface UserService {

    public void save (User user);

    public void edit (User user);

    public void delete (User user);

    public void deleteById (int id);

    public User getUserById (int id);

    public List getAllUsers ();

    public List<User> getAllFounders ();

    public List<User> getAllInvestors ();

    public List<User> getAllAdministrators ();


}
