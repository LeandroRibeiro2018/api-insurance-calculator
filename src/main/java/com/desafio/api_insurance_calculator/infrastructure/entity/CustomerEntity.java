package com.desafio.api_insurance_calculator.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String document;
    private String birthday;
    private String location;
    private double vehicleValue;
    private double insuranceValue;

    public CustomerEntity() {
    }
    public CustomerEntity(String name, String document, String birthday, String location, double vehicleValue, double insuranceValue) {
        this.name = name;
        this.document = document;
        this.birthday = birthday;
        this.location = location;
        this.vehicleValue = vehicleValue;
        this.insuranceValue = insuranceValue;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
