package com.ClothesForWeatherConditions.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OpenWeatherDtoBasic {

    @JsonProperty("lat")
    private Float lat;

    @JsonProperty("lon")
    private Float lon;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("current")
    private OpenCurrentDto openCurrentDto;

}


