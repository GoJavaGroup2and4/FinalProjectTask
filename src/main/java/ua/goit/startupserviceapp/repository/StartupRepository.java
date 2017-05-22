package ua.goit.startupserviceapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.startupserviceapp.model.Startup;

@Repository
public interface StartupRepository extends JpaRepository<Startup, Long>{
}
