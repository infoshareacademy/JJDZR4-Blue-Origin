package com.infoshareacademy.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = ServiceType.TABLE_NAME)

public class ServiceType {

    public static final String TABLE_NAME = "service_type";

    @Id
    @GeneratedValue
    private int ID;

    private String description;
    private String price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_provider_id")
    private ServiceProvider serviceProvider;

    private TypesOfService typesOfService;

    public ServiceType(int ID, String description, String price, TypesOfService typesOfService) {
        this.ID = ID;
        this.description = description;
        this.price = price;
        this.typesOfService = typesOfService;
    }

    public ServiceType(String description, String price, TypesOfService typesOfService) {
        this.description = description;
        this.price = price;
        this.typesOfService = typesOfService;
    }

    public TypesOfService getTypesOfService() {
        return typesOfService;
    }

    @Override
    public String toString() {
        return "ServiceType{" +
                "ID=" + ID +
                ", typesOfService=" + typesOfService +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
