package com.example.kfk.service;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import com.example.kfk.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class KafkaConsumer {
    private final SimpMessageSendingOperations sms;

    @KafkaListener(topics = "kafka-demo", groupId = "kafka-demo")
    public void consume(String messageJson) throws IOException {
        System.out.println(String.format("Consumed message : %s", messageJson));
        Message message = new ObjectMapper().readValue(messageJson, Message.class);
        sms.convertAndSend("/sub/channel/" + message.getChannelId(), message);
    }
}
