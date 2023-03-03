package com.example.springboot.controllers;

import com.example.springboot.domain.User;
import com.example.springboot.services.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaProducerController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    private Producer kafkaProducer;

    public KafkaProducerController(Producer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/produce/{topic}/{total}")
    public ResponseEntity<String> insertUsersInKafka(@PathVariable Integer total,@PathVariable String topic){
        logger.info("Se van a escribir: " + Integer.toString(total) + " en el topic " + topic );
        kafkaProducer.sendMessage(topic,"hola");
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}
