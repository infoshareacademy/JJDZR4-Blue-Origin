package com.infoshareacademy;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.model.ServiceProvider;

import java.io.File;
import java.io.IOException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

// outer class
public class ProviderDataBase {
    List<ServiceProvider> listOfProviders = new ArrayList<>();

    @Override
    public String toString() {
        String toReturn = "";
        for (ServiceProvider provider : listOfProviders) {
            toReturn += provider.toString() + "\n";
        }
        return toReturn;
    }

    public List<ServiceProvider> getListOfProviders() {

        return listOfProviders;
    }

    public void addNewProvider(ServiceProvider provider) {
        listOfProviders.add(provider);
    }

    public void addProviderListToFile(){
        ObjectMapper mapper = new ObjectMapper();
    String path = "src/main/resources/providers.json";
        try {
            mapper.writeValue(new File(path), listOfProviders);
        } catch (IOException e) {
            e.printStackTrace();
        }    }

        public void readProviderListFromFile(){
        ObjectMapper mapper = new ObjectMapper();
    String path = "src/main/resources/providers.json";
            try {
                mapper.readValue(new File(path), List.class);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

}
