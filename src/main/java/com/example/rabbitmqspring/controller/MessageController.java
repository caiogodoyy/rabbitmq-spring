package com.example.rabbitmqspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmqspring.producer.Producer;

@RestController
public class MessageController {

    @Autowired
    private Producer producer;

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message,
            @RequestParam("routingkey") String routingKey) {
        producer.sendMessage(message, routingKey);
        return ResponseEntity.ok("Message sent to RabbitMQ");
    }

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("To send a message, go to http://localhost:8080/send?message=`your_message`&routingkey=`your_routingkey`");
    }

}
