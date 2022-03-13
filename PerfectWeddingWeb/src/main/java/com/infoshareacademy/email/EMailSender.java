package com.infoshareacademy.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class EMailSender {

    @Value("${spring.mail.host}")
    private String SPRING_MAIL_HOST;
    @Value("${spring.mail.port}")
    private int SPRING_MAIL_PORT;
    @Value("${spring.mail.username}")
    private String SPRING_MAIL_USERNAME;
    @Value("${spring.mail.password}")
    private String SPRING_MAIL_PASSWORD;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(SPRING_MAIL_HOST);
        mailSender.setPort(SPRING_MAIL_PORT);
        mailSender.setUsername(SPRING_MAIL_USERNAME);
        mailSender.setPassword(SPRING_MAIL_PASSWORD);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
