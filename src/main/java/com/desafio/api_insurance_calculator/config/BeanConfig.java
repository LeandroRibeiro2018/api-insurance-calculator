package com.desafio.api_insurance_calculator.config;

import com.desafio.api_insurance_calculator.core.port.CustomerServicePort;
import com.desafio.api_insurance_calculator.core.service.CustomerServiceImpl;
import com.desafio.api_insurance_calculator.core.strategy.CalculationStrategyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public CustomerServicePort customerService(CalculationStrategyFactory strategyFactory) {
        return new CustomerServiceImpl(strategyFactory);
    }
}
