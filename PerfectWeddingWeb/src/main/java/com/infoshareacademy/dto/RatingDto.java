package com.infoshareacademy.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor

@Getter
@Setter
public class RatingDto {
    private int ID;
    private int rating;
    private String comment;
    private String companyName;

    public RatingDto() {
    }

}
