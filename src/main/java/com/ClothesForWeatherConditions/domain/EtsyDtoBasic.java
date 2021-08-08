package com.ClothesForWeatherConditions.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Getter
//@AllArgsConstructor
@NoArgsConstructor
public class EtsyDtoBasic {

    @JsonProperty("count")
    private Long count;

    @JsonProperty("results")
    private ArrayList<EtsyResultsDto> etsyResultsDtoList;

    @JsonProperty("params")
    private EtsyParamsDto etsyParamsDto;

    @JsonProperty("type")
    private String type;


}
