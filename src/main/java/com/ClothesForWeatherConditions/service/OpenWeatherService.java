package com.ClothesForWeatherConditions.service;

import com.ClothesForWeatherConditions.configuration.OpenWeatherConfiguration;
import com.ClothesForWeatherConditions.domain.*;
import com.ClothesForWeatherConditions.service.utils.MyJsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class OpenWeatherService {
    private final OpenWeatherConfiguration openWeatherConfiguration;

    public OpenWeatherDtoBasic getActualWeather() throws JsonProcessingException {
        Request request = new Request.Builder()
                .url(createUrl())
                .build();

        String response = executeRequest(request);
        OpenWeatherDtoBasic result = MyJsonUtils.convertStringToObject(response, OpenWeatherDtoBasic.class);
        return result;
    }


    public OpenWeatherService(OpenWeatherConfiguration openWeatherConfiguration) {
        this.openWeatherConfiguration = openWeatherConfiguration;
    }


    private HttpUrl createUrl() {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(openWeatherConfiguration.getUrl())
                .addPathSegment("data")
                .addPathSegment("2.5")
                .addPathSegment("onecall")
                .addQueryParameter("lat", "52.23")
                .addQueryParameter("lon", "21.01")
                .addQueryParameter("exclude", "minutely hourly")
                .addQueryParameter("appid", openWeatherConfiguration.getAppid())
                .addQueryParameter("units", "metric")
                .addQueryParameter("lang", "pl")
                .build();

        System.out.println("tu powinien wyświetlić się url" + url);

        return url;

    }
    private String executeRequest(Request request) {
        String result = "";
        OkHttpClient client = new OkHttpClient();
        Call requestCall = client.newCall(request);
        try (ResponseBody response = requestCall.execute().body()) {
            if (response != null) {
                result = response.string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
