package ada.countrcity.service;

import ada.countrcity.city.CityDto;
import ada.countrcity.city.TypeSort;
import ada.countrcity.country.CountryDto;
import ada.countrcity.country.CountryMapper;
import ada.countrcity.country.PageableCountry;
import ada.countrcity.repo.entity.City;
import ada.countrcity.repo.entity.Country;
import ada.countrcity.repo.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImp implements CountryService {
    private final CountryRepository repository;
    private final CountryMapper mapper;

    @Override
    public CountryDto getCountryById(Long id) {
        Country country = repository.findById(id)
                                    .orElseThrow(( ) -> new RuntimeException("Country id not found"));
        CountryDto response = mapper.entityToDto(country);
        return response;
    }

    @Override
    public void addCountry(CountryDto dto) {
        Country mapEntity = mapper.dtoToEntity(dto);
        repository.save(mapEntity);
    }

    @Override
    public CountryDto getByPresidentName(String name) {
        Country country = repository.getCountryByPresidentName(name);
        return mapper.entityToDto(country);
    }

    @Override
    public CountryDto getMaxPeopleCountCountry( ) {
        Country country = repository.getMaxPeopleCountCountry();
        return mapper.entityToDto(country);
    }

    @Override
    public void deleteCountryById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CountryDto updateCountry(CountryDto dto, Long id) {
        Country city = repository.findById(id)
                                 .orElseThrow(( ) -> new RuntimeException("Country id not found"));
        var setCountry = setCountry(dto, city);
        CountryDto countryDto = mapper.entityToDto(setCountry);
        return countryDto;
    }

    @Override
    public PageableCountry pageCountry(Integer page, Integer count) {
        var countries = repository.findAll(PageRequest.of(page, count));
        PageableCountry pageableCountry = PageableCountry.builder()
                                                         .hasNextPage(countries.hasNext())
                                                         .pageCount(countries.getTotalPages())
                                                         .dtoList(mapper.entitysToDtos(countries.getContent()))
                                                         .build();
        return pageableCountry;
    }

    @Override
    public List<CountryDto> sortCountry(String value, TypeSort typeSort) {
        List<Country> countries = new LinkedList<>();
        if (typeSort == TypeSort.UP) {
            countries = repository.findAll(Sort.by(Sort.Direction.DESC, value));
        } else countries = repository.findAll(Sort.by(Sort.Direction.ASC, value));

        List<CountryDto> dtoList = mapper.entitysToDtos(countries);
        return dtoList;
    }


    private Country setCountry(CountryDto dto, Country country) {
        country.setName(dto.getName());
        country.setPresidentFullName(dto.getPresidentName());
        country.setPeopleCount(dto.getPeopleCount());
        repository.save(country);
        return country;
    }
}
