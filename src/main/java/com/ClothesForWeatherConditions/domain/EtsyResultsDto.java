package com.ClothesForWeatherConditions.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EtsyResultsDto {

    @JsonProperty("title")
    private String title;

    @JsonProperty("price")
    private Float price;

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("type")
    private String type;

    @JsonProperty("url")
    private String url;

   // @JsonProperty("who_made")
   // private String whoMade;

 //   @JsonProperty("occasion")
 //   private String occasion;

    @JsonProperty("language")
    private String language;

}
