package com.producer.controller;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private static final String QUEUE_NAME = "task_queue";
    private static final String EXCHANGE_NAME = "task_exchange";
    private static final String ROUTING_KEY = "task_routing";

    @Bean
    public Queue taskQueue() {
        return new Queue(QUEUE_NAME, true); // Durable queue
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue taskQueue, DirectExchange exchange) {
        return BindingBuilder.bind(taskQueue).to(exchange).with(ROUTING_KEY);
    }
}
