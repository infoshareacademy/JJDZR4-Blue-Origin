package com.infoshareacademy.dto;

import com.infoshareacademy.domain.TypesOfService;
import com.infoshareacademy.domain.Voivodeship;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class ServiceAddProviderDto {
    public static int incrementalID;
    double averageRating;
    private int currentID;
    @NotEmpty(message = "You have to type a company name.")
    private String companyName;
    @NotEmpty(message = "You have to type owner name.")
    private String ownerName;
    @NotEmpty(message = "You have to type a owner surname.")
    private String ownerSurname;
    @NotEmpty(message = "You have to type a phone number.")
    private String phone;
    @NotEmpty(message = "You have to type an email address.")
    private String email;
    private String websiteAddress;
    @NotNull(message = "You have to pick a voivodeship.")
    private Voivodeship voivodeship;
    @NotEmpty(message = "You have to type a city.")
    private String city;
    private int ID;
    @NotEmpty(message = "You have to type a description.")
    private String description;
    @NotEmpty(message = "You have to name your price.")
    private String price;
    @NotNull(message = "You have to pick a type of service.")
    private TypesOfService typesOfService;
    @NotNull(message = "You have to type a date.")
    @Future(message = "You have to type a date from future.")
    private LocalDate availability;
    private boolean isActive;

}
