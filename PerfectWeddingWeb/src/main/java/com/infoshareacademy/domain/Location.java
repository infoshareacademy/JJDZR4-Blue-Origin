package com.infoshareacademy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = Location.TABLE_NAME)
public class Location {

    public static final String TABLE_NAME = "location";

    @Id
    @GeneratedValue
    private int id;

    private Voivodeship voivodeship;
    private String city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_provider_id")
    private ServiceProvider serviceProvider;


    public Location(String city, Voivodeship voivodeship) {
        this.voivodeship = voivodeship;
        this.city = city;
    }

    public Location(String city) {
        this.city = city;
    }

}
