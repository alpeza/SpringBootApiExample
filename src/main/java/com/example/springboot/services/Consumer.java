package com.example.springboot.services;

import com.example.springboot.controllers.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @KafkaListener(topics = "users")
    public void consume(String message) throws IOException {
        logger.info("Se ha consumido el mensaje: " + message);
    }
}