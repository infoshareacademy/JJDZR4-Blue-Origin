package com.infoshareacademy.dto;

import com.infoshareacademy.domain.Availability;
import com.infoshareacademy.domain.ServiceType;
import com.infoshareacademy.domain.TypesOfService;
import com.infoshareacademy.domain.Voivodeship;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceAddProviderDto {
    public static int incrementalID;
    double averageRating;
    private int currentID;
    private String companyName;
    private String ownerName;
    private String ownerSurname;
    private String phone;
    private String email;
    private String websiteAddress;
    private Voivodeship voivodeship;
    private String city;
    private int ID;
    private String description;
    private String price;
    private TypesOfService typesOfService;
    private Availability availability;
    private boolean isActive;
    private ServiceType serviceType;

}
