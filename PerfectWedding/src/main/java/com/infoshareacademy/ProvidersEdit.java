package com.infoshareacademy;

import com.infoshareacademy.model.Availability;
import com.infoshareacademy.model.ServiceProvider;
import com.infoshareacademy.model.ServiceType;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static com.infoshareacademy.Utils.*;

public class ProvidersEdit {
    List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();

    public void editProvider() {

        if (providersList.isEmpty()) {
            System.out.println("There are no providers. \n");
            return;
        } else {
            printListOfProviders(providersList);
        }
        // returnIndexOfProviderAppointedByProviderID wymaga podania ID, które jest przekazywane tej metodzie metodą scanInput, stąd taki tasiemiec.
        int chosenProviderId = returnIndexOfProviderAppointedByProviderId(providersList, scanInput("Wybierz usługodawcę, którego chcesz edytować (podaj ID): \n Podaj 0, aby wyjść do menu głównego.", 0, 999)) + 1;
        if (chosenProviderId == 0) {
            return;
        } else {
            editSelectedProvider(chosenProviderId - 1);
        }
    }

    public void editSelectedProvider(int providerId) {
        Scanner scanner = new Scanner(System.in);
        boolean areYouFinished = true;
        System.out.println("Szczegóły wybranego dostawcy: ");
        System.out.println(providersList.get(providerId).toStringVertical());

        do {
            String chosenField = null;
            chosenField = scanInput("Które pole chciałbyś edytować? (podaj nazwę pola lub inną wartość, aby zrezygnować)");

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
                    setPhone(providersList.get(providerId));
                    break;
                case "email":
                    providersList.get(providerId).setEmail(scanInput("Podaj imie email: "));
                    break;
                case "websiteAddress":
                    providersList.get(providerId).setWebsiteAddress(scanInput("Podaj strone internetowa: "));
                    break;
                case "locality":
                    providersList.get(providerId).getLocation().setCity(scanInput("Podaj miejscowosc: "));
                    break;
                case "voivodeship":
                    setVoivodeship(providersList.get(providerId));
                    break;
                case "name":
                    setTypesOfService(providersList.get(providerId));
                    break;
                case "description:":
                    providersList.get(providerId).getServiceType().setDescription(scanInput("Podaj opis działalności"));
                    break;
                case "price":
                    providersList.get(providerId).getServiceType().setPrice(scanInput("Podaj cenę w pełnych złotych"));
                    break;
                case "availability":
                    editAvailabilities(providerId);
                    break;
                case "active":
                    System.out.println("true or false");
                    boolean isActiveQ = scanner.nextBoolean();
                    providersList.get(providerId).setActive(isActiveQ);
                    break;
                default:
                    System.out.println("Nie wybrano żadnego pola. Czy chcesz edytować innego dostawcę?");
                    String response = Utils.scanForString("", "Tak", "Nie");
                    if (response.equalsIgnoreCase("tak")) {
                        areYouFinished = false;
                        editProvider();
                    } else {
                        return;
                    }
            }
        }
        while (areYouFinished);
    }

    public void editAvailabilities(int providerId) {
        String choice = "unknown";
        System.out.println("Wolne terminy to: ");
        System.out.println(providersList.get(providerId).getAvailability());
        System.out.println("W celu dodania terminu dostępności napisz \"dodaj\" \nW celu usunięcia terminu dostępności napisz \"usuń\"");

        choice = scanForString("", "dodaj", "usuń", "q");

        switch (choice) {
            case "dodaj":
                addAvailability(providerId);
                break;
            case "usuń":
                removeAvailability(providerId);
                break;
            case "q":
                System.out.println("Wychodzę z menu edycji dostępności \n");
                return;
            default:
                System.out.println("SOMETHING WENT WRONG! :O");
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
        Availability availability = new Availability();
        availability = providersList.get(providerId).getAvailability();
        List<LocalDate> availableDates = availability.getDates();

        do {
            System.out.println("Wolne terminy to: ");
            int i = 1;
            for (LocalDate n : availableDates) {
                System.out.println(i++ + ". " + n);
            }
            if (availableDates.isEmpty()) {
                break;
            }
            index = scanInput("Podaj ID terminu do usunięcia: ", 1, availableDates.size());
            availableDates.remove(index - 1);
        } while (!returnTrueOrFalse("Czy już skończyłeś?", "tak", "nie"));

    }
}
