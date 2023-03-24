package ada.countrcity.repo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "country")
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String presidentFullName;
    private BigDecimal peopleCount;

    @OneToMany(mappedBy = "country", orphanRemoval = true)
    private List<City> cities;
}
