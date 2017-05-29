package ua.goit.startupserviceapp.service;

import ua.goit.startupserviceapp.model.Startup;

import java.util.List;

/**
 * Service class for {@link ua.goit.startupserviceapp.model.Startup}
 *
 * @author Illia Kulinich
 * @version 1.0
 **/

public interface StartupService {

    void save (Startup startup);

    void edit (Startup startup);

    void delete(Startup startup);

    void deleteById (long id);

    void ready (Startup startup);

    void approve (Startup startup);

    void reject (Startup startup);

    Startup findByName (String name);

    List<Startup> getAllStartups ();

//    List<Startup> getStartupsByUser(UserDB user);

    List <Startup> getStartupsByName(String name);

//    List <Startup> getStartupsByCategory();

//    List <Startup> getStartupsByStatus(String status);

    Startup getStartupById (long id);






}
