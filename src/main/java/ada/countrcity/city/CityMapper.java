package ada.countrcity.city;

import ada.countrcity.repo.entity.City;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityMapper {

    public CityDto entityToDto(City city) {
        return CityDto.builder()
                      .isCapitalCity(city.getIsCapitalCity())
                      .name(city.getName()).build();
    }

    public City dtoToEntity(CityDto dto) {
        return City.builder()
                   .isCapitalCity(dto.getIsCapitalCity())
                   .name(dto.getName()).build();
    }

    public List<CityDto> entitysToDtos(List<City> cities) {
        var dtoList = cities.stream().map(this::entityToDto).collect(Collectors.toList());
        return dtoList;
    }
}
