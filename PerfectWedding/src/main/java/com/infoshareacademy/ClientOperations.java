package com.infoshareacademy;

import com.infoshareacademy.model.Rating;
import com.infoshareacademy.model.ServiceProvider;

import java.util.List;

import static com.infoshareacademy.PerfectWeddingUtils.scanInput;


public class ClientOperations {

    public void dummyCallOfRating() {
        //this method will be removed - this is just manual call out of method rateByClient - in the future rateByClient should be called out after "Wyszukaj dostawce"
        Integer rating;
        Integer serviceProviderPosInArray;
        Integer maxSupplierNumber = App.providerDataBase.listOfProviders.size() - 1;
        serviceProviderPosInArray = scanInput("podaj nr dostawcy do oceny. Od 0 do " + maxSupplierNumber, 0, maxSupplierNumber);
        do {
            rating = scanInput("podaj ocene od 0 do 5 (-1 aby zakonczyc ocene)", -1, 5);
            if (rating >= 0) {
                String comment = scanInput("podaj komentarz (moze byc puste)");
                rateByClient(serviceProviderPosInArray, rating, comment);
            }
        } while (rating >= 0);
        for (Rating ratingInArray : App.providerDataBase.listOfProviders.get(serviceProviderPosInArray).getRatingList())
            System.out.println(ratingInArray.toString());
        System.out.println("średnia ocena to: " + App.providerDataBase.listOfProviders.get(serviceProviderPosInArray).getAverageRating());
    }

    private void rateByClient(Integer serviceProviderPosInArray, Integer rating, String comment) {
        //in the future rateByClient should be called out after "Wyszukaj dostawce" - metoda przyjmuje nr doatwcy wg tablicy ProviderDataBase
        App.providerDataBase.listOfProviders.get(serviceProviderPosInArray).addRating(rating, comment);
    }

    public void findProviderByLocality() {
        List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();
        String finder = scanInput("Wyszukaj usługodawcę poprzez lokalizację\n" + "Podaj nazwę miejscowości: ");

        for (ServiceProvider re : providersList) {
            if (re.getLocation().getLocality().equals(finder))
                System.out.println(re.toStringVertical());
            else {
                System.out.println("Brak wyników");
            }
        }
        new Menu().mainMenu();
    }

    public void findProviderByType() {
        List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();
        String finder = scanInput("Wyszukaj usługodawcę poprzez rodzaj usługi\n" + "Podaj rodzaj usługi: ");

        for (ServiceProvider re : providersList) {
            if (re.getServiceType().getName().equals(finder))
                System.out.println(re.toStringVertical());
            else {
                System.out.println("Brak wyników");
            }
        }
        new Menu().mainMenu();

    }
}

