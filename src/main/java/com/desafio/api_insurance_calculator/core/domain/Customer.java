package com.desafio.api_insurance_calculator.core.domain;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
