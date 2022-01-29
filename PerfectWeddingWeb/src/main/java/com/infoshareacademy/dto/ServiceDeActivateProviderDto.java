package com.infoshareacademy.dto;

import com.infoshareacademy.domain.TypesOfService;
import com.infoshareacademy.domain.Voivodeship;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ServiceDeActivateProviderDto {

    private int id;
    private boolean isActive = false;


}
