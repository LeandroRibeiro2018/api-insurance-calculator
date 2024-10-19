package com.desafio.api_insurance_calculator.infrastructure.strategy;

import com.desafio.api_insurance_calculator.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class SPCalculationStrategy implements CalculationStrategy{
    @Override
    public double calculate(Customer customer) {
        return customer.getVehicleValue() * 0.05;
    }
}
