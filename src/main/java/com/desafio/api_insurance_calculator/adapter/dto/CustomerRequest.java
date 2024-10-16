package com.desafio.api_insurance_calculator.adapter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    @JsonProperty("name")
    private String name;
    @JsonProperty("document")
    private String document;
    @JsonProperty("birthday")
    private String birthday;
    @JsonProperty("location")
    private String location;
    @JsonProperty("vehicleValue")
    private double vehicleValue;
    @JsonProperty("insuranceValue")
    private double insuranceValue;
}
