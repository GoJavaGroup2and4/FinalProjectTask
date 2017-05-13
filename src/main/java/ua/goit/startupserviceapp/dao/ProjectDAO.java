package ua.goit.startupserviceapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.startupserviceapp.model.Project;

public interface ProjectDAO extends JpaRepository<Project, Long>{
}
