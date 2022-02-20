package com.infoshareacademy.repository;

import com.infoshareacademy.domain.Availability;
import com.infoshareacademy.domain.Rating;
import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.dto.RatingDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class ServiceProviderRepoDB {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveProviders(ServiceProvider serviceProvider) {
//        Availability availability = serviceProvider.getAvailability();
        entityManager.persist(serviceProvider);
//        availability.setServiceProvider(serviceProvider);
    }

    public void addRating(Rating rating) {
        entityManager.persist(rating);

    }
}
