package com.infoshareacademy.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = ServiceType.TABLE_NAME)

public class ServiceType {

    public static final String TABLE_NAME = "service_type";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String description;
    private String price;

    @JsonBackReference
    @OneToOne(mappedBy = "serviceType")
    private ServiceProvider serviceProvider;

    @Enumerated(value = EnumType.STRING)
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
