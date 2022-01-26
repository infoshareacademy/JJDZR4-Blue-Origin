package com.infoshareacademy.dto;

import com.infoshareacademy.domain.TypesOfService;
import com.infoshareacademy.domain.Voivodeship;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ServiceProviderSearchDto {
    private Voivodeship voivodeship;
    private String city;

    private String description;
    private String price;
    private TypesOfService typesOfService;

}
