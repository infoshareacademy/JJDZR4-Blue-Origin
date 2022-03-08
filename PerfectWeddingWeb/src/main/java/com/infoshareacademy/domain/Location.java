package com.infoshareacademy.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @JsonBackReference
    @OneToOne(mappedBy = "location")
    private ServiceProvider serviceProvider;


    public Location(String city, Voivodeship voivodeship) {
        this.voivodeship = voivodeship;
        this.city = city;
    }

    public Location(String city) {
        this.city = city;
    }

}
