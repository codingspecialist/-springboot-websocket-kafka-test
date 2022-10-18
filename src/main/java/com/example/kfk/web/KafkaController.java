package com.example.kfk.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kfk.model.Message;
import com.example.kfk.service.KafkaProducer;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class KafkaController {
    private final KafkaProducer producer;

    @PostMapping("/kafka")
    public String sendMessage(@RequestParam("message") String message) throws JsonProcessingException {
        System.out.println("나 실행됨");
        this.producer.sendMessage(new Message("ssar", "1", "hello"));

        return "success";
    }
}