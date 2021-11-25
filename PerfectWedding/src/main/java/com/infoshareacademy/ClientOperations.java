package com.infoshareacademy;

import com.infoshareacademy.model.Rating;
import com.infoshareacademy.model.ServiceProvider;
import com.infoshareacademy.model.TypesOfService;
import com.infoshareacademy.model.Voivodeship;

import java.util.*;

import static com.infoshareacademy.Utils.*;


public class ClientOperations {
    int reference = 0;

    private void rateByClient(List<ServiceProvider> filteredProvidersList) {
        System.out.println("Wybierz usługodawcę, którego chcesz ocenić. Podaj ID:");
        int providerToBeRated = Utils.scanInput("", 0, 999);
        ArrayList<Integer> idsOfFilteredProviders = Utils.returnIdsFromList((ArrayList<ServiceProvider>) filteredProvidersList);
        boolean isProviderFoundOnTheList = false;

        while (!isProviderFoundOnTheList) {
            if (!(idsOfFilteredProviders.contains(providerToBeRated))) {
                System.out.println("Brak usługodawcy o takim ID na liście. Podaj ID jeszcze raz: ");
                providerToBeRated = Utils.scanInput("", 0, 999);
            } else {
                isProviderFoundOnTheList = true;
            }
        }

        int providerRating = Utils.scanInput("Podaj liczbe od 1 do 5", 1, 5);
        String providerRatingComment = Utils.scanInput("Podaj komentarz");
        filteredProvidersList.get(providerToBeRated-1).addRating(providerRating, providerRatingComment);
    }

    public void findProviderByLocality() {
        Voivodeship finder;
        List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();
        List<ServiceProvider> filteredProvidersList = new ArrayList<>();
        List<Voivodeship> listOfVoivodeships = Arrays.asList(Voivodeship.values());
        boolean areThereAnyProvidersFound = false;
        System.out.println("Wybierz wojewodztwo z ponizszej list");
        System.out.println(Utils.listToString(listOfVoivodeships, true));
        finder = listOfVoivodeships.get(Utils.scanForInt("Wybiez wojewodztwo od 1 do " + listOfVoivodeships.size(), 1, listOfVoivodeships.size(), true).get(0) - 1);

        for (ServiceProvider re : providersList) {
            if (re.getLocation().getVoivodeship().equals(finder) && re.isActive()) {
                reference += 1;
                System.out.println(re.toStringVertical());
                filteredProvidersList.add(re);
                areThereAnyProvidersFound = true;
            }
        }
        if (reference == 0) {
            System.out.println("Brak wyników\n");
        }

        if (areThereAnyProvidersFound) {
            System.out.println("Czy chciałbyś ocenić, któregoś usługodawcę?");
            String response = Utils.scanForString("", "tak", "nie");
            if (response.equalsIgnoreCase("tak")) {
                rateByClient(filteredProvidersList);
            }
        }
    }

    public void findProviderByType() {
        TypesOfService finder;
        List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();
        List<ServiceProvider> filteredProvidersList = new ArrayList<>();
        List<TypesOfService> listOfServiceTypes = Arrays.asList(TypesOfService.values());
        boolean areThereAnyProvidersFound = false;
        System.out.println("Wybierz rodzaj usługi z poniższej listy");
        System.out.println(Utils.listToString(listOfServiceTypes, true));
        finder = listOfServiceTypes.get(Utils.scanForInt("Wybiez usługę od 1 do " + listOfServiceTypes.size(), 1, listOfServiceTypes.size(), true).get(0) - 1);

        for (ServiceProvider re : providersList) {
            if (re.getServiceType().getTypesOfService().toString().equals(finder.toString()) && re.isActive()) {
                reference += 1;
                System.out.println(re.toStringVertical());
                filteredProvidersList.add(re);
                areThereAnyProvidersFound = true;
            }
        }
        if (reference == 0) {
            System.out.println("Brak wyników\n");
        }

        if (areThereAnyProvidersFound) {
            System.out.println("Czy chciałbyś ocenić, któregoś usługodawcę?");
            String response = Utils.scanForString("", "tak", "nie");
            if (response.equalsIgnoreCase("tak")) {
                rateByClient(filteredProvidersList);
            }
        }
    }

}

