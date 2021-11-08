package com.infoshareacademy;

import com.infoshareacademy.model.Rating;
import com.infoshareacademy.model.ServiceProvider;

import java.util.List;
import java.util.Scanner;

import static com.infoshareacademy.Utils.scanInput;


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
        App.providerDataBase.listOfProviders.get(serviceProviderPosInArray).addRating(rating, comment);
    }

    public void findProviderByLocality() {

        List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();
        String finder = scanInput("Wyszukaj usługodawcę poprzez lokalizację\n" + "Podaj nazwę miejscowości: ");

        for (ServiceProvider re : providersList) {
            if (re.getLocation().getCity().equals(finder) && re.isActive()) {
                reference += 1;
                System.out.println(re.toStringVertical());
            }
        }
        if (reference == 0) {
            System.out.println("Brak wyników\n");
        }
    }

    public void findProviderByType() {
        List<ServiceProvider> providersList = App.providerDataBase.getListOfProviders();
        String finder = scanInput("Wyszukaj usługodawcę poprzez rodzaj usługi\n" + "Podaj rodzaj usługi: ");

        for (ServiceProvider re : providersList) {
            if (re.getServiceType().getName().equals(finder) && re.isActive()) {
                reference += 1;
                System.out.println(re.toStringVertical());
            }
        }
        if (reference == 0) {
            System.out.println("Brak wyników\n");
        }
    }

}

