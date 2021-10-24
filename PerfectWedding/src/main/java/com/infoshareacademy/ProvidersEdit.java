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

}
