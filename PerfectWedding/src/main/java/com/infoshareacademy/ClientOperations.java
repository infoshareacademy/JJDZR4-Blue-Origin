package com.infoshareacademy;

import com.infoshareacademy.model.Rating;
import com.infoshareacademy.model.ServiceProvider;
import com.infoshareacademy.model.TypesOfService;
import com.infoshareacademy.model.Voivodeship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.infoshareacademy.Utils.*;


public class ClientOperations {
    int reference = 0;

    public void dummyCallOfRating() {
        //this method will be removed - this is just manual call out of method rateByClient - in the future rateByClient should be called out after "Wyszukaj dostawce"
        Integer rating;
        Integer serviceProviderPosInArray;
        List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Aktualna lista usługodawców wygląda następująco: ");
        for (ServiceProvider n : providersList) {
            System.out.println("ID " + n.getCurrentID() + " Nazwa firmy " + n.getCompanyName() + " Imię i nazwisko właściciela " + n.getOwnerName() + " " + n.getOwnerSurname());
        }
        int ifExit = scanInput("Jeżeli chcesz zakończyć wybierz 0, w innym wypadku wybierz 1", 0, 1);
        if (ifExit == 0) {
            new Menu().mainMenu();
        } else ;

        Integer maxSupplierNumber = App.providerDataBase.listOfProviders.size();
        serviceProviderPosInArray = scanInput("podaj nr dostawcy do oceny. Od 1 do " + maxSupplierNumber, 0, maxSupplierNumber);
        do {
            rating = scanInput("podaj ocene od 0 do 5 (-1 aby zakonczyc ocene)", -1, 5);
            if (rating >= 0) {
                String comment = scanInput("podaj komentarz (moze byc puste)");
                rateByClient(serviceProviderPosInArray - 1, rating, comment);
            }
        } while (rating >= 0);
        for (Rating ratingInArray : App.providerDataBase.listOfProviders.get(serviceProviderPosInArray - 1).getRatingList())
            System.out.println(ratingInArray.toString());
        System.out.println("średnia ocena to: " + App.providerDataBase.listOfProviders.get(serviceProviderPosInArray - 1).getAverageRating());
    }

    private void rateByClient(Integer serviceProviderPosInArray, Integer rating, String comment) {
        //in the future rateByClient should be called out after "Wyszukaj dostawce" - metoda przyjmuje nr doatwcy wg tablicy ProviderDataBase
        //App.providerDataBase.listOfProviders.get(serviceProviderPosInArray).addRating(rating, comment);
        List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();



    }

    public void findProviderByLocality() {
        Voivodeship finder;
        List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();
        List<ServiceProvider> filteredProvidersList = new ArrayList<>();
        List<Voivodeship> listOfVoivodeships = Arrays.asList(Voivodeship.values());
        System.out.println("Wybierz wojewodztwo z ponizszej list");
        System.out.println(Utils.listToString(listOfVoivodeships, true));
        finder = listOfVoivodeships.get(Utils.scanForInt("Wybiez wojewodztwo od 1 do " + listOfVoivodeships.size(), 1, listOfVoivodeships.size(), true).get(0) - 1);

        for (ServiceProvider re : providersList) {
            if (re.getLocation().getVoivodeship().equals(finder) && re.isActive()) {
                reference += 1;
                System.out.println(re.toStringVertical());
                filteredProvidersList.add(re);
            }
        }
        if (reference == 0) {
            System.out.println("Brak wyników\n");
        }
    }

    public void findProviderByType() {
        TypesOfService finder;
        List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();
        List<ServiceProvider> filteredProvidersList = new ArrayList<>();
        List<TypesOfService> listOfServiceTypes = Arrays.asList(TypesOfService.values());
        System.out.println("Wybierz rodzaj usługi z poniższej listy");
        System.out.println(Utils.listToString(listOfServiceTypes, true));
        finder = listOfServiceTypes.get(Utils.scanForInt("Wybiez usługę od 1 do " + listOfServiceTypes.size(), 1, listOfServiceTypes.size(), true).get(0) - 1);

        for (ServiceProvider re : providersList) {
            if (re.getServiceType().getTypesOfService().toString().equals(finder.toString()) && re.isActive()) {
                reference += 1;
                System.out.println(re.toStringVertical());
                filteredProvidersList.add(re);
            }
        }
        if (reference == 0) {
            System.out.println("Brak wyników\n");
        }
    }

}

