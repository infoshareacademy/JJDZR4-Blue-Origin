package com.infoshareacademy.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.infoshareacademy.domain.Availability;
import com.infoshareacademy.domain.Location;
import com.infoshareacademy.domain.Rating;
import com.infoshareacademy.domain.ServiceType;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Repository
public class ServiceProviderOldRepo {
    public static int incrementalID;
    double averageRating;
//    @JsonProperty(value = "currentID")
    private int currentID;
    public String companyName;
    private String ownerName;
    private String ownerSurname;
    private String phone;
    private String email;
    private String websiteAddress;
    private Location location;
    private ServiceType serviceType;
    private Availability availability;
    private boolean isActive;
    private List<Rating> ratingList;


    public ServiceProviderOldRepo() {
//        ratingList = new ArrayList<>();
        incrementalID++;
        currentID = incrementalID;
    }

    public int getCurrentID() {
        return currentID;
    }

    public void setCurrentID(int currentID) {
        this.currentID = currentID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsiteAddress() {
        return websiteAddress;
    }

    public void setWebsiteAddress(String websiteAddress) {
        this.websiteAddress = websiteAddress;
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    @Override
    public String toString() {
        return "ServiceProvider{" +
                "ID=" + currentID +
                ", companyName='" + companyName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerSurname='" + ownerSurname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", websiteAddress='" + websiteAddress + '\'' +
//                ", location=" + location.getCity() + '\'' +
//                ", serviceType=" + serviceType.getTypesOfService() + '\'' +
//                ", availability=\n" + availability + '\n' +
//                ", rating=\n" + ratingList + '\n' +
                ", isActive=" + isActive +
                "}\n";
    }


    public String toStringVertical() {
        return
                "\n ID: " + currentID
                        + "\n companyName: " + companyName
                        + "\n ownerName: " + ownerName
                        + "\n ownerSurname: " + ownerSurname
                        + "\n phone: " + phone
                        + "\n email: " + email
                        + "\n websiteAddress: " + websiteAddress
//                        + "\n   voivodeship: " + location.getVoivodeship()
//                        + "\n   locality: " + location.getCity()
//                        + "\n   name: " + serviceType.getTypesOfService()
//                        + "\n   description: " + serviceType.getDescription()
//                        + "\n   price: " + serviceType.getPrice()
//                        + "\n availability: " + availability
//                        + "\n rating: " + ratingList
                        + "\n isActive: " + isActive
                        + "\n";

    }
}
