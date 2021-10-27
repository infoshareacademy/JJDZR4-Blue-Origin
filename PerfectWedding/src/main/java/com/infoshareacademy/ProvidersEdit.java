package com.infoshareacademy;

import com.infoshareacademy.model.Availability;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.ServiceProvider;
import com.infoshareacademy.model.ServiceType;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static com.infoshareacademy.PerfectWeddingUtils.*;

public class ProvidersEdit {
    List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();

    public void editProvider() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Aktualna lista usługodawców wygląda następująco: ");
        for (ServiceProvider n : providersList) {
            System.out.println("ID " + n.getID() + " Nazwa firmy " + n.getCompanyName() + " Imię i nazwisko właściciela " + n.getOwnerName() + " " + n.getOwnerSurname());
        }
        int chosenProviderId = scanInput("Wybierz usługodawcę, którego chcesz edytować (podaj ID): ", 1, providersList.size());
        editSelectedProvider(chosenProviderId - 1);
    }

    public void editSelectedProvider(int providerId) {
        List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();
        Scanner scanner = new Scanner(System.in);
        boolean areYouFinished = true;
        System.out.println("Szczegóły wybranego dostawcy: ");
        System.out.println(providersList.get(providerId).toStringVertical());

        do {
            String chosenField = null;
            chosenField = scanInput("Które pole chciałbyś edytować? (podaj nazwę pola)");

            switch (chosenField) {
                case "companyName":
                    providersList.get(providerId).setCompanyName(scanInput("Podaj nazwe firmy: "));
                    break;
                case "ownerName":
                    providersList.get(providerId).setOwnerName(scanInput("Podaj imie wlasciciela: "));
                    break;
                case "ownerSurname":
                    providersList.get(providerId).setOwnerSurname(scanInput("Podaj nazwisko wlasciciela: "));
                    break;
                case "phone":
                    providersList.get(providerId).setPhone(scanInput("Podaj telefon: "));
                    break;
                case "email":
                    providersList.get(providerId).setEmail(scanInput("Podaj imie email: "));
                    break;
                case "websiteAddress":
                    providersList.get(providerId).setWebsiteAddress(scanInput("Podaj strone internetowa: "));
                    break;
                case "location":
                    providersList.get(providerId).setLocation(new Location(scanInput("Podaj miejscowosc: ")));
                    break;
                case "service":
                    providersList.get(providerId).setServiceType(new ServiceType(scanInput("Podaj rodzaj uslugi: ")));
                    break;
                case "availability":
                    editAvailabilities(providerId);
                    break;
                default:
                    System.out.println("Nie wybrano żadnego pola.");
                    editProvider();

            }
            String response = scanInput("Czy chciałbyś edytować jeszcze jakieś pole? (tak/nie)");
            if (response.equals("tak")) {
                areYouFinished = true;
            } else {
                areYouFinished = false;
            }
        }
        while (areYouFinished);
    }

    public void editAvailabilities(int providerId) {
        String choice = "unknown";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wolne terminy to: ");
        System.out.println(providersList.get(providerId).getAvailability());
        System.out.println("W celu dodania terminu dostępności napisz \"dodaj\" \nW celu usunięcia terminu dostępności napisz \"usuń\"");

        choice = scanInput("");
        if (choice.equals("dodaj")) {
            addAvailability(providerId);
        } else {
            if (choice.equals("usuń")) {
            removeAvailability(providerId);
            }
        }
    }

    public void addAvailability(int providerId) {
        LocalDate availableDate;
        Availability availability = new Availability();
        availability = providersList.get(providerId).getAvailability();
        do {
            availableDate = scanInputDate("Podaj date dostepnosci (RRRR-MM-DD)", "q", LocalDate.of(1900, 1, 1));
            if (!(availableDate.equals(LocalDate.of(1900, 1, 1)))) {
                availability.addNewAvailability(availableDate);
            }
        } while (!availableDate.equals(LocalDate.of(1900, 01, 01)));
        providersList.get(providerId).setAvailability(availability);
    }

    public void removeAvailability(int providerId) {
        int index = 0;
        boolean areYouFinished = false;
        LocalDate availableDate;
        Availability availability = new Availability();
        availability = providersList.get(providerId).getAvailability();
        List<LocalDate> availableDates = availability.getAvailability();
        System.out.println("Wolne terminy to: ");

        do {
            int i = 1;
            for (LocalDate n: availableDates) {
                System.out.println(i++ + ". " + n);
            }
            if (availableDates.isEmpty()){
                break;
            }
            index = scanInput("Podaj ID terminu do usunięcia: ", 1, availableDates.size());
            availableDates.remove(index-1);
        } while (!returnTrueOrFalse("Czy już skończyłeś?", "tak", "nie"));

    }



}
