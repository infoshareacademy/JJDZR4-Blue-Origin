package com.infoshareacademy.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@RequiredArgsConstructor
public class EmailRequestDto {
    @NotEmpty(message = "You have to type a message.")
    String queryMessage;
    String clientPhone;
    @NotEmpty(message = "You have to type your email address.")
    String clientEmail;
    String providerEmail;
    Integer providerID;
}
