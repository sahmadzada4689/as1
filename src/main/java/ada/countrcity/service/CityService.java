package ada.countrcity.service;

import ada.countrcity.city.CityDto;
import ada.countrcity.city.PageableCity;
import ada.countrcity.city.TypeSort;

import java.util.List;

public interface CityService {
    CityDto getCityById(Long id);

    CityDto getCityByName(String name);

    void addCity(CityDto dto, Long countryId);

    Boolean checkCityIsMain(String cityName);

    void deleteCityById(Long id);

    CityDto updateCity(CityDto dto, Long id);

    PageableCity pageCity(Integer page, Integer count);

    List<CityDto> sortCity(String value, TypeSort typeSort);


}
