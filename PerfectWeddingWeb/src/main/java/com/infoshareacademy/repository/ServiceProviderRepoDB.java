package com.infoshareacademy.repository;

import com.infoshareacademy.domain.ServiceProvider;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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

}
