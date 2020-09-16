package com.itis.javalab.rabbitmq.producer.services.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itis.javalab.rabbitmq.producer.models.Person;
import com.itis.javalab.rabbitmq.producer.services.interfaces.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

    private final ObjectMapper objectMapper;
    private final BufferedReader bufferedReader;
    private final DateFormat dateFormat;

    @Override
    public String getDataToConsumeJsonFormat() {
        try {

            System.out.println("Enter name");
            String name = bufferedReader.readLine();
            System.out.println("Enter surname");
            String surname = bufferedReader.readLine();
            System.out.println("Enter patronymic");
            String patronymic = bufferedReader.readLine();
            System.out.println("Enter age");
            Integer age = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Enter passport");
            String passport = bufferedReader.readLine();
            System.out.println("Enter date in dd.mm.yyyy format");

            Date date = new Date(dateFormat.parse(bufferedReader.readLine()).getTime());
            Person person = Person.builder()
                    .name(name).surname(surname)
                    .age(age).passport(passport)
                    .date(date).patronymic(patronymic)
                    .build();
            return objectMapper.writeValueAsString(person);
        } catch (IOException | ParseException e) {
            throw new IllegalStateException(e);
        }
    }
}
