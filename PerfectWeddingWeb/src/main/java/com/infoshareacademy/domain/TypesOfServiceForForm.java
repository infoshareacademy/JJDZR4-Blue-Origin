package com.infoshareacademy.domain;


import lombok.Getter;

@Getter
public enum TypesOfServiceForForm {
    WSZYSTKIE("WSZYSTKIE"),
    FILMOWANIE("FILMOWANIE"),
    FOTOGRAFIA("FOTOGRAFIA"),
    SALA_WESELNA("SALA_WESELNA"),
    OPRAWA_MUZYCZNA("OPRAWA_MUZYCZNA");

    private String fullName;

    TypesOfServiceForForm(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
