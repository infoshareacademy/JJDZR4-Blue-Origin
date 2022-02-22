package com.infoshareacademy.services;

import com.infoshareacademy.domain.Location;
import com.infoshareacademy.domain.Rating;
import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.domain.ServiceType;
import com.infoshareacademy.dto.RatingDto;
import com.infoshareacademy.dto.ServiceAddProviderDto;
import com.infoshareacademy.dto.ServiceEditProviderDto;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.repository.ServiceProviderRepo;
import com.infoshareacademy.repository.ServiceProviderRepoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
        return serviceProviderRepo.getServiceProvidersList();
    }

    public ServiceProvider deActivate(Integer id) {
        serviceProviderRepo.getServiceProvidersList().stream()
                .filter(serviceProvider -> serviceProvider.getCurrentID() == id)
                .forEach(serviceProvider -> serviceProvider.setActive(false));
        return null;
    }

    public ServiceProvider findById(Integer id) {
        return serviceProviderRepo.getServiceProvidersList()
                .stream()
                .filter(serviceProvider -> serviceProvider.getCurrentID() == id)
                .findFirst()
                .orElseThrow();
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
        return serviceProviderRepo.getServiceProvidersList().get(id);
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
        ServiceProvider serviceProvider = serviceProviderMapper.mapperFromAddDto(serviceAddProviderDto);
//        serviceProviderRepo.getServiceProvidersList().add(serviceProvider);
//        serviceProviderRepo.exportProviders();
        serviceProviderRepoDB.saveProviders(serviceProvider);
    }


    public List<ServiceProvider> findProviders(String typeOfService, String city, LocalDate date, boolean onlyActive) {
        List<ServiceProvider> filteredList = new ArrayList();
        switch (typeOfService) {
            case "WSZYSTKIE":
                if (Objects.nonNull(date) && Objects.nonNull(city)) {
                    filteredList = filterByCityAndDate(city, date);
                }
                if (Objects.nonNull(city)) {
                    filteredList = filterByCity(city);
                }
                if (Objects.nonNull(date)) {
                    filteredList = filterByDate(date);
                }
                break;
            default:
                if (Objects.nonNull(date) && Objects.nonNull(city)) {
                    filteredList = filterServiceCityAndDate(typeOfService, city, date);
                }
                if (Objects.nonNull(city)) {
                    filteredList = filterByServiceAndCity(typeOfService, city);
                }
                if (Objects.nonNull(date)) {
                    filteredList = filterByDateAndServiceType(date, typeOfService);
                }
                break;
        }

        if (onlyActive) {
            return filteredList.stream().filter(sd -> sd.isActive()).toList();
        }
        return filteredList;
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

    private List<ServiceProvider> filterByDate(LocalDate date) {
        return serviceProviderRepo.getServiceProvidersList().stream()
                .filter(sp -> sp.getAvailability().getDates().contains(date))
                .toList();
    }

    private List<ServiceProvider> filterByDateAndServiceType(LocalDate date, String typeOfService) {
        return serviceProviderRepo.getServiceProvidersList().stream()
                .filter(sp -> sp.getServiceType().getTypesOfService().getFullName().equalsIgnoreCase(typeOfService))
                .filter(sp -> sp.getAvailability().getDates().contains(date))
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

    public void addRatingToProvider(RatingDto rating) {
        ServiceProvider serviceProvider = findById(rating.getID());
        serviceProvider.addRating(new Rating(rating.getRating(), rating.getComment()));
    }
}
