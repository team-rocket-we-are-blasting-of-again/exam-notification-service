package com.example.emailservice.service;

import java.io.IOException;

public interface KafkaService {
    void orderAccepted(String email) throws IOException;
    void orderPickedUp(String email) throws IOException;
    void orderCancelled(String email) throws IOException;
    void customerSignup(String email) throws IOException;
}
