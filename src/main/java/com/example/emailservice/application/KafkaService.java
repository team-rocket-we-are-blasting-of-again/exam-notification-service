package com.example.emailservice.application;

import com.example.emailservice.model.CustomerNotification;
import com.example.emailservice.model.NewCustomerEventDTO;

public interface KafkaService {
    void orderNotification(CustomerNotification customerNotification);
    void customerSignup(NewCustomerEventDTO newCustomerEventDTO);
}
