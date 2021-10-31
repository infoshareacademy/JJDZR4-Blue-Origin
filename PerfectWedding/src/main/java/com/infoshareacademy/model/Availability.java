package com.infoshareacademy.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Availability {

    private List<LocalDate> dates = new ArrayList<>();

    public Availability() {
    }

    public void addNewAvailability(LocalDate date) {
        if (dates == null) {
            dates = new ArrayList<>();
        }
        dates.add(date);
    }

    public void setDates(List<LocalDate> dates) {
        this.dates = dates;
    }

    public List<LocalDate> getDates() {
        return dates;
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
