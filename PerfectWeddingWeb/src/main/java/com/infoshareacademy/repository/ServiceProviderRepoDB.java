package com.infoshareacademy.repository;

import com.infoshareacademy.domain.ServiceProvider;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ServiceProviderRepoDB {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveProviders(ServiceProvider serviceProvider) {
        entityManager.merge(serviceProvider);
    }
}
