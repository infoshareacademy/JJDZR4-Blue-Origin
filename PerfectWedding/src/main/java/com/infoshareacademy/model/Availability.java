package com.infoshareacademy.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Availability {
    private List<LocalDate> availability;

    public Availability() {
        availability = new ArrayList<>();
    }

    public void addNewAvailability(LocalDate date) {
        availability.add(date);
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (LocalDate localDate : availability) {
            toReturn = toReturn + localDate + "\n";
        }
        return toReturn;
    }
}
