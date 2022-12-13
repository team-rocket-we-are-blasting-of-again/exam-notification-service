package com.example.emailservice.service;

import com.example.emailservice.model.CustomerEmailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public CustomerEmailDTO sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        this.mailSender.send(message);

        return new CustomerEmailDTO(to, subject, text);
    }
}


