package ada.countrcity.country;

import ada.countrcity.repo.entity.Country;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryMapper {

    public CountryDto entityToDto(Country country) {
        return CountryDto.builder()
                         .name(country.getName())
                         .presidentName(country.getPresidentFullName())
                         .peopleCount(country.getPeopleCount())
                         .build();
    }

    public Country dtoToEntity(CountryDto dto) {
        return Country.builder()
                      .name(dto.getName())
                      .presidentFullName(dto.getPresidentName())
                      .peopleCount(dto.getPeopleCount())
                      .build();
    }

    public List<CountryDto> entitysToDtos(List<Country> countries) {
        var dtoList = countries.stream().map(this::entityToDto).collect(Collectors.toList());
        return dtoList;
    }
}
