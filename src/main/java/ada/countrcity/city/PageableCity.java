package ada.countrcity.city;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PageableCity {
    public List<CityDto> dtoList;
    public Integer pageCount;
    public Boolean hasNextPage;
}
