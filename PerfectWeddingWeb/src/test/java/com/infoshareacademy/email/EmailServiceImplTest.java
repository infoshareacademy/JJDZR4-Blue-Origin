package com.infoshareacademy.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmailServiceImplTest {


    @Autowired
    public EmailServiceImplTest(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    private EmailServiceImpl emailService;

    @Test
    void sendMessage() {
        emailService.sendMessage("test", "test", "test");
    }
}