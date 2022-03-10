package com.infoshareacademy.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.dto.ServiceSearchProviderRestDto;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.services.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/service-provider/find")
    public List<ServiceProvider> returnFoundProvidersActive(@RequestBody ServiceSearchProviderRestDto serviceSearchProviderRestDto) {
        return serviceProviderService.findProviders(serviceSearchProviderRestDto.getServiceType(), serviceSearchProviderRestDto.getCity(), serviceSearchProviderRestDto.getDate(), serviceSearchProviderRestDto.getIsActive());
    }

    @GetMapping(value = "/service-provider/get/{id}")
    public ServiceProvider getProviderData(@PathVariable Integer id) {
        return serviceProviderService.getProviderData(id);
    }

    @GetMapping(value = "/service-provider/find/{id}")
    public ServiceProvider findById(@PathVariable Integer id) {
        return serviceProviderService.findById(id);
    }
    @Secured("ROLE_USER")
    @PostMapping(value = "/service-provider/add/availability")
    public void addAvailabilityToProvider(@RequestBody ObjectNode objectNode) {
        String availabilityDate = objectNode.get("availabilityDate").asText();
        int id = objectNode.get("id").asInt();
        serviceProviderService.addAvailabilityDateToProvider(availabilityDate, id);
    }
    @Secured("ROLE_USER")
    @GetMapping(value = "/service-provider/remove/availability/{providerId}/{dateIndex}")
    public void removeAvailabilityFromProvider(@PathVariable int providerId, @PathVariable int dateIndex) {
        serviceProviderService.removeAvailabilityDateFromProvider(providerId, dateIndex);
    }
}