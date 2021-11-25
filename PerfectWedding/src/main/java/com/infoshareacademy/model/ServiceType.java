package com.infoshareacademy.model;

public class ServiceType {
    private int ID;
    private String description;
    private String price;
    TypesOfService typesOfService;

    public ServiceType() {
    }

    public String getPrice() {
        return price;
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

       public void setPrice(String price) {
        this.price = price;
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
