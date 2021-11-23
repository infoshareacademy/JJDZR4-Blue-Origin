package com.infoshareacademy.model;

public class ServiceType {
    private int ID;
    private String name;
    private String description;
    private float price;
    TypesOfService typesOfService;

    public ServiceType() {
    }

    public ServiceType(String name) {
        this.name = name;
    }

    public TypesOfService getTypesOfService() {
        return typesOfService;
    }

    public void setTypesOfService(TypesOfService typesOfService) {
        this.typesOfService = typesOfService;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ServiceType{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", typesOfService=" + typesOfService +
                '}';
    }
}
