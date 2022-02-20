package com.infoshareacademy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = Availability.TABLE_NAME)

public class Availability {

    public static final String TABLE_NAME = "availability";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ElementCollection
    private List<LocalDate> dates = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "service_provider_id")
    private ServiceProvider serviceProvider;

    public Availability(List<LocalDate> dates) {
        this.dates = dates;
    }

    public void addNewAvailability(LocalDate date) {
        if (dates == null) {
            dates = new ArrayList<>();
        }
        dates.add(date);
    }


    public List<LocalDate> sortDates(List<LocalDate> dates) {
        List<LocalDate> datesToBeSorted = dates;
        Collections.sort(datesToBeSorted);
        return datesToBeSorted;
    }

    public void removeAvailability(int dateIndex) {
        if (dates == null) {

        }
        dates.remove(dateIndex);
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
