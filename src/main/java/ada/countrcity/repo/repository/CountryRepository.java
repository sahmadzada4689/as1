package ada.countrcity.repo.repository;

import ada.countrcity.repo.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("SELECT co FROM Country co WHERE  co.presidentFullName=:name")
    Country getCountryByPresidentName(String name);

    @Query("SELECT co FROM Country co  ORDER BY co.peopleCount desc limit 1")
    Country getMaxPeopleCountCountry( );
}
