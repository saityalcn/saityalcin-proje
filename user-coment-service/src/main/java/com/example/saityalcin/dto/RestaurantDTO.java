package com.example.saityalcin.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantDTO {
    private Double rating;
    private Double latitude;
    private Double longitude;
    private Double score;
}
