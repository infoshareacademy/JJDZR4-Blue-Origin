package com.infoshareacademy;

import java.util.Locale;
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
                    if (wantToQuit.equals("T")) {
                        App.providerDataBase.addProviderListToFile();
                        response = 1;
                        break;
                    } else if (wantToQuit.equals("N"))
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
                    choiceOptions();
                    break;
            }
        } while (response < 0 || response > 2);
    }

    public void providerMenu() {
        ProvidersAdd providersAdd = new ProvidersAdd();
        ProvidersEdit providersEdit = new ProvidersEdit();
        ProvidersDisable providersDisable = new ProvidersDisable();
        do {
            printProviderMenu();
            skeletonMenu();
            switch (response) {
                case 0:
                    reallyQuitSkeleton();
                    if (wantToQuit.equals("T")) {
                        App.providerDataBase.addProviderListToFile();
                        response = 1;
                        break;
                    } else if (wantToQuit.equals("N"))
                        response = -1;
                    else providerMenu();
                    break;
                case 1:
                    providersAdd.createProvider();
                    mainMenu();
                    break;
                case 2:
                    providersEdit.editProvider();
                    mainMenu();
                    break;
                case 3:
                    providersDisable.deleteProvider();
                    mainMenu();
                    break;
                default:
                    choiceOptions();
                    break;
            }
        } while (response < 0 || response > 3);
    }

    public void clientMenu() {
        ClientOperations clientOperations = new ClientOperations();
        do {
            printClientMenu();
            skeletonMenu();
            switch (response) {
                case 0:
                    reallyQuitSkeleton();
                    if (wantToQuit.equals("T")) {
                        response = 1;
                        break;
                    } else if (wantToQuit.equals("N"))
                        response = -1;
                    else clientMenu();
                    break;
                case 1:
                    clientFinderMenu();
                    mainMenu();
                    break;
                case 2:
                    clientOperations.dummyCallOfRating();
                    mainMenu();
                    break;
                default:
                    choiceOptions();
                    break;
            }
        } while (response < 0 || response > 3);
            }

    public void clientFinderMenu() {
        ClientOperations clientOperations = new ClientOperations();
        do {
            printClientFinderMenu();
            skeletonMenu();
            switch (response) {
                case 0:
                    reallyQuitSkeleton();
                    if (wantToQuit.equals("T")) {
                        response = 1;
                        break;
                    } else if (wantToQuit.equals("N"))
                        response = -1;
                    else clientMenu();
                    break;
                case 1:
                    clientOperations.findProviderByLocality();
                    mainMenu();
                    break;
                case 2:
                    clientOperations.findProviderByType();
                    mainMenu();
                    break;
                default:
                    choiceOptions();
                    break;
            }
        } while (response < 0 || response > 2);

    }

    private String reallyQuitSkeleton() {
        System.out.println("Czy na pewno wyjść (T/N)?");
        Scanner scanner1 = new Scanner(System.in);
        wantToQuit = scanner1.nextLine().toUpperCase();
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

    private void choiceOptions() {
        System.out.println("wybierz tylko dostępne opcje: ");
    }

    private void lessPrintlnInPrint() {
        System.out.println("Wybierz opcje:");
        System.out.println("0. Wyjście z programu");
    }

    private void printMainMenu() {
        System.out.println("Menu główne");
        lessPrintlnInPrint();
        System.out.println("1. Panel klienta");
        System.out.println("2. Panel usługodawcy");
    }

    private void printProviderMenu() {
        System.out.println("Menu usługodawcy");
        lessPrintlnInPrint();
        System.out.println("1. Załóż konto");
        System.out.println("2. Edytuj konto");
        System.out.println("3. Usuń konto");
    }

    private void printClientMenu() {
        System.out.println("Menu klienta");
        lessPrintlnInPrint();
        System.out.println("1. Wyszukiwarka");
        System.out.println("2. Ocena dostawcy");
    }

    private void printClientFinderMenu() {
        System.out.println("Szukaj usługodawcy: ");
        lessPrintlnInPrint();
        System.out.println("1. wg miejscowości");
        System.out.println("2. wg rodzaju usługi");
    }
}