package com.example.rabbitmqspring.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.topic.exchange.name}")
    private String exchange;

    public void sendMessage(String message, String routingKey) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        logger.info("Message sent: " + message);
    }

}
