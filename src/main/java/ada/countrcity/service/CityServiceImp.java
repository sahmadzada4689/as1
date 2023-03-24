package ada.countrcity.service;

import ada.countrcity.city.CityDto;
import ada.countrcity.city.CityMapper;
import ada.countrcity.city.PageableCity;
import ada.countrcity.city.TypeSort;
import ada.countrcity.repo.entity.City;
import ada.countrcity.repo.entity.Country;
import ada.countrcity.repo.repository.CityRepository;
import ada.countrcity.repo.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImp implements CityService {
    private final CityRepository repository;
    private final CityMapper mapper;
    private final CountryRepository countryRepository;

    @Override
    public CityDto getCityById(Long id) {
        City city = repository.findById(id)
                              .orElseThrow(( ) -> new RuntimeException("City id not found"));
        CityDto response = mapper.entityToDto(city);
        return response;
    }

    @Override
    public CityDto getCityByName(String name) {
        City city = repository.findByName(name)
                              .orElseThrow(( ) -> new RuntimeException("City id not found"));
        var response = mapper.entityToDto(city);
        return response;
    }

    @Override
    public void addCity(CityDto dto, Long countryId) {
        var checkCapital = repository.findAll().stream().filter(City::getIsCapitalCity).count();
        if (checkCapital > 0) {
            throw new RuntimeException("Country already have capital city");
        }
        City mapEntity = mapper.dtoToEntity(dto);
        Country country = countryRepository.findById(countryId)
                                           .orElseThrow(( ) -> new RuntimeException("Country id not found"));
        mapEntity.setCountry(country);
        repository.save(mapEntity);
    }

    @Override
    public Boolean checkCityIsMain(String cityName) {
        var existCity = repository.checkNameIsMain(cityName);
        return existCity;
    }

    @Override
    public void deleteCityById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CityDto updateCity(CityDto dto, Long id) {
        City city = repository.findById(id)
                              .orElseThrow(( ) -> new RuntimeException("City id not found"));
        var setCity = setCity(dto, city);
        CityDto cityDto = mapper.entityToDto(setCity);
        return cityDto;
    }

    @Override
    public PageableCity pageCity(Integer page, Integer count) {
        var city = repository.findAll(PageRequest.of(page, count));
        PageableCity pageableCity = PageableCity.builder()
                                                .hasNextPage(city.hasNext())
                                                .pageCount(city.getTotalPages())
                                                .dtoList(mapper.entitysToDtos(city.getContent()))
                                                .build();
        return pageableCity;
    }

    @Override
    public List<CityDto> sortCity(String value, TypeSort typeSort) {
        List<City> city = new LinkedList<>();
        if (typeSort == TypeSort.UP) {
            city = repository.findAll(Sort.by(Sort.Direction.DESC, value));
        } else city = repository.findAll(Sort.by(Sort.Direction.ASC, value));

        List<CityDto> dtoList = mapper.entitysToDtos(city);
        return dtoList;
    }


    private City setCity(CityDto dto, City city) {
        city.setIsCapitalCity(dto.getIsCapitalCity());
        city.setName(dto.getName());
        repository.save(city);
        return city;
    }
}
