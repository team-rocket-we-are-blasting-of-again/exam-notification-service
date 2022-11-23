package com.example.emailservice.controller;

import com.example.emailservice.model.CustomerEmailDTO;
import com.example.emailservice.service.EmailSenderService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/emails")
public class EmailResource {
    private final EmailSenderService emailSenderService;

    public EmailResource(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/test/message")
    public String testEmail() {
        // Insert mail you want to send the message too
        this.emailSenderService.sendSimpleEmail(
                "",
                "Hej Mathias (exam project test)!",
                "Der er hul igennem."
        );
        return "Test message has been sent.";
    }

    @PostMapping("/message")
    public CustomerEmailDTO responseEmail(@RequestBody CustomerEmailDTO customerEmailDTO) {
        return emailSenderService.sendEmail(customerEmailDTO.getToEmail(), customerEmailDTO.getSubject(), customerEmailDTO.getText());
    }
}
