package com.example.emailservice.service;

import com.example.emailservice.model.CustomerEmailDTO;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class EmailSenderService implements EmailService {

    // Interface of a Java mail sender class
    private final JavaMailSender mailSender;

    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    // For testing or string made mail (request)
    public void sendSimpleEmail(String to,
                                String subject,
                                String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        // Insert the sender email
        message.setFrom("");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        this.mailSender.send(message);
    }

    // For UserComplaint response
    public CustomerEmailDTO sendEmail(String to,
                                      String subject,
                                      String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        // Insert the sender email
        message.setFrom("");
        // Our make believe customer mail for receiving complaints
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        this.mailSender.send(message);

        // Here we need to pass the customer email which needs the notification
        sendNotification(message);

        // Could return Date from here
        return new CustomerEmailDTO(to, subject, text);
    }

    // Auto generated notification
    public void sendNotification(SimpleMailMessage message) {
        // Here we need to either make a new mail to have a fully proof of concept or leave it as it is for now
        String subject = "Request has been received";
        String text = "Dear customer, thank you for your mail. \n" +
                "We have received your request and will start working on it immediately";
        // Insert the sender email
        message.setFrom("");
        message.setTo(Objects.requireNonNull(message.getTo()));
        message.setSubject(subject);
        message.setText(text);
        this.mailSender.send(message);
        System.out.println("Notification has been send to customer");
    }
}


