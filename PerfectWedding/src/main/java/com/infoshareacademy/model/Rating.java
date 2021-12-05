package com.infoshareacademy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Rating {
    private int rating;
    private String comment;

    public Rating() {
    }

    public Rating(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }


    @Override
    public String toString() {
        return "Rating{" +
                "rating=" + rating +
                ", Comment='" + comment + '\'' +
                '}';
    }
}
