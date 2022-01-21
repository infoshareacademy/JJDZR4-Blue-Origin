package com.infoshareacademy.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Rating {
    private int rating;
    private String comment;

    public Rating() {
    }

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
