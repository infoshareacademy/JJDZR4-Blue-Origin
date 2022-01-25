package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.services.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProviderRestController {

    private ServiceProviderService serviceProviderService;
    private ServiceProviderMapper serviceProviderMapper;

    @Autowired
    public ProviderRestController(ServiceProviderService serviceProviderService, ServiceProviderMapper serviceProviderMapper) {
        this.serviceProviderService = serviceProviderService;
        this.serviceProviderMapper = serviceProviderMapper;
    }

    @GetMapping(value = "/service-provider/search-by-city/{city}")
    public List<ServiceProvider> returnProvidersFoundByCity(@PathVariable String city) {
        return serviceProviderService.findByCity(city);
    }

    @GetMapping(value = "/service-provider/search-by-type/{service}{city}")
    public List<ServiceProvider> returnProvidersFoundByServiceType(@PathVariable String service, String city) {
        return serviceProviderService.findTypeOfService(service, city);
    }

    @GetMapping(value = "/service-provider/search-by-id/{id}")
    public List<ServiceProvider> returnProvidersFoundById(@PathVariable int id) {
        return serviceProviderService.findById(id);
    }
}