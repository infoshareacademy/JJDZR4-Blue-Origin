package com.infoshareacademy.model;

public class Location {

    private String voivodeship;
    private String locality;

    public Location() {
    }

    public Location(String locality) {
        this.locality = locality;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

}
