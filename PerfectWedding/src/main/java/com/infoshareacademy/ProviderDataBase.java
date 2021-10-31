package com.infoshareacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.infoshareacademy.model.ServiceProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// outer class
public class ProviderDataBase {

    private static final String PROVIDERS_PATH = System.getProperty("user.dir") + "/src/resources/providers.json";
    private final ObjectMapper mapper;

    List<ServiceProvider> listOfProviders;


    public ProviderDataBase() {
        this.listOfProviders = new ArrayList<>();
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public List<ServiceProvider> getListOfProviders() {
        return listOfProviders;
    }

    public void addNewProvider(ServiceProvider provider) {
        listOfProviders.add(provider);
    }

    public void addProviderListToFile() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(PROVIDERS_PATH), listOfProviders);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readProviderListFromFile() {
        try {
            listOfProviders = mapper.readValue(new File(PROVIDERS_PATH), new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (ServiceProvider provider : listOfProviders) {
            toReturn += provider.toString() + "\n";
        }
        return toReturn;
    }

}
