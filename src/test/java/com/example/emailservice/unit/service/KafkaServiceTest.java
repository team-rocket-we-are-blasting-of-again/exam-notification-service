package com.example.emailservice.unit.service;

import com.example.emailservice.model.CustomerNotification;
import com.example.emailservice.model.NewCustomerEventDTO;
import com.example.emailservice.service.EmailServiceImpl;
import com.example.emailservice.application.KafkaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

class KafkaServiceTest {

    private EmailServiceImpl emailServiceMock;
    private KafkaService kafkaService;

    @BeforeEach
    void setup() {
        emailServiceMock = mock(EmailServiceImpl.class);
        kafkaService = new KafkaService(emailServiceMock);
    }

    @Test
    public void orderNotification() {
        String toEmail = "mail";
        String subject = "Order cancellation";
        String message = "Your order has been cancelled.";
        CustomerNotification notification = new CustomerNotification(toEmail, subject, message);

        kafkaService.orderNotification(notification);
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

        kafkaService.customerSignup(dto);
        Mockito.verify(emailServiceMock).sendEmail(dto.getEmail(), subject, message);
        Mockito.verifyNoMoreInteractions(emailServiceMock);
    }
}