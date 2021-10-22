package com.infoshareacademy;

import com.infoshareacademy.model.Rating;

import static com.infoshareacademy.ProvidersOperations.scanInput;

public class ClientOperations {

    public void dummyCallOfRating() {
        //this method will be removed - this is just manual call out of method rateByClient - in the future rateByClient should be called out after "Wyszukaj dostawce"
        Integer rating = 0;
        Integer serviceProviderPosInArray = 0;
        Integer maxSupplierNumber=App.providerDataBase.listOfProviders.size()-1;
        do {
            serviceProviderPosInArray = Integer.parseInt(scanInput("podaj nr dostawcy. Od 0 do "+maxSupplierNumber));
            rating = Integer.parseInt(scanInput("podaj ocene od 0 do 5"));
            if (rating >= 0) {
                String comment = scanInput("podaj komentarz (moze byc puste)");
                rateByClient( serviceProviderPosInArray,rating, comment);
            }
        } while (rating > 0);
        for (Rating ratingInArray : App.providerDataBase.listOfProviders.get(serviceProviderPosInArray).getRatingList()) {
            System.out.println(ratingInArray.toString());
        }
        System.out.println("srednia ocena to: " + App.providerDataBase.listOfProviders.get(serviceProviderPosInArray).getAverageRating());
    }

    private void rateByClient(Integer serviceProviderPosInArray, Integer rating, String comment) {
        //in the future rateByClient should be called out after "Wyszukaj dostawce" - metoda przyjmuje nr doatwcy wg tablicy ProviderDataBase
        App.providerDataBase.listOfProviders.get(serviceProviderPosInArray).addRating(rating, comment);
    }
}
