package ua.goit.startupserviceapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.startupserviceapp.model.User;

public interface UserDAO extends JpaRepository<User, Long> {
}
