package org.example;

import com.github.javafaker.Faker;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.example.models.Consumer;
import org.example.repositories.ConsumerRepository;
import org.example.repositories.ConsumerRepositoryImpl;

import java.sql.Date;

public class Main {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "1234565";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Carsaloon";
    private static final String DB_DRIVER = "org.postgresql.Driver";
    public static void main(String[] args) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(DB_URL);
        hikariConfig.setUsername(DB_USERNAME);
        hikariConfig.setPassword(DB_PASSWORD);
        hikariConfig.setDriverClassName(DB_DRIVER);
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        ConsumerRepository consumerRepository = new ConsumerRepositoryImpl(dataSource);
        for (int i = 0; i < 1000; i++) {
            Faker faker = new Faker();
            Consumer consumer = Consumer.builder()
                    .consumer_name(faker.name().firstName())
                    .consumer_surname(faker.name().lastName())
                    .consumer_patronymic(faker.name().fullName())
                    .money(faker.number().randomDigit())
                    .car_saloon(faker.number().numberBetween(1,5))
                    .date_of_birth(String.valueOf(faker.date().birthday()))
                    .job(faker.job().title())
                    .nationality(faker.nation().nationality())
                    .phonenumber(faker.phoneNumber().phoneNumber())
                    .email(faker.internet().emailAddress())
                    .build();
            consumerRepository.save(consumer);

        }
    }
}