package com.infoshareacademy.repository;

import com.infoshareacademy.domain.ServiceProvider;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


@Repository
@Transactional
public class ServiceProviderRepoDB {

    private ServiceProviderCRUD serviceProviderCRUD;

    public ServiceProviderRepoDB(ServiceProviderCRUD serviceProviderCRUD) {
        this.serviceProviderCRUD = serviceProviderCRUD;
    }

    public void saveProviders(ServiceProvider serviceProvider) {
        serviceProviderCRUD.save(serviceProvider);
    }

    public List<ServiceProvider> returnAllProviders() {
        return serviceProviderCRUD.findAll();
    }

    public List<ServiceProvider> returnByLocationAndAvailability(String city, LocalDate availabilityDate) {
        return serviceProviderCRUD.findAllByLocation_CityAndAvailability_Dates(city, availabilityDate);
    }

    public List<ServiceProvider> returnByLocation(String city) {
        return serviceProviderCRUD.findAllByLocation_City(city);
    }

    public List<ServiceProvider> returnByAvailability(LocalDate availabilityDate) {
        return serviceProviderCRUD.findAllByAvailability_Dates(availabilityDate);
    }

}
