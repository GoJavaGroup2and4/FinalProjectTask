package ua.goit.startupserviceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.startupserviceapp.dao.StartupDAO;
import ua.goit.startupserviceapp.model.Startup;
import java.util.List;

/**
 * Implementation of {@link ua.goit.startupserviceapp.service.UserService}
 *
 * @author Illia Kulinich
 * @version 1.0
 */

@Service
public class StartupServiceImpl implements StartupService {

    private StartupDAO startupDAO;

    @Autowired
    public StartupServiceImpl (StartupDAO startupDAO) {
        this.startupDAO = startupDAO;
    }

    @Override
    public void save(Startup startup) {
        startupDAO.save(startup);
    }

    @Override
    public void edit(Startup startup) {
        startupDAO.save(startup);
    }

    @Override
    public void delete(Startup startup) {
        startupDAO.delete(startup);
    }

    @Override
    public void deleteById(long id) {
        startupDAO.delete(id);
    }


//        TODO: In case when status is already approved or above - validator has to show respective error on web-page. Or develop another logic
//        TODO: add Admin authorization checks
    @Override
    public void ready(Startup startup) {
        if(startup.getStatus().equals("Draft")){
            startup.setStatus("Ready");
        }
        else return;

    }

    @Override
    public void approve(Startup startup) {

        if(startup.getStatus().equals("Ready")){
            startup.setStatus("Approved");
        }
        else return;


    }

    @Override
    public void reject(Startup startup) {
        if(startup.getStatus().equals("Ready")){
            startup.setStatus("Rejected");
        }
        else return;

    }

    @Override
    public List<Startup> getAllStartups() {
        return startupDAO.findAll();
    }

//    TODO: розібратися що таке UserStartup
//    @Override
//    public List<Startup> getStartupsByUser(UserDB user) {
//        return null;
//    }

    @Override
    public List<Startup> getStartupsByName(String name) {
        List <Startup> startupsByName = this.getAllStartups();

        startupsByName.removeIf(p -> !p.getName().equals(name));

        return startupsByName;
    }

//    TODO: розібратися чи дійсно Category.class має бути таким складним, чи нам вистачить ENUM. Після цього завершити реалізацію метода
//    @Override
//    public List<Startup> getStartupsByCategory() {
//        return null;
//    }

//    TODO: status - String or ENUM? make respective realisation.
//    @Override
//    public List<Startup> getStartupsByStatus(String status) {
//        return null;
//    }

    @Override
    public Startup getStartupById(long id) {
        List <Startup> startupsByName = this.getAllStartups();

        startupsByName.removeIf(p -> p.getId() != id);

        return startupsByName.get(0);

    }
}
