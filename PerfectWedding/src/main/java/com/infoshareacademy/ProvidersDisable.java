package com.infoshareacademy;

import com.infoshareacademy.model.ServiceProvider;

import java.util.List;
import java.util.Scanner;

import static com.infoshareacademy.PerfectWeddingUtils.scanInput;

public class ProvidersDisable {

    List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();
    public void deleteProvider() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Aktualna lista usługodawców wygląda następująco: ");
        for (ServiceProvider n : providersList) {
            System.out.println("ID " + n.getID() + " Nazwa firmy " + n.getCompanyName() + " Imię i nazwisko właściciela " + n.getOwnerName() + " " + n.getOwnerSurname());
        }
        int chosenProviderId = scanInput("Wybierz usługodawcę, którego chcesz edytować (podaj ID): ", 1, providersList.size());
        providersList.get(chosenProviderId - 1).setActive(false);
    }

}
