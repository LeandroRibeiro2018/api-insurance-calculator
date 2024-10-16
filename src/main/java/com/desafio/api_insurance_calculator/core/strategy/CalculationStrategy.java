package com.desafio.api_insurance_calculator.core.strategy;

import com.desafio.api_insurance_calculator.core.domain.Customer;

public interface CalculationStrategy {
    double calculate(Customer customer);
}
