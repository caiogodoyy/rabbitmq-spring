package com.example.rabbitmqspring.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = {"#{queueOne.name}"})
    public void consumerOne(String message) {
        logger.info("Message received by Consumer One: " + message);
    }

    @RabbitListener(queues = {"#{queueTwo.name}"})
    public void consumerTwo(String message) {
        logger.info("Message received by Consumer Two: " + message);
    }

}
