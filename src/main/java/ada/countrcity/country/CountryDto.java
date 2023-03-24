package ada.countrcity.country;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CountryDto {
    private String name;
    private String presidentName;
    private BigDecimal peopleCount;
}
