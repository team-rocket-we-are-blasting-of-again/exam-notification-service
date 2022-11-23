package com.example.emailservice.service;

import com.example.emailservice.model.CustomerEmailDTO;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    public void sendSimpleEmail(String to,
                                String subject,
                                String text);

    public CustomerEmailDTO sendEmail(String to,
                                      String subject,
                                      String text);

    public void sendNotification(SimpleMailMessage message);
}
