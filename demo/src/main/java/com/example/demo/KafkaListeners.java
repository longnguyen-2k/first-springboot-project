package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(
            topics = "shin-events",
            groupId = "groupId"
    )
    void listener(String message){
        System.out.println("Listener received "+ message+" :)))))))");
    }
}

