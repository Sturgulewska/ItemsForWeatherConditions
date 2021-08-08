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
public class OpenWeatherConfiguration {

    @Value("${api.openweathermap.org.appid}")
    private String appid;

    @Value("${api.openweathermap.org.url}")
    private String url;

}
