package com.infoshareacademy.services;

import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.dto.ServiceAddProviderDto;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.repository.ServiceProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<ServiceProvider> findById(Integer id) {
        return serviceProviderRepo.getServiceProvidersList()
                .stream()
                .filter(serviceProvider -> serviceProvider.getCurrentID() == id)
                .collect(Collectors.toList());
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


    public List<ServiceProvider> findByCityAndTypeOfService(String typeOfService, String city, LocalDate date) {
        List<ServiceProvider> toReturn = new ArrayList<>();
        List<ServiceProvider> filteredByTypeAndCity = new ArrayList<>();
        //filtrujemy po nazwie miasta - dziala
        filteredByTypeAndCity = serviceProviderRepo.getServiceProvidersList()
                .stream()
                .filter(serviceProvider -> StringUtils.containsIgnoreCase(serviceProvider.getLocation().getCity(), city, Locale.ROOT))
                //zamienilem collect(Collectors.toList()) na toList z JAVA 16
                .toList();
        if (!typeOfService.equals("All")) {
            filteredByTypeAndCity
                    .stream()
                    //rozumiem, ze ponizsze ma nas chronic przed null pointer exception
                    .filter(serviceProvider -> Objects.nonNull(serviceProvider.getServiceType()))
                    //TODO: te 2 linie sa chyba niepotrzebne?:
                    .toList()
                    .stream()
                    //TODO: ten filtr nie dziala - przepuszcza wszystko
                    .filter(serviceProvider -> serviceProvider.getServiceType().getTypesOfService().getFullName().equals(typeOfService))
                    .toList();
            //TODO: ponisza petla na pewno moze zostac zastapiona filtrem - tylko, ze filtr nie dziala patrz linia 75
            for (ServiceProvider serviceProvider : filteredByTypeAndCity) {
                String typeCheck = serviceProvider.getServiceType().getTypesOfService().getFullName();
                if (typeCheck.equals(typeOfService)) {
                    toReturn.add(serviceProvider);
                }
            }
            filteredByTypeAndCity = toReturn.stream().toList();
            toReturn.clear();
        }
        if (!Objects.isNull(date)) {
            //TODO: i ta petla tez pewnie moze zostac wywalona i zastapinoan przez stream
            for (ServiceProvider serviceProvider : filteredByTypeAndCity) {
                Integer datesCheck = serviceProvider.getAvailability().getDates()
                        .stream()
                        .filter(domainDate -> Objects.nonNull(domainDate))
                        //TODO: te 2 linie sa chyba niepotrzebne?:
                        .toList()
                        .stream()
                        .filter(domainDate -> domainDate.equals(date))
                        .toList().size();
                if (datesCheck > 0) {
                    toReturn.add(serviceProvider);
                }
            }
            filteredByTypeAndCity = toReturn;
        }
        return filteredByTypeAndCity;
    }
}
