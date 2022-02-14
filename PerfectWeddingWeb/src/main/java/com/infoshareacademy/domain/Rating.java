package com.infoshareacademy.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = Rating.TABLE_NAME)
public class Rating {

    public static final String TABLE_NAME = "rating";

    @Id
    @GeneratedValue
    private int id;

    private int rating;
    private String comment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_provider_id")
    private ServiceProvider serviceProvider;

    public Rating(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "Rating{" +
                "rating=" + rating +
                ", Comment='" + comment + '\'' +
                '}';
    }
}
