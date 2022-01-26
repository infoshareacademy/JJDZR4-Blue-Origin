package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.services.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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

    @GetMapping(value = "/service-provider/search-by-type-city-and-date/{service}/{city}/{date}")
    public List<ServiceProvider> returnProvidersFoundByServiceTypeAndCity(@PathVariable String service, @PathVariable String city, @PathVariable LocalDate date) {
        return serviceProviderService.findByCityAndTypeOfService(service, city, date);
    }

    @GetMapping(value = "/service-provider/search-by-id/{id}")
    public List<ServiceProvider> returnProvidersFoundById(@PathVariable int id) {
        return serviceProviderService.findById(id);
    }
}