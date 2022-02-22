package com.infoshareacademy.repository;

import com.infoshareacademy.domain.Availability;
import com.infoshareacademy.domain.Rating;
import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.dto.RatingDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class ServiceProviderRepoDB {

    @PersistenceContext
    private EntityManager entityManager;
    private ServiceProviderCRUD serviceProviderCRUD;

    public ServiceProviderRepoDB(ServiceProviderCRUD serviceProviderCRUD) {
        this.serviceProviderCRUD = serviceProviderCRUD;
    }

    public void saveProviders(ServiceProvider serviceProvider) {
//        Availability availability = serviceProvider.getAvailability();
        entityManager.persist(serviceProvider);
//        availability.setServiceProvider(serviceProvider);
    }

    public List<ServiceProvider> returnAllProviders() {
        return serviceProviderCRUD.findAll();
    }

    public void addRating(Rating rating) {
        entityManager.persist(rating);
    }
}
