package ada.countrcity.controller;

import ada.countrcity.city.TypeSort;
import ada.countrcity.country.CountryDto;
import ada.countrcity.country.PageableCountry;
import ada.countrcity.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest-api")
public class CountryController {
    private final CountryService service;


    @GetMapping("/country/{id}")
    public CountryDto getCountryById(@PathVariable Long id) {
        return service.getCountryById(id);
    }

    @GetMapping("/country/max-people-count")
    public CountryDto getMaxPeopleCountCountry( ) {
        return service.getMaxPeopleCountCountry();
    }

    @GetMapping("/country/president")
    public CountryDto getByPresidentName(@RequestParam String name) {
        return service.getByPresidentName(name);
    }

    @PostMapping("/country")
    public void addCountry(@RequestBody CountryDto dto) {
        service.addCountry(dto);
    }

    @PutMapping("/country/update/{id}")
    public void updateCountry(@RequestBody CountryDto dto, @PathVariable Long id) {
        service.updateCountry(dto, id);
    }

    @DeleteMapping("/country/{id}")
    public void deleteCityById(@PathVariable Long id) {
        service.deleteCountryById(id);
    }

    @GetMapping("/country/sort")
    public List<CountryDto> sortCountry(@RequestParam String name,@RequestParam TypeSort typeSort) {
        return service.sortCountry(name,typeSort);
    }

    @GetMapping("/country/page")
    public PageableCountry pageCountry(@RequestHeader Integer page, @RequestHeader Integer count) {
        return service.pageCountry(page, count);
    }
}
