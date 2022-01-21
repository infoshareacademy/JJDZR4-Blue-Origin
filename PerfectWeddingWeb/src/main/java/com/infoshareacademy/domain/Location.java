package com.infoshareacademy.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {

    private Voivodeship voivodeship;
    private String city;
    public Location() {
    }

    public Location( String city, Voivodeship voivodeship) {
        this.voivodeship = voivodeship;
        this.city = city;
    }

    public Location(String city) {
        this.city = city;
    }

}
