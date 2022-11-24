package com.example.emailservice.controller;

import com.example.emailservice.model.CustomerEmailDTO;
import com.example.emailservice.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/emails")
public class EmailResource {

    private final EmailServiceImpl emailServiceImpl;

    public EmailResource(EmailServiceImpl emailServiceImpl) {
        this.emailServiceImpl = emailServiceImpl;
    }

    @PostMapping("/test/message")
    public CustomerEmailDTO testEmail() {
        return this.emailServiceImpl.sendEmail(
                "",
                "Hej du (exam project test)!",
                "Der er hul igennem."
        );
    }
}
