package com.infoshareacademy;


import com.infoshareacademy.model.ServiceProvider;
import com.infoshareacademy.model.TypesOfService;
import com.infoshareacademy.model.Voivodeship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientOperations {

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
        int indexOfProviderToBeRated = Utils.returnIndexOfProviderAppointedByProviderId(filteredProvidersList, providerToBeRated);
        filteredProvidersList.get(indexOfProviderToBeRated).addRating(providerRating, providerRatingComment);
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
                System.out.println(re.toStringVertical());
                filteredProvidersList.add(re);
                areThereAnyProvidersFound = true;
            }
        }
        noResultsOrAddCommentToProvider(filteredProvidersList, areThereAnyProvidersFound);
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
                System.out.println(re.toStringVertical());
                filteredProvidersList.add(re);
                areThereAnyProvidersFound = true;
            }
        }
        noResultsOrAddCommentToProvider(filteredProvidersList, areThereAnyProvidersFound);
    }

    private void noResultsOrAddCommentToProvider(List<ServiceProvider> filteredProvidersList, boolean areThereAnyProvidersFound) {
        if (!areThereAnyProvidersFound) {
            System.out.println("Brak wyników\n");
        } else {
            System.out.println("Czy chciałbyś ocenić, któregoś usługodawcę?");
            String response = Utils.scanForString("", "tak", "nie");
            if (response.equalsIgnoreCase("tak")) {
                rateByClient(filteredProvidersList);
            }
        }
    }
}

