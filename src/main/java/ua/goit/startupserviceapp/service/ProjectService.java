package ua.goit.startupserviceapp.service;

import ua.goit.startupserviceapp.model.Project;

import java.util.List;

/**
 * Service class for {@link ua.goit.startupserviceapp.model.Project}
 *
 * @author Illia Kulinich
 * @version 1.0
 **/

public interface ProjectService {

    public void save (Project project);

    public void edit (Project project);

    public void delete(Project project);

    public void deleteById (int id);

    public void ready (Project project);

    public void approve (Project project);

    public void reject (Project project);

    public List<Project> getAllProjects ();

    public List<Project> getProjectsByFounder();

    public List <Project> getProjectsByName();

    public List <Project> getProjectsByCategory();

    public List <Project> getProjectsByStatus();

    public Project getProjectById (int id);






}
