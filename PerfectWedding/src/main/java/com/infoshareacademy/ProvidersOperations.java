package com.infoshareacademy;

import com.infoshareacademy.model.Availability;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.ServiceProvider;
import com.infoshareacademy.model.ServiceType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class ProvidersOperations {
    ServiceProvider provider = new ServiceProvider();

    public void createProvider() {
        provider.setCompanyName(scanInput("Podaj nazwe firmy"));

        provider.setOwnerName(scanInput("Podaj Imie wlasciciela"));
        provider.setOwnerSurname(scanInput("Podaj nazwisko wlasciciela"));
        provider.setPhone(scanInput("Podaj nr telefonu"));
        provider.setEmail(scanInput("Podaj email firmy"));
        provider.setWebsiteAddress(scanInput("Podaj adres strony www firmy"));

        provider.setLocation(new Location(scanInput("Podaj lokalizcje firmy (miasto)")));
        provider.setServiceType(new ServiceType(scanInput("Rodzaj uslugi")));
        provider.setActive(askIfActive("Dostawca aktywny (T/N)?"));


        // add availability here :
        String dataToParse = scanInput("Podaj date dostepnosci");
        LocalDate parse = LocalDate.parse(dataToParse, DateTimeFormatter.ISO_LOCAL_DATE);
        Availability availability = new Availability();
        availability.addNewAvailability(parse);
        provider.setAvailability(availability);
        System.out.println(provider.toString());
    }

//        private String companyLocation;
//        private ServiceType serviceType;
//        private String availabilityStartDate;
//        private String availabilityEndDate;
//        private double rating;
//        private boolean isActive;


    public void editProvider() {

    }

    public void deleteProvider() {

    }

    public String scanInput(String prompt) {
        System.out.println(prompt);
        String toReturn = new String();
        try {
            Scanner scanner = new Scanner(System.in);
            toReturn = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("nieodpowiedia wartosc");
            scanInput(prompt);
        }
        return toReturn;

    }

    public boolean askIfActive(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        String answer= scanner.nextLine();
        if (answer.toUpperCase(Locale.ROOT).equals("T")) {
            return true;
        }

        return false;

    }
}
