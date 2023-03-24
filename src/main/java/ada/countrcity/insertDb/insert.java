package ada.countrcity.insertDb;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@RequiredArgsConstructor
@Configuration
public class insert {
    private final JdbcTemplate jdbcTemplate;

    @Bean
    CommandLineRunner inserting( ) {
        return args -> {


            jdbcTemplate.execute("INSERT INTO country (name, president_full_name,people_count)\n" +
                                         "VALUES ( 'Azerbaijan','Ilham Aliyev',10000000)");

            jdbcTemplate.execute("INSERT INTO country (name, president_full_name,people_count)\n" +
                                         "VALUES ( 'Turkey','Recep Tayyip Erdogan',80000000)");

            jdbcTemplate.execute("INSERT INTO country (name, president_full_name,people_count)\n" +
                                         "VALUES ( 'USA','Joe Biden',60000000)");

            //
            jdbcTemplate.execute("INSERT INTO city (name, is_capital_city,country_id)\n" +
                                         "VALUES ( 'Baku','true',1)");

            jdbcTemplate.execute("INSERT INTO city (name, is_capital_city,country_id)\n" +
                                         "VALUES ( 'Ankara','true',2)");

            jdbcTemplate.execute("INSERT INTO city (name, is_capital_city,country_id)\n" +
                                         "VALUES ( 'Istanbul','false',2)");

            jdbcTemplate.execute("INSERT INTO city (name, is_capital_city,country_id)\n" +
                                         "VALUES ( 'Washington','true',3)");
        };
    }
}
