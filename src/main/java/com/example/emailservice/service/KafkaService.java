package com.example.emailservice.service;

import java.io.IOException;

public interface KafkaService {
    void orderAccepted(String topic, String message) throws IOException;
    void orderPickedUp(String topic, String message) throws IOException;
    void orderCancelled(String topic, String message) throws IOException;
}
