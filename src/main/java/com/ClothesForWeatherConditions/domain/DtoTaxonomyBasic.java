package com.ClothesForWeatherConditions.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class DtoTaxonomyBasic {

    @JsonProperty(value = "count")
    private Integer count;

    @JsonProperty(value = "results")
    private ArrayList<DtoTaxonomy> taxonomyList;
}
