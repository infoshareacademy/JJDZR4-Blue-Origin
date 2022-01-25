package com.infoshareacademy.dto;

import com.infoshareacademy.domain.TypesOfService;
import com.infoshareacademy.domain.Voivodeship;
import com.infoshareacademy.repository.ServiceProviderRepo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

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
    private LocalDate availability;
    private boolean isActive;

    public int getCurrentID() {
        ServiceProviderRepo serviceProviderRepo = new ServiceProviderRepo();
        int count = serviceProviderRepo.getServiceProvidersList().size();
        return currentID = serviceProviderRepo.getServiceProvidersList()
                .stream().skip(count - 1).findFirst().get().getCurrentID() + 1;
    }
}
