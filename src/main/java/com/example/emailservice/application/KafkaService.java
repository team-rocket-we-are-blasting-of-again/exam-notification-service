package com.example.emailservice.application;

import com.example.emailservice.model.CustomerEmailDTO;
import com.example.emailservice.model.CustomerNotification;
import com.example.emailservice.model.NewCustomerEventDTO;
import com.example.emailservice.service.EmailServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {
    private final EmailServiceImpl emailServiceImpl;

    @KafkaListener(topics = "CUSTOMER_NOTIFICATION", groupId = "order-manager")
    public void orderNotification(@Payload CustomerNotification customerNotification) {
        log.info("Consumed event: CUSTOMER_NOTIFICATION to email:" + customerNotification.getEmail());
        try {
            CustomerEmailDTO returnVal = emailServiceImpl.sendEmail(customerNotification.getEmail(),
                    customerNotification.getSubject(), customerNotification.getMessage());
            log.info("Email successfully sent to " + returnVal + " with subject: " + customerNotification.getSubject());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @KafkaListener(topics = "NEW_CUSTOMER", groupId = "order-manager")
    public void customerSignup(@Payload NewCustomerEventDTO newCustomerEventDTO) {
        String subject = "Signup";
        String message = "Thank you " +
                newCustomerEventDTO.getFirstName() + " " +
                newCustomerEventDTO.getLastName() +
                " for registering at MTOGO.";
        log.info("Consumed event: NEW_CUSTOMER to email:" + newCustomerEventDTO.getEmail());
        emailServiceImpl.sendEmail(newCustomerEventDTO.getEmail(), subject, message);
    }
}
