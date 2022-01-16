package com.infoshareacademy.dto;

import com.infoshareacademy.domain.Availability;
import com.infoshareacademy.domain.Location;
import com.infoshareacademy.domain.Rating;
import com.infoshareacademy.domain.ServiceType;

import java.util.List;

public class ServiceProviderDto {
    public static int incrementalID;
    double averageRating;
    private int currentID;
    public String companyName;
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

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public Availability getAvailability() {
        return availability;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }



    public static int getIncrementalID() {
        return incrementalID;
    }

    public static void setIncrementalID(int incrementalID) {
        ServiceProviderDto.incrementalID = incrementalID;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
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
}
