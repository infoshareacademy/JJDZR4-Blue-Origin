package com.infoshareacademy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"ID", "companyName", "ownerName", "ownerSurname", "phone",
        "email", "websiteAddress", "location", "serviceType", "availability", "isActive", "ratingList"
        , "averageRating"})
public class ServiceProvider {
    public static int incrementalID;
    double averageRating;
    @JsonProperty(value = "currentID")
    private int currentID;
    private String companyName;
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


    public ServiceProvider() {
        ratingList = new ArrayList<>();
        incrementalID++;
        currentID = incrementalID;
    }

    public int getCurrentID() {
        return currentID;
    }

    public void setCurrentID(int currentID) {
        this.currentID = currentID;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public double getAverageRating() {
        double sum = 0;
        for (Rating rating : ratingList) {
            sum += rating.getRating();
        }
        if (ratingList.size() > 0) {
            return sum / ratingList.size();
        } else {
            return -1.0; //returns -1 if no rating has been done so far
        }
    }

    public void addRating(int rating, String comment) {
        ratingList.add(new Rating(rating, comment));
    }

    public void addRating(int rating) {
        ratingList.add(new Rating(rating));
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
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
                ", location=" + location.getLocality() + '\'' +
                ", serviceType=" + serviceType.getName() + '\'' +
                ", availability=\n" + availability + '\n' +
                ", rating=\n" + ratingList + '\n' +
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
                        + "\n   voivodeship: " + location.getVoivodeship()
                        + "\n   locality: " + location.getLocality()
                        + "\n   name: " + serviceType.getName()
                        + "\n   description: " + serviceType.getDescription()
                        + "\n   price: " + serviceType.getPrice()
                        + "availability: " + availability
                        + "\n rating: " + ratingList
                        + "\n isActive: " + isActive
                        + "\n";

    }
}
