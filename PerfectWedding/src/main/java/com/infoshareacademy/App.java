package com.infoshareacademy;


public class App
{
    public static ProviderDataBase providerDataBase = new ProviderDataBase();
    public static void main( String[] args )
    {
        PerfectWeddingUtils.printWelcomeLogo();
        providerDataBase.readProviderListFromFile();
        //below line just for testing purposes to eb removed later
        System.out.println(providerDataBase);
        Menu menu = new Menu();
        menu.mainMenu();
        providerDataBase.addProviderListToFile();
    }
}
