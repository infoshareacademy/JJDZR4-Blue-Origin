package com.infoshareacademy;

import com.infoshareacademy.model.ServiceProvider;

import java.util.ArrayList;
import java.util.List;

// outer class
public class ProviderDataBase {
    List<ServiceProvider> listOfProviders = new ArrayList<>();

    @Override
    public String toString() {
        String toReturn = "";
        for (ServiceProvider provider : listOfProviders) {
            toReturn += provider.toString();
        }
        return toReturn;
    }

    public void addNewProvider(ServiceProvider provider) {
        listOfProviders.add(provider);
    }
}
