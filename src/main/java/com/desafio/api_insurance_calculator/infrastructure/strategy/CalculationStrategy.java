package com.desafio.api_insurance_calculator.infrastructure.strategy;

import com.desafio.api_insurance_calculator.domain.Customer;

public interface CalculationStrategy {
    double calculate(Customer customer);
}
