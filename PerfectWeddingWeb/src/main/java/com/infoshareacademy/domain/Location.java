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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private Voivodeship voivodeship;
    private String city;

    @OneToOne
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
