package com.example.rabbitmqspring.config;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.topic.exchange.name}")
    private String exchange;

    private static final String routingKeyOne = "orange.*";

    private static final String routingKeyTwo = "red.yellow.#";

    // Exchange
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    // Queues
    @Bean
    public Queue queueOne() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue queueTwo() {
        return new AnonymousQueue();
    }

    // Bindings
    @Bean
    public Binding bindingOne() {
        return BindingBuilder.bind(queueOne()).to(exchange()).with(routingKeyOne);
    }

    @Bean
    public Binding bindingTwo() {
        return BindingBuilder.bind(queueTwo()).to(exchange()).with(routingKeyTwo);
    }

    // ao iniciar a aplicação Spring, o Spring chama esses métodos @Bean para criar
    // respectivas instâncias

}
