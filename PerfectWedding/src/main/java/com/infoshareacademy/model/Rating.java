package com.infoshareacademy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Rating {
    private int rating;
    private String Comment;

    public Rating() {
    }

    public Rating(int rating) {
        this.rating = rating;
    }

    public Rating(int rating, String comment) {
        this.rating = rating;
        Comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return Comment;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "rating=" + rating +
                ", Comment='" + Comment + '\'' +
                '}';
    }
}
