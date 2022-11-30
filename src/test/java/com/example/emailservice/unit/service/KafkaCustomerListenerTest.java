package com.example.emailservice.unit.service;

import com.example.emailservice.model.CustomerNotification;
import com.example.emailservice.model.NewCustomerEventDTO;
import com.example.emailservice.service.EmailServiceImpl;
import com.example.emailservice.application.KafkaCustomerListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

class KafkaCustomerListenerTest {

    private EmailServiceImpl emailServiceMock;
    private KafkaCustomerListener kafkaCustomerListener;

    @BeforeEach
    void setup() {
        emailServiceMock = mock(EmailServiceImpl.class);
        kafkaCustomerListener = new KafkaCustomerListener(emailServiceMock);
    }

    @Test
    public void orderNotification() {
        String toEmail = "mail";
        String subject = "Order cancellation";
        String message = "Your order has been cancelled.";
        CustomerNotification notification = new CustomerNotification(toEmail, subject, message);

        kafkaCustomerListener.orderNotification(notification);
        Mockito.verify(emailServiceMock).sendEmail(toEmail, subject, message);
        Mockito.verifyNoMoreInteractions(emailServiceMock);
    }

    @Test
    public void customerSignup(){
        String subject = "Signup";
        String message = "Thank you Bob The Builder for registering at MTOGO.";
        NewCustomerEventDTO dto =
                new NewCustomerEventDTO("Bob", "The Builder",
                        "email", 1, "88888888");

        kafkaCustomerListener.customerSignup(dto);
        Mockito.verify(emailServiceMock).sendEmail(dto.getEmail(), subject, message);
        Mockito.verifyNoMoreInteractions(emailServiceMock);
    }
}