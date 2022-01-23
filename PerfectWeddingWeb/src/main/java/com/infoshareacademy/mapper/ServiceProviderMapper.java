package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.Availability;
import com.infoshareacademy.domain.Location;
import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.domain.ServiceType;
import com.infoshareacademy.dto.ServiceAddProviderDto;
import com.infoshareacademy.dto.ServiceProviderDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ServiceProviderMapper {
    
    
    public ServiceProviderDto mapperToDto(ServiceProvider serviceProvider) {
        ServiceProviderDto serviceProviderDto = new ServiceProviderDto();
        serviceProviderDto.setActive(serviceProvider.isActive());
        serviceProviderDto.setAvailability(serviceProvider.getAvailability());
        serviceProviderDto.setLocation(serviceProvider.getLocation());
        serviceProviderDto.setServiceType(serviceProvider.getServiceType());
        serviceProviderDto.setAverageRating(serviceProvider.getAverageRating());
        serviceProviderDto.setCompanyName(serviceProvider.getCompanyName());
        serviceProviderDto.setEmail(serviceProvider.getEmail());
        serviceProviderDto.setOwnerName(serviceProvider.getOwnerName());
        serviceProviderDto.setOwnerSurname(serviceProvider.getOwnerSurname());
        serviceProviderDto.setPhone(serviceProvider.getPhone());
        serviceProviderDto.setCurrentID(serviceProvider.getCurrentID());
        serviceProviderDto.setWebsiteAddress(serviceProvider.getWebsiteAddress());
        serviceProviderDto.setRatingList(serviceProvider.getRatingList());
        return serviceProviderDto;
    }

    public ServiceProvider mapperFromDto(ServiceProviderDto serviceProviderDto) {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setActive(serviceProviderDto.isActive());
        serviceProvider.setAvailability(serviceProviderDto.getAvailability());
        serviceProvider.setLocation(serviceProviderDto.getLocation());
        serviceProvider.setServiceType(serviceProviderDto.getServiceType());
        serviceProvider.setAverageRating(serviceProviderDto.getAverageRating());
        serviceProvider.setCompanyName(serviceProviderDto.getCompanyName());
        serviceProvider.setEmail(serviceProviderDto.getEmail());
        serviceProvider.setOwnerName(serviceProviderDto.getOwnerName());
        serviceProvider.setOwnerSurname(serviceProviderDto.getOwnerSurname());
        serviceProvider.setPhone(serviceProviderDto.getPhone());
        serviceProvider.setCurrentID(serviceProviderDto.getCurrentID());
        serviceProvider.setWebsiteAddress(serviceProviderDto.getWebsiteAddress());
        serviceProvider.setRatingList(serviceProviderDto.getRatingList());
        return serviceProvider;
    }

    public ServiceProvider mapperFromAddDto(ServiceAddProviderDto serviceAddProviderDto) {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setActive(serviceAddProviderDto.isActive());
        serviceProvider.setAvailability(new Availability(Arrays.asList(serviceAddProviderDto.getAvailability())));
        serviceProvider.setLocation(new Location(serviceAddProviderDto.getCity(), serviceAddProviderDto.getVoivodeship()));
        serviceProvider.setServiceType(new ServiceType(serviceAddProviderDto.getID(), serviceAddProviderDto.getDescription(), serviceAddProviderDto.getPrice(), serviceAddProviderDto.getTypesOfService()));
        serviceProvider.setAverageRating(serviceAddProviderDto.getAverageRating());
        serviceProvider.setCompanyName(serviceAddProviderDto.getCompanyName());
        serviceProvider.setEmail(serviceAddProviderDto.getEmail());
        serviceProvider.setOwnerName(serviceAddProviderDto.getOwnerName());
        serviceProvider.setOwnerSurname(serviceAddProviderDto.getOwnerSurname());
        serviceProvider.setPhone(serviceAddProviderDto.getPhone());
        serviceProvider.setCurrentID(serviceAddProviderDto.getCurrentID());
        serviceProvider.setWebsiteAddress(serviceAddProviderDto.getWebsiteAddress());
        return serviceProvider;
    }
    public ServiceAddProviderDto mapperToAddDto(ServiceProvider serviceProvider){
        ServiceAddProviderDto serviceAddProviderDto = new ServiceAddProviderDto();
        serviceAddProviderDto.setActive(serviceProvider.isActive());
        serviceAddProviderDto.setAvailability(serviceProvider.getAvailability().getDates().get(0));
//        serviceAddProviderDto.setLocation(new Location(serviceAddProviderDto.getCity(), serviceAddProviderDto.getVoivodeship()));
//        serviceAddProviderDto.setServiceType(new ServiceType(serviceAddProviderDto.getID(), serviceAddProviderDto.getDescription(), serviceAddProviderDto.getPrice(), serviceAddProviderDto.getTypesOfService()));
        serviceAddProviderDto.setAverageRating(serviceAddProviderDto.getAverageRating());
        serviceAddProviderDto.setCompanyName(serviceAddProviderDto.getCompanyName());
        serviceAddProviderDto.setEmail(serviceAddProviderDto.getEmail());
        serviceAddProviderDto.setOwnerName(serviceAddProviderDto.getOwnerName());
        serviceAddProviderDto.setOwnerSurname(serviceAddProviderDto.getOwnerSurname());
        serviceAddProviderDto.setPhone(serviceAddProviderDto.getPhone());
        serviceAddProviderDto.setCurrentID(serviceAddProviderDto.getCurrentID());
        serviceAddProviderDto.setWebsiteAddress(serviceAddProviderDto.getWebsiteAddress());
        return serviceAddProviderDto;
    }

}
