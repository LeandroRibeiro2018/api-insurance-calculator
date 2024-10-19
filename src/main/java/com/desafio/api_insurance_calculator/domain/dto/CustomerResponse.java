package com.desafio.api_insurance_calculator.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    @JsonProperty("name")
    private String name;
    @JsonProperty("location")
    private String location;
    @JsonProperty("insuranceValue")
    private double insuranceValue;

    public CustomerResponse(String valorDoVeículoInválido) {
    }
}
