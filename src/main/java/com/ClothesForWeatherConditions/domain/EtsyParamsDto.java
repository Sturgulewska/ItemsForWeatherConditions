package com.ClothesForWeatherConditions.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EtsyParamsDto {

    @JsonProperty("min_price")
    private Float minPrice;

    @JsonProperty("max_price")
    private Float maxPrice;

    @JsonProperty("color")
    private String color;

    @JsonProperty("location")
    private String location;

    @JsonProperty("region")
    private String region;

}
