package com.s36.apirest.backend.DB;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataBase {

    @Bean
    public DataSource dataBaseConnection() {
        return DataSourceBuilder.create()
                .url(System.getenv("DB_URL"))
                .username(System.getenv("DB_USERNAME"))
                .password(System.getenv("DB_PASSWORD"))
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}