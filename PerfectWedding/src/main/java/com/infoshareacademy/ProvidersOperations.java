package com.infoshareacademy;

import com.infoshareacademy.model.Availability;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.ServiceProvider;
import com.infoshareacademy.model.ServiceType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProvidersOperations {
    ServiceProvider provider = new ServiceProvider();

    public static String scanInput(String prompt) {
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

    public void createProvider() {
        provider.setID();
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

    public void editProvider() {
        List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Current providers are shown below: ");
        for (ServiceProvider n: providersList) {
            System.out.println("ID " + n.getID() + " and owner name is " + n.getOwnerName());
        }
        System.out.println("Chose provider to be edited (type ID): ");
        int chosenProviderId = scanner.nextInt();
        editSelectedProvider(chosenProviderId-1);

    }

    public void editSelectedProvider (int i) {
        List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();
        Scanner scanner = new Scanner(System.in);
        boolean areYouFinished = true;
        System.out.println("Chosen provider details are: ");
        System.out.println(providersList.get(i).toString());

        do {
            String chosenField = null;
            chosenField = scanInput("Which field would you like to edit?");

            switch (chosenField) {
                case "companyName": providersList.get(i).setCompanyName(scanInput("Podaj nazwe firmy: "));
                    break;
                case "ownerName": providersList.get(i).setOwnerName(scanInput("Podaj imie wlasciciela: "));
                    break;
                case "ownerSurname": providersList.get(i).setOwnerSurname(scanInput("Podaj nazwisko wlasciciela: "));
                    break;
                case "phone": providersList.get(i).setPhone(scanInput("Podaj telefon: "));
                    break;
                case "email": providersList.get(i).setEmail(scanInput("Podaj imie email: "));
                    break;
                case "websiteAddress": providersList.get(i).setWebsiteAddress(scanInput("Podaj strone internetowa: "));
                    break;
                case "location": providersList.get(i).setLocation(new Location(scanInput("Podaj miejscowosc: ")));
                    break;
                case "service": providersList.get(i).setServiceType(new ServiceType(scanInput("Podaj rodzaj uslugi: ")));
                    break;
                default:
                    System.out.println("None field chosen");
                    editProvider();

            }
            String response = scanInput("Would you like to change any other field? (yes/no)");
            if (response.equals("yes")) {
                areYouFinished = true;
            } else {
                areYouFinished = false;
            }
        }
        while (areYouFinished);
    }


    public void deleteProvider() {
    }
}
