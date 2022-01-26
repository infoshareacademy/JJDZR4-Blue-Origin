package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.dto.ServiceSearchProviderDto;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.services.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //duzo zaszllo zmian w filrowaniu i trzeba to przerobic, nie wyrzucajcie klasy bo ja uzywam sobie jej do testowania w POSTMANIE

//    @GetMapping(value = "/service-provider/search-by-type-city-and-date/{service}/{city}/{date}")
//    public List<ServiceProvider> returnProvidersFoundByServiceTypeAndCity(@PathVariable String service, @PathVariable String city, @PathVariable LocalDate date) {
//        return serviceProviderService.findByCityAndTypeOfService(service, city, date);
//    }

//    @PostMapping(value = "/service-provider/search-by-type-city-and-date/{service}/{city}/{date}")
//    public List<ServiceProvider> returnProvidersFoundByServiceTypeAndCity(@RequestBody ServiceSearchProviderDto serviceSearchProviderDto) {
//        return serviceProviderService.findByCityAndTypeOfService(serviceSearchProviderDto);
//    }

//    @GetMapping(value = "/service-provider/search-by-id/{id}")
//    public List<ServiceProvider> returnProvidersFoundById(@PathVariable int id) {
//        return serviceProviderService.findById(id);
//    }
}