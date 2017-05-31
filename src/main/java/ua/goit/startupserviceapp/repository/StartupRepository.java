package ua.goit.startupserviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.goit.startupserviceapp.model.Startup;

import java.util.Collection;

@Repository
public interface StartupRepository extends JpaRepository<Startup, Long> {
    Startup findByName(String name);

    Startup findById(long id);

    @Query("SELECT s from Startup s where s.name like %:key% or s.description like %:key%")
    Collection<Startup> findAllByKeyWord(@Param("key") String key);
}
