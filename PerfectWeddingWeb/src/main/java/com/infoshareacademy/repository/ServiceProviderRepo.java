package com.infoshareacademy.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.infoshareacademy.domain.ServiceProvider;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ServiceProviderRepo {

    private List<ServiceProvider> serviceProvidersList;
    private ObjectMapper allProvidersMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(new JSR310Module());
    private final String pathToRepoForCurrentUser = System.getProperty("user.dir");
    //To sie moze wyjebac na windowsie.
    private File allProvidersFile = new File(pathToRepoForCurrentUser + "/PerfectWeddingWeb/src/main/resources/providers.json");

    public ServiceProviderRepo() {
        this.serviceProvidersList = importProviders();
    }

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
}
