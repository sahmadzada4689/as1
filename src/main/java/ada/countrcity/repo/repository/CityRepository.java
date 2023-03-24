package ada.countrcity.repo.repository;

import ada.countrcity.repo.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface CityRepository extends JpaRepository<City, Long> {

    @Query("SELECT c.isCapitalCity FROM City c WHERE c.name=:name")
    Boolean checkNameIsMain(String name);

    Optional<City> findByName(String name);
}
