package com.example.emailservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaServiceImpl implements KafkaService {
    private final EmailServiceImpl emailServiceImpl;

    @Override
    @KafkaListener(topics = "ORDER_ACCEPTED", groupId = "order-status")
    public void orderAccepted(String toEmail, String message) throws IOException {
        String subject = "Order being prepared";
        log.info("Consumed event: ORDER_ACCEPTED to email:" + toEmail);
        emailServiceImpl.sendEmail(toEmail, subject, message);
    }

    @Override
    @KafkaListener(topics = "ORDER_PICKED_UP", groupId = "order-status")
    public void orderPickedUp(String toEmail, String message) throws IOException {
        String subject = "Order on the way";
        log.info("Consumed event: ORDER_PICKED_UP to email:" + toEmail);
        emailServiceImpl.sendEmail(toEmail, subject, message);
    }

    @Override
    @KafkaListener(topics = "ORDER_CANCELED", groupId = "order-status")
    public void orderCancelled(String toEmail, String message) throws IOException {
        String subject = "Order cancellation";
        log.info("Consumed event: ORDER_CANCELED to email:" + toEmail);
        emailServiceImpl.sendEmail(toEmail, subject, message);
    }
}
