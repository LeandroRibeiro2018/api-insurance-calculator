package com.desafio.api_insurance_calculator.domain.port.interfaces;

import com.desafio.api_insurance_calculator.domain.Customer;
import com.desafio.api_insurance_calculator.infrastructure.entity.CustomerEntity;

import java.util.List;

public interface CustomerServicePort {
    Customer calculateInsurance(Customer customer);
    Customer saveCustomer(Customer customerRequest);
    List<CustomerEntity> getAllCustomers();
}
