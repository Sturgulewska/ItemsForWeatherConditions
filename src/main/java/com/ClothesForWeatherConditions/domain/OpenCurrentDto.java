package com.ClothesForWeatherConditions.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OpenCurrentDto {
    @JsonProperty("temp")
    private Float temp;

    @JsonProperty("feels_like")
    private Float feelsLike;

    @JsonProperty("clouds")
    private Float clouds;

    @JsonProperty("wind_speed")
    private Float windSpeed;

    @JsonProperty("weather")
    private OpenWeatherPlDto weatherPlDto;
}
