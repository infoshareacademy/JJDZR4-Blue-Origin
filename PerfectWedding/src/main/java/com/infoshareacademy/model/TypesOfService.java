package com.infoshareacademy.model;

public enum TypesOfService {
    FILMOWANIE ("Filmowanie"),
    FOTOGRAFIA ("Fotografia"),
    SALA_WESELNA ("Sala weselna"),
    OPRAWA_MUZYCZNA ("Oprawa muzyczna");

    private String fullName;

    TypesOfService(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
