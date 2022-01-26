package com.infoshareacademy.domain;


import lombok.Getter;

@Getter
public enum TypesOfService {
    FILMOWANIE("FILMOWANIE"),
    FOTOGRAFIA("FOTOGRAFIA"),
    SALA_WESELNA("SALA_WESELNA"),
    OPRAWA_MUZYCZNA("OPRAWA_MUZYCZNA"),
    WSZYSTKIE("WSZYSTKIE");

    private String fullName;

    TypesOfService(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
