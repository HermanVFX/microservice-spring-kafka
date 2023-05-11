package com.example.userservice;

import com.example.userservice.initializer.Postgres;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.wait.strategy.LogMessageWaitStrategy;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
@ContextConfiguration(initializers = {
        Postgres.Initializer.class
})
public abstract class IntegrationTestBase {

    @BeforeAll
    static void init() {
        Postgres.container.setWaitStrategy(
                new LogMessageWaitStrategy()
                        .withRegEx(".*database system is ready to accept connections.*\\s")
                        .withTimes(1)
                        .withStartupTimeout(Duration.of(60, ChronoUnit.SECONDS))
        );
        Postgres.container.start();
    }

    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.datasource.url", Postgres.container::getJdbcUrl);
        dynamicPropertyRegistry.add("spring.datasource.username", Postgres.container::getUsername);
        dynamicPropertyRegistry.add("spring.datasource.password", Postgres.container::getPassword);
        dynamicPropertyRegistry.add("spring.datasource.driver-class-name", Postgres.container::getDriverClassName);
    }
}
