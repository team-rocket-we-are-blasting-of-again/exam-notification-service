package com.example.emailservice.service;

import com.example.emailservice.model.CustomerEmailDTO;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    public CustomerEmailDTO sendEmail(String to,
                                      String subject,
                                      String text);
}
