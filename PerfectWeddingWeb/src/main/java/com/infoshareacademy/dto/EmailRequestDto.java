package com.infoshareacademy.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EmailRequestDto {
    String queryMessage;
    String clientPhone;
    String clientEmail;
    String providerEmail;
}
