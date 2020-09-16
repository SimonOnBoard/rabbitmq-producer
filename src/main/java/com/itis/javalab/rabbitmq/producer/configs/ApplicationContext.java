package com.itis.javalab.rabbitmq.producer.configs;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

@Configuration
@RequiredArgsConstructor
public class ApplicationContext {
    private final Environment environment;

    @Bean
    public String  exchangeName(){
        return environment.getProperty("exchange.name");
    }

    @Bean
    public String exchangeType(){
        return environment.getProperty("exchange.type");
    }

    @Bean
    public ConnectionFactory connectionFactory(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        return connectionFactory;
    }

    @Bean
    public BufferedReader scanner(){
        return new BufferedReader(new InputStreamReader(System.in));
    }

    @Bean
    public DateFormat dateFormat(){
        return new SimpleDateFormat("dd.MM.yyyy");
    }

}
