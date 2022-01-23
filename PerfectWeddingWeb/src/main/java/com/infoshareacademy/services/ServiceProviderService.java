package com.infoshareacademy.services;

import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.dto.ServiceAddProviderDto;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.repository.ServiceProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ServiceProviderService {

    private ServiceProviderRepo serviceProviderRepo;
    private ServiceProviderMapper serviceProviderMapper;

    @Autowired
    public ServiceProviderService(ServiceProviderRepo serviceProviderRepo, ServiceProviderMapper serviceProviderMapper) {
        this.serviceProviderRepo = serviceProviderRepo;
        this.serviceProviderMapper = serviceProviderMapper;

    }


    public List<ServiceProvider> returnAllServiceProviders() {
        return serviceProviderRepo.getServiceProvidersList();
    }

    public void exportServiceProviders() {
        try {
            serviceProviderRepo.exportProviders();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addProvider(ServiceAddProviderDto serviceAddProviderDto) throws IOException {
        serviceProviderRepo.getServiceProvidersList()
                .add(serviceProviderMapper.mapperFromAddDto(serviceAddProviderDto));
        serviceProviderRepo.exportProviders();
    }

    public List<ServiceProvider> findByCity(String city) {
        return serviceProviderRepo.getServiceProvidersList()
                .stream()
                .filter(serviceProvider -> StringUtils.containsIgnoreCase(serviceProvider.getLocation().getCity(), city, Locale.ROOT))
                .collect(Collectors.toList());
    }

//    public List<ServiceProvider> findTypeOfService(String typeOfService) {
//        return serviceProviderRepo.getServiceProvidersList()
//                .stream()
//                .filter(serviceProvider -> serviceProvider.getServiceType().getTypesOfService().getFullName().equals(typeOfService))
//                .collect(Collectors.toList());
//    }

    public List<ServiceProvider> findTypeOfService(String typeOfService) {
        return serviceProviderRepo.getServiceProvidersList()
                .stream()
                .filter(serviceProvider -> Objects.nonNull(serviceProvider.getServiceType()))
                .collect(Collectors.toList()).stream()
                .filter(serviceProvider -> serviceProvider.getServiceType().getTypesOfService().getFullName().equals(typeOfService))
                .collect(Collectors.toList());
    }
}
