package com.infoshareacademy;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private int response;
    private String wantToQuit;

    public void mainMenu() {
        do {
            printMainMenu();
            skeletonMenu();
            switch (response) {
                case 0:
                    reallyQuitSkeleton();
                    if (wantToQuit.toUpperCase().equals("T")) {
                        break;
                    } else if (wantToQuit.toUpperCase().equals("N"))
                        response = -1;
                    else mainMenu();
                    break;
                case 1:
                    clientMenu();
                    break;
                case 2:
                    providerMenu();
                    break;
                default:
                    System.out.println("wybierz opcje 0,1 lub 2");
                    break;
            }
        } while (response < 0 || response > 2);
    }

    private void providerMenu() {
        ProvidersOperations providersOperations = new ProvidersOperations();
        do {
            printProviderMenu();
            skeletonMenu();
            switch (response) {
                case 0:
                    reallyQuitSkeleton();
                    if (wantToQuit.toUpperCase().equals("T")) {
                        break;
                    } else if (wantToQuit.toUpperCase().equals("N"))
                        response = -1;
                    else providerMenu();
                    break;
                case 1:
                    providersOperations.createProvider();
                    break;
                case 2:
                    providersOperations.editProvider();
                    break;
                case 3:
                    providersOperations.deleteProvider();
                    break;
                default:
                    System.out.println("wybierz opcje:");
                    break;
            }
        } while (response < 0 || response > 3);
    }

    private String reallyQuitSkeleton() {
        System.out.println("Czy na pewno wyjsc(T/N)?");
        Scanner scanner1 = new Scanner(System.in);
        String wantToQuit = scanner1.nextLine();
        return wantToQuit;
    }

    private int skeletonMenu() {
        try {
            response = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("");
            response = -1;
            scanner.nextLine();
        }
        return response;
    }

    private void printMainMenu() {
        System.out.println("Menu główne");
        System.out.println("Wybierz opcje:");
        System.out.println("0. wyjście z programu.");
        System.out.println("1. panel klienta");
        System.out.println("2. panel usługodawcy");
    }

    private void printProviderMenu() {
        System.out.println("Menu usługodawcy");
        System.out.println("Wybierz opcje:");
        System.out.println("0. wyjście z programu.");
        System.out.println("1. Załóż konto");
        System.out.println("2. Edytuj konto");
        System.out.println("3. Usuń konto");

        //menuAddNewProvider.

    }

    private void clientMenu() {
        System.out.println("Menu klienta - do zrobienia :)");
    }

    private void deleteAccount() {
        System.out.println("Usunięcie konta - do zrobienia :P");
    }
}
