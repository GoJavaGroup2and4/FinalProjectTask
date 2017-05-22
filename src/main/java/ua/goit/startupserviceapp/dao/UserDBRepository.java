package ua.goit.startupserviceapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.startupserviceapp.model.UserDB;

@Repository
public interface UserDBRepository extends JpaRepository<UserDB, Long> {
    UserDB findByLogin(String login);
}
