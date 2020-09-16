package com.itis.javalab.rabbitmq.producer.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Person {
    private String name;
    private String surname;
    private String patronymic;
    private String passport;
    private Integer age;
    private Date date;
}
