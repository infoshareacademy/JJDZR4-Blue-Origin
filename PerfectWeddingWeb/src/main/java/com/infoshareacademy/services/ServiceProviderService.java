package com.infoshareacademy.services;

import com.infoshareacademy.domain.*;
import com.infoshareacademy.dto.RatingDto;
import com.infoshareacademy.dto.ServiceAddProviderDto;
import com.infoshareacademy.dto.ServiceEditProviderDto;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.repository.ServiceProviderRepo;
import com.infoshareacademy.repository.ServiceProviderRepoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ServiceProviderService {

    private ServiceProviderRepo serviceProviderRepo;
    private ServiceProviderMapper serviceProviderMapper;
    private ServiceProviderRepoDB serviceProviderRepoDB;

    @Autowired
    public ServiceProviderService(ServiceProviderRepo serviceProviderRepo, ServiceProviderMapper serviceProviderMapper, ServiceProviderRepoDB serviceProviderRepoDB) {
        this.serviceProviderRepo = serviceProviderRepo;
        this.serviceProviderMapper = serviceProviderMapper;
        this.serviceProviderRepoDB = serviceProviderRepoDB;
    }

    public List<ServiceProvider> returnAllServiceProviders() {
//        return serviceProviderRepo.getServiceProvidersList();
        return serviceProviderRepoDB.returnAllProviders();
    }

    public ServiceProvider deActivate(Integer id) {
        serviceProviderRepoDB.returnAllProviders().stream()
                .filter(serviceProvider -> serviceProvider.getCurrentID() == id)
                .forEach(serviceProvider -> serviceProvider.setActive(false));
        return null;
    }

    public ServiceProvider findById(Integer id) {
        return serviceProviderRepoDB.returnProviderById(id);
    }

    public void addAvailabilityDateToProvider(String availabilityDate, Integer id) {
        ServiceProvider serviceProvider = findById(id);
        serviceProvider.getAvailability().addNewAvailability(LocalDate.parse(availabilityDate));
    }

    public void removeAvailabilityDateFromProvider(Integer providerId, int dateIndex) {
        ServiceProvider serviceProvider = findById(providerId);
        serviceProvider.getAvailability().removeAvailability(dateIndex);
    }

    public ServiceProvider getProviderData(Integer id) {
        return serviceProviderRepoDB.returnAllProviders().get(id);
    }

    public void editProvider(ServiceEditProviderDto serviceEditProviderDto) throws IOException {
        ServiceProvider serviceProvider = findById(serviceEditProviderDto.getId());
        serviceProvider.setCompanyName(serviceEditProviderDto.getCompanyName());
        serviceProvider.setOwnerName(serviceEditProviderDto.getOwnerName());
        serviceProvider.setOwnerSurname(serviceEditProviderDto.getOwnerSurname());
        serviceProvider.setPhone(serviceEditProviderDto.getPhone());
        serviceProvider.setEmail(serviceEditProviderDto.getEmail());
        serviceProvider.setWebsiteAddress(serviceEditProviderDto.getWebsiteAddress());
        serviceProvider.setLocation(new Location(serviceEditProviderDto.getCity(), serviceEditProviderDto.getVoivodeship()));
        serviceProvider.setServiceType(new ServiceType(serviceEditProviderDto.getDescription(), serviceEditProviderDto.getPrice(), serviceEditProviderDto.getTypesOfService()));

    }

    public void addProvider(ServiceAddProviderDto serviceAddProviderDto) throws IOException {
        ServiceProvider serviceProvider = serviceProviderMapper.mapperFromAddDto(serviceAddProviderDto);
        serviceProviderRepoDB.saveProviders(serviceProvider);
    }


    public List<ServiceProvider> findProviders(String typeOfService, String city, LocalDate date, boolean onlyActive) {
        List<ServiceProvider> filteredList = new ArrayList();
        switch (typeOfService) {
            case "WSZYSTKIE":
                if (Objects.nonNull(date) && Objects.nonNull(city) && !city.isEmpty()) {
                    filteredList = serviceProviderRepoDB.returnByLocationAndAvailability(city, date);
                    break;
                }
                if (Objects.nonNull(city) && !city.isEmpty()) {
                    filteredList = serviceProviderRepoDB.returnByLocation(city);
                    break;
                }
                if (Objects.nonNull(date)) {
                    filteredList = serviceProviderRepoDB.returnByAvailability(date);
                    break;
                }
                if (city.isEmpty() && Objects.isNull(date)) {
                    filteredList = serviceProviderRepoDB.returnAllProviders();
                    break;
                }
                break;
            default:
                if (Objects.nonNull(date) && Objects.nonNull(city) && !city.isEmpty()) {
                    filteredList = serviceProviderRepoDB.returnByTypeOfServiceAndCityAndAvailability(TypesOfService.valueOf(typeOfService), city, date);
                    break;
                }
                if (Objects.nonNull(city) && !city.isEmpty()) {
                    filteredList = serviceProviderRepoDB.returnByTypeOfServiceAndCity(TypesOfService.valueOf(typeOfService), city);
                    break;
                }
                if (Objects.nonNull(date)) {
                    filteredList = serviceProviderRepoDB.returnByTypeOfServiceAndAvailability(TypesOfService.valueOf(typeOfService), date);
                }
                if (city.isEmpty() && Objects.isNull(date)) {
                    filteredList = serviceProviderRepoDB.returnAllByServiceType(TypesOfService.valueOf(typeOfService));
                    break;
                }
                break;
        }

        if (onlyActive) {
            return filteredList.stream().filter(sd -> sd.isActive()).toList();
        }
        return filteredList;
    }

    public void addRatingToProvider(RatingDto rating) {
        ServiceProvider serviceProvider = findById(rating.getID());
        serviceProvider.addRating(new Rating(rating.getRating(), rating.getComment(), serviceProvider));
    }
}
