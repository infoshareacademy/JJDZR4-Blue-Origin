package com.infoshareacademy.domain;

public class Location {

    private Voivodeship voivodeship;
    private String city;


    public Location() {
    }

    public Location(String city) {
        this.city = city;
    }

    public Voivodeship getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(Voivodeship voivodeship) {
        this.voivodeship = voivodeship;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
