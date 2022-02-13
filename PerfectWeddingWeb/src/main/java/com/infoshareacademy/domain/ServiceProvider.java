package com.infoshareacademy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = ServiceProvider.TABLE_NAME)

public class ServiceProvider {

    public static final String TABLE_NAME = "service_provider";
    public static final String COLUMN_PREFIX = "s_";

    public static int incrementalID;
    double averageRating;

    @Id
    @GeneratedValue
    @Column(name = COLUMN_PREFIX + "id")
    private int currentID;
    private String companyName;
    private String ownerName;
    private String ownerSurname;
    private String phone;
    private String email;
    private String websiteAddress;

    @OneToOne(mappedBy = "serviceProvider", fetch = FetchType.LAZY)
    private Location location;

    @OneToOne(mappedBy = "serviceProvider", fetch = FetchType.LAZY)
    private ServiceType serviceType;

    @OneToOne(mappedBy = "serviceProvider", fetch = FetchType.LAZY)
    private Availability availability;

    private boolean isActive;

    @OneToMany(mappedBy = "serviceProvider", fetch = FetchType.LAZY)
    private List<Rating> ratingList = new ArrayList<>();

    public double getAverageRating() {
        if (Objects.isNull(ratingList)) {
            return 0;
        }
        double sum = 0;
        for (Rating rating : ratingList) {
            sum += rating.getRating();
        }
        if (ratingList.size() > 0) {
            Double averageRating = sum / ratingList.size();
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(averageRating));

        } else {
            return -1; //returns -1 if no rating has been done so far
        }
    }

    @Override
    public String toString() {
        return "ServiceProvider{" +
                "ID=" + currentID +
                ", companyName='" + companyName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerSurname='" + ownerSurname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", websiteAddress='" + websiteAddress + '\'' +
                ", location=" + location.getCity() + '\'' +
                ", serviceType=" + serviceType.getTypesOfService() + '\'' +
                ", availability=\n" + availability + '\n' +
                ", rating=\n" + ratingList + '\n' +
                ", isActive=" + isActive +
                "}\n";
    }


    public String toStringVertical() {
        return
                "\n ID: " + currentID
                        + "\n companyName: " + companyName
                        + "\n ownerName: " + ownerName
                        + "\n ownerSurname: " + ownerSurname
                        + "\n phone: " + phone
                        + "\n email: " + email
                        + "\n websiteAddress: " + websiteAddress
                        + "\n   voivodeship: " + location.getVoivodeship()
                        + "\n   locality: " + location.getCity()
                        + "\n   name: " + serviceType.getTypesOfService()
                        + "\n   description: " + serviceType.getDescription()
                        + "\n   price: " + serviceType.getPrice()
                        + "\n availability: " + availability
                        + "\n rating: " + ratingList
                        + "\n isActive: " + isActive
                        + "\n";

    }
    public void addRating (Rating rating) {
        ratingList.add(rating);
    }

}
