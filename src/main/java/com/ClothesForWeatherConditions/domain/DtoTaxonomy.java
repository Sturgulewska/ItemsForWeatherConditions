package com.ClothesForWeatherConditions.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class DtoTaxonomy {

    // link https://api.etsy.com/v2/taxonomy/buyer/get?api_key=whk7wsv42qjexu3cmsizdyq8
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "path")
    private String path;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "children")
    private ArrayList<DtoTaxonomy> children;
}
