package com.itis.javalab.rabbitmq.producer.services.implementations;

import com.itis.javalab.rabbitmq.producer.services.interfaces.ExchangeSenderService;
import com.itis.javalab.rabbitmq.producer.services.interfaces.ProducerService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
@RequiredArgsConstructor
public class ExchangeSenderServiceImpl implements ExchangeSenderService {
    private final ConnectionFactory connectionFactory;
    private final String exchangeName;
    private final String exchangeType;
    private final ProducerService producerService;
    private Connection connection;
    @PostConstruct
    public void setNewConnection(){
        try {
            connection = connectionFactory.newConnection();
        } catch (IOException | TimeoutException e) {
            throw new IllegalArgumentException(e);        }
    }
    @Override
    public void sendMessages() {
        try {
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(exchangeName, exchangeType);
            for(int i = 0; i < 10; i++){
                channel.basicPublish(exchangeName, "",null, producerService.getDataToConsumeJsonFormat().getBytes());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
