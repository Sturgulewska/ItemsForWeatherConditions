package com.ClothesForWeatherConditions.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OpenWeatherPlDto {

    @JsonProperty("main")
    private String main;

    @JsonProperty("description")
    private String description;
}
