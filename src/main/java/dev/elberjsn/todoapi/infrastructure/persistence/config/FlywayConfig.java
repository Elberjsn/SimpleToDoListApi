package dev.elberjsn.todoapi.infrastructure.persistence.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    @Bean
    @Profile("!test")
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return flyway -> {
            flyway.clean();
            flyway.migrate();
        };
    }
    @Bean
    @Profile("test")
    public FlywayMigrationStrategy flywayMigrationStrategyTest() {
        return flyway -> {
            flyway.clean();
            flyway.migrate();
        };
    }
    @Bean
    public Flyway flyway(DataSource dataSource) {
        return Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .outOfOrder(false)
                .validateOnMigrate(true)
                .load();
    }
}
