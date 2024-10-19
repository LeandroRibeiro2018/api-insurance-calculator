package com.desafio.api_insurance_calculator.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
public class CustomerRequest {
    private String name;
    private String document;
    private String birthday;
    private String location;
    private double vehicleValue;
    private double insuranceValue;

    public CustomerRequest() {
    }
    public CustomerRequest(String name, String document, String birthday, String location, double vehicleValue, double insuranceValue) {
        this.name = name;
        this.document = document;
        this.birthday = birthday;
        this.location = location;
        this.vehicleValue = vehicleValue;
        this.insuranceValue = insuranceValue;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDocument() {
        return document;
    }
    public void setDocument(String document) {
        this.document = document;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public double getVehicleValue() {
        return vehicleValue;
    }
    public void setVehicleValue(double vehicleValue) {
        this.vehicleValue = vehicleValue;
    }
    public void setInsuranceValue(double insuranceValue) {
        this.insuranceValue = insuranceValue;
    }
    public double getInsuranceValue() {
        return insuranceValue;
    }
}
