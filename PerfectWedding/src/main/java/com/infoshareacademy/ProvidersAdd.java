package com.infoshareacademy;

import com.infoshareacademy.model.Availability;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.ServiceProvider;
import com.infoshareacademy.model.ServiceType;
import com.infoshareacademy.PerfectWeddingUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import static com.infoshareacademy.PerfectWeddingUtils.scanInput;

public class ProvidersAdd {
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
        App.providerDataBase.addNewProvider(provider);


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



}
