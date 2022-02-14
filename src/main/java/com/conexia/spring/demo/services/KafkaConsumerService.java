package com.conexia.spring.demo.services;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

@Service
public class KafkaConsumerService {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "demo-topic", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message)
    {
        logger.info(String.format("Message recieved -> %s", message));
    }
}
