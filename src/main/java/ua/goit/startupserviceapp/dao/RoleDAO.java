package ua.goit.startupserviceapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.startupserviceapp.model.Role;

@Repository
public interface RoleDAO extends JpaRepository<Role, Long> {
}
