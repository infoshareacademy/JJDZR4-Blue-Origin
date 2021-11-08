package com.infoshareacademy;

import com.infoshareacademy.model.*;
import com.infoshareacademy.model.ServiceType;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static com.infoshareacademy.Utils.scanInput;
import static com.infoshareacademy.Utils.scanInputDate;

public class ProvidersAdd {
    ServiceProvider provider = new ServiceProvider();

    public void createProvider() {
        LocalDate availableDate = null;
        provider.setCompanyName(scanInput("Podaj nazwe firmy"));
        provider.setOwnerName(scanInput("Podaj Imie wlasciciela"));
        provider.setOwnerSurname(scanInput("Podaj nazwisko wlasciciela"));
        provider.setPhone(scanInput("Podaj nr telefonu"));
        provider.setEmail(scanInput("Podaj email firmy"));
        provider.setWebsiteAddress(scanInput("Podaj adres strony www firmy"));
        setVoivodeship();
        provider.setServiceType(new ServiceType(scanInput("Rodzaj uslugi")));
        provider.setActive(askIfActive("Dostawca aktywny (T/N)?"));
        addAvailability();
        App.providerDataBase.addNewProvider(provider);

    }

    public void setVoivodeship() {
        provider.setLocation(new Location(scanInput("Podaj lokalizcje firmy (miasto)")));
        List<Voivodeship> listOfVoivodeships = Arrays.asList(Voivodeship.values());
        System.out.println("Wybierz wojewodztwo z ponizszej list");
        System.out.println(Utils.listToString(listOfVoivodeships, true));
        provider.getLocation().setVoivodeship(listOfVoivodeships.get(Utils.scanForInt("Wybiez wojewodztwo od 1 do " + listOfVoivodeships.size(), 1, listOfVoivodeships.size(), true).get(0) - 1));
    }

    private void addAvailability() {
        Availability availability = new Availability();
        LocalDate availableDate;
        do {
            availableDate = scanInputDate("Podaj date dostepnosci (RRRR-MM-DD)", "q", LocalDate.of(1900, 1, 1));
            if (!(availableDate.equals(LocalDate.of(1900, 1, 1)))) {
                availability.addNewAvailability(availableDate);
            }
        } while (!availableDate.equals(LocalDate.of(1900, 01, 01)));
        provider.setAvailability(availability);
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
