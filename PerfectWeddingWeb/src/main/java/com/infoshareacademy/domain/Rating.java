package com.infoshareacademy.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Getter
@Setter
@Table(name = Location.TABLE_NAME)
public class Rating {

    public static final String TABLE_NAME = "rating";
    public static final String COLUMN_PREFIX = "r_";

    @Id
    @GeneratedValue
    @Column(name = COLUMN_PREFIX + "id")
    private int id;

    @Column(name = COLUMN_PREFIX + "rating", nullable = false)
    private int rating;

    @Column(name = COLUMN_PREFIX + "comment", nullable = false)
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
