package com.infoshareacademy;

public enum ServiceType {
    BallRoom ("Sala Weselna"),
    Band("Zespol muzyczny"),
    Catering("Catering");

    private String serviceDescription;

    ServiceType(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }
}
