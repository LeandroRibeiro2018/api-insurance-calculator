package com.desafio.api_insurance_calculator.infrastructure.strategy;

import com.desafio.api_insurance_calculator.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalculationStrategyFactory {

    private final List<CalculationStrategy> strategies;

    @Autowired
    public CalculationStrategyFactory(List<CalculationStrategy> strategies) {
        this.strategies = strategies;
    }

    public CalculationStrategy getStrategy(Customer customer) {
      if (customer.getLocation().equals("SP") && customer.getVehicleValue() <= 70000) {
            return strategies.stream()
                    .filter(strategy -> strategy instanceof SPCalculationStrategy)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No strategy found"));
        }
        if (customer.getVehicleValue() <= 70000) {
            return strategies.stream()
                    .filter(strategy -> strategy instanceof LowValueStrategy)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No strategy found"));
        }
       if (customer.getVehicleValue() > 70000 && customer.getVehicleValue() < 100000) {
            return strategies.stream()
                    .filter(strategy -> strategy instanceof MediumValueStrategy)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No strategy found"));
        }
            return strategies.stream()
                    .filter(strategy -> strategy instanceof HighValueStrategy)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No strategy found"));
        }


}
