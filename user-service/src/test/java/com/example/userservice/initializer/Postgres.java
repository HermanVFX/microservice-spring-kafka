package com.example.userservice.initializer;

import lombok.experimental.UtilityClass;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@UtilityClass
public class Postgres {

    public static final PostgreSQLContainer<?> container =
            new PostgreSQLContainer<>(
                    DockerImageName.parse("postgres:15.1")
                            .asCompatibleSubstituteFor("postgres")
            )
                    .withDatabaseName("postgres")
                    .withUsername("postgres_user")
                    .withPassword("172440");

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + container.getJdbcUrl(),
                    "spring.datasource.username=" + container.getUsername(),
                    "spring.datasource.password=" + container.getPassword()
            ).applyTo(applicationContext);
        }
    }
}
