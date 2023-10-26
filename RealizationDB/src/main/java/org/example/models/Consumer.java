package org.example.models;

import lombok.*;

import java.sql.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consumer {
    private Integer id;
    private String consumer_name;
    private String consumer_surname;
    private String consumer_patronymic;
    private Integer money;
    private Integer car_saloon;
    private String date_of_birth;
    private String job;
    private String nationality;
    private String phonenumber;
    private String email;

}
