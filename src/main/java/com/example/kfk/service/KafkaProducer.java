package com.example.kfk.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kfk.model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class KafkaProducer {
    private static final String TOPIC = "kafka-demo";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(Message message) throws JsonProcessingException {
        System.out.println(String.format("Produce message : %s", message));
        this.kafkaTemplate.send(TOPIC, new ObjectMapper().writeValueAsString(message));
    }
}
