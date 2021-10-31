package com.infoshareacademy;


public class App
{
    public static ProviderDataBase providerDataBase = new ProviderDataBase();
    public static void main( String[] args )
    {
        PerfectWeddingUtils.printWelcomeLogo();
        providerDataBase.readProviderListFromFile();
        Menu menu = new Menu();
        menu.mainMenu();
        providerDataBase.addProviderListToFile();
    }
}
