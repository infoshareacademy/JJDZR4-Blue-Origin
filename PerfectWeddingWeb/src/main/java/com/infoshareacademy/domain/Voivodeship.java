package com.infoshareacademy.domain;

import lombok.Getter;

@Getter
public enum Voivodeship {
    DOLNOŚLĄSKIE("DOLNOŚLĄSKIE"),
    KUJAWSKOPOMORSKIE("KUJAWSKO-POMORSKIE"),
    LUBELSKIE("LUBELSKIE"),
    LUBUSKIE("LUBUSKIE"),
    ŁÓDZKIE("ŁÓDZKIE"),
    MAŁOPOLSKIE("MAŁOPOLSKIE"),
    MAZOWIECKIE("MAZOWIECKIE"),
    OPOLSKIE("OPOLSKIE"),
    PODKARPACKIE("PODKARPACKIE"),
    PODLASKIE("PODLASKIE"),
    POMORSKIE("POMORSKIE"),
    ŚLĄSKIE("ŚLĄSKIE"),
    ŚWIĘTOKRZYSKIE("ŚWIĘTOKRZYSKIE"),
    WARMIŃSKOMAZURSKIE("WARMIŃSKO-MAZURSKIE"),
    WIELKOPOLSKIE("WIELKOPOLSKIE"),
    ZACHODNIOPOMORSKIE("ZACHODNIOPOMORSKIE");
    private String fullName;

    Voivodeship(String fullName) {
        this.fullName = fullName;
    }

    @Override public String toString() {
        return fullName;
    }

}
