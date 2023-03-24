package ada.countrcity.controller;

import ada.countrcity.city.CityDto;
import ada.countrcity.city.PageableCity;
import ada.countrcity.city.TypeSort;
import ada.countrcity.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest-api")
@RequiredArgsConstructor
public class CityController {
    private final CityService service;

    @GetMapping("/city/{id}")
    public CityDto getById(@PathVariable Long id) {
        return service.getCityById(id);
    }

    @GetMapping("/city/check")
    public Boolean checkCityIsMain(@RequestParam String cityName) {
        return service.checkCityIsMain(cityName);
    }

    @PostMapping("/city")
    public void addCity(@RequestBody CityDto dto, @RequestHeader Long countryId) {
        service.addCity(dto, countryId);
    }

    @PutMapping("/city/update/{id}")
    public void updateCity(@RequestBody CityDto dto, @PathVariable Long id) {
        service.updateCity(dto, id);
    }

    @DeleteMapping("/city/{id}")
    public void deleteCityById(@PathVariable Long id) {
        service.deleteCityById(id);
    }

    @GetMapping("/city/sort")
    public List<CityDto> sortCity(@RequestParam String name,@RequestParam TypeSort typeSort ) {
        return service.sortCity(name, typeSort);
    }

    @GetMapping("/city/page")
    public PageableCity pageCity(@RequestHeader Integer page, @RequestHeader Integer count) {
        return service.pageCity(page, count);
    }

    @GetMapping("/city")
    public CityDto getCityByName(@RequestParam String cityName) {
        return service.getCityByName(cityName);
    }
}
