package com.infoshareacademy.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ServiceSearchProviderDto {

    private String city;
    private String serviceType;
    private LocalDate date;

}
