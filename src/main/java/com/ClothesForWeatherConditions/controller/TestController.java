package com.ClothesForWeatherConditions.controller;
import com.ClothesForWeatherConditions.domain.*;
import com.ClothesForWeatherConditions.service.EtsyService;
import com.ClothesForWeatherConditions.service.ItemByTheWeatherService;
import com.ClothesForWeatherConditions.service.OpenWeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@CrossOrigin
@RequestMapping("/test_controller")
public class TestController {

    private final OpenWeatherService openWeatherService;
    private final EtsyService etsyService;
    private final ItemByTheWeatherService itemByTheWeatherService;

    public TestController(OpenWeatherService openWeatherService, EtsyService etsyService, ItemByTheWeatherService itemByTheWeatherService) {
        this.openWeatherService = openWeatherService;
        this.etsyService = etsyService;
        this.itemByTheWeatherService = itemByTheWeatherService;
    }

    @RequestMapping(value = "/get_actual_weather", method = RequestMethod.GET)
    public ResponseEntity<Object> getActualWeather() throws JsonProcessingException, MessagingException {
        // String result = accuWeatherService.getActualWeather();
        OpenWeatherDtoBasic resultDto = openWeatherService.getActualWeather();
        return new ResponseEntity<>(resultDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/get_item", method = RequestMethod.GET)
    public ResponseEntity<Object> getItem() throws JsonProcessingException, MessagingException {
        EtsyDtoBasic resultDto = etsyService.getItem();
        return new ResponseEntity<>(resultDto, HttpStatus.OK);
    }

     @RequestMapping(value = "/send_email", method = RequestMethod.GET)
     public ResponseEntity<Object> sendArticleByWeatherAndArticle() throws JsonProcessingException, MessagingException {
         EtsyDtoBasic resultDto = etsyService.getItem();
         itemByTheWeatherService.sendConfirmMail(resultDto);
         return new ResponseEntity<>("OK", HttpStatus.OK);
     }
}