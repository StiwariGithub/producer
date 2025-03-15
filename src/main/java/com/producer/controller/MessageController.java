package com.producer.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final RabbitMQProducer producer;

    public MessageController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        producer.sendMessage(message);
        return "Message sent: " + message;
    }
}
