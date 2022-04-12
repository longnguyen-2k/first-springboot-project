package com.example.demo.listener;

import org.springframework.stereotype.Component;

@Component
public class KafkaListener {
    @org.springframework.kafka.annotation.KafkaListener(
            topics = "shin-events",
            groupId = "groupId"
    )
    void listener(String message){
        System.out.println("Listener received "+ message+" :)))))))");
    }
}

