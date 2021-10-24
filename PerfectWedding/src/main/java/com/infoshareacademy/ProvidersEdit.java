package com.infoshareacademy;

import com.infoshareacademy.model.ServiceProvider;

import java.util.List;
import java.util.Scanner;

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
//        editSelectedProvider(chosenProviderId-1);
    }

}
