package ada.countrcity.service;

import ada.countrcity.city.TypeSort;
import ada.countrcity.country.CountryDto;
import ada.countrcity.country.PageableCountry;

import java.util.List;

public interface CountryService {
    CountryDto getCountryById(Long id);

    void addCountry(CountryDto dto);

    CountryDto getByPresidentName(String name);

    CountryDto getMaxPeopleCountCountry( );

    void deleteCountryById(Long id);

    CountryDto updateCountry(CountryDto dto, Long id);

    PageableCountry pageCountry(Integer page, Integer count);

    List<CountryDto> sortCountry(String value, TypeSort typeSort);
}
