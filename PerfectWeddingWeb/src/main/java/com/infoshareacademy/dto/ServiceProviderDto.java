package com.infoshareacademy.dto;

import com.infoshareacademy.domain.Availability;
import com.infoshareacademy.domain.Location;
import com.infoshareacademy.domain.Rating;
import com.infoshareacademy.domain.ServiceType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ServiceProviderDto {
    public static int incrementalID;
    double averageRating;
    private int currentID;
    private String companyName;
    private String ownerName;
    private String ownerSurname;
    private String phone;
    private String email;
    private String websiteAddress;
    private Location location;
    private ServiceType serviceType;
    private List<Rating> ratingList;
    private Availability availability;
    private boolean isActive;

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

}
