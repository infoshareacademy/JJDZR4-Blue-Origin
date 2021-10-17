package com.infoshareacademy;


import java.util.Scanner;

public class MenuAddNewProvider {
    Provider providerToBeAdded;

    public MenuAddNewProvider(Provider providerToBeAdded) {
        this.providerToBeAdded = new Provider();
    }



    public MenuAddNewProvider() {
        Scanner scanner=new Scanner(System.in);
        Provider provider=new Provider();
        System.out.println("Podaj nazwe firmy");
        provider.setCompanyName(scanner.nextLine());
        System.out.println("Podaj imie wlasciciela");
        provider.setOwnerName(scanner.nextLine());
        System.out.println("Podaj nazwisko wlasciciela");
        provider.setOwnerSurname(scanner.nextLine());
        System.out.println("Podaj nr telefonu firmy");
        provider.setCompanyPhone(scanner.nextLine());
        System.out.println("Podaj email firmy");
        provider.setCompanyEmail(scanner.nextLine());
        System.out.println("Podaj adres strony www firmy");
        provider.setCompanyWebsite(scanner.nextLine());
        System.out.println("Podaj lokalizcje firmy (miasto)");
        provider.setCompanyLocation(scanner.nextLine());



//        private String companyLocation;
//        private ServiceType serviceType;
//        private String availabilityStartDate;
//        private String availabilityEndDate;
//        private double rating;
//        private boolean isActive;

    }
}
