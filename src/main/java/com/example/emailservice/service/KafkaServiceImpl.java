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
    public void orderAccepted(String toEmail) throws IOException {
        String subject = "Order being prepared";
        String message = "Your order has been accepted and is being prepared.";
        log.info("Consumed event: ORDER_ACCEPTED to email:" + toEmail);
        emailServiceImpl.sendEmail(toEmail, subject, message);
    }

    @Override
    @KafkaListener(topics = "ORDER_PICKED_UP", groupId = "order-status")
    public void orderPickedUp(String toEmail) throws IOException {
        String subject = "Order on the way";
        String message = "Your order is being delivered to your address.";
        log.info("Consumed event: ORDER_PICKED_UP to email:" + toEmail);
        emailServiceImpl.sendEmail(toEmail, subject, message);
    }

    @Override
    @KafkaListener(topics = "ORDER_CANCELED", groupId = "order-status")
    public void orderCancelled(String toEmail) throws IOException {
        String subject = "Order cancellation";
        String message = "Your order has been cancelled.";
        log.info("Consumed event: ORDER_CANCELED to email:" + toEmail);
        emailServiceImpl.sendEmail(toEmail, subject, message);
    }

    @Override
    @KafkaListener(topics = "NEW_CUSTOMER", groupId = "customer-status")
    public void customerSignup(String toEmail) throws IOException {
        String subject = "Signup";
        String message = "You have successfully been registered.";
        log.info("Consumed event: NEW_CUSTOMER to email:" + toEmail);
        emailServiceImpl.sendEmail(toEmail, subject, message);
    }
}
