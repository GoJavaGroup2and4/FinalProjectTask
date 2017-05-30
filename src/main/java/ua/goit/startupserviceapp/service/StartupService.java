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

    void save(Startup startup);

    void edit(Startup startup);

    void delete(Startup startup);

    void deleteById(long id);

    void ready(long id);

    void approve(long id);

    void reject(long id);

    void close(long id);

    Startup findByName(String name);

    List<Startup> getAllStartups();

    List<Startup> getAllApprovedStartups();

    List<Startup> getAllBusinessStartups();

    List<Startup> getAllInvestmentStartups();

    List<Startup> getAllMobileStartups();

//    List<Startup> getStartupsByUser(UserDB user);

    List<Startup> getStartupsByName(String name);


    Startup getStartupById(long id);

    Double averageRating(long id);

    int votesCount (long id);


}
