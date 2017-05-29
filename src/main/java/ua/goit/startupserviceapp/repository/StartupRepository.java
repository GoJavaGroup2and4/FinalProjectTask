package ua.goit.startupserviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.startupserviceapp.model.Startup;

@Repository
public interface StartupRepository extends JpaRepository<Startup, Long> {
    Startup findByName(String name);
}
