package com.infoshareacademy.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceType {
    private int ID;
    private String description;
    private String price;
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

    public ServiceType() {
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
