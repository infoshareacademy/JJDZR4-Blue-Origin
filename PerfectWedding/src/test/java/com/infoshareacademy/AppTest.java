package com.infoshareacademy;

import com.infoshareacademy.model.Availability;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.ServiceProvider;
import com.infoshareacademy.model.ServiceType;
import org.junit.Test;

import java.time.LocalDate;

public class AppTest {

    @Test
    public void deserializeServiceProvider() {
        ProviderDataBase providerDataBase = new ProviderDataBase();
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setLocation(new Location());
        serviceProvider.setServiceType(new ServiceType());
        var availability = new Availability();
        availability.addNewAvailability(LocalDate.now());
        serviceProvider.setAvailability(availability);
        providerDataBase.addNewProvider(serviceProvider);

        providerDataBase.addProviderListToFile();

        providerDataBase.readProviderListFromFile();
        providerDataBase.getListOfProviders().forEach(System.out::println);
    }
}
