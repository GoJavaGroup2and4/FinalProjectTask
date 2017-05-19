package ua.goit.startupserviceapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.startupserviceapp.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
}
