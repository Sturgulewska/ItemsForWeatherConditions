package com.ClothesForWeatherConditions.configuration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@Getter
@Setter
public class EtsyConfiguration {

    @Value("${openapi.etsy.com.api_key}")
    private String apiKey;


    //https://openapi.etsy.com/v2/listings/active?api_key=whk7wsv42qjexu3cmsizdyq8&recipient=woman&includes=Shop&language=pl-pl&currency_code=PLN
    @Value("${openapi.etsy.com.url}")
    private String url;
}
