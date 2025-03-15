package com.producer.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;
    private static final String EXCHANGE_NAME = "task_exchange";
    private static final String ROUTING_KEY = "task_routing";
    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);
        System.out.println("Sent message: " + message);
    }
}
