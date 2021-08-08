package com.ClothesForWeatherConditions.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {
    private String message = "";
    private String field = "";

    public boolean isError() {
        return !message.isEmpty();
    }
}

