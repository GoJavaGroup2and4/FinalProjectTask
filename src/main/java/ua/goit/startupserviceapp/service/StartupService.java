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

    public void save (Startup startup);

    public void edit (Startup startup);

    public void delete(Startup startup);

    public void deleteById (int id);

    public void ready (Startup startup);

    public void approve (Startup startup);

    public void reject (Startup startup);

    public List<Startup> getAllStartups ();

    public List<Startup> getStartupsByFounder();

    public List <Startup> getStartupsByName();

    public List <Startup> getStartupsByCategory();

    public List <Startup> getStartupsByStatus();

    public Startup getStartupById (int id);






}
