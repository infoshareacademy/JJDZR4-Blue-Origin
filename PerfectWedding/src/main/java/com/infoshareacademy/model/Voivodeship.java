package com.infoshareacademy.model;

public enum Voivodeship {
    DOLNOSLASKIE("DOLNOŚLĄSKIE"),
    KUJAWSKOPOMORSKIE("KUJAWSKO-POMORSKIE"),
    LUBELSKIE("LUBELSKIE"),
    LUBUSKIE("LUBUSKIE"),
    LODZKIE("ŁÓDZKIE"),
    MALOPOLSKIE("MAŁOPOLSKIE"),
    MAZOWIECKIE("MAZOWIECKIE"),
    OPOLSKIE("OPOLSKIE"),
    PODKARPACKIE("PODKARPACKIE"),
    PODLASKIE("PODLASKIE"),
    POMORSKIE("POMORSKIE"),
    SLASKIE("ŚLĄSKIE"),
    SWIETOKRZYSKIE("ŚWIĘTOKRZYSKIE"),
    WARMINSKOMAZURSKIE("WARMIŃSKO-MAZURSKIE"),
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
