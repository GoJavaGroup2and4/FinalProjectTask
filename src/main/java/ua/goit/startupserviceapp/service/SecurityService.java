package ua.goit.startupserviceapp.service;

/**
 *Service for Security.
 *
 * @author  Anstasuya Kravchenko
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String login,String password);

}
