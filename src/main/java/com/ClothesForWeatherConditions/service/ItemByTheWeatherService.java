package com.ClothesForWeatherConditions.service;

import com.ClothesForWeatherConditions.configuration.EmailConfiguration;
import com.ClothesForWeatherConditions.domain.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ItemByTheWeatherService {

    private final OpenWeatherService openWeatherService;
    private final EmailService emailService;
    private final EtsyService etsyService;
    private final EmailConfiguration emailConfiguration;



    public ItemByTheWeatherService(OpenWeatherService openWeatherService, EmailService emailService, EtsyService etsyService,
                                   EmailConfiguration emailConfiguration) {
        this.openWeatherService = openWeatherService;
        this.emailService = emailService;
        this.etsyService = etsyService;
        this.emailConfiguration = emailConfiguration;
    }
    public void sendConfirmMail(EtsyDtoBasic etsyDtoBasic) throws MessagingException, JsonProcessingException {
        String email = emailConfiguration.getEmailSender();
        OpenWeatherDtoBasic openWeatherDtoBasic =openWeatherService.getActualWeather();
        List<EtsyResultsDto> etsyItems = etsyDtoBasic.getEtsyResultsDtoList();
        Float temperature = openWeatherDtoBasic.getOpenCurrentDto().getTemp();
        String body = "Dzisiejsza temperatura wynosi: " + temperature + "\n";

        if (temperature > 20.0f) {
            etsyItems = etsyItems.stream()
                    .filter(i -> i.getPrice() > 20.0f)
                    .collect(Collectors.toList());
        }

        for (EtsyResultsDto e : etsyItems) {
            body += "\nLink do artukułu " + e.getUrl()
                    + "\no tytule: " + e.getTitle()
                    + "\no cenie: " + e.getPrice() + " " + e.getCurrencyCode()
                    + "\no typie: " + e.getType();
        }

        String tittle = "Rzeczy do dzisiejszej pogody";
        emailService.sendEmail(email, tittle, body);
    }

}

