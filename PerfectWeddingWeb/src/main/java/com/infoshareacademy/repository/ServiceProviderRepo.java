package com.infoshareacademy.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.infoshareacademy.domain.ServiceProvider;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// TODO Ta klasa będzie do zaorania jak się wszystko przepnie na ServiceProviderRepoDB

@Repository
public class ServiceProviderRepo {

    public List<ServiceProvider> serviceProvidersList;
    private ObjectMapper allProvidersMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(new JavaTimeModule());
    private final String pathToRepoForCurrentUser = System.getProperty("user.dir");
    private File allProvidersFile = new File(pathToRepoForCurrentUser + "/PerfectWeddingWeb/src/main/resources/providers.json");

//    public ServiceProviderRepo() {
//        this.serviceProvidersList = importProviders();
//    }

    public List<ServiceProvider> importProviders() {
        var allProviders = new ArrayList<ServiceProvider>();
        try {
            allProviders = allProvidersMapper.readValue(allProvidersFile, new TypeReference<>() {});
        } catch (Exception e) {
            System.out.println("Something went wrong during importing the file.");
            e.printStackTrace();
        }
        return allProviders;
    }

    public List<ServiceProvider> getServiceProvidersList() {
        return serviceProvidersList;
    }

    public void exportProviders() throws IOException {
        for (int i = 0; i < serviceProvidersList.size(); i++) {
            serviceProvidersList.get(i).getAvailability().sortDates(serviceProvidersList.get(i).getAvailability().getDates());
        }
        allProvidersMapper.writerWithDefaultPrettyPrinter().writeValue(allProvidersFile, serviceProvidersList);
    }
}
