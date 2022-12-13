package com.example.emailservice.unit.service.stubs;

import com.example.emailservice.model.CustomerEmailDTO;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailServiceImplStub {
        private String fromEmail = "fromEmail";
        private JavaMailSender mailSender;

        public EmailServiceImplStub(JavaMailSender mailSender) {
            this.mailSender = mailSender;
        }

        public CustomerEmailDTO sendEmail(String to, String subject, String text) {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(fromEmail);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            // this.mailSender.send(message);

            return new CustomerEmailDTO(to, subject, text);
        }
}
