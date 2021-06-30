package com.luck.conference.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    @Value("${spring.datasource.url}")
    private String DB_URL;

    @Value("${spring.datasource.password}")
    private String DB_PASSWORD;

    @Value("${spring.datasource.username}")
    private String DB_USERNAME;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        System.out.println("Initialization of datasource: " + DB_URL);
        return builder.url(DB_URL)
                .username(DB_USERNAME)
                .password(DB_PASSWORD)
                .build();
    }
}
