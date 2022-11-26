package com.example.emailservice.unit.service;

import com.example.emailservice.model.CustomerEmailDTO;
import com.example.emailservice.service.EmailService;
import com.example.emailservice.service.EmailServiceImpl;
import com.example.emailservice.unit.service.stubs.EmailServiceImplStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("unit")
class EmailServiceImplTest {

    private JavaMailSender mailSenderMock;
    private EmailServiceImplStub emailService;

    @BeforeEach
    public void setup() {
       mailSenderMock = mock(JavaMailSender.class);
       emailService = new EmailServiceImplStub(mailSenderMock);
    }

    @Test
    void sendEmail() {
        String toEmail = "mail";
        String subject = "subject";
        String message = "message";

        CustomerEmailDTO dto = emailService.sendEmail(toEmail, subject, message);
        assertEquals(toEmail, dto.getToEmail());
        assertEquals(subject, dto.getSubject());
        assertEquals(message, dto.getText());
    }
}