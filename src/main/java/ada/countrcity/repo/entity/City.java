package ada.countrcity.repo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "city")
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Boolean isCapitalCity;


    @ManyToOne()
    @JoinColumn(name = "country_id")
    private Country country;

    @Override
    public String toString( ) {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isCapitalCity=" + isCapitalCity +
                ", country=" + country +
                '}';
    }
}
