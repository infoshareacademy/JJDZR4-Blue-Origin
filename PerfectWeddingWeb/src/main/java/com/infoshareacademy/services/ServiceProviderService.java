package com.infoshareacademy.services;

import com.infoshareacademy.domain.Location;
import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.domain.ServiceType;
import com.infoshareacademy.dto.ServiceAddProviderDto;
import com.infoshareacademy.dto.ServiceEditProviderDto;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.repository.ServiceProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

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

    public ServiceProvider deActivate(Integer id) {
        serviceProviderRepo.getServiceProvidersList().stream()
                .filter(serviceProvider -> serviceProvider.getCurrentID() == id)
                .forEach(serviceProvider -> serviceProvider.setActive(false));
        return null;

    }

    public ServiceProvider editById(Integer id) {
        return serviceProviderRepo.getServiceProvidersList()
                .stream()
                .filter(serviceProvider -> serviceProvider.getCurrentID() == id)
                .findFirst()
                .orElseThrow();
    }

    public void editProvider(ServiceEditProviderDto serviceEditProviderDto) throws IOException {
        ServiceProvider serviceProvider = editById(serviceEditProviderDto.getId());
        serviceProvider.setCompanyName(serviceEditProviderDto.getCompanyName());
        serviceProvider.setOwnerName(serviceEditProviderDto.getOwnerName());
        serviceProvider.setOwnerSurname(serviceEditProviderDto.getOwnerSurname());
        serviceProvider.setPhone(serviceEditProviderDto.getPhone());
        serviceProvider.setEmail(serviceEditProviderDto.getEmail());
        serviceProvider.setWebsiteAddress(serviceEditProviderDto.getWebsiteAddress());
        serviceProvider.setLocation(new Location(serviceEditProviderDto.getCity(), serviceEditProviderDto.getVoivodeship()));
        serviceProvider.setServiceType(new ServiceType(serviceEditProviderDto.getDescription(), serviceEditProviderDto.getPrice(), serviceEditProviderDto.getTypesOfService()));


        // ToDo add more fields allowed to edit; we can also create remaping method in ServiceProviderMapper
        serviceProviderRepo.exportProviders();
    }

    public void exportServiceProviders() {
        try {
            serviceProviderRepo.exportProviders();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addProvider(ServiceAddProviderDto serviceAddProviderDto) throws IOException {
        serviceProviderRepo.getServiceProvidersList().add(serviceProviderMapper.mapperFromAddDto(serviceAddProviderDto));
        serviceProviderRepo.exportProviders();
    }

    //tu pewnie najczytelniejszy bylby switch, ale musialbym sie zastanowic, poki co niech zostanie
    public List<ServiceProvider> findProviders(String typeOfService, String city, LocalDate date, Boolean onlyActive) {
        List<ServiceProvider> toReturn = new ArrayList();
        if (typeOfService.equalsIgnoreCase("WSZYSTKIE")) {
            if (Objects.isNull(date)) {
                toReturn = filterByCity(city);
            } else {
                toReturn = filterByCityAndDate(city, date);
            }
        } else {
            if (Objects.isNull(date)) {
                toReturn = filterByServiceAndCity(typeOfService, city);
            } else {
                toReturn = filterServiceCityAndDate(typeOfService, city, date);
            }
        }
        if (onlyActive) {
            toReturn = toReturn.stream()
                    .filter(sd -> sd.isActive())
                    .toList();
        }
        return toReturn;
    }

    private List<ServiceProvider> filterServiceCityAndDate(String typeOfService, String city, LocalDate date) {
        return serviceProviderRepo.getServiceProvidersList().stream()
                .filter(sp -> sp.getServiceType().getTypesOfService().getFullName().equalsIgnoreCase(typeOfService))
                .filter(sp -> StringUtils.containsIgnoreCase(sp.getLocation().getCity(), city, Locale.ROOT))
                .filter(sp -> sp.getAvailability().getDates().contains(date))
                .toList();
    }

    private List<ServiceProvider> filterByCity(String city) {
        return serviceProviderRepo.getServiceProvidersList().stream()
                .filter(sp -> StringUtils.containsIgnoreCase(sp.getLocation().getCity(), city, Locale.ROOT))
                .toList();
    }

    private List<ServiceProvider> filterByCityAndDate(String city, LocalDate date) {
        return serviceProviderRepo.getServiceProvidersList().stream()
                .filter(sp -> StringUtils.containsIgnoreCase(sp.getLocation().getCity(), city, Locale.ROOT))
                .filter(sp -> sp.getAvailability().getDates().contains(date))
                .toList();
    }

    private List<ServiceProvider> filterByServiceAndCity(String typeOfService, String city) {
        return serviceProviderRepo.getServiceProvidersList().stream()
                .filter(sp -> sp.getServiceType().getTypesOfService().getFullName().equalsIgnoreCase(typeOfService))
                .filter(sp -> StringUtils.containsIgnoreCase(sp.getLocation().getCity(), city, Locale.ROOT))
                .toList();
    }
}
