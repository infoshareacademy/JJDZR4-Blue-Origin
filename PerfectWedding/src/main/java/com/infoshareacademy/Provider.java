package com.infoshareacademy;

public class Provider {
    private String companyName;
    private String ownerName;
    private String ownerSurname;
    private String companyPhone;
    private String companyEmail;
    private String companyWebsite;
    private String companyLocation;
    private ServiceType serviceType;
    private String availabilityStartDate;
    private String availabilityEndDate;
    private double rating;
    private boolean isActive;

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

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getAvailabilityStartDate() {
        return availabilityStartDate;
    }

    public void setAvailabilityStartDate(String availabilityStartDate) {
        this.availabilityStartDate = availabilityStartDate;
    }

    public String getAvailabilityEndDate() {
        return availabilityEndDate;
    }

    public void setAvailabilityEndDate(String availabilityEndDate) {
        this.availabilityEndDate = availabilityEndDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
