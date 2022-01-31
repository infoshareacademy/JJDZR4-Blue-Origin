package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.dto.ServiceProviderSearchDto;
import com.infoshareacademy.dto.ServiceSearchProviderRestDto;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.services.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping(value = "/service-provider/find")
    public List<ServiceProvider> returnFoundProvidersActive(@RequestBody ServiceSearchProviderRestDto serviceSearchProviderRestDto) {
        return serviceProviderService.findProviders(serviceSearchProviderRestDto.getServiceType(), serviceSearchProviderRestDto.getCity(), serviceSearchProviderRestDto.getDate(), serviceSearchProviderRestDto.isActive());
    }
}