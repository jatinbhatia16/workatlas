package in.workatlas.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayRepairConfig {

    @Bean
    public Runnable flywayRepair(Flyway flyway) {
        return () -> flyway.repair();
    }
}

