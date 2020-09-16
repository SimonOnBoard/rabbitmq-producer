package com.itis.javalab.rabbitmq.producer.controllers;

import com.itis.javalab.rabbitmq.producer.services.interfaces.ExchangeSenderService;
import com.itis.javalab.rabbitmq.producer.services.interfaces.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {
    private final ExchangeSenderService exchangeSenderService;
    @GetMapping("/start")
    public ResponseEntity<String> startProducing(){
        exchangeSenderService.sendMessages();
        return ResponseEntity.ok("Done");
    }
}
