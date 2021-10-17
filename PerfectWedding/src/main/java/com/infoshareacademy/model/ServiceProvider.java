package com.infoshareacademy.model;

import java.util.Date;
import java.util.List;

public class ServiceProvider {

    private int ID;
    private String companyName;
    private String ownerName;
    private String ownerSurname;
    private int phone;
    private String email;
    private String websiteAddress;
    private Location location;
    private ServiceType serviceType;
    private List<Date> availability;
    private boolean isActive;
    private List<Rating> rating;
}
