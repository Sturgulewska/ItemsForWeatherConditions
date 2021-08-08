package com.ClothesForWeatherConditions.service;

import com.ClothesForWeatherConditions.configuration.EtsyConfiguration;
import com.ClothesForWeatherConditions.domain.*;
import com.ClothesForWeatherConditions.service.utils.MyJsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EtsyService {
    private final EtsyConfiguration etsyConfiguration;

    public EtsyDtoBasic getItem() throws JsonProcessingException {
        Request request = new Request.Builder()
                .url(createUrlItems())
                .build();

        String response = executeRequest(request);
        EtsyDtoBasic result = MyJsonUtils.convertStringToObject(response, EtsyDtoBasic.class);
        return result;
    }

    public DtoTaxonomyBasic getTaxonomyList() throws JsonProcessingException {
        Request request = new Request.Builder()
                .url(createUrlTaxonomyList())
                .build();

        String response = executeRequest(request);
        DtoTaxonomyBasic result = MyJsonUtils.convertStringToObject(response, DtoTaxonomyBasic.class);
        return result;
    }

    public EtsyService(EtsyConfiguration etsyConfiguration) {
        this.etsyConfiguration = etsyConfiguration;
    }

    // https://openapi.etsy.com/v2/listings/active?api_key=whk7wsv42qjexu3cmsizdyq8&taxonomy_id=500&recipient=women
    private HttpUrl createUrlItems() {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(etsyConfiguration.getUrl())
                .addPathSegment("v2")
                .addPathSegment("listings")
                .addPathSegment("active")
                .addQueryParameter("api_key", etsyConfiguration.getApiKey())
                .addQueryParameter("taxonomy_id", "500")
                .addQueryParameter("recipient", "women")
                .build();

        return url;
    }

    // https://api.etsy.com/v2/taxonomy/buyer/get?api_key=whk7wsv42qjexu3cmsizdyq8
    private HttpUrl createUrlTaxonomyList() {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(etsyConfiguration.getUrl())
                .addPathSegment("v2")
                .addPathSegment("taxonomy")
                .addPathSegment("buyer")
                .addPathSegment("get")
                .addQueryParameter("api_key", etsyConfiguration.getApiKey())
                .build();

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

