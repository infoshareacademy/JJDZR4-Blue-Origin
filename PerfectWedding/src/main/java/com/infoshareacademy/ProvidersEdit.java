package com.infoshareacademy;

import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.ServiceProvider;
import com.infoshareacademy.model.ServiceType;

import java.util.List;
import java.util.Scanner;

import static com.infoshareacademy.PerfectWeddingUtils.scanInput;

public class ProvidersEdit {
    public void editProvider() {
        List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Aktualna lista usługodawców wygląda następująco: ");
        for (ServiceProvider n: providersList) {
            System.out.println("ID " + n.getID() +" Nazwa firmy " + n.getCompanyName() + " Imię i nazwisko właściciela " + n.getOwnerName() + " " + n.getOwnerSurname());
        }
//        System.out.println("Wybierz usługodawcę, którego chcesz edytować (podaj ID): ");

        int chosenProviderId = scanInput("Wybierz usługodawcę, którego chcesz edytować (podaj ID): ", 1, providersList.size());
        editSelectedProvider(chosenProviderId-1);
    }

    public void editSelectedProvider (int i) {
        List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();
        Scanner scanner = new Scanner(System.in);
        boolean areYouFinished = true;
        System.out.println("Szczegóły wybranego dostawcy: ");
        System.out.println(providersList.get(i).toStringVertical());

        do {
            String chosenField = null;
            chosenField = scanInput("Które pole chciałbyś edytować? (podaj nazwę pola)");

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

}
