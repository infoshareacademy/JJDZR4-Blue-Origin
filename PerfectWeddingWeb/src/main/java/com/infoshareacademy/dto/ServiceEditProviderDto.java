package com.infoshareacademy.dto;

import com.infoshareacademy.domain.ServiceType;
import com.infoshareacademy.domain.Voivodeship;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ServiceEditProviderDto {

    private String companyName;
    private String ownerName;
    private String ownerSurname;
    private String phone;
    private String email;
    private String websiteAddress;
    private Voivodeship voivodeship;
    private String city;
    private ServiceType serviceType;
    private LocalDate availability;
    private boolean isActive;


}
