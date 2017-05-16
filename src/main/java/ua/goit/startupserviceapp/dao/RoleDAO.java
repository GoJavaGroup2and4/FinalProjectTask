package ua.goit.startupserviceapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.startupserviceapp.model.Role;

public interface RoleDAO extends JpaRepository<Role, Long> {

}
