package com.infoshareacademy;

import com.infoshareacademy.model.ServiceType;
import com.infoshareacademy.model.*;
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
        String dataToParse = scanInput("Podaj date dostepnosci (RRRR-MM-DD)");
        LocalDate parse = LocalDate.parse(dataToParse, DateTimeFormatter.ISO_LOCAL_DATE);
        Availability availability = new Availability();
        availability.addNewAvailability(parse);
        provider.setAvailability(availability);


        //this section will be removed once proper methods are added to YoungCoupleOperations class
        Integer rating;
        do {
            rating = Integer.parseInt(scanInput("podaj ocene"));

            if (rating > 0) {
                String comment = scanInput("podaj komentarz (moze byc puste)");
                provider.addRating(rating, comment);
            }
        } while (rating > 0);
        for (Rating ratingInArray : provider.getRatingList()) {
            System.out.println(ratingInArray.toString());
        }
        System.out.println("srednia ocena to: " + provider.getAverageRating());
        App.providerDataBase.addNewProvider(provider);
        System.out.println(App.providerDataBase);
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
        String answer = scanner.nextLine();
        if (answer.toUpperCase(Locale.ROOT).equals("T")) {
            return true;
        }
        return false;
    }
    public void editProvider() {
    }
    public void deleteProvider() {
    }
}
