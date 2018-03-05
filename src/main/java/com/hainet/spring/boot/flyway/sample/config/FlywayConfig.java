package com.hainet.spring.boot.flyway.sample.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class FlywayConfig {

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        final FlywayMigrationStrategy strategy = flyway -> {
            flyway.clean();
            flyway.migrate();
        };

        return strategy;
    }
}
