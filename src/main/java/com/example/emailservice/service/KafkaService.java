package com.example.emailservice.service;

import com.example.emailservice.model.CustomerNotification;
import com.example.emailservice.model.NewCustomerEventDTO;

public interface KafkaService {
    void orderNotification(CustomerNotification customerNotification);
    void customerSignup(NewCustomerEventDTO newCustomerEventDTO);
}
