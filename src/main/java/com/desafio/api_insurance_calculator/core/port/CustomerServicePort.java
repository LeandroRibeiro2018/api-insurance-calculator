package com.desafio.api_insurance_calculator.core.port;

import com.desafio.api_insurance_calculator.adapter.dto.CustomerResponse;
import com.desafio.api_insurance_calculator.core.domain.Customer;

import java.util.List;

public interface CustomerServicePort {
    Customer calculateInsurance(Customer customer);
    void saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
}
