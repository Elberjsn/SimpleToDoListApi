package dev.elberjsn.todoapi.infrastructure.persistence.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "dev.elberjsn.todoapi.infrastructure.repositories")
@EnableJpaAuditing
@EnableTransactionManagement
public class JpaConfig {
}
