package com.desafio.api_insurance_calculator.domain.port.repository;

import com.desafio.api_insurance_calculator.domain.Customer;
import com.desafio.api_insurance_calculator.infrastructure.entity.CustomerEntity;

import java.util.List;

public interface CustomerRepositoryPort {

    CustomerEntity save(Customer customer);
    List<CustomerEntity> getAllCustomers();

}
