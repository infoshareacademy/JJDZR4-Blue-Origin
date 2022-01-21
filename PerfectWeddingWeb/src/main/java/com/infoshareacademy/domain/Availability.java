package com.infoshareacademy.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Availability {

    private List<LocalDate> dates = new ArrayList<>();

    public Availability() {
    }

    public Availability(List<LocalDate> dates) {
        this.dates = dates;
    }

    public void addNewAvailability(LocalDate date) {
        if (dates == null) {
            dates = new ArrayList<>();
        }
        dates.add(date);
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (LocalDate localDate : dates) {
            toReturn = toReturn + localDate + "\n";
        }
        return toReturn;
    }
}
