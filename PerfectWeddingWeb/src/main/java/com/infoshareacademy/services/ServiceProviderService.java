package com.infoshareacademy.services;

import com.infoshareacademy.repository.ServiceProvider;
import com.infoshareacademy.repository.ServiceProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProviderService {

    private ServiceProviderRepo serviceProviderRepo;

    @Autowired
    public ServiceProviderService(ServiceProviderRepo serviceProviderRepo) {
        this.serviceProviderRepo = serviceProviderRepo;
    }

    public List<ServiceProvider> returnAllServiceProviders() {
        return serviceProviderRepo.getServiceProvidersList();
    }
}
