package ada.countrcity.country;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PageableCountry {
    public List<CountryDto> dtoList;
    public Integer pageCount;
    public Boolean hasNextPage;
}
