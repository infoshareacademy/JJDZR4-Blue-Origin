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
    public static final String COLUMN_PREFIX = "l_";

    @Id
    @GeneratedValue
    @Column(name = COLUMN_PREFIX + "id")
    private int id;

    @Column(name = COLUMN_PREFIX + "voivodeship", nullable = false)
    private Voivodeship voivodeship;

    @Column(name = COLUMN_PREFIX + "city", nullable = false)
    private String city;


    public Location(String city, Voivodeship voivodeship) {
        this.voivodeship = voivodeship;
        this.city = city;
    }

    public Location(String city) {
        this.city = city;
    }

}
